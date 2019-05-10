package bom.spring.practice.service;

import bom.spring.practice.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

}
