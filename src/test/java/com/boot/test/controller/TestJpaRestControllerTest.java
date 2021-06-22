package com.boot.test.controller;

import com.boot.test.repository.MemberRepository;
import com.boot.test.service.MemberService;
import com.boot.test.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

//@RunWith(SpringRunner.class) //junit4 사용시

/**
 * 요청 데이터를 설정할때 사용할 Static 메서드
 * import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 * 실행 결과를 검증할때 사용할 Static 메서드
 * import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 * 실행 결과를 로그 등으로 출력할깨 사용항 static 메서드
 * import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
 *
 *
 */
@SpringBootTest(
        properties = {
                "testId=woobinKim",
                "testName=김우빈"
        }
        ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
@Slf4j
@AutoConfigureMockMvc
public class TestJpaRestControllerTest {

    @Value("${testId}")
    private String testId;

    @Value("${testName")
    private String testName;

    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;
    /**
     *  정리 URL : https://itmore.tistory.com/entry/MockMvc-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85
     *
     * - 테스트 실행
     *   --perform()
     *      DispathcherServlet에 요청을 의뢰
     *      MockMvcRequestBuilders를 사용해 설정한 요청 데이터를 perform()의 인수로 전달
     *      get / post / fileUpload 와 같은 메서드 제공
     *      perform()에서 반환된 ResultActions() 호출
     *      실행 결과 검증
     *
     * -요청 데이터 설정
     *  --MockHttpServletRequestBuilder 와
     *  --MockMultipartHttpServletRequestBuilderd
     *
     *    MockHttpServletRequestBuilder
     *
     *      param / params
     *      요청 파라미터 설정
     *      header / headers
     *      요청 해더 설정
     *      contentType & accept와 같은 특정 해더를 설정하는 메서드도 제공
     *      cookie
     *      쿠키 설정
     *      content
     *      요청 본문 설정
     *      requestAttr
     *      요청 스코프에 객체를 설정
     *      flashAttr
     *      플래시 스코프에 객체를 설정
     *      sessionAttr
     *      세션 스코프에 객체를 설정
     *
     *   MockMultipartHttpServletRequestBuilderd
     *
     *      file 업로드할 파일 지정
     *
     * ex)
     * @Test
     * public void testBooks() throws Exception {
     *   mockMvc.perform(get("books"))
     *     .param("name", "Spring")
     *     .accept(MediaType.APPLICATION_JSON)
     *     .header("X-Track-Id", UUID.randomUUID().toString())
     *     .andExpect(status().isOk());
     * }
     *
     *  -실행 결과 검증
     *      ResultActions의 andExpect()
     *          인수에 실행결과를 검증하는 ResultMatcher 지정 ( MockMvcResultMatchers에서 제공)
     *     mockMvcResultMatchers의 메서드
     *
     *      status
     *          HTTP 상태 코드 검증
     *      header
     *          응답 해더의 상태 검증
     *      cookie
     *          쿠키 상태 검증
     *      content
     *          응답 본문 내용 검증
     *          jsonPath나 xpath와 같은 특정 콘텐츠를 위한 메서드도 제공
     *      view
     *          컨트롤러가 반환한 뷰 이름 검증
     *      forwardedUrl
     *          이동대상의 경로를 검증
     *          패턴으로 검증할떄는 forwardedUrlPattern 메서드를 사용
     *      redirectedUrl
     *          리다이렉트 대상의 경로 또는 URL 검증
     *          패턴으로 검증할때는 redirectedUrlPattern 메서드를 사용
     *      model
     *          스프링 MVC 모델 상태 검증
     *      flash
     *          플래시 스코프의 상태 검증
     *      request
     *          서블릿 3.0부터 지원되는 비동기 처리의 상태나 요청 스코프의 상태, 세션 스코프의 상태 검증
     *
     * -실행 결과 출력
     *  ResultActions의 andDo()
     *      인수에 실행 결과를 처리할 수 있는 ResultHandler 지정
     *      스프링 테스튼는 MockMvc ResultHandler의 팩토리 클래스를 통해 다양한 ResultHandler 제공
     *
     *   -MockMvcResultHandler
     *   log
     *      실행결과를 디버깅 레벨에서 로그로 출력
     *      org.springframework.test.web.servlet.resut
     *   print
     *      실행결과를 임의의 출력대상에 출력
     *      출력개상을 지정하지 않으면 기본으로 System.out 출력력
    */
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private TestRestTemplate restTemplate;

//    @BeforeEach() //Junit4 의 @Brfore
//    public void setup(){
//        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
//                .addFilter(new CharacterEncodingFilter("UTF-8", true))//필터 추가
//                .alwaysDo(print())
//                .build();
//    }

    @Test
    void getAllMembers() {
    }

    @Test
    void getMember() throws Exception{
        log.info("###Properties 테스트 ###");
        log.info("testId : " +testId);
        log.info("testName : " + testName);

        /******start Mock MVC TEST **********/
        /*log.info("*****start Mock MVC TEST *********");


        mvc.perform(get("/jpaTest/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("wbKim")))
                .andDo(print());
        /******end Mock MVC TEST **********/

        /******start Mock MVC TEST **********/
        /*ResponseEntity<MemberVo> response = restTemplate.getForEntity("/jpaTest/1", MemberVo.class);
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(response.getBody()).isNotNull();

        /******end Mock MVC TEST **********/

        /****start MockBean TEST **********/

        MemberVo member = MemberVo.builder()
                .id(testId)
                .name(testName)
                .build();

        given(memberRepository.findById(1L))
                .willReturn(Optional.of(member));

        Optional<MemberVo> memberVo = memberService.findById(1L);
        if(memberVo.isPresent()){
            //#Junit4 사용시
//            assertThat(member.getId()).isEqualTo(memberVo.get().getId());
//            assertThat(member.getName()).isEqualTo(memberVo.get().getName());

            //Junit5 BDD 사용시
            then("wbkim").isEqualTo(memberVo.get().getId());
            then("김우빈").isEqualTo(memberVo.get().getName());

        }

        /****end MockBean TEST **********/


    }

    @Test
    void deleteMember() {
    }

    @Test
    void updateMember() {
    }

    @Test
    void save() {
    }

    @Test
    void testSave() {
    }
}