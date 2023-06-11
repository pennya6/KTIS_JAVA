package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@Builder //lombok -> 요즘은 백퍼로 다 씀
@AllArgsConstructor //lombok
@NoArgsConstructor //lombok
public class Member {
    @Id
    @Column(name="id")
    private String memberId;
    @Column(name="pw")
    private String memberPw;

//    public Member(){
//
//    } -> @NoArgsConstructor

//    public Member(String memberId,String memberPw){
//        this.memberId=memberId;
//        this.memberPw=memberPw;
//    } -> @AllArgsConstructor
}
