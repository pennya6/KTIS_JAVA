package main

import (
	"fmt"
	"time"
)

// channel
// 고루틴끼리 정보를 교환하고 실행의 흐름을 동기화 하기 위해 사용

// 일반 변수 선언과 동일, make() 함수로 생성
// 채널 정의시 chan 키워드로 채널을 주고 받을 데이터 타입 지정

func main() {
	fmt.Println("main 함수 시작", time.Now())

	//짧은 선언 - 선언과 동시에 값 할당
	done := make(chan bool)
	go long(done)
	go short(done)

	<-done
	<-done
	fmt.Println("main 항수 종료", time.Now())
}
func long(done chan bool) {
	fmt.Println("long 함수 시작", time.Now())
	time.Sleep(3 * time.Second) // 3초 대기
	fmt.Println("long 함수 종료", time.Now())
	done <- true
}
func short(done chan bool) {
	fmt.Println("short 함수 시작", time.Now())
	time.Sleep(1 * time.Second) // 1초 대기
	fmt.Println("short 함수 종료", time.Now())
	done <- true
}
