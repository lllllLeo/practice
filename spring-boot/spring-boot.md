# 2-1강 스프링 부트 소개

스프링 부트는 제품 수준의 프로젝트를 빠르고 쉽게 만들 수 있게 도와준다.   
자바 8 이상 부트 사용 가능.

# 2-2강 스프링 부트 시작하기

GroupID는 보통 패키지명을 사용한다.

create new project하고 maven선택하고 groupId, artifactId 선택 후 만든다.
만들고 우측 하단에 Event 뜨는데 인텔리제이에서 `pom.xml`을 변경할 때 마다 반영이 되기 때문에 바로바로 적용이 되게 Enable-Auto-import 클릭

- pom.xml
```xml
<!-- Inherit defaults from Spring Boot -->
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.0.RELEASE</version>
	</parent>

<!-- Add typical dependencies for a web application -->
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>

<!-- Package as an executable jar -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

메이븐 간에는 프로젝트 계층구조를 만들 수 있어서 이 프로젝트의 부모 프로젝트를 spring-boot-starter-parent 로 지정한 것이다. 이것이 스프링부트가 제공하는 의존성 관리와 관련이 있는 설정이다.

# 2-4강 스프링 부트 프로젝트 구조

`@SpringBootApplication`을 붙인 클래스를 **Main application class**라고 부른다.   
`@SpringBootApplication`을 붙인 패키지부터 **component-scan**을 시작한다. 다른 패키지는 component-scan 안함.

# 3-1 의존성 관리 이해

`pom.xml`에 의존성 주입을 `spring-boot-starter-web`, `spring-boot-starter-test`만 해주었다. 그리고 버전을 명시해주지도 않았지만 알아서 맞는 버전을 가져온다. 이것이 spring-boot가 제공해주는 의존성 관리 기능 때문인데 `spring-boot-starter-parent`에 가보면 또 parent인 `spring-boot-dependencies` 가 있다. `spring-boot-dependencies` 여기에 버전이 명시되어 있고 `dependencyManagement`가 정의가 되어있다. 그래서 우리가 `pom.xml`에 명시한 **dependency**가 하나라도 있으면 명시를 안 해줘도 된다. `spring-boot-dependencies`에 있는 버전을 사용함. `pom.xml`에서 왼쪽 동그라미 아이콘에 마우스를 올려보면 어떤 버전을 사용하는지 나온다. (동그라미 아이콘 누르면 있는 곳으로 찾아감)

**의존성 관리가 좋은 이유**는 우리가 `pom.xml`에서 직접 관리해야 할 의존성이 줄어든다. 즉, 우리의 일이 줄어든다. 우리가 일반 스프링 프레임워크를 사용했을 때는 각 버전간의 호환이 맞는지 직접 올리거나 내려보면서 맞춰봐야한다. 하지만 그럴 필요없다.  
스프링 스타터 위주로 의존성을 추가하면된다.  
자신이 원하는 특정한 버전이 있으면 명시해주면 된다. `pom.xml`에 직접 적어주면 **overriding** 된다.  
의존성 관리는 parent를 사용해서 관리하는 방법이다.   

---
parent방법을 사용하지 않으려면 

1. parent에 넣어놓은 우리만의 프로젝트의 parent로 `spring-boot-stater-parent`를 넣어주면 된다. 그러면 타고 타고 와서 의존성 관리를 받을 수 있다.
2. 난 죽어도 `pom.xml`에서 parent를 못바꾸고 고정되어있어서 할 수가 없다 하면

```xml
<dependencyManagement>
  <dependencies>
	<dependency>
		<!-- Import dependency management from Spring Boot -->
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-dependencies</artifactId>
		<version>2.1.0.RELEASE</version>
		<type>pom</type>
		<scope>import</scope>
	</dependency>
  </dependencies>
