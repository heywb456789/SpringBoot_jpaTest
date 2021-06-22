package com.boot.test.mapper;

import com.boot.test.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {

    List<TestVo> selectTest();

//    TestVo selectOneMember(String name);
}
