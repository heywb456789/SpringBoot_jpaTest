package com.boot.test.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * assertEquals(a,b)
 * 객체 A와 B의 실제  값이 일치한지 확인한다.
 *
 * assertSame(a,b)
 * 객체 A와 B가 같은 객체임을 확인한다
 *  -assertEquals 메서드는 두 객체의 값을 비교
 *  -assertSame 메서드는 두 객체가 동일한지 객체의 비교 (==연산자와 같다)
 */
class MemberVoTest {

    @Test
    public void getId() {
        final MemberVo member = MemberVo.builder()
                .id("heywb")
                .name("wbKim")
                .build();
        final String id = member.getId();

        assertEquals("heywb",id);
    }

    @Test
    public void getName() {
        final MemberVo member = MemberVo.builder()
                .id("heywb")
                .name("테스트")
                .build();
        final String name = member.getName();

        assertEquals("테테스트",name);
    }

    @Test
    public void getName2(){
        final MemberVo mem = MemberVo.builder().id("zz").name("zzz").build();
        final MemberVo mem2 = MemberVo.builder().id("zz").name("zzz").build();

        assertSame(mem.getName() , mem2.getName());

        MemberVo mem3 = new MemberVo();
        mem3.setName("zzz");

        MemberVo mem4 = new MemberVo();
        mem4.setName("zzz");

        assertSame(mem3, mem4);

    }
}