</dependencyManagement>
```
를 추가해주면 되는데 **단점**이 있다.

`spring-boot-stater-parent`를 하면 의존성 관리는 물론 **Java 버전**, **기본 인코딩 UTF-8**도, **properties**, **yml 파일**들도 리소스에 포함시켜주는 등 스프링부트에 **최적화**되는 설정이 포함되어있다. 특히 플러그인 설정도 마찬가지다. 이러한 설정이 먹히지 않는다. 그래서 parent 방법을 쓰는걸 **추천**한다.
parent로 받아서 사용해야 더 많은 최적화 설정을 받을 수 있다. 


# 3-2 의존성 관리 응용  

3. 의존성을 추가하는 방법

1-1 스프링부트가 버전 관리 해주는 의존성 추가
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

1-2 스프링부트가 버전 관리 안해주는 의존성 추가(스프링부트가 지원하지 않는 버전을 추가할 시) 
  - 버전 명시 안했을 때 옆에 아이콘이 안뜨면 stater가 의존성 관리를 안해주는것이기 때문에 `<version>`을 명시를 해줘야한다.

1-3 기존 의존성 버전 변경하기 (스프링부트가 지원하는 버전을 추가할 시)   
  - `spring-goot-dependencies`에 명시 되어있는 `<properties>`에 있는 버전들을 `pom.xml`에 `<properties>`에 넣으면 된다.

# 3-3 자동 설정

@EnableAutoConfiguration 톰캣을 계속 띄워놓아준다.
ServletWebServerFactory bean을 만들어준다.

`@SpringBootApplication`은  
 - `@SpringBootConfiguration`, 
 - `@ComponentScan`, 
 - `@EnableAutoConfiguration`  
 을 합쳐놓은 것이다.

`@SpringBootApplication`은 Bean을 2번 등록한다. `@ComponentScan`, `@EnableAutoConfiguration`로 읽어온 Bean들을 다시 등록한다. 2단계로 나눠짐. 그래서 `@EnableAutoConfiguration` 없어도 돌아는 간다. component scan으로 Bean을 읽어들인 다음에 추가적으로 `@EnableAutoConfiguration`이 Bean을 등록한다.
> 2번 할 필요가 있는건가?

- `@SpringBootConfiguration`은 `@Configuration`이랑 같다.

- `@ComponentScan`은 `@Component` Annotation을 가진 Bean을 등록해서 가져오는 것이다. Annotation이 있는 클래스의 하위패키지에 있는 애들은 component scan이 되어서 Bean으로 등록이 된다.  
`@Configuration`, `@Repository`, `@Service`, `@Controller`, `@RestController` 도 component scan해온다.  
(`@Configuration` Annotation이 적용된 클래스는 `@Component` 어노테이션이 적용된 클래스와 마찬가지로 컴포넌트 스캔 대상이므로 스캔범위만 지정해주면 따로 Bean을 등록할 필요가 없어짐)

- `@EnableAutoConfiguration`은 `External Libraries-> spring-boot-autoconfigure -> META-INF -> spring.factories`에 있는 Key값 중에 `Springframework.boot.autoconfigure.EnableAutoConfiguration`가 있는데 Value로 밑에 여러개들이 정의가 되어있다. 이것 전부가 **autoconfiguration**이다. 즉, 기본설정들이다. 이 Key값으로 Value들을 autoconfiguration하는 것이다. 그래서 이것들이 다 적용되는 것이다. 근데 조건에 따라 적용/미적용이다. 이 autoconfiguration 위에는 `@Configuration`이 정의되어있는데 자세히 보면 `@Conditional`로 시작하는 Annotation이 있는데 즉, 조건에 따라 어떠한 Bean을 등록/미등록 한다. 

예를 들어, WebMvcAutoConfiguration 클래스에서 `@ConditionalOnWebApplication(type= Type.SERVLET)`인데 타입이 SERVLET이면 이 설정을 사용하라! 이 뜻이다.

즉, 조건에 맞으면 Bean 등록을 한다.

---
WebApplicationType으로 하려면
```java
SpringApplication application = new SpringApplication(Application.class)
application.setWebApplicationType(WebApplicationType.NONE);
application.run(args);
```

로 하면 AutoConfiguration으로 불러들이는 bean없이도 application을 구동할 수 있다. 물론 WebServer로 동작하지 않는다. WebApplication없이 돌릴 수 있음.

---
[Comment]  

`pom.xml`에 `spring-boot-starter-data-jpa` 추가했었는데 사용을 안하니까 Run하면 에러뜨더라 
>[ Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.]    

그래서 그냥 지워서 돌림.

# 3-4 자동 설정 만들기 1부: Starter와 AutoConfigure

- pom.xml
```xml
 <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure-processor</artifactId>
            <optional>true</optional>
        </dependency>
 </dependencies>

    <!-- 위 두 개의 버전관리를 위해 의존성 관리자를 추가함 -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.0.3.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
