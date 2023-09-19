package com.example.rental.service.serviceImpl;

import com.example.rental.dto.MemberRequestDTO;
import com.example.rental.dto.MemberResponseDTO;
import com.example.rental.repository.MemberRepository;
import com.example.rental.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
