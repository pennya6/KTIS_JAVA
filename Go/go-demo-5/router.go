package main

import (
	"net/http"
	"strings"
)

type router struct {
	handlers map[string]map[string]http.HandlerFunc
}
type Handler interface {
	ServeHTTP(http.ResponseWriter, *http.Request)
}

func (r *router) HandleFunc(method, pattern string, h http.HandlerFunc) {
	//http 메서드로 등록된 맵이 있는지 확인
	m, ok := r.handlers[method]
	if !ok {
		m = make(map[string]http.HandlerFunc)
		r.handlers[method] = m
	}
	m[pattern] = h
}

func (r *router) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	if m, ok := r.handlers[req.Method]; ok {
		if h, ok := m[req.URL.Path]; ok {
			h(w, req)
			return
		}
	}
	http.NotFound(w, req)
}
func match(pattern, path string) (bool, map[string]string) {
	if pattern == path {
		return true, nil
	}

	//패턴과 패스를 "/" 단위로 구분
	patterns := strings.Split(pattern, "/")
	paths := strings.Split(path, "/")

	//"/"로 구분한 후 부분 문자열 집합의 개수가 다르면 false를 반환
	if len(patterns) != len(paths) {
		return false, nil
	}
	//패턴에 일치하는 URL 매개변수를 담기 위한 params 맵 생성
	params := make(map[string]string)

	for i := 0; i < len(patterns); i++ {
		switch {
		case patterns[i] == paths[i]:
		case len(patterns[i]) > 0 && patterns[i][0] == ':':
			params[patterns[i][1:]] = paths[i]
		default:
			return false, nil
		}
	}
	return true, params
}
func (r *router) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	// http 메서드에 맞는 모든 handers를 반복하여 요청 URL에 해당하는 handler를 찾음
	for pattern, handler := range r.handlers[req.Method] {
		if ok, _ := match(pattern, req.URL.Path); ok {
			// 요청 URL에 해당하는 handler 수행
			handler(w, req)
			return
		}
	}
	// 요청 URL에 해당하는 handler를 찾지 못하면 NotFound 에러 처리
	http.NotFound(w, req)
	return
}
