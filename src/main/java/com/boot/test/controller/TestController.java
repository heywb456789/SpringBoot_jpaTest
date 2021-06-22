package com.boot.test.controller;

import com.boot.test.service.TestService;
import com.boot.test.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TestService testService;

    @RequestMapping("/home")
    public String home(){
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value="테스트 STring";
        return value;
    }

    @RequestMapping("/bootTest")
    public ModelAndView test() throws Exception{
        ModelAndView mov  = new ModelAndView("test");
        mov.addObject("name","wbKim");

//        List<String> testList = new ArrayList<String>();
//        testList.add("a");
//        testList.add("b");
//        testList.add("c");
        List<TestVo> testList = testService.selectTest();

        mov.addObject("list",testList);

        logger.trace("Trace ");
        logger.debug("debug ");
        logger.info("info ");
        logger.warn("warn ");
        logger.error("error ");
        return mov;
    }

    @RequestMapping("/thymeleafTest")
    public String thymeleafTest(Model model){
        TestVo testModel = new TestVo();
        testModel.setId("kimkim");
        testModel.setName("김우빈");
        model.addAttribute("testModel",testModel);
        return "thymeleaf/thymeleafTest";
    }

}
