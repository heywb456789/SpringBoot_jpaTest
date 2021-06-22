package com.boot.test.controller;

import com.boot.test.service.TestService;
import com.boot.test.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@WebMvcTest(TestRestController.class)
@Slf4j
class TestRestControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TestService testService;

    @Test
    void getTestVo() throws Exception{

//        //given
//        TestVo testVo = TestVo.builder()
//                .id("wbkim")
//                .name("김우빈")
//                .build();
//
//        //given
//        given(testService.selectOneMember("wbkim"))
//                .willReturn(testVo);
//
//        //when
//        final ResultActions actions = mvc.perform(get("/testValue2")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print());
//
//        //then
//        actions.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.name",is("김우빈")))
//                .andDo((print()));
    }
}