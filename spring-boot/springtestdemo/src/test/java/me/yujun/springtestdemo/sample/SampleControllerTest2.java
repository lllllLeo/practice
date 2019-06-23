package me.yujun.springtestdemo.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //RANDOM_PORT 하면 내장 톰캣이 뜬다.
@AutoConfigureMockMvc
public class SampleControllerTest2 {
    /**
     * test용 RestTemplate이나
     * test용 WebClient - spring5 새로 추가된 spring web flux에 추가된 rest client 중 하나인데 기존에 사용하던것은 synchronous인데
     * 이거는 Asynchronous이다. 그래서 우리가 요청을 보내고 기다리는 것이 아니라 응답이 오면 우리한테 callback이 온다.
     * dependency 추가해야함 spring-boot-starter-webflux
     * 를 사용해야한다.
     * <p>
     * 다른 test 방법들
     *
     * @SpringBootTest 빼고
     * ->
     * 1.
     * @JsonTest ...
     * @Autowired JacksonTester<Sample> (실험해 볼 도메인 타입)
     * <p>
     * 2. 슬라이싱 테스트 / 가볍다
     * @WebMvcTest(SampleController.class) -> (Web과 관련된 컴포넌트)@Controller, @ControllerAdvice, 등 이런것만 등록됨.
     * 일반적인(regular) component 들은 등록이 안됨. (service, repository 같은)
     * ...
     * 그래서 따로 주입해줘야함
     * @Autowired SampleService mockSampleService;
     * @Autowired MockMvc mockMvc;
     */
//    @Autowired
//    TestRestTemplate testRestTemplate;

    @Autowired
    WebTestClient webTestClient;

    /*
     * 내장 톰캣 서버에 요청을 보내서 응답을 받아서 확인을 함
     *
     * @MockBean을 안쓰면 Service단 까지가서 값을 가져와서 확인을 한다. 딱 Controller까지로만 테스트하고 있으면
     * @MockBean을 사용하면 application-context에 있는 SampleContrller Bean을 여기서 MockBean으로 교체한다.
     * 그러면 실제로 SampleController는 MockSampleService를 사용하게 된다. 원본이 아니라. 이렇게하면 mocking을 할 수있다.
     * */
    @MockBean
    SampleService mockSampleService;

    //    public으로 만들어야함 Rule의 제약사항
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("leo");
        /* testRestTemplate 사용
        String result = testRestTemplate.getForObject("/hello", String.class);   // url, 내가 원하는 body 타입
        assertThat(result).isEqualTo("hello leo");
        */

        /* webTestCLient 사용
        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello leo");
        */

        /*
        @Autowired
        MockMvc mockMvc;
        when(mockSampleService.getName()).thenReturn("leo");
        mockMvc.perform(get("/hello"))
               .andExpect(content().string("hello yujun));
        */
        when(mockSampleService.getName()).thenReturn("leo");
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hello leo"));

        assertThat(outputCapture.toString())
                .contains("holoman")
                .contains("skip");


    }
}