- Yujun.java
```java
@Configuration
public class YujunConfiguration {
    @Bean
    public Yujun yujun(){
        Yujun yujun = new Yujun();
        yujun.setAge(27);
        yujun.setName("JUN");
        return yujun;
    }
}
```
 `@Bean`을 리턴하는 설정파일.  
 `@EnableAutoConfiguration`을 하면 `spring.factories`에 있는 `org.springframework.boot.autoconfigure.EnableAutoConfiguration`를 읽어온다. 그럼 여기에 들어와서 `@Bean`을 읽어서 준다.
 
 이 프로젝트를 빌드를 하고 다른 프로젝트에서 사용할 수 있도록 Install 해야한다. 우측 `Maven Projects - Lifecycle - install` 하면 이 프로젝트를 빌드를해서 jar파일을 생성 후 다른 Maven 프로젝트에서 사용할 수 있도록 local maven repository에 설치를 한다. 그리고 `pom.xml`에 가서
```xml     
     <groupId>me.yujun</groupId>
         <artifactId>yujun-spring-boot-starter</artifactId>
     <version>1.0-SNAPSHOT</version>
```     
 를 복사해서 다른 프로젝트의 `pom.xml`에  Dependency를 추가한다. 그러면 External Libraries에 들어온것을 볼 수 있고 `@EnableAutoConfiguration`으로 등록된 Bean을 사용할 수 있다.

 그런데 직접 프로젝트에서 같은 이름의 Bean을 직접 만들면 `@EnableAutoConfiguration`로 가져온 Bean을 사용을 한다.  
 왜냐하면  
 Bean 등록하는 방법이 `@ComponentScan`과 `@EnableAutoConfiguration` 두 가지가 있었는데 `@ComponentScan`으로 Bean으로 등록하는게 먼저 실행된다. 그래서 직접 다시 만든 Bean을 등록한 후 `@EnableAutoConfiguration`이 다시 다른 프로젝트에서 가져온 Bean을 등록을 하면서 처음 직접 만든 Bean을 등록한 것을 덮어씌워서 **결국, `@EnableAutoConfiguration`로 가져온 Bean을 사용한다.**
 


# 3-5 자동 설정 만들기 2부: @ConfigurationProperties
> yujunspringbootstarter

`@ConditionalOnMissingBean`  (새로운 Bean으로 덮어쓰기 방지하기 위해)  
Bean으로 등록되지 않도록 조건을 걸어준다. 해당 타입의 Bean이 없을 때만 Bean으로 등록해준다. (`@EnableAutoConfiguration`로 가져오는 Bean에 붙이면 됨)   

즉, 이 프로젝트에서 component scan으로 직접 만든 Bean을 등록을 하고 `@EnableAutoConfiguration`으로 Bean을 재등록 할 때 `@ConditionalOnMissingBean` Annotation으로 인해 자동설정으로 가져오는 Bean을 등록을 안함.

Bean이 없기 때문에 자동설정에 있는 Bean을 사용하게 될 것이고 사용하게 될 때 `HolomanProperties`를 읽어오게 되는데 이 `HolomanProperties`에 해당하는 것은 위 애노테이션에 있는 "holoman" Properties를 사용하게 된다. application.properties를 실행해서 여기에 있는 name, how-long 값들을 읽어서 사용하게 되는 것이다.
> 자동설정 빈을 만드는 프로젝트에서 `spring.factories`에는 왜 적어놓는거지 그러면 어처피 다른 프로젝트에서 자동설정 빈을 사용할때 `application.properties`에 있는 값을 사용하는데?
 spring.factories랑 application.properties 차이점 봐야겠네

