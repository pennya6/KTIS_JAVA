package com.example.springboot.dto;

import com.example.springboot.entity.Member;
import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class MemberRequestDTO {
    private String memberId;
    private String memberpw;

    //빌더 패턴
    //어떤 변수가 어디에 매핑되는지 모름 -> 그래서 너가 어디에 뭘로 매핑되는지 알려줌
    public Member toEntity(){
        return Member.builder()
                .memberId(this.memberId)
                .memberPw(this.memberpw)
                .build();
    }

}
