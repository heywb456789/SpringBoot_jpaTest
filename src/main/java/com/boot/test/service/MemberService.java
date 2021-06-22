package com.boot.test.service;

import com.boot.test.repository.MemberRepository;
import com.boot.test.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberVo> findAll(){
        List<MemberVo> members = new ArrayList<>();
        memberRepository.findAll().forEach(e->members.add(e));
        return members;
    }

//    public Optional<List<MemberVo>> findAllOptional(){
//        Optional<List<MemberVo>> membersOptional = Optional.ofNullable();
//    }
    public Optional<MemberVo> findById(Long mbrNo){
        Optional<MemberVo> member = memberRepository.findById(mbrNo);
        return member;
    }

    public void deleteById(Long mbrNo){
        memberRepository.deleteById(mbrNo);
    }

    public MemberVo save (MemberVo member){
        memberRepository.save(member);
        return member;
    }

    public void updateById(Long mbrNo, MemberVo member){
        Optional<MemberVo> e = memberRepository.findById(mbrNo);

        if(e.isPresent()){
            e.get().setMbrNo(member.getMbrNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            memberRepository.save(member);
        }
    }
}
