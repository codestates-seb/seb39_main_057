package com.courseori.server.member;

import lombok.Getter;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;

@RestController
@Getter
public class Member {
    @Id
    long memberId;
}
