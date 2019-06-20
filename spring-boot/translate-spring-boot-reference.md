# 파트3. 스프링 부트 사용
이번 섹션은 어떻게 스프링 부트를 사용해야 하는지에 대해 더 자세하게 설명한다. 빌드 시스템, auto-configuration과 어플리케이션 실행방법과 같은 주제를 다룬다. 또한 스프링 부트의 가장 좋은 연습을 다룬다. 비록 스프링 부트에 대한 특별한 것은 없지만, 따라서 개발 진행에 조금 더 쉽게할 수 있도록 몇가지 추천사항이 있다. 

스프링 부트를 시작한다면, 아마도 이 섹션에 들어가기 전에 시작하기(링크) 가이드를 읽어야 한다.

## 13. 빌드 시스템
dependency management를 지원하고 "Maven Central" 저장소에 배포된 아티펙트를 사용할 수 있는 빌드시스템을 강력히 추천한다. Maven이나 Gradle을 선택하는 것을 추천한다. 스프링 부트가 다른 빌드 시스템과 작동하는 것은 가능하지만 특별히 잘 지원되지 않는다.

## 13.1 Maven
Maven 유저는 `spring-boot-starter-parent` 프로젝트에서 상속하여 실용적인/합리적인 기본값을 얻을 수 있다. 부모 프로젝트는 다음과 같은 특징을 제공합니다:
- 기본 컴파일러 레벨은 Java 1.8
- UTF-8 소스 인코딩
- spring-boot-dependencies pom에서 상속하는 의존성 관리 섹션은, 공통의 의존성 버전을 관리한다. 이 의존성 관리는 pom에서 사용될 때 \<version> 태그를 생략할 수 있다.
- An execution of the repackage goal with a repackage execution id.
- 합리적인 리소스 필터링
- 합리적인 플러그인 구성 
- 프로파일 관련 파일을 포함한 `application.properties`과 `application.yml`을 대한 합리적인 리소스 필터링(예를 들면, `application-dev.properties` and `application-dev.yml`)

참고로, `application.properties` and `application.yml` 파일은 스프링 스타일 플레이스홀더인 `${...}`을 허용하기때문에, Maven 필터링은 `@..@` 플레이스홀더를 사용하는것으로 바뀌었다. (`resource.delimiter`로 불리는 Maven 프로퍼티 설정으로 재정의 할 수 있다.)

## 13.2.1 스타터 부모 상속
`spring-boot-stater-parent`로부터 상속받은 프로젝트를 설정하기 위해서, `parent`를 다음과 같이 세팅하세요.
```xml
<!-- Inherit defaults from Spring Boot -->
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.1.5.RELEASE</version>
</parent>
```
  > 이 의존성에는 스프링 부트 버전 숫자를 명시해야한다. 스타터에 추가적으로 임포트하는 것에는 버전 숫자를 빠뜨려도 안전하다.

설정을 할 때, 프로젝트의 속성을 재정의함으로써 각 의존성 또한 재정의할 수 있다. 예를 들어 다른 Spring Data release train으로 업그레이드하려면 `pom.xml`에 다음과 같이 추가하면 된다.

```xml
<properties>
	<spring-data-releasetrain.version>Fowler-SR2</spring-data-releasetrain.version>
</properties>
```

## 13.2.2 부모 POM없이 스프링부트 사용하기
모두가 `spring-boot-starter-parent` POM에서 상속하는것을 좋아하는것은 아니다. 아마도 사용할 필요가 있거나 모든 Maven 설정에서 명확하게 선언하는 것을 선호하는 공동의 기준이 있을 것이다.

`spring-boot-starter-parent`를 사용하고 싶지 않으면, 다음과 같이 `scope=import` 의존성을 사용함에 따라 의존성 관리의 이점을 계속 사용/유지할 수 있다.

```xml
<dependencyManagement>
	<dependencies>
		<dependency>
			<!-- Import dependency management from Spring Boot -->
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-dependencies</artifactId>
			<version>2.1.5.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```

