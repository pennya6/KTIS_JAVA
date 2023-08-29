package main

// 고루틴
// Go 프로그램 안에서 동시에 독립적으로 실행되는 흐름의 단위
// 스레드와 비슷한 개념
// 아주 적은 리소스에서 동작, 수만개의 고루틴을 동작할 수 있음
// 서로 메시지를 주고받는 방식으로 동작

//주의점
// 실행중인 고루틴이 있어도 메인함수가 종료되면 프로그램 종료
import (
	"fmt"
	"time"
)

func main() {
	fmt.Println("main 함수 시작", time.Now())

	go long()
	go short()

	time.Sleep(5 * time.Second)
	fmt.Println("main 함수 종료", time.Now())
}
func long() {
	fmt.Println("long 함수 시작", time.Now())
	time.Sleep(3 * time.Second)
	fmt.Println("long 함수 종료", time.Now())
}
func short() {
	fmt.Println("short 함수 시작", time.Now())
	time.Sleep(1 * time.Second)
	fmt.Println("long 함수 종료", time.Now())
}