자동설정이 어디에 있으며, 어떻게 찾아보는거고, 어떻게 적용되고있는지 읽을 수 있을 것이다. 물로 @Conditional~가 되게 많다. AutoConfiguration 프로퍼티스 보면 어떻게 활용할 수 있을지 알 수 있을 것이다.

---
- properties에서 자동완성 하기 위해서 필요한 의존성 xml코드
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
```        

# 3-6 내장 웹 서버 이해
스프링 부트는 웹서버가 아니다. 툴이다. 내장 서블릿 컨테이너를 쉽게 사용해줄수 있게 해주는 툴이다. 서버는 톰캣, Netty 등.
스프링 부트 애플리케이션을 만들었으면 의존성에는 tomcat이 들어와있다. 자바코드로 톰캣을 만들 수 있다.



`spring.factories`에 있는 AutoConfiguration에서 `DispatcherServletAutoConfiguration` 클래스에서 `DispatherServlet`을 생성한다. 이 생성한거를 계속 쓴다?

---

Tomcat 코드에서 `A child container failed during start` 에러가 났는데 
Windows에서는 docBase에 해당하는 디렉토리를 생성해주면 문제 없이 실행할 수 있다.  
Windows에서는 `String docBase = Files.createTempDirectory("tomcat-basedir").toString();`을 추가해야지 에러가 안남.

Servlet 만들 때 파라미터를 `HttpServletResponse`로 만드니까 @Override 부분에 빨간줄 떴음. 그래서 `request` 먼저 해주니까 오류 없어짐


# 3-7 내장 웹 서버 응용 1부 : 컨테이너와 포트

기본적으로 의존성(자동설정)으로 Tomcat이 들어와있어서 Tomcat을 사용하게된다. `ConditionalOnClass`에 의해서 Tomcat용 자동 설정 파일이 읽혀지고 만들어지고 사용하게된다. 항상 Tomcat만 가져오니까 tomcat만 빼면 됨. 빼기만하고 아무것도 추가안하면 웹 애플리케이션이 안뜨고 그냥 애플리케이션만 뜨고 끝이 난다.
다른 웹 서버를 사용하려면 `spring-boot-starter-web`에서 tomcat을 빼야한다.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
</dependency>
```
빼고 사용하고 싶은 것을 넣으면 됨

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

기본적으로 의존성에 웹관련 기술(Jetty)을 넣으면 웹 애플리케이션으로 만들려고 시도를 한다. 그래서 코딩으로 `WebApplicationType`을 `NONE`으로 바꿔주는 방법을 썼다.  
근데 다른 방법이 있는데 `properties`를 이용해서 바꾸는 방법이 있다.

**방법 1 (기존 코딩 방식)**  
```java
SpringApplication application = new SpringApplication(Application.class);
application.setWebApplicationType(WebApplicationType.NONE);
```

**방법 2**  
```xml
spring.main.web-application-type=none
```
로 주면 의존성이 있더라도 무시하고 이 `properties`를 읽어서 **none application**이 실행됨


**포트 변경**  
`properties`  
```java
server.port=7070
```

**Random port 사용하기**   
```java
server.port=0
```
그러면 랜덤으로 사용할 수 있는 port를 찾아서 띄워준다.

마지막으로 위에 작업한 것들을 application에서 적용하는 방법을 해보자   
> (springboot0306 프로젝트에 있음 참고하기)

---
- Enable HTTP Response Compression 알아보기

# 4-2 SpringApplication 1부

#### DEBUG 레벨  
아무런 옵션을 안 주고 실행하면 기본적으로 Log 레벨은 `INFO` 이다.
Run Configurations에서 Application일 경우 VM options에 `–Ddebug` 나 Program arguments에 `—debug` 적어주면 Log 레벨이 `DEBUG`가 된다.
`DEBUG` 레벨로 찍을 때 어떠한 자동 설정이 적용이 됐는지 / 안됐는지 로그를 볼 수 있다. 그래서 궁금할 때 `DEBUG` 모드로 띄워보면 쉽게 알 수 있다.

