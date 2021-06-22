package com.boot.test.vo;

import javassist.bytecode.annotation.MemberValue;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//모든 필드값을 파라미터로 받는 생성자를 만들어준다.
@AllArgsConstructor
//파라미터가 없는 기본생성자를 생성해주고
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//jpa가 관리하는 클래스이고, 테이블과 매핑할 테이블은 해당 어노테이션을 붙인다.
@Entity(name = "member")
//final 이나 @nonNull인 필드 값만 파라미터로 받는 생성자를 만들어준다.
//@RequiredArgsConstructor
public class MemberVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrNo;

    private String id;
    private String name;

    @Builder
    public MemberVo(String id, String name){
        this.id = id;
        this.name = name;
    }
}
