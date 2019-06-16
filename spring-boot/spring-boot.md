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
 Bean 등록하는 방법이 `@ComponentScan`과 `@EnableAutoConfiguration` 두 가지가 있었는데 `@ComponentScan`으로 Bean으로 등록하는게 먼저 실행된다. 그래서 직접 다시 만든 Bean을 등록한 후 `@EnableAutoConfiguration`이 다시 다른 프로젝트에서 가져온 Bean을 등록을 하면서 처음 직접 만든 Bean을 등록한 것을 덮어씌우고 가져온 Bean을 사용한다.
 
---

`@ConditionalOnMissingBean`
- Bean으로 등록되지 않도록 조건을 걸어준다. 해당 타입의 Bean이 없을 때만 Bean으로 등록해줌
