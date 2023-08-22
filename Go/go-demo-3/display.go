package main

import (
	"fmt"
)

func display(s interface{ show() }) {
	s.show()
}

type rect struct{ width, height float64 }

func (r rect) show() {
	fmt.Print("width: %f,height: %f\n", r.width, r.height)
}

type circle struct{ radius float64 }

func (c circle) show() {
	fmt.Print("radius:%f\n", c.radius)
}
func main() {
	r := rect{3, 4}
	c := circle{2.5}
	display(r)
	display(c)
}
