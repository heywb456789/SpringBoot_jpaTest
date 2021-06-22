package com.boot.test.service;

import com.boot.test.mapper.TestMapper;
import com.boot.test.vo.TestVo;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TestMapper mapper;

    public List<TestVo> selectTest(){
        logger.trace("Trace ");
        logger.debug("debug ");
        logger.info("info ");
        logger.warn("warn ");
        logger.error("error ");
        return mapper.selectTest();
    }

    public TestVo selectOneMember(String name){

//        return mapper.selectOneMember(name);
        return null;

    }
}
