package main

import (
	"fmt"
	"runtime"
)

//저수준 제어
//고루틴과 채널외에도 병행 프로그래밍을 위한 저수준 제어 기능 존재
//sync package - mutex : 공유메무리를 제어할 수 있는 기능
//sync/atomic package - add,compare,swap

//mutex
//고루틴에서 공유하는 데이터를 보호해야할 때 사용

type counter struct {
	i int64
}

func (c *counter) increment() {
	c.i += 1
}

func (c *counter) display() {
	fmt.Println(c.i)
}
func main() {
	//모든 cpu 사용
	runtime.GOMAXPROCS(runtime.NumCPU())

	c := counter{i: 0}               //카운터 생성
	done := make(chan chan struct{}) //완료 신호 수신용 채널

	for i := 0; i < 1000; i++ {
		go func() {
			c.increment() // 카운터 값을 1 증가시킴
			//done <- struct{} // done 채널에 완료 신호 전송
		}()
	}
	// 모든 고루틴이 완료될 때까지 대기
	for i := 0; i < 1000; i++ {
		<-done
	}

	c.display() // c의 값 출력
}
