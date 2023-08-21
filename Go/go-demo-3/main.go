package main

import "fmt"

//사용자 정의 타입 정의(구조체)
// 구조체 정의 후 필드 정의
type Item struct {
	name     string
	price    float64
	quantity int
}

//Cost() 메서드 정의
func (t Item) Cost() float64 {
	return t.price * float64(t.quantity)
}

func main() {
	//main 함수에 Item타임 값으로 shirt 생성
	shirt := Item{name: "Men's Slim-fit shirt", price: 250000, quantity: 3}
	fmt.Println(shirt.Cost())
}
