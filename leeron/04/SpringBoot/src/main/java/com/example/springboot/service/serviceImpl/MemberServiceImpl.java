package com.example.springboot.service.serviceImpl;

import com.example.springboot.dto.MemberRequestDTO;
import com.example.springboot.dto.MemberResponseDTO;
import com.example.springboot.repository.MemberRepository;
import com.example.springboot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //lombok -> @AutoWired대체
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repo;

    @Override
    public MemberResponseDTO memberSignup(MemberRequestDTO request) {
        try {
            repo.save(request.toEntity()); //insert into admin(id,pw) value (1,2); -> 중복시 update
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