앞선 설치 예시에서 위의 설명대로 속성을 사용하여 개별적으로 의존성을 재정의할 수 없다. 같은 결과를 얻으려면 `spring-boot-dependencies`항목이 들어가기 전에 `dependencyManagement`에 항목을 추가해야 한다. 예를 들면, Spring Data release train을 업그레이드하려면 다음과 같이 `pom.xml`에 요소를 추가할 수 있다.

```xml
<dependencyManagement>
	<dependencies>
		<!-- Override Spring Data release train provided by Spring Boot -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-releasetrain</artifactId>
			<version>Fowler-SR2</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-dependencies</artifactId>
			<version>2.1.5.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```

## 13.2.3 스프링 부트 메이븐 플러그인 사용하기
스프링 부트는 실행가능한 jar 파일로 패키징이 가능한 Maven 플러그인이 포함되어 있다. 다음으로 보여지는 예와 같이 플러그인을 사용하고 싶으면를 `<plugins>` 부분에 플러그인을 추가하면 된다.

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

## 13.3 Gradle
Gradle을 사용한 스프링 부트를 사용하는 것을 배우고 싶으면, 스프링 부트의 Gradle 플러그인 공식문서를 참조해라.
- Reference ([HTML](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/reference/html/) and [PDF](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/reference/pdf/spring-boot-gradle-plugin-reference.pdf))
- [API](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/api/)

## 13.4 Ant
## 13.5 Starters

스타터는 어플리케이션에 포함할 수 있는 편리한 의존성 기술자 세트/집합이다. 스프링의 모든 것들과 이것들과 관련된 기술을 예제 코드와 의존성 기술자의 복사-붙여넣기할 필요가 없이 한 번에 얻을 수 있다. 예를 들어, 스프링과 데이터베이스 접근을 위한 JPA를 사용해서 프로젝트를 시작하고 싶으면, 프로젝트에 `spring-boot-starter-data-jpa` 의존성을 포함하면 된다.

스타터에는 의존성들을 관리하는 집합들이 지원되고 있고 프로젝트를 실행하고 일관성있고 빠르게 실행할 필요가 있는 여러가지 많은 의존성들이 포함되어 있다. 

다음과 같은 어플리케이션 스타터는 스프링 부트의 `org.springframework.boot` 그룹에서 제공된다.

/ 표 /

## 14. 코드 구조화하기
스프링 부트는 작동하기위한 특정 코드 레이아웃이 필요는 없지만 작동에 도움되는 좋은 방법이 있다.

## 14.1 default 패키지 사용하기
클래스에 `package`선언이 포함되어 있지 않을때, default package가 된다. default package의 사용은 일반적으로 금지되고 피해야 한다. 모든 jar파일로부터 모든 클래스를 읽기 떄문에 `@ComponentScan`, `@EntityScan`, 또는 `@SpringBootApplication` 어노테이션을 사용하는 스프링 부트 어플리케이션에서 특정한 문제를 일으킬 수 있다.
> Java의 패키지 네이밍 컨벤션과 도메인 네임을 거꾸로되게 사용하는 것을 추천합니다.(예를 들어서, `com.example.project`)

## 14.메인 어플리케이션 클래스 위치 지정하기
일반적으로 다른 클래스들의 위에 있는 루트 패키지에 메인 어플리케이션을 위치시키는 것을 추천한다. `@SpringBootApplication` 어노테이션은 종종 메인 클래스에 놓인다. 그리고 특정 항목들에 대한 search package로 암묵적으로 정의된다. 예로, JPA 어플리케이션을 작성하는경우에 `@SpringBootApplication` 어노테이션이 작성된 클래스의 패키지가 `@Entity` 항목에 대한것을 검색하는데 사용된다. 루트 패키지를 사용 하는것은 프로젝트에서만 지원하는 component scan을 허용한다.
> 마지막 뭔가 이상하네

> `@SpringBootApplication`을 사용하고 싶지 않으면, `@EnableAutoConfiguration`와 `@ComponentScan` 어노테이션을 선언하면 `@SpringBootApplication` 대신에 똑같은 동작할 수 있다.

