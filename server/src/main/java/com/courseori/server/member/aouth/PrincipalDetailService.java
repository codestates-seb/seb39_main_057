package com.courseori.server.member.aouth;

import com.courseori.server.member.entity.Member;
import com.courseori.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private  final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findByUsername(username);
        return new PrincipalDetails(memberEntity);
    }
}