#### FailureAnalyzer
에러가 떴을 때 예쁘게 출력해줌

#### Banner
1. Application을 실행할 때 console 창에 보이는 SPRING 그림이다. 이것을 바꾸고 싶으면 `src/main/resource/banner.txt`에 넣어주면 된다
2. `${spring-boot.version}` 변수 넣으면 Spring version이 출력됨
3. `${application.version}`, `${application.formatted-version}`은 MANIFEST.MF 파일이 있어야만 사용할 수 있다. 없으면 에러는 안뜨고 아예 안찍힌다.
4. Banner를 gif 움직이는 배너, 이미지로 만들 수도 있음.
5. banner.txt를 `resources/`에 안놔두고 다른곳에 놔두고 싶으면 `resources/application.properties`에서 `spring.banner.location=classpath:directory-name/banner.txt`로 정의해주면됨.
6. `application.properties`에서 image 배너도 설정이 가능하다. 
7. 기본 Encoding은 `UTF-8`이다. 하지만 `application.properties`가 UTF-8이어도 console이 UTF-8이 아니면 이상하게 뜨겠지. 그래서 console Encoding도 확인해야함.
8. Banner를 끄고싶으면 main에서 아래와 같이 하면 된다.  
    ```java
    app.setBannerMode(Banner.Mode.OFF);
    ``` 
9. Banner를 conding으로 구현하고 싶으면 main에서
    ```java 
    SpringApplication app = new SpringApplication(SpringinitApplication.class);
    app.setBanner(
        new Banner() {
        @Override
        public void printBanner(Environment environment, Class<?> sourceClass, Print~){
          out.println("=============");
          out.println("yujun");
        }
이런식으로 구현하면 됨.
coding과 banner.txt에 둘 다 설정하면 <u>banner.txt로 설정한 banner가 출력된다.</u>

`SpringApplicationBuilder`
`SpringApplicationBuilder`로도 `SpringApplicaion`을 실행이 가능하다.

```java
new SpringApplicationBuilder().sources(SpringinitApplication.class).run(args);
```

스프링 부트에서 Terminal에서 mvn package를 하면 jar파일 하나에 모든 의존성을 포함한 것을 만들어준다. 그래서 이 jar파일을 실행하면 실행이 된다.   
`$ java –jar target/springinit ~.jar`


# 4-3 SpringApplication 2부

#### Application Events
`ApplicationListener <ApplicationStartingEvent>` 이 타입은 `application-context`가 만들어지기 이전에 발생하는 이벤트이다. 그래서 `application-context`는 얘가 있는지 모른다. 그래서 Bean으로 등록을 한다고 Listener가 동작을 안함.
그래서 main에서 `addListenenr(~.class)` 해줘야함.
Application Events 중 다른 것들은 Bean으로 등록하면 됨. 다 뜨고 찍힘.


#### Application Type

Spring MVC가 있으면 기본적으로 
```java
app.setWebApplicationType(WebApplicationType.SERVLET)
``` 
타입으로 돌아간다.

Spring webFlux 면 
```java
app.setWebApplicationType(WebApplicationType.REACTIVE)
``` 

SERVLET이 없고 REACTIVE 가 있으면 REACTIVE
SERVLET이 있으면 무조건 SERVLET으로 동작하는거
둘 다 없으면 NONE로 동작

둘 다 있으면 SERVLET이 돌아가는데 / REACTIVE 하고 싶으면 type에 적어주면 됨  
첫 번째 조건 SERVLET 유무

# 4-4 외부설정 1부

#### properties 
`application.properties` 파일은 스프링 부트가 애플리케이션을 구동할 때 자동으로 로딩하는 규약, 컨벤션이다.
여기에 정의되어있는 **Key**, **Value** 값을 사용할 수 있다. 
- application.properties
```
yujun.name=유준
```
위처럼 선언 후 
- ~.java
```java
@Value("yujun.name") String name;
```
으로 받아서 사용 가능하다

- properties 우선 순위
> 1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
> 2. 테스트에 있는 @TestPropertySource
> 3. @SpringBootTest 애노테이션의 properties 애트리뷰트
> 4. CommandLine Arguments
> 5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
> 6. ServletConfig 파라미터
> 7. ServletContext 파라미터
> 8. java:comp/env JNDI 애트리뷰트
> 9. System.getProperties() 자바 시스템 프로퍼티
> 10. OS 환경 변수
> 11. RandomValuePropertySource
> 12. JAR 밖에 있는 특정 프로파일용 application properties
> 13. JAR 안에 있는 특정 프로파일용 application properties
> 14. JAR 밖에 있는 application properties
> 15. JAR 안에 있는 application properties -> resources/application.properties 에 정의한거
> 16. @PropertySource
> 17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)



`application.properties` 우선 순위 (높은것이 낮은것을 덮어 쓴다.)
1. file:./config/
2. file:./
3. classpath:/config/
4. classpath:/
> 같은 디렉토리 위치에 안놔두고 다른 위치에 놓으면 Override안함. 그리고 다른곳에 놓을 수 있음. 여기 4곳에서 properties를 찾는다.

- `src`를 먼저 읽어서 `java디렉토리`부터 `resources 디렉토리`를 컴파일해서 `classpath`에 추가한다. 그리고 똑같이 `test 디렉토리`를 컴파일해서 `classpath`에 추가해서 `test`에 있는 `application.properties`가 최근에 추가되었으니 여기에 있는 값을 읽는다.
`src properties`에는 값이 있고 `test properties`에는 값이 없으면 에러가 뜬다. `test가 뒤에 실행되니까 `Override`하니까. 그래서 `test properties`에도 `src properties`에 있는 값을 적어야한다. 
아니면 `test properties`를 지우면 됨