다음은 일반적인 레이아웃을 보여준다.
```
com
 +- example
     +- myapplication
         +- Application.java
         |
         +- customer
         |   +- Customer.java
         |   +- CustomerController.java
         |   +- CustomerService.java
         |   +- CustomerRepository.java
         |
         +- order
             +- Order.java
             +- OrderController.java
             +- OrderService.java
             +- OrderRepository.java
```			 
다음과 같이, `Application.java`파일은 기존 `@SpringBootApplication`에 따라 `main`메소드가 선언된다.

```java
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

## 15. 클래스 설정
스프링부트는 Java 기반 설정을 선호한다. 비록 XML 소스를 사용하는 `SpringApplication` 을 사용하는 것이 가능할지라도 일반적으로 당신의 주요 소스가 `@Configuration` 단일 클래스인 것을 추천한다. 보통 `main` 메소드를 정의한 클래스는 주요 `@Configuration`로서 좋은 후보가 된다.

## 15.1 추가 설정 클래스 불러오기
`@Configuration` 클래스 하나에 모든걸 넣을 필요 없다. `@Import` 어노테이션은 추가적으로 설정 클래스를 사용할 수 있게 해준다. 그 대신에, `@ComponentScan` 사용해서 `@Configuration` 클래스들을 포함한 모든 스프링 컴포넌트들을 자동적으로 가져올 수 있다.

## 15.2 XML 설정 불러오기
XML 기반 설정을 무조건 사용해야 한다면, `@Configuration` 클래스를 사용하여 시작하는 것을 추천한다. 그러면 XML 설정 파일을 로드하는 `@ImportResource` 어노테이션을 사용할 수 있다.

## 16. 자동 설정
스프링 부트 자동 설정은 추가한 jar 의존성에 기초한/따라 스프링 어플리케이션을 자동적으로 구성하려고 시도한다. 예를 들어, 클래스 패스에 `HSQLDB`가 있고 데이터베이스 연결 Bean들을 수동적으로 설정하지 않는다면 스프링 부트는 메모리 데이터베이스에서 자동으로 구성한다.

`@Configuration`클래스들 중 하나에 `@EnableAutoConfiguration` 또는 `@SpringBootApplication` 어노테이션을 추가함으로써 자동적으로 구성 할 필요가 있다.

> 항상 `@SpringBootApplication`이나 `@EnableAutoConfiguration` 어노테이션 중 하나만 추가해야 한다. We generally recommend that you add one or the other to your primary `@Configuration` class only.

## 16.1 점진적으로 자동 설정 대체하기
자동 설정은 비침습적이다. 어느 지점에서, 자동 설정의 특정 부분을 대신해서 자신만의 설정으로 정의하여 시작할 수 있다. 예를 들어서,  `DataSource` 빈을 추가하면 기본 임베디드 데이터베이스 지원이 사라진다.

자동 설정이 현재 지원되고 있는지, 그리고 또 왜 그런지 알고 싶으면, `--debug` 를 사용하여 어플리케이션을 시작해라. 이렇게하면 코어 로거 부분에 대한 디버그 로깅과 콘솔에 상태를 로깅한다.

## 16.2 특정 자동설정 비활성화
지원되길 원하지 않는 자동 설정 특정 클래스를 찾는다면, 다음 보여지는 예와 같이 비활성화 하기 위해 `@EnableAutoConfiguration`의 exclude 속성을 사용할 수 있다.

```java
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MyConfiguration {
}
```

클래스가 클래스패스에 있지 않으면, 어노테이션의 속성 `excludeName`을 사용할 수 있고, 대신에 완전한 이름을 명시해라. 마지막으로, `spring.autoconfigure.exclude` 속성을 사용하여 제외해서 자동 설정 클래스의 리스트 또한 제어할 수 있다.

> 어노테이션 레벨과 속성을 사용하는 것 모두 다 제외를 항목을 정의할 수 있다.

## 17. 스프링 빈과 의존성 주입

의존성 주입과 빈을 정의하기 위해 표준 스프링 프레임워크 기술을 사용하는 것은 자유다. 간단히 말하자면,  `@ComponentScan`(빈을 찾기 위해서)과 `@Autowired`(생성자 주입하기 위해서)을 사용하는 것을 종종 볼수 있다.  

위에서 제안한 대로 코드를 구조화하면 
(루트 패키지에 어플리케이션 클래스 배치), 다른 매개변수 없이 `@ComponentScan`을 추가할 수 있다. 모든 어플리케이션 컴포넌트(`@Component`, `@Service`, `@Repository`, `@Controller` 등)이 스프링 빈으로서 자동적으로 등록 된다.

다음 예는 `@Service` 빈이 필요한 `RiskAssessor`빈 얻기 위해 생성자 주입을 사용하는 것을 보여준다.

```java
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAccountService implements AccountService {

	private final RiskAssessor riskAssessor;

	@Autowired
	public DatabaseAccountService(RiskAssessor riskAssessor) {
		this.riskAssessor = riskAssessor;
	}

	// ...

}
```

다음 예와같이, 만약 빈이 생성자를 하나만 가지고 있으면, `@Autowired`를 생략할 수 있다. 

```java
@Service
public class DatabaseAccountService implements AccountService {

