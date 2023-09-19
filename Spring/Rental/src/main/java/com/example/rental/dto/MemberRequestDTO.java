package com.example.rental.dto;

import com.example.rental.entity.Member;
import lombok.Data;

@Data
public class MemberRequestDTO {
    private String memberId;
    private String memberPw;

    public Member toEntity(){
        return Member.builder()
                .memberId(this.memberId)
                .memberPw(this.memberPw)
                .build();
    }
}
