package main

import "fmt"

func main() {
	f1()
}
func f1() {
	fmt.Println("start")
	//함수가 종료되기 전까지 특정 구문의 실행을 지연시켰다가 함수가 종료지전 구문 수행
	defer f2()
	fmt.Println("end")
}
func f2() {
	fmt.Print("f2")
}

// finally로 작성했을때보다 defer이 가독성이 더 높음
// 보통 특정 리소스의 사용을 해제하는 코드로 작성