- `application.properties`에 `${random.int}` 사용. 이걸로 `server.port`에 주면 안됨. `server.port = 0` 해야함. 이거는 <u>가용가능한</u> port number를 주는거임.

- Random Value
```
${random.*}
```

- Place Holder
```
yujun.name = yujun  
fullName = ${yujun.name} Kim 
```

# 4-6 외부설정 2부(2) 	
- `${random.int(0,100)}` 할 때 0, 100 이렇게 공백이 있으면 에러뜸 

**융통성 있는 바인딩**
- context-path (케밥)
- context_path (언드스코어)
- contextPath (케멀)
- CONTEXTPATH
케멀케이스나 언드스코어로 해도 매핑을 해준다.

**properties type conversion (타입 개조, 타입 전환)**  
`properties`에서는 type이 없다. 다 문자이다. 스프링이 제공하는 conversion을 통해서 타입 컨버전이 된다. 사용할 `@DurationUnit` 써야함

`properties`에 숫자 + `suffix`
- `ns` for **nanoseconds**  
- `ms` for **milliseconds**  
- `s` for **seconds**  
- `m` for **minutes**  
- `h` for **hours**  
- `d` for **days**  

이렇게 사용하면 굳이 `@DurationUnit` 쓰지 않아도 된다.

하면 타입 컨버젼이 일어난다.

