package com.boot.test.controller;

import com.boot.test.service.TestService;
import com.boot.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testValue", method = RequestMethod.GET)
    public String getTestValue(){
        String testValue = "RestController Test";
        return testValue;
    }

    @RequestMapping(value = "/testVale2", method = RequestMethod.GET)
    public TestVo getTestVo(@RequestParam String name ){
        TestVo testVo = new TestVo();
//
//        testVo.setId("wbKim");
//        testVo.setName("김우빈");

//        TestVo testVo = testService.selectOneMember(name);

//
        return testVo;
    }
}
