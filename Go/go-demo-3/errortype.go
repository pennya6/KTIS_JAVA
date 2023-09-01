package main

// 에러타입
// 비정상적인 상태를 나타낼떄 사용

//Error() string 메서드를 가지고 있으면 에러로 사용 가능

// 함수나 메서드의 마지막 반환 값으로 에러 상태를 반환
// 에러 미발생 -> nil

func New(text string) error {
	return &errorString{text}
}

type errorString struct {
	s string
}

func (e *errorString) Error() string {
	return e.s
}
