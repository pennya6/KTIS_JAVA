package main

//저수준 제어
//고루틴과 채널외에도 병행 프로그래밍을 위한 저수준 제어 기능 존재
//sync package - mutex : 공유메무리를 제어할 수 있는 기능
//sync/atomic package - add,compare,swap

//mutex
//고루틴에서 공유하는 데이터를 보호해야할 때 사용
//