	private final RiskAssessor riskAssessor;

	public DatabaseAccountService(RiskAssessor riskAssessor) {
		this.riskAssessor = riskAssessor;
	}

	// ...

}
```

> 생성자 주입을 사용하면 `final`로 표시된 `riskAssessor`이 나중에 변경될 수 없다는 것에 주목하자

## 18. `@SpringBootApplicaion` 어노테이션 사용하기

많은 스프링 부트 개발자는 "application class"에서 자동 설정, 컴포넌트 스캔과 그 이외의 설정을 자신의 앱에서 사용하는 것을 좋아한다. `@SpringBootApplication` 어노테이션 하나로 3가지 특징을 사용할 수 있다.

- `@EnableAutoConfiguration` : [스프링 부트 자동 설정 메커니즘](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-auto-configuration) 활성화
- `@ComponentScan` : 어플리케이션이 위치하고 있는 패키지에서 `@Component` 스캔 활성화 ([좋은 예제](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-structuring-your-code))
- `@Configuration` : 컨텍스트에서 이외의 빈을 등록하거나 추가적인 설정 클래스들을 불러오는 것을 허용

다음 예와 같이, `@SpringBootApplication` 어노테이션은 `@Configuration`, `@EnableAutoConfiguration`, 그리고 `@ComponentScan`의 기본 속성을 가지고 사용하는 것과 같다. 

```java
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @Configuration @EnableAutoConfiguration @ComponentScan와 같다.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```

> `@SpringBootApplication`은 `@EnableAutoConfiguration`와 `@ComponentScan`의 별칭을 커스텀하는 속성도 제공한다.

> 이러한 기능은 필수사항이 아니고 어떤 기능들을 활성화하는 하나의 어노테이션으로 대체할 것을 선택할 것이다. 예를 들어, 어플리케이션에서 컴포넌트 스캔을 사용하고 싶지 않으면

```java
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({ MyConfig.class, MyAnotherConfig.class })
public class Application {

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
	}

}
```
> 이 예제에서, `Application`은 사용자가 정의한 빈들을 명확하게 불러오고(`@Import`) 자동적으로 `@Component` 어노테이션이 있는 클래스를 감지하지 못하는 것을 제외한 그저 다른 스프링 부트 어플리케이션과 같다. 

## 19. 어플리케이션 실행하기

내장 HTTP 서버와 어플리케이션을 jar로 패키징하는것의 가장 큰 이점은 다른 어플리케이션과 마찬가지로 어플리케이션을 실행할 수 있다. 또한 스프링 부트 어플리케이션 디버깅은 쉽다. 특별한 IDE 플러그인이나 확장이 필요하지 않다.

> 이 부분은 오직 jar 기반 패키징만 다룬다. war 파일로 어플리케이션을 패키징하려면, 서버와 IDE 공식문서를 참조해야한다.

## 19.1 IDE에서 실행하기

간단한 자바 어플리케이션으로서 IDE로부터 스프링 부트 어플리케이션을 실행할 수 있다. 그러나, 가장 먼저 프로젝트를 불러와야한다. 불러오는 과정은 IDE와 빌드 시스템에 의존하는것에 따라 다르다. 대부분의 IDE는 직접 메이븐 프로젝트를 불러올 수 있다. 예를 들어서, Eclipse 사용자는 `File`메뉴에서 `Import` -> `Existing Maven Projects` 를 선택할 수 있다.

IDE에서 프로젝트를 직접적으로 불러낼 수 없는 경우에는, 빌드 플러그인을 사용함으로써 IDE 메타데이터를 생성할 수 있다. 메이븐은 Eclipse와 IDEA를 위한 플러그인을 포함한다. Gradle은 다양한 IDEs를 위한 플러그인을 제공한다.

> 뜻하지않게 웹 어플리케이션을 두번 실행한다면, "포트가 이미 사용중이다."라는 에러를 볼 것입니다. STS 사용자는 `Relaunch` 버튼 대신에 어떤 존재하고 있는 인스턴스를 닫혀있는것을 보장하는 `Run` 버튼을 사용할 수 있다.

## 19.2 패키지된 어플리케이션으로 실행하기

다음 보이는 예와 같이, 스프링 부트 메이븐이나 Gradle 플러그인으로 실행 가능한 jar 파일을 만들면, `java -jar`로 어플리케이션을 실행할 수 있다.
`$ java -jar target/myapplication-0.0.1-SNAPSHOT.jar`

원격 디버깅 지원이 활성화된 패키지 어플리케이션을 실행하는 것 또한 가능하다. 다음 보여지는 예와 같이, 패키지된 어플리케이션에 디버거를 첨가해보자.
```
$ java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
       -jar target/myapplication-0.0.1-SNAPSHOT.jar
