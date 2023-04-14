package com.example.springboot.service;

import com.example.springboot.dto.MemberRequestDTO;
import com.example.springboot.dto.MemberResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    //설계적인 구조도 -> 서비스 구현체가 없더라도 잘돌아가는지를 볼 수 있음
    //협업의 중요도도 맞음 -> 가이드라인 제공

    public MemberResponseDTO memberSignup(MemberRequestDTO request);
}