properties에 들어오는 값들을 검증하는 법
- `@Validated`
- JSR-303 (`@NotEmpty`, `@Size`, `@Max`, `@Min`, `@Email`, `@creditCardNumber` etc)
  -  validation api에 대한 구현체는 hibernate validation이라는 구현체를 쓰고 있다. (`org.hibernate.validator:hibernate-validator:6.0.10.Final`)
  
    ` | @Notnull | @NotEmpty | @NotBlank
  --- | --- | --- | ---
  null | 허용하지 않음 | 허용하지 않음 | 허용하지 않음
  “” | 허용 | 않음 | 허용하지 않음
  ” “(space) | 허용 | 허용 | 허용하지 않음
  > 실제 디비에는 모두 not null로 들어 간다.


> `properties`를 사용할때는 `app.~`으로 한번에 다 받아서 각 DTO마다 다른 이름으로 `@ConfiguraionProperties`를 안하고 하나로 받아서 하는게 편하겠지?

> `@Value` 어노테이션을 가급적 안쓰는게 좋다. 그냥 `@ConfigurationProperties("yujun")`을 쓰는게 더 편하고 좋다. 이걸 쓰면 위에서 배운 융통성있는 바인딩도 적용이 된다. 캐멀케이스, 대문자로 써도 된다.  
`@Value` 어노테이션을 쓰려면 `application.properties`에 정의되어있는 문자 그대로 써야한다. 그리고 이런 META 정보도 제공해주지 않는다. 딱 하나 차이가 있다면 `@Value`에는 **Sp**ring **L**anguage **E**xpression을 사용할 수 있지만 위에 있는 기능들은 전부 사용을 못한다. 

# 4-7 프로파일

`config/`에 2개의 Configuration클래스에 `@Profile("prod")`, `@Profile("test")` 이렇게 각 2개의 Configuration이 있는데 저렇게 써놓고 `spring.profiles.active=test` 라고 적고 실행하면 `@Profile("test")`라고 적혀있는 Configuration이 실행된다.

> `CommanLine Arguments` 우선순위가 `application.properties`에 정의되어있는 arguments 보다 더 높다. Overriding 한다. 
`java –jar target/springinit-0.0.1 SNAPSHOT.jar —spring.profile.active=prod`
이 방법은 jar 파일로 하거나 Docker를 사용할 때 사용 

또 다른 방법으로는 profile용 `properties`를 만든다. `application-prod.properties` 파일을 만든다.

Profile로 관련된 `properties` 우선순위가 기본인 `application.properties`보다 높다.  
`java –jar target/springinit-0.0.1 SNAPSHOT.jar —spring.profile.active=prod` 하면 `application.properties` 에 있는 값을 `application-prod.properties` 값이 Overriding 한다.

properties에서 `spring.profiles.include = prod` 이런식으로 해서 다른 `properties`를 활성화 할 수 있다.

Edit Configurations에서 `Program arguments`에서 값을 줘도 됨. 
> `spring.profiles.active=prod` 이 방법은 주로 개발을 할 때 profiles 값을 setting 하고싶을 때 사용

# 4-9 로깅 1부: 스프링 부트 기본 로거 설정

Spring Boot는 기본적으로 `Commnos Logging`을 사용하는데 `SLF4j`를 쓰자.  

`Commnos Logging`, `SLF4j` 는 실제 Logging을 하는 애들이 아니고 Logger API를 추상화해놓은 Interface들이다. 주로 Framework들은 Logging Parser를 사용한다. Logging Parser 장점은 Logging Parser (`Commons Logging`, `SLF4j`) 아래에 있는 `JUL`(Java Util Logging), `Log4J2`, `Logback` 얘들을 바꿔끼울 수 있다. 그래서 더욱이 Framework에서 코딩을 한다. Framework에서 사용하는 application들이 Logger를 자기들이 원하는 것을 사용하게끔 하기 위해서. Spring Framework에서 core 모듈이 개발되고 있을 때 Logging Parser가 `Commnos Logging` 밖에 없어서 이거를 사용하고 있어서 Spring의 기본 Logging Parser가 `Commons Logging`(런타임 도중에 Logger를 찾는다. classloader를 뒤지면서)이다.  


spring-boot 1.0에서는 `Commons Logging` 을 exclusion 하고 해서 `SLF4j` 설정을 했다. 최근에 Spring 5에서 exculsion 쓰지 않아도 안전하게 사용할 수 있도록 Spring 자체 내에서 jcl이라는 모듈을 만들어서 Spring-JCL 코드를 컴파일 시점에 `SLF4j`나 `Log4j2`로 변경할 수 있게 해주는 모듈을 만들었다. 그래서 그냥 Spring-JCL을 써도 된다. 결국에는 Spring-JCL이 개입을 하면서 이 코드가 `SLF4j`나 Log4j2 dependency가 있으면 여기로 쓰게 될 것이고 `SLF4j`는 JUL, Log4J2, Logback 들 중 에 선택을 하게 된다.

Spring-boot는 `Commons Logging`을 쓴다. `Commons Logging`을 써도 `SLF4j`로 가게 되어있고 `SLF4j`는 `Logback`을 사용하게 된다. 최종적으로 `Logback`을 사용하게 된다. 우리가 지금 껏 본 log는 `Logback`이 찍은 것이다.  
`Commons Logging -> SLF4j -> logback`

Dependency를 보면 starter-logging에서 하위에 `Logback`과 log4j-to-slf4j, jul-to-slf4j가 있는데 ‘log4j나 jul을 slf4j로 보내라' 그리고 `slf4j`를 구현한게 `logback`이니까 최종적으로 `logback`을 사용하게 되는 것이다.

Edit Configuration에서  
VM options : `-Ddebug`  
Program arguments : `--debug`  
해서 DEBUG 모드로 출력할 수 있다. 둘중에 하나만 하면 됨.  
DEBUG 모드는 모두 다 찍어주는게 아님. embedded container, Hibernate, Spring Boot 만 찍어준다. -> 음 뭐야

`—trace` : 모든 메시지를 DEBUG로 찍고 싶을 때  
`application.properties`에서 설정함  
컬러 출력 : `spring.output.ansi.enabled`	 spring.output.ansi.enabled=속성)  
파일 출력 : `logging.file` (log file을 설정) 또는 `logging.path` (directory를 설정하는것임. 설정하면 spring.log 라는 파일이 생성되고 쓰임)  
이 file은 10mb마다 rolling이 되고 나머지는 archiving이 됨(설정 가능)  
(default는 console에만 출력하고 있다.)  
로그 레벨 조정 : logging.lebel.패키지경로 = 로그 레벨

# 4-10 로깅 2부: 커스터마이징

logging.level.org.springframework = debug 하면 다 찍힘. 기본적으로 info로 찍히니까 내 패키지만 debug로 바꾸기

커스텀 로그 설정 파일 사용하기
- logging 관련설정을 내가 다 커스터마이징 하고 싶으면 
- Logback (추천) : logback-spring.xml (추천)/ logback.xml도 있음(너무 일찍 loading이 됨)
Logback extension (확장기능을 제공해줌) 
- 프로파일 <springProfile name="프로파일">
- Environment 프로퍼티 <springProperty>

```xml
<?xml version="1.0" encoding="UTF-8"?>
    <configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <logger name="me.yujun" level="DEBUG"/>