```

## 19.3 메이븐 플러그인 사용하기
스프링 부트 메이븐 플러그인은 어플리케이션을 실행하고 빠르게 컴파일하여 사용할 수 있게 되는 `run` 목표를 가지고 있다. 어플리케이션은 IDE. 스프링 부트 다음 예는 어플리케이션을 실행하기 위한 대표적인 메이븐 커맨드를 보여준다.
```
$ mvn spring-boot:run
```

```
$ export MAVEN_OPTS=-Xmx1024m
```

---
go into detail : 상세히 설명하다.  
particularly : 특히, 특별히  
?when followed : 따라서  
start out : 시작하다  
omit : 빠뜨리다, 생략하다, 누락시키다.  
execution : 실행, 수행  
Sensible : 합리적인, 실용적인  
Note that : 참고로  
preceding : 이전의, 앞선  
executable : 실행 가능한  
explicitly : 분명하게, 명쾌하게, 명백하게  
a set of + N : N 세트  
one-stop : 한 곳에서, 다 할 수 있는  
hunt : 찾다, 뒤지다  
consistent : 한결같은, 일관된, 변함없는  
reversed : 거꾸로 된, 반대의, 뒤집은    
be placed on : ~에 놓이다  
implicitly : 암암리에, 무조건, 절대적으로, 넌지시  
certain items : 특정 항목들 
equivalent : 상응하는, 동등한, 맞먹는  
Alternatively : 그 대신에, 그렇지 않으면  
by ~ing : ~함으로써  
Gradually : 서서히, 점진적으로  
At any point : 어떠한 관점에서, 어느 지점  
back away : 사라지다, 손을 떼다, 후퇴하다, 물러서다  
Disabling : 무력화, 비활성화  
For simplicity : 간단히 말해서, 간단히 말하자면, 정리하면  
be marked as : ~로 표시된  
subsequently : 그 뒤에, 나중에  
equivalent : 동등한, 맞먹는  
mandatory : 정해진, 의무적인  
vary : (상황에 따라)다르다, 달라지다  
generate : 발생시키다, 만들어 내다, 생기게 하다  
accidentally : 우연히, 뜻하지 않게, 잘못하여  
attach : 첨부하다, 부여하다, 붙이다, 추가하다, 첨가하다, 덧붙이다.  