</configuration>
```

logging pattern들 설정은 사내에 적합한 패턴을 설정하면 됨
- Log4J2 : log4j2-spring.xml (여기서도 커스터마이징 가능)
- JUL (비추) : logging.properties

Logger를 Log4j2로 변경하기 (기본적으로는 logback을 쓴다)
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springwork.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```


# 4-13 Spring-Boot-Devtools

Spring Boot가 제공하는 optional한 tool이다. 반드시 써야하는 것도 아니고 부트가 기본적으로 적용하는것도 아니고

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

하면 여러 설정들이 바뀜. (주로 cache를 끔)

- cache 설정을 개발 환경에 맞게 변경.
- classpath에 있는 파일이 변경 될 때마다 자동으로 서버재시작. (코드를 바꾸면 자동으로 restart해줌. 우리가 톰캣을 껏다가 재실행 해주는 속도 보다 빠르다. 왜냐하면 Spring Boot는 클래스로더를 2개를 사용한다. 
  - base classloader  
    - Library들, 우리가 바꾸지 않는, 의존성을 읽어들이는 classloader
  - restart classloader
    - 우리 application을 읽어들이는 classloader. code 수정 후 Build Project (Ctrl + F9) 를 하고 새로고침.

- live reload – restart 했을 때 서버 재시작, 브라우저 auto refresh 해주는 기능 (원래 front-end에 있던 기능)
- browser plugin 설치해야 함
- live reload 서버 끄려면 `spring.devtools.liveload.enabled = false`

- 글로벌 설정 (`properties` 우선순위 1순위 but, 의존성에 있으면)
  - `~/.spring-boot-devtools.properties`

- Remote Applications  
원격에 applications 띄워놓고 local에서 작업. 운영할 때 쓰면 안됨. 
