# 파트3. 스프링 부트 사용
이번 섹션은 어떻게 스프링 부트를 사용해야 하는지에 대해 더 자세하게 설명한다. 빌드 시스템, auto-configuration과 어플리케이션 실행방법과 같은 주제를 다룬다. 또한 스프링 부트의 가장 좋은 연습을 다룬다. 비록 스프링 부트에 대한 특별한 것은 없지만, 따라서 개발 진행에 조금 더 쉽게할 수 있도록 몇가지 추천사항이 있다. 

스프링 부트를 시작한다면, 아마도 이 섹션에 들어가기 전에 시작하기(링크) 가이드를 읽어야 한다.

## 13. 빌드 시스템
dependency management를 지원하고 "Maven Central" 저장소에 배포된 아티펙트를 사용할 수 있는 빌드시스템을 강력히 추천한다. Maven이나 Gradle을 선택하는 것을 추천한다. 스프링 부트가 다른 빌드 시스템과 작동하는 것은 가능하지만 특별히 잘 지원되지 않는다.

### 13.1 Maven
Maven 유저는 `spring-boot-starter-parent` 프로젝트에서 상속하여 실용적인/합리적인 기본값을 얻을 수 있다. 부모 프로젝트는 다음과 같은 특징을 제공합니다:
- 기본 컴파일러 레벨은 Java 1.8
- UTF-8 소스 인코딩
- spring-boot-dependencies pom에서 상속하는 의존성 관리 섹션은, 공통의 의존성 버전을 관리한다. 이 의존성 관리는 pom에서 사용될 때 \<version> 태그를 생략할 수 있다.
- An execution of the repackage goal with a repackage execution id.
- 합리적인 리소스 필터링
- 합리적인 플러그인 구성 
- 프로파일 관련 파일을 포함한 `application.properties`과 `application.yml`을 대한 합리적인 리소스 필터링(예를 들면, `application-dev.properties` and `application-dev.yml`)

참고로, `application.properties` and `application.yml` 파일은 스프링 스타일 플레이스홀더인 `${...}`을 허용하기때문에, Maven 필터링은 `@..@` 플레이스홀더를 사용하는것으로 바뀌었다. (`resource.delimiter`로 불리는 Maven 프로퍼티 설정으로 재정의 할 수 있다.)

### 13.2.1 스타터 부모 상속
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

### 13.2.2 부모 POM없이 스프링부트 사용하기
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

### 13.2.3 스프링 부트 메이븐 플러그인 사용하기
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

### 13.3 Gradle
Gradle을 사용한 스프링 부트를 사용하는 것을 배우고 싶으면, 스프링 부트의 Gradle 플러그인 공식문서를 참조해라.
- Reference ([HTML](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/reference/html/) and [PDF](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/reference/pdf/spring-boot-gradle-plugin-reference.pdf))
- [API](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/gradle-plugin/api/)

### 13.4 Ant
### 13.5 Starters

스타터는 어플리케이션에 포함할 수 있는 편리한 의존성 기술자 세트/집합이다. 스프링의 모든 것들과 이것들과 관련된 기술을 예제 코드와 의존성 기술자의 복사-붙여넣기할 필요가 없이 한 번에 얻을 수 있다. 예를 들어, 스프링과 데이터베이스 접근을 위한 JPA를 사용해서 프로젝트를 시작하고 싶으면, 프로젝트에 `spring-boot-starter-data-jpa` 의존성을 포함하면 된다.

스타터에는 의존성들을 관리하는 집합들이 지원되고 있고 프로젝트를 실행하고 일관성있고 빠르게 실행할 필요가 있는 여러가지 많은 의존성들이 포함되어 있다. 

다음과 같은 어플리케이션 스타터는 스프링 부트의 `org.springframework.boot` 그룹에서 제공된다.

/ 표 /

## 14. 코드 구조화하기
스프링 부트는 작동하기위한 특정 코드 레이아웃이 필요는 없지만 작동에 도움되는 좋은 방법이 있다.

### 14.1 default 패키지 사용하기
클래스에 `package`선언이 포함되어 있지 않을때, default package가 된다. default package의 사용은 일반적으로 금지되고 피해야 한다. 모든 jar파일로부터 모든 클래스를 읽기 떄문에 `@ComponentScan`, `@EntityScan`, 또는 `@SpringBootApplication` 어노테이션을 사용하는 스프링 부트 어플리케이션에서 특정한 문제를 일으킬 수 있다.
> Java의 패키지 네이밍 컨벤션과 도메인 네임을 거꾸로되게 사용하는 것을 추천합니다.(예를 들어서, `com.example.project`)

### 14.2메인 어플리케이션 클래스 위치 지정하기
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

### 15.1 추가 설정 클래스 불러오기
`@Configuration` 클래스 하나에 모든걸 넣을 필요 없다. `@Import` 어노테이션은 추가적으로 설정 클래스를 사용할 수 있게 해준다. 그 대신에, `@ComponentScan` 사용해서 `@Configuration` 클래스들을 포함한 모든 스프링 컴포넌트들을 자동적으로 가져올 수 있다.

### 15.2 XML 설정 불러오기
XML 기반 설정을 무조건 사용해야 한다면, `@Configuration` 클래스를 사용하여 시작하는 것을 추천한다. 그러면 XML 설정 파일을 로드하는 `@ImportResource` 어노테이션을 사용할 수 있다.

## 16. 자동 설정
스프링 부트 자동 설정은 추가한 jar 의존성에 기초한/따라 스프링 어플리케이션을 자동적으로 구성하려고 시도한다. 예를 들어, 클래스 패스에 `HSQLDB`가 있고 데이터베이스 연결 Bean들을 수동적으로 설정하지 않는다면 스프링 부트는 메모리 데이터베이스에서 자동으로 구성한다.

`@Configuration`클래스들 중 하나에 `@EnableAutoConfiguration` 또는 `@SpringBootApplication` 어노테이션을 추가함으로써 자동적으로 구성 할 필요가 있다.

> 항상 `@SpringBootApplication`이나 `@EnableAutoConfiguration` 어노테이션 중 하나만 추가해야 한다. We generally recommend that you add one or the other to your primary `@Configuration` class only.

### 16.1 점진적으로 자동 설정 대체하기
자동 설정은 비침습적이다. 어느 지점에서, 자동 설정의 특정 부분을 대신해서 자신만의 설정으로 정의하여 시작할 수 있다. 예를 들어서,  `DataSource` 빈을 추가하면 기본 임베디드 데이터베이스 지원이 사라진다.

자동 설정이 현재 지원되고 있는지, 그리고 또 왜 그런지 알고 싶으면, `--debug` 를 사용하여 어플리케이션을 시작해라. 이렇게하면 코어 로거 부분에 대한 디버그 로깅과 콘솔에 상태를 로깅한다.

### 16.2 특정 자동설정 비활성화
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

### 19.1 IDE에서 실행하기

간단한 자바 어플리케이션으로서 IDE로부터 스프링 부트 어플리케이션을 실행할 수 있다. 그러나, 가장 먼저 프로젝트를 불러와야한다. 불러오는 과정은 IDE와 빌드 시스템에 의존하는것에 따라 다르다. 대부분의 IDE는 직접 메이븐 프로젝트를 불러올 수 있다. 예를 들어서, Eclipse 사용자는 `File`메뉴에서 `Import` -> `Existing Maven Projects` 를 선택할 수 있다.

IDE에서 프로젝트를 직접적으로 불러낼 수 없는 경우에는, 빌드 플러그인을 사용함으로써 IDE 메타데이터를 생성할 수 있다. 메이븐은 Eclipse와 IDEA를 위한 플러그인을 포함한다. Gradle은 다양한 IDEs를 위한 플러그인을 제공한다.

> 뜻하지않게 웹 어플리케이션을 두번 실행한다면, "포트가 이미 사용중이다."라는 에러를 볼 것입니다. STS 사용자는 `Relaunch` 버튼 대신에 어떤 존재하고 있는 인스턴스를 닫혀있는것을 보장하는 `Run` 버튼을 사용할 수 있다.

### 19.2 패키지된 어플리케이션으로 실행하기

다음 보이는 예와 같이, 스프링 부트 메이븐이나 Gradle 플러그인으로 실행 가능한 jar 파일을 만들면, `java -jar`로 어플리케이션을 실행할 수 있다.
`$ java -jar target/myapplication-0.0.1-SNAPSHOT.jar`

원격 디버깅 지원이 활성화된 패키지 어플리케이션을 실행하는 것 또한 가능하다. 다음 보여지는 예와 같이, 패키지된 어플리케이션에 디버거를 첨가해보자.
```
$ java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
       -jar target/myapplication-0.0.1-SNAPSHOT.jar
```

### 19.3 메이븐 플러그인 사용하기
스프링 부트 메이븐 플러그인은 어플리케이션을 실행하고 빠르게 컴파일하여 사용할 수 있게 되는 `run` 목표를 가지고 있다. 어플리케이션은 IDE에서 메이븐은 분리된 형태로 실행된다. 다음 예는 스프링 부트 어플리케이션을 실행하기 위한 대표적인 메이븐 명령어를 보여준다.
```
$ mvn spring-boot:run
```

운영체제 환경 변수 `MAVEN_OPTS`를 사용하기를 원할 수도 있다. 다음의 예를 보자

```
$ export MAVEN_OPTS=-Xmx1024m
```

### 19.4 Gradle 플러그인 사용하기
스프링 부트 Gradle 플러그인 또한 분해된 상태에서 어플리케이션을 실행할 수 있는 `bootRun` 작업을 포함하고 있다. 다음 보여지는 예와 같이 `bootRun` 작업은 `org.springframework.boot`과 `java`을 지원할 때 추가된다.

```
$ gradle bootRun
```

다음 예와 같이  운영체제 환경변수 `JAVA_OPTS`를 사용하는 것을 원할 수도 있다.

```
$ export JAVA_OPTS=-Xmx1024m
```


### 19.5 핫 스와핑
스프링부트는 보통의 자바 어플리케이션이기 때문에, JVM 핫 스와핑은 즉시 사용가능 하다. JVM 핫 스와핑은 교체 가능한 바이트코드로 이루어져 어느 정도 한계가 있다. 좀 더 완벽한 솔루션을 위해, [JRebel](https://zeroturnaround.com/software/jrebel/)을 사용할 수 있다.

`spring-boot-devtools` 모듈은 어플리케이션을 빠르게 재시작을 위한 지원도 포함하고 있다. 이 챕터 뒤의 [챕터20](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools), [Developer Tools](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools) 와 [Hot swapping "How-to"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools)의 상세정보를 보자.


## 20 개발자 툴
스프링 부트는 쾌적한 개발 경험을 [만들 수 있는/만들어 주는] 추가적인 툴 세트를 포함하고 있다. `spring-boot-devtools` 모듈은 어떤 프로젝트에 추가적인 개발 시간 특성을 제공하는 것을 포함한다. devtools 지원을 포함하기 위해서, 다음에 보여지는 메이븐과 Gradle에 대한 것들을 참조해서 빌드에 모듈 의존성을 추가하세요.

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies>
```

```ruby
configurations {
	developmentOnly
	runtimeClasspath {
		extendsFrom developmentOnly
	}
}
dependencies {
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}
```

> Developer tools는 완전히 패키지된 어플리케이션을 실행할 떄 자동적으로 비활성화 된다. `java -jar`으로 실행된 어플리케이션이거나 특별한 클래스로더로 실행 되었으면, "제품 어플리케이션"으로 간주된다. 이것들이 적용되지 않는다면 devtools를 제외하는것을 고려해보거나 시스템 속성을 `-Dspring.devtools.restart.enabled=false` 로 설정해라.

> Flagging the dependency as optional in Maven or using a custom`developmentOnly` configuration in Gradle (as shown above) is a best practice that prevents devtools from being transitively applied to other modules that use your project.

> 리패키지된 아카이브는 기본적으로 devtools를 포함하지 않는다. [원격 devtools 특성을 포함](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-remote)하여 사용하고 싶다면, 이를 포함한 빌드 속성 `excludeDevtools`를 비활성화 해야한다. 이 속성은 메이븐, Gradle 플러그인 둘다 지원된다.


### 20.1 기본 속성

스프링 부트가 지원하는 몇몇의 라이브러리는 성능 향상을 위해 캐시를 사용한다. 예를 들어, [템플릿 엔진](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-template-engines)은 템플릿 파일이 다시 파싱되는것을 [막기/피하기] 위해서 컴파일된 템플릿을 저장한다. 또한, 스프링 MVC는 정적 자원들을 제공할 때 응답하기 위해서 HTTP 캐싱 헤더를 추가할 수 있다.

개발하는 동안에는 캐싱은 많은 도움이 되지만 개발중에는 역효과를 낳을 수 있고, 어플리케이션에서 방금 만든 변경내역을 볼 수 없다. 이러한 이유로, spring-boot-devtools는 기본적으로 캐싱 옵션을 비활성화로 설정되어있다.

캐시 옵션은 보통 `application.properties` 파일에서 설정한다. 예를 들어, Thymeleaf는 `spring.thymeleaf.cache` 속성을 제공한다. 이러한 속성들을 수동적으로 세팅할 필요보다는 합리적인 개발 시간 구성을 자동적으로 지원하는 `spring-boot-devtools` 모듈을 사용하자.

왜냐하면 스프링 MVC와 스프링 WebFlux 어플리케이션을 개발하는 동안에 웹 요청 관련 정보들이 더 필요하기 때문에, 개발자 도구는 `web` 로깅 그룹에 대한 `DEBUG` 레벨의 로깅을 할 수 있다. 이는 들어오는 요청에 대한 자세한 정보(어떤 핸들러가 처리하고 있는지, 응답의 결과 등)들을 줄 것이다. 만약 모든 요청을 자세하게 로그하고 싶다면(잠재적인 중요한 정보들을 포함), 설정 속성인 `spring.http.log-request-details`을 적용할 수 있다.

> `application.properties`에서 지원받고 있는 기본 속성을 사용하고 싶지 않다면 `spring.devtools.add-properties`를 `false`로 설정할 수 있다.

> devtools가 적용되고 있는 속성의 전체 목록을 참조하려면 [DevToolsPropertyDefaultsPostProcessor](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-devtools/src/main/java/org/springframework/boot/devtools/env/DevToolsPropertyDefaultsPostProcessor.java)

### 20.2 자동 재시작
`spring-boot-devtools`를 사용하는 어플리케이션은 클래스패스에서 파일이 변경될 떄마다 자동으로 재시작한다. IDE에서 작업할 때 코드 변경에 대한 매우 빠른 피드백 루프를 줌으로써 유용한 기능이 될 수 있다. 기본적으로, 폴더를 가리키는 클래스패스에 있는 항목들은 변경사항에 대해 모니터링된다. 정적 항목과 뷰 템플릿과 같은 특정 항목들은 어플리케이션 [재시작을 할 필요가 없다는 것](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-restart-exclude)을 주목하세요.

```
재시작 트리거

클래스패스 자원을 모니터링하는 DevTools로서 트리거를 하는 유일한 방법은 클래스패스를 업데이트 하는 것이다. 방법은 클래스패스가 업데이트되는 방법은 사용하고 있는 IDE에 달려있다. IntelliJ IDEA에서는 프로젝트 빌드하기(`Build -> Build Project`)는 같은 효과를 갖는다.
```

> 포크가 활성화가 되는 한 DevTools은 제대로 작동하는 독립된 어플리케이션 클래스 로더가 필요하기 때문에 지원되고있는 빌드 플러그인(메이븐, Gradle)을 사용함으로써 어플리케이션을 시작할 수도 있다.

> 자동 재시작은 LiveReload와 함께 사용될때 잘 작동한다. 자세한 사항은 [LiveReload 파트](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-livereload)를 보자. JRebel을 사용한다면, 동적 클래스를 리로딩에 유리한 자동 재시작이 비활성화 된다. 다른 devtools 기능(LiveReload, 속성 재정의와 같은)들은 계속 사용된다.

> DevTools는 재시작을 하는 동안에 어플리케이션을 종료하기 위해서 어플리케이션 컨텍스트의 셧다운 훅에 의존하고 있다. 셧다운 훅을 비활성화를 하면 제대로 작동하지 않는다.  
(`SpringApplication.setRegisterShutdownHook(false)`)

> 클래스패스에 있는 항목이 변경될 때 트리거를 재시작해야하는지 결정할 떄 DevTools는 자동으로 `spring-boot`, `spring-boot-devtools`, `spring-boot-autoconfigure`, `spring-boot-actuator`, `spring-boot-starter` 라는 이름의 프로젝트를 무시한다.

> DevTools는  `ApplicationContext`가 사용하는  `ResourceLoader`를 사용자 정의해야한다. 


```
재시작vs재배치

The restart technology provided by Spring Boot works by using two classloaders. Classes that do not change (for example, those from third-party jars) are loaded into a base classloader. Classes that you are actively developing are loaded into a restart classloader. When the application is restarted, the restart classloader is thrown away and a new one is created. This approach means that application restarts are typically much faster than “cold starts”, since the base classloader is already available and populated.

If you find that restarts are not quick enough for your applications or you encounter classloading issues, you could consider reloading technologies such as JRebel from ZeroTurnaround. These work by rewriting classes as they are loaded to make them more amenable to reloading.
```

### 20.2.1 상태 평가에서 변경사항 로깅하기
기본적으로 어플리케이션을 재시작할 때 마다, 조건 평가 델타 를 보여주는 보고서를 기록한다. 이 보고서는 빈 추가나 제거, 설정 속성 설정과 같은 변경을 수행할 떄 어플리케이션의 자동 설정의 변경사항을 보여준다.

보고서의 로깅을 비활성화하려면, 다음 속성을 설정해라
`spring.devtools.restart.log-condition-evaluation-delta=false`

### 20.2.2 리소스 제외하기

변경사항이 생겨도 특정 리소스를 트리거 반드시 재시작을 할 필요는 없다. 예를들어서, 타임리프 템플릿은 그 자리에서 편집할 수 있다. 기본적으로,  `/META-INF/maven`, `/META-INF/resources`, `/resources`, `/static`, `/public`, `/templates`에서 리소스 변경은 트리거로 재시작하지 않고 [live reload](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-livereload)로 발생한다. 만약 이런 제외 항목들을 사용자 정의하고 싶다면, `spring.devtools.restart.exclude` 속성을 사용할 수 있다. 예를 들어서, `/static`과 `/public`만 제외하고 싶다면, 다음의 속성을 설정하세요.

`spring.devtools.restart.exclude=static/**,public/**`

> 이러한 기본적인 것들을 놔두고 추가적으로 제외할 항목을 추가하고 싶다면, `spring.devtools.restart.additional-exclude` 속성을 대신 사용해라.


### 20.2.3 추가 경로 보기
아마 클래스패스에 없는 파일을 변경할 때 어플리케이션에서 재시작되거나, 리로드되는것을 원할 것이다. 그러길 원하면, `spring.devtools.restart.additional-paths` 속성을 사용해서 변경사항을 지겨보기 위한 추가적인 경로를 설정해라. 이전에 설명한 `spring.devtools.restart.exclude` 속성을 사용해서 추가적인 경로 아래에서 전체 재시작이나 live reload로 [변경가능한지 아닌지/변경여부]를 제어할 수 있다.

### 20.2.4 재시작 비활성화하기

재시작 기능을 사용하고 싶지 않으면 `spring.devtools.restart.enabled` 속성을 사용하여 비활성화 할 수 있다. 대부분, `application.properties` 속성에서 설정할 수 있다. (그렇게 하면 재시작 클래스로더 기존 설정으로 하지만 파일 변경에 대한 것을 지켜보지 않는다.)

완전히 재시작 지원을 비활성화 해야하면 (예를 들면, 특정 라이브러리에서 작동하지 않기 때문에), 다음으로 보여지는 예와 같이 `SpringApplication.run(...)`이 실행되기 전에 `System` 속성의 `spring.devtools.restart.enabled`을 `false`로 설정해야한다. 

```java
public static void main(String[] args) {
	System.setProperty("spring.devtools.restart.enabled", "false");
	SpringApplication.run(MyApp.class, args);
}
```

### 20.2.5 트리거 파일 사용하기
IDE를 사용하여 변경된 파일을 계속 컴파일한다면, 특정 시간에만 재시작하는 편이 더 나을 수 있다. 그러기 위해서, 실제로 재시작 체크를 원할때 반드시 수정해야 하는 특정파일인 "트리거 파일"을 사용해라. 파일을 변경할때만 검사를 촉발하고 Devtools가 무엇인가 어떤 행동을 한것을 [알아챌/감지될]때만 재시작이 된다. 트리거 파일은 IDE의 플러그인을 사용하거나 수동적으로 업데이트할 수 있다.

트리거 파일을 사용하기 위해서, `spring.devtools.restart.trigger-file` 속성을 트리거 파일의 경로를 설정해라.

> 모든 프로젝트를 같은 방식으로 동작하도록 `spring.devtools.restart.trigger-file`을 글로벌 세팅으로 설정하는 것이 좋을 것이다. / 해야할 것이다.

### 20.2.6 재시작 클래스로더 사용자 정의하기

이전에 설명한 재시작vs리로드 부분에서, 재시작 기능은 2개의 클래스로드를 사용함으로써 구현된다. 대부분의 어플리케이션에 이 처리방법은 잘 작동한다. 그런데, 가끔 클래스로딩 이슈가 생길 수 있다. 

기본적으로, IDE에서 연 프로젝트는 "재시작" 클래스로더가 로드되고, 어떤 규칙적인 `.jar` 파일은 "기본" 클래스로더가 로드된다. 만약 멀티 모듈 프로젝트에서 작업을 하고 있고, IDE에 모든 모듈이 불러오지 않으면 그것들을 커스텀마이즈 해야 할 것이다. 그러기 위해서, `META-INF/spring-devtools.properties` 파일을 생성해라.

`spring-devtools.properties`파일은 `restart.exclude`와 `restart.include`를 접두사로해서 속성을 포함할 수 있다.  ---

### 20.2.7 Known Limitations
### 20.3 LiveReload
### 20.4 글로벌 설정
### 20.5 원격 어플리케이션
### 20.5.1 원격 클라이언트 어플리케이션 실행하기
### 20.5.2 원격 업데이트
## 21. 제품으로 어플리케이션 패키징하기
## 22. 다음에 읽을 내용

# Part IV. 스프링 부트 기능
이번 섹션에서는 스프링 부트의 상세한 것들을 볼 것이다. 여기서 키의 특징에 대해서 사용하고 싶거나 사용자 정의하고 싶어하는 것들을 배울 수 있다. 아직 하지 않았다면, 기초지식을 가질 수 있는 "파트2, "시작하기""와 "파트3, "스프링 부트 사용하기"" 섹션을 읽자.

## 23. SpringApplication
`SpringApplication` 클래스는 `main()` 메소드로에서 시작되는 스프링 어플리케이션을 부트스트랩 하기위한 편리한 방법을 제공한다. 다음 예제와 같이, 많은 상황에서 `SpringApplication.run`메소드에 위임할 수 있다.
```java
public static void main(String[] args) {
	SpringApplication.run(MySpringConfiguration.class, args);
}
```

어플리케이션을 실행할 떄, 다음과 비슷한 출력을 볼 수 있다.

```java
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::   v2.1.6.RELEASE

2013-07-31 00:08:16.117  INFO 56603 --- [           main] o.s.b.s.app.SampleApplication            : Starting SampleApplication v0.1.0 on mycomputer with PID 56603 (/apps/myapp.jar started by pwebb)
2013-07-31 00:08:16.166  INFO 56603 --- [           main] ationConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6e5a8246: startup date [Wed Jul 31 00:08:16 PDT 2013]; root of context hierarchy
2014-03-04 13:09:54.912  INFO 41370 --- [           main] .t.TomcatServletWebServerFactory : Server initialized with port: 8080
2014-03-04 13:09:56.501  INFO 41370 --- [           main] o.s.b.s.app.SampleApplication            : Started SampleApplication in 2.992 seconds (JVM running for 3.658)
```

기본적으로, 어플리케이션을 실행한 사용자와 같은 시작과 관련된 상세한 상세한 정보들을 포함한 `INFO` 레벨의 로깅 메시지를 보여준다. `INFO` 레벨 대신 다른 레벨의 로그가 필요하다면, [26.4 "로그 레벨"]()에 설명되어있는 것을 보고 설정할 수 있다.

### 23.1 시작 실패

어플리케이션 실행하는것을 실패했으면, 등록된 `FailureAnalyzers`로 문제를 고치기 위한 구체적인 행동과 에러 메시지 용도로 제공할 기회다. 예로, 포트 `8080`에서 웹 어플리케이션을 실행 했으면 그 포트는 이미 사용중이라서, 다음과 같은 비슷한 메시지를 봐야한다.

```
***************************
APPLICATION FAILED TO START
***************************

Description:

Embedded servlet container failed to start. Port 8080 was already in use.

Action:

Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
```

> 스프링 부트는 많은 `FailureAnalyzer` 구현체들을 제공하고 자신의 것을 추가할 수 있다.

예외를 처리할 수 있는 failure anayzers가 없는 경우에, 무엇이 잘못되었는지 이해하기 쉬운 자세한 조건의 보고서를 계속 보여줄 수 있다. 그러기 위해서, `org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener`에 대해서 `debug` 속성을 활성화 하거나 `DEBUG` 로깅을 활성화 해야한다.

예를 들어서, `java -jar`를 사용하여 어플리케이션을 실행하기 위해서, 다음과 같이 `debug` 속성을 활성화 할 수 있다.

`$ java -jar myproject-0.0.1-SNAPSHOT.jar --debug`


### 23.2 배너 사용자 정의하기

배너는 `banner.txt` 파일을 클래스패스에 추가하거나 파일과 관련된 위치에 있는 `spring.banner.location` 속성을 세팅함으로써 실행할 때 바꿔서 출력할 수 있다. 파일이 UTF-8대신 아른 것으로 인코딩 되어있다면, `spring.banner.charset`을 설정해야 한다. 게다가 텍스트 파일에, `spring.banner.image.location` 속성을 설정을 하거나 `banner.gif`, `banner.jpg`, 또는 `banner.png` 이미지 파일을 클래스 패스에 추가할 수 있다. 이미지는 ASCII art로 묘사해서 변환되고 텍스트 배너위에 출력된다.

`banner.txt` 파일 안에, 다음과 같은 플레이스홀더를 사용할 수 있다.

 #### Table 23.1. Banner variables

Variable |	Description
--- | ---
`${application.version}` | The version number of your application, as declared in `MANIFEST.MF`. For example, `Implementation-Version: 1.0` is printed as `1.0`.
`${application.formatted-version}` | The version number of your application, as declared in `MANIFEST.MF` and formatted for display (surrounded with brackets and prefixed with `v`). For example `(v1.0)`.
`${spring-boot.version}` | The Spring Boot version that you are using. For example `2.1.6.RELEASE`.
`${spring-boot.formatted-version}` | The Spring Boot version that you are using, formatted for display (surrounded with brackets and prefixed with `v`). For example `(v2.1.6.RELEASE)`.
`${Ansi.NAME}` (or `${AnsiColor.NAME}`, `${AnsiBackground.NAME}`, `${AnsiStyle.NAME}`) | Where `NAME` is the name of an ANSI escape code. See `AnsiPropertySource` for details.
`${application.title}` | The title of your application, as declared in `MANIFEST.MF`. For example `Implementation-Title: MyApp` is printed as `MyApp`.

> `SpringApplication.setBanner(...)` 메소드는 프로그래밍 방식으로 배너를 생성할 수 있다. `org.springframework.boot.Banner`를 사용하고 `printBanner()` 메소드를 구현해라.

배너가 `System.out`(`console`)로 출력되거나, 설정된 로그로 보내거나(`log`)거나 생산되지 않도록(`off`)하기 위해 `spring.main.banner-mode` 속성을 사용할 수도 있다.

출력된 배너는 다음과 같은 이름의 싱글톤 빈으로 등록된다
`springBootBanner`.

> YAML는 `off`를 `false`로 매핑하니까, 다음처럼 보여지는 예와 같이 어플리케이션에서 배너를 비활성화를 하고 싶다면 따옴표를 추가해라.
```java
spring:
	main:
		banner-mode: "off"
```
### 23.3 SpringApplication 사용자 정의하기
기존의 `SpringApplication`이 마음에 들지 않으면, 대신에 로컬 인스턴스를 만들거나 그것을 사용자 정의할 수 있다. 예를 들어서, 배너를 끄려면, 다음과 같이 쓸 수 있다.

```java
public static void main(String[] args) {
	SpringApplication app = new SpringApplication(MySpringConfiguration.class);
	app.setBannerMode(Banner.Mode.OFF);
	app.run(args);
}
```

> `SpringApplication`으로 넘어간 생성자 인자는 스프링 빈들에 대한 설정 소스이다. 대부분의 경우, 이것들은 `@Configuration` 클래스를 참조하지만 XML 설정과  스캔해야하는 패키지 또한 참조할 수 있다.

`application.properties`파일을 사용하여 `SpringApplication`을 설정하는 것 또한 가능하다. 자세한 것들은 [챕터24. 외부설정](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html) 을 보세요

구성 옵션의 전체 목록은 [`SpringApplication` Javadoc](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/SpringApplication.html)을 보세요

### 23.4 Fluent Builder API

만약 `ApplicationContext` 계층 (parent/child 관계를 사용하는 복합적인 구문)을 만들어야하거나 "fluent" 빌더 API를 사용하는것을 선호한다면, `SpringApplicationBuilder`를 사용해라.

다음의 보여지는 예와 같이, `SpringApplicationBuilder`은 다양한 메소드 호출을 함께 묶을 수 있고, 계층을 만들 수 있는 `parent`와 `child` 메소드를 포함한다.

```java
new SpringApplicationBuilder()
		.sources(Parent.class)
		.child(Application.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
```

> `ApplicationContext` 계층 구조를 만들 때 몇가지 제한이 있다. 예를 들어서, 웹 컴포넌트는 반드시 child 컨텍스트 안에 포함되어 있어야 하고, 같은 `Environment`은 parent와 child 컨텍스트 양쪽에서 사용 되어야 한다. 더 자세한 것들은 [`SpringApplicationBuilder` Javadoc](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/builder/SpringApplicationBuilder.html)에서 볼 수 있다.

### 23.5 어플리케이션 이벤트와 리스너

보통의 스프링 프레임워크 이벤트들에 더하여, 추가적인 몇몇의 어플리케이션 이벤트인 `ContextRefreshedEvent`, `SpringApplication`를 전송한다.

> 몇몇의 이벤트들은 실제로 `ApplicationContext`가 생성되기 전에 트리거 되므로, 리스너를 `@Bean`으로 등록할 수 없다. `SpringApplication.addListeners(...)` 메소드나 `SpringApplicationBuilder.listeners(...)` 메소드를 사용하여 리스너를 등록할 수 있다.  
리스너들을 자동으로 등록되기를 원한다면, 어플리케이션이 생성되는 것에 구애받지 않고, 프로젝트에 `META-INF/spring.factories`파일을 추가할 수 있고, 다음에 보이는 예와 같이, `org.springframework.context.ApplicationListener` 키를 사용함으로써 리스너들을 참고할 수 있다.  
`org.springframework.context.ApplicationListener=com.example.project.MyListener`

어플리케이션 이벤트는 어플리에키션에서 실행될 때, 다음과 같은 순서로 전송된다.

1. `ApplicationStartingEvent`는 실행을 시작했지만 리스너와 이니셜라이저의 등록에 대한것들을 제외하고 진행되기 전에 전송된다.
2. `ApplicationEnvironmentPreparedEvent`는 컨텍스트에서 사용될 `Environment` 을 알고있지만 컨텍스트가 생성되기 전에 전송된다.
3. `ApplicationPreparedEvent`는 빈 정의가 로드된 후에 새로고침이 시작하기 전에 전송된다.
4. `ApplicationStartedEvent`는 컨텍스트가 새로고침 된 후 어플리케이션과 커맨드-라인 실행기로 호출되기 전에 전송된다.
5. `ApplicationReadyEvent`는 어플리케이션과 커맨드-라인 실행기로 호출된 후에 전송된다. 이는 어플리케이션이 서비스 요청들에 대한 준비가 되었음를 나타낸다.
6. `ApplicationFailedEvent`는 실행할 때 예외가 있으면 전송된다.

> 자주 어플리케이션 이벤트를 사용할 필요가 없지만 어플리케이션 이벤트가 존재하는 것을 아는 것이 편리할 수 있다. 내부적으로, 스프링 부트는 작업의 여러가지들을 조작하기 위해 이벤트를 사용한다.

어플리케이션 이벤트는 스프링 프레임워크의 이벤트 퍼블리싱 메커니즘을 사용하여 전송된다. 이 매커니즘은 자식 컨텍스트의 리스너들에게 발생한 이벤트는 조상 컨텍스트의 리스너들에게도 발생하는것을 보장한다. 이것의 결과로, 어플리케이션에 `SpringApplication` 객체의 계층구조를 사용하면, 리스너는 같은 타입의 어플리케이션 이벤트의 여러개의 객체를 받을 것이다.

To allow your listener to distinguish between an event for its context and an event for a descendant context, it should request that its application context is injected and then compare the injected context with the context of the event. The context can be injected by implementing ApplicationContextAware or, if the listener is a bean, by using @Autowired.

### 23.6 웹 환경
`SpringApplication`는 사용자 대신 `ApplicationContext`의 올바른 타입을 생성하려고 시도한다.  `WebApplicationType`을 알아내기 위해 사용되는 알고리즘은 꽤 간단하다.

- 스프링 MVC가 있는 경우, `AnnotationConfigServletWebServerApplicationContext`가 사용된다.
- 스프링 MVC가 있지 않은 경우와 스프링 웹 플럭스가 있는 경우, `AnnotationConfigReactiveWebServerApplicationContext`가 사용된다.
- 그 외에는, `AnnotationConfigApplicationContext`가 사용 된다.

같은 어플리케이션에서 스프링 MVC와 스프링 웹플럭스의 새로운 `WebClient`를 사용하면, 스프링 MVC는 기본적으로 사용[된다는/될] 것을 의미한다. `setWebApplicationType(WebApplicationType)`를 호출하면 쉽게 재정의할 수 있다.

`setApplicationContextClass(…​)`을 호출하여 사용하는 `ApplicationContext` 타입을 완전히 제어도 가능하다.

> 이는 `SpringApplication` JUnit 테스트와 함께 사용할 떄 `setWebApplicationType(WebApplicationType.NONE)` 를 자주 호출하는 것이 바람직하다.

## 23.7 어플리케이션 인자에 접근하기
`SpringApplication.run(...)`에 전달했던 어플리케이션 인자들에 접근해야 하면 `org.springframework.boot.ApplicationArguments` 빈을 주입해라. 다음 보여지는 예와 같이, 원시 `String[]`뿐만 아니라 파싱된 `option`와 `non-option`인자 둘 다 `ApplicationArguments` 인터페이스에 접근하는  권한을 제공한다.

```java
import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class MyBean {

	@Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		// if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
	}

}
```

> 스프링 부트는 또한 스프링 `Environment`에서 `CommandLinePropertySource` 또한 등록한다. 이것은 `@Value` 어노테이션을 사용함으로써 하나의 어플리케이션 인자를 주입하는것도 가능하다.

### 23.8 어플리케이션 실행기나 커맨드라인 실행기 사용하기

`SpringApplication`이 시작되고 언젠가 특정한 코드를 실행하려면, `ApplicationRunner`나 `CommandLineRunner` 인터페이스를 구현해라. 두개의 인터페이스는 같은 방식으로 작동하고 하나의 `run` 메소드를 제공한다. 이것은 `SpringApplication.run(...)`이 완료되기 바로 직전에 호출된다.

`CommandLineRunner` 인터페이스는 간단한 문자 배열로서 어플리케이션 인자에 접근하는 방법을 제공한다. 반면에, `ApplicationRunner`는 앞에서 논의한 `ApplicationArguments` 인터페이스 사용한다. 다음 예는 `run`메소드를 사용한 `CommandLineRunner` 를 보여준다.

```java
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class MyBean implements CommandLineRunner {

	public void run(String... args) {
		// Do something...
	}

}
```
특정한 순서로 호출되어야 하는 몇몇의 `CommandLineRunner`이나 `ApplicationRunner` 빈들이 정의된 경우에 `org.springframework.core.Ordered` 인터페이스나 `org.springframework.core.annotation.Order` 어노테이션을 사용하여 추가적으로 구현할 수 있다.

### 23.9 어플리케이션 끄기
각각의 `SpringApplication`은 종료시에 `ApplicationContext`가 정상적이게 닫히는 것을 보장하는 JVM을 사용하여 셧다운 훅을 등록한다. 모든 표준 스프링 생명주기는 콜백(`DisposableBean` 인터페이스나  `@PreDestory`어노테이션과 같은)이 사용할 수 있다. 

게다가, 만약 `SpringApplication.exit()`가 호출될때 특정 종료 코드를 리턴 받길 원한다면 빈들은 `org.springframework.boot.ExitCodeGenerator` 인터페이스를 구현해야 한다. 다음에 보여지는 예제에서 이 종료 코드는 상태 코드같은 것을 반환받기 위해서`System.exit()`에 전달할수 있다.

```java
@SpringBootApplication
public class ExitCodeApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(ExitCodeApplication.class, args)));
	}

}
```

또한,`ExitCodeGenerator`인터페이스는 예외에 의해서 구현될 수도 있을 것이다. 예외와 맞닥뜨릴때, 스프링 부트는 구현된 `getExitCode()`로 제공된 종료 코드를 반환한다.

### 23.10 관리자 특징
`spring.application.admin.enabled` 속성에 명시하면 어플리케이션에 대한 관리와 관련된 기능을 활성화하는것이 가능하다. 이는 `MBeanServer` 플랫폼에 `SpringApplicationAdminMXBean`을 드러낸다. 이 기능으로 스프링 부트 어플리케이션을 원격으로 관리할 수 있다. 이 기능은 다른 서비스 랩퍼 구현에 대한 것에도 유용할 수 있다.

> 어플리케이션을 실행하는데 어떤 HTTP 포트를 사용하는지 알고 싶으면, `local.server.port`의 키를 사용하여 속성을 얻을 수 있다.

  > **주의**
    이 기능을 활성화할 때 어플리케이션을 끄기 위한 메소드인 MBean을 노출하므로 주의해라.


## 24. 외부 설정

스프링 부트는 다른 환경에서 같은 코드로 작동할 수 있도록 설정을 외부에서 할 수 있다. 외부에서 설정하기 위해 properties 파일, YAML 파일, 환경 변수 그리고 커맨드-라인 인자를 사용할 수 있다. 속성 값은 `@Value` 어노테이션을 사용하면 빈에 직접 주입을 할 수 있고 스프링의 `Environment` 추상(화)을 통해서 접근할 수 있거나 `@ConfigurationProperties`를 통해서 구조화된 객체에 바인딩이 될 수 있다.

스프링 부트는  합리적이게 값의 재정의를 허용하기위해 만들어진 아주 특별한 `PropertySource` 순서로 사용한다. 속성은 다음의 순서에 따라 고려된다.

1. 홈 디렉토리에서의 [Devtools 글로벌 설정 속성](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-globalsettings)(~/.spring-boot-devtools.properties Devtools가 켜있을 때).
2. 테스트에서의 [@TestPropertySource](https://docs.spring.io/spring/docs/5.1.8.RELEASE/javadoc-api/org/springframework/test/context/TestPropertySource.html) 어노테이션
3. 테스트에서 `properties` 속성. [`@SpringBootTest`](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/test/context/SpringBootTest.html)와 [어플리케이션의 특정한 부분 테스트에 대한 테스트 어노테이션](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-tests)
4. 커맨드-라인 인수
5. `SPRING_APPLICATION_JSON`에서의 속성 (시스템 속성이나 환경 변수에 내장된 인라인(직렬의?) JSON).
6. `ServletConfig` 초기 파라미터.
7. `ServletContext` 초기 파라미터.
8. `java:comp/env`에서의 JNDI 속성
9. 자바 시스템 속성 (`System.getProperties()`).
10. OS 환경변수.
11. `random.*` 속성만 가지고 있는 `RandomValuePropertySource`.
12. jar로 패키징된 외부의 프로필 관련 어플리케이션 속성(`application-{profile}.properties` and YAML variants).
13. jar로 패키징된 내부의 프로필 관련 어플리케이션 속성 (`application-{profile}.properties` and YAML variants).
14. jar로 패키징된 외부의 어플리케이션 속성 (`application.properties` and YAML variants).
15. jar로 패키징된 내부의 프로필 관련 어플리케이션 속성(`application.properties` and YAML variants).
16. `@Configuration` 클래스에 있는 `@PropertySource`어노테이션
17. 기본 속성 (`SpringApplication.setDefaultProperties`설정으로 명시된 ).

구체적인 예를 제공하기위해 다음으로 보여지는 예와 같이 `name`속성을 사용하는 `@Component`개발한다고 가정한다

```java
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Component
public class MyBean {

    @Value("${name}")
    private String name;

    // ...

}
```
어플리케이션 클래스패스에서(예를들면, jar의 내부) `name`에 대한 합리적인 기본 속성을 제공하는 `application.properties` 파일을 가질 수 있다. 새로운 환경에서 실행될 떄, `name`을 재정의한 `application.properties`파일은 jar의 외부에 제공할 수 있다. 일회성 테스트를 위해, 특정 커맨드-라인 스위치를 사용하여 실행할 수 있다.(예를 들어, `java -jar app.jar --name="Spring"`)

> 

### 24.1 랜덤 값 설정하기

`RandomValuePropertySource`는 랜덤 값을 주입하는것에 유용하다. (예를 들어서, 테스트 케이스나 암호) 다음과 같이 Integer, long, uuid 또는 문자열을 만들 수 있다.

```xml
my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.uuid=${random.uuid}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024,65536]}
```

`random.int*`구문은 `OPEN value (,max) CLOSE`이다. 여기서 `OPEN,CLOSE`은 문자이고 `value,max`은 정수다. 만약 `max`가 제공된다면, `value` 최소값이고 `max`는 최대값이다.

### 24.2 커맨드-라인 속성 접근하기

기본적으로, `SpringApplication`은 커맨드-라인 옵션 인자(인자를 시작할 떄 사용하는 `--`, `--server.port=9000`)를 `property`로 변환한다. 그리고 이것들을 스프링 `Environment`에 추가한다. 이전에 언급한것처럼, 커맨드-라인 속성은 다른 속성 코드보다 항상 우선시 된다.

만약 `Environment`에 추가되는 커맨드-라인 속성을 사용하길 원하지 않으면, `SpringApplication.setAddCommandLineProperties(false)`를 사용하여 비활성화 할 수 있다.

### 24.3 어플리케이션 속성 파일

다음의 위치에서 `application.properties`파일에서 `SpringApplication`은 속성을 불러오고 스프링 `Environment`에 추가한다.

1. 현재 디렉토리의 하위 디렉토리인 `/config`
2. 현재 디렉토리
3. 클래스패스 `/config` 패키지
4. 최상위 클래스패스

우선 순위에 따른 순서이다. (속성은 높은 위치에서 정의된것이 낮은 위치에 정의된 것을 재정의한다.)

> '.properties'의 대안으로서 YAML('.yml') 파일을 사용할 수도 있다.

만약 설정 파일 이름으로 `application.properties`이 마음에 들지 않는다면, `spring.config.name` 환경 속성으로 지정해서 다른 파일 이름으로 바꿀 수 있다. 또한 `spring.config.location` 환경 속성을 사용하여 명확한 위치를 참조할 수도 있다.(디렉토리 위치의 콤마로 분리된 순서나 파일 경로) 다음은 다른 파일 이름으로 지정하는법의 예를 보여준다.

`$ java -jar myproject.jar --spring.config.name=myproject`

다음은 두개의 위치를 지정하는 법을 보여준다.

`$ java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties`

> `spring.config.name`과 `spring.config.location`은 불러해야하는 파일을 알아내기위해 아주 빨리 사용되어서 환경 속성으로서 정의되어야 한다(일반적으로 OS 환경 변수, 시스템 속성 또는 커맨드-라인 인자).

만약 `spring.config.location`가 디렉토리를 포함하면, `/`로 끝나야 한다(그리고, 구동되기전에 프로파일-specific 파일을 포함한 `spring.config.name`에서 생성된 이름이 추가된다). 파일은 `spring.config.location`에 명시된 파일은 프로파일-specific 변형을 지원하지 않고 어느 프로파일-specific 속성으로서 재정의된다.

설정 위치는 역순으로 찾는다. 기본적으로 설정 위치는 `classpath:/,classpath:/config/,file:./,file:./config/` 이다. 검색 순서 결과는 다음과 같다.

1. `file:./config/`
2. `file:./`
3. `classpath:/config/`
4. `classpath:/`

커스텀 설정 위치가 `spring.config.location`을 사용하여 설정되었을 때, 기본의 위치를 대체한다. 예를 들어서, `spring.config.location`이 값이 `classpath:/custom-config/,file:./custom-config/`를 사용하여 설정되었으면, 다음과 같은 검색 순서가 된다.

1. `file:./custom-config/`
2. `classpath:custom-config/`

대신에, `spring.config.additional-location`을 사용하여 설정한 커스텀 설정 위치일때, 기본 위치에 더하여 사용한다. 추가된 위치는 기본 위치 전에 검색된다. 예를 들어서, 만약 `classpath:/custom-config/,file:./custom-config/`에 추가 위치가 설정된 경우에는, 다음과 같은 검색 순서가 된다.

1. `file:./custom-config/`
2. `classpath:custom-config/`
3. `file:./config/`
4. `file:./`
5. `classpath:/config/`
6. `classpath:/`

이 검색 순서는 하나의 설정 파일에서 기본 값으로 지정과 다른 설정 파일에서의 값을 선택적으로 재정의할 수 있다. 기본 위치중에서 하나인 `application.properties`(또는 `spring.config.name`을 사용하여 선택한 다른 기본 이름)에서 어플리케이션에 대한 기본 값을 제공할 수 있다. 이 기본 값들은 런타임 때 커스텀 위치중의 하나에서 다른 파일로 위치하고 있는 파일로 재정의할 수 있다.

> 만약 시스템 속성을 사용하는 대신에 환경 변수를 사용한다면, 대부분의 운영체제는 기간 별 키 이름을 허용하지 않지만 대신에 언더스코어`_`를 사용할 수 있다. (예, `spring.config.name` 대신으로 `SPRING_CONFIG_NAME`)

> 컨테이너에서 어플리케이션이 실행된다면, 환경 변수나 시스템 속성대신에 JDNI 속성(`java:comp/env`)이나 서블릿 컨텍스트 초기화 파라미터를 사용할 수 있다.

### 24.4 프로파일 specific 속성

`application.properties` 파일에 더하여, 프로필 specific 속성은 `application-{profile}.properties`와 같은 네이밍 컨벤션을 사용하여 정의할 수도 있다. `Environment`는 만약 프로파일을 설정하지 않은 경우에는 기본 프로파일의 설정(기본적으로 `[default]`)으로 사용된다. 다시 말해서, 만약 명확하게 설정한 프로파일이 없으면, `application-default.properties`로 부터 속성들을 불러온다.

프로파일-specific 속성들은 표준 `application.properties`로서 같은 위치에서 불러온다. 프로파일 specific 파일은 프로파일-specific 파일은 패키지된 jar파일이 내부나 외부에 있는것에 상관없이 명시가 되지 않은 것을 항상 재정의한다. 

만약 몇몇의 프로파일 명시되면, 마지막으로 이기는 전략을 지원한다. 예를 들어서, `spring.profiles.active` 속성으로 명시된 프로파일은 `SpringApplication` API를 통해서 설정된 후에 추가되고 그러므로 우선시 된다.

> `spring.config.location`에 파일을 명시했으면, 이 파일들의 프로파일-specific 변형은 고려되지 않는다. 프로파일-specific 속성들도 사용하고 싶다면 `spring.config.location`에 디렉토리를 사용해라

### 24.5 Properties 에서의 플레이스홀더
`application.properties`에 있는 값은 사용할 때 존재하는 `Environment`을 통해서 필터된다. 그래서 이전에 정의한 값들을 참조할 수 있다. (예로, 시스템 속성)

```xml
app.name=MyApp
app.description=${app.name} is a Spring Boot application
```
> 존재하는 스프링 부트 속성의 "short" 변형을 생성하기 위해서 이 기술을 사용할 수 있다. 자세한 설명은 [77.4, "커맨드 라인 인자에서 'Short' 사용하기"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-use-short-command-line-arguments)을 봐라


## 24.6 Properties 암호화하기
스프링 부트는 속성 값을 암호화 하는것에 대한 지원을 제공해주지 않는다. 하지만, 스프링 `Environment`에 포함된 값을 수정하기 위해서 필요한 훅 포인트를 제공해준다. `EnvironmentPostProcessor`인터페이스는 어플리케이션 실행 전에 `Environment`을 [조작/처리]하는것을 허용한다. 

### 24.7 Properties 대신에 YAML 사용하기
~
### 24.8 Properties 타입세이프 설정

properties 설정을 주입하기 위해 `@Value("${property}")` 어노테이션을 사용하는것은 때때로 다루기 힘들다. 특히 만약 여러개의 properties를 사용하거나 작업하거나 데이터가 계층 구조인 경우라면. 다음에 보여지는 예와 같이, 스프링 부트는 어플리케이션의 설정 검증과 강력하게 빈의 타입을 통제할 수 있는 속성을 사용하여 작동하는 대안의 메소드 제공한다. 

```java
package com.example;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("acme")
public class AcmeProperties {

	private boolean enabled;

	private InetAddress remoteAddress;

	private final Security security = new Security();

	public boolean isEnabled() { ... }

	public void setEnabled(boolean enabled) { ... }

	public InetAddress getRemoteAddress() { ... }

	public void setRemoteAddress(InetAddress remoteAddress) { ... }

	public Security getSecurity() { ... }

	public static class Security {

		private String username;

		private String password;

		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

		public String getUsername() { ... }

		public void setUsername(String username) { ... }

		public String getPassword() { ... }

		public void setPassword(String password) { ... }

		public List<String> getRoles() { ... }

		public void setRoles(List<String> roles) { ... }

	}
}
```

이전의 POJO는 다음의 속성을 정의한다.

- `acme.enabled`, 기본적으로 `false` 의 값을 사용한다.
- `acme.remote-address`, `String`으로 부터 강요받는 타입을 사용한다.
- `acme.security.username`, 속성의 이름으로 결정되는 중첩된 "security" 객체를 사용한다 . 특히, 반환 타입은 거기서 모두 사용되지 않고 `SecurityProperties` 빈을 가질 수 있다..
- `acme.security.password`.
- `acme.security.roles`, `String`의 콜렉션을 사용한다.

> Getters and setters are usually mandatory, since binding is through standard Java Beans property descriptors, just like in Spring MVC. A setter may be omitted in the following cases:

> - Maps, as long as they are initialized, need a getter but not necessarily a setter, since they can be mutated by the binder.
> - Collections and arrays can be accessed either through an index (typically with YAML) or by using a single comma-separated value (properties). In the latter case, a setter is mandatory. We recommend to always add a setter for such types. If you initialize a collection, make sure it is not immutable (as in the preceding example).
> - If nested POJO properties are initialized (like the Security field in the preceding example), a setter is not required. If you want the binder to create the instance on the fly by using its default constructor, you need a setter.
> Some people use Project Lombok to add getters and setters automatically. Make sure that Lombok does not generate any particular constructor for such a type, as it is used automatically by the container to instantiate the object.  

> Finally, only standard Java Bean properties are considered and binding on static properties is not supported.

> [`@Value`와 `@ConfigurationProperties`의 차이점](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-vs-value)을 봐라

다음으로 보여지는 예와 같이, `@EnableConfigurationProperties` 어노테이션에서 등록하기 위해서 클래스 속성을 나열할 필요가 있다.

```java
@Configuration
@EnableConfigurationProperties(AcmeProperties.class)
public class MyConfiguration {
}
```

> When the @ConfigurationProperties bean is registered that way, the bean has a conventional name: <prefix>-<fqn>, where <prefix> is the environment key prefix specified in the @ConfigurationProperties annotation and <fqn> is the fully qualified name of the bean. If the annotation does not provide any prefix, only the fully qualified name of the bean is used.

The bean name in the example above is acme-com.example.AcmeProperties.

The preceding configuration creates a regular bean for AcmeProperties. We recommend that @ConfigurationProperties only deal with the environment and, in particular, does not inject other beans from the context. Keep in mind that the @EnableConfigurationProperties annotation is also automatically applied to your project so that any existing bean annotated with @ConfigurationProperties is configured from the Environment. Instead of annotating MyConfiguration with @EnableConfigurationProperties(AcmeProperties.class), you could make AcmeProperties a bean, as shown in the following example:

```java
@Component
@ConfigurationProperties(prefix="acme")
public class AcmeProperties {

	// ... see the preceding example

}
```
이 설정의 스타일은 스프링 어플리케이션 외부 YAML 설정[에서/과] 특히 잘 작동한다.

```yml
# application.yml

acme:
	remote-address: 192.168.1.1
	security:
		username: admin
		roles:
		  - USER
		  - ADMIN

# additional configuration as required
```
다음의 예와 같이 `@ConfigurationProperties` 빈을 사용하여 작동하기 위해서, 다른 빈 처럼 같은 방법으로 주입하면 된다.

```java
@Service
public class MyService {

	private final AcmeProperties properties;

	@Autowired
	public MyService(AcmeProperties properties) {
	    this.properties = properties;
	}

 	//...

	@PostConstruct
	public void openConnection() {
		Server server = new Server(this.properties.getRemoteAddress());
		// ...
	}

}
```
> `@ConfigurationProperties` 사용하는 것은 자체 키에 대해 자동완성을 제공하는 IDE들을 사용할 수 있는 메타데이터 파일을 만들 수도 있다. 자세한 내용은 부록 B, 설정 메타데이터 부록을 참조해라

### 24.8.1 써드파티 설정

클래스에 어노테이트를 하기 위해 `@ConfigurationProperties`를 사용하는 것 뿐만아니라, 퍼블릭 `@Bean` 메소드에서도 사용할 수 있다. 이렇게 하면 제어의 외부인 써드파티 컴포넌트에 속성을 바인딩하는 것을 원할 떄 특히 유용할 수 있다.

다음과 같이, `Environment` 속성에서 빈을 설정하려면, 빈을 등록하는 곳에 `@ConfigurationProperties`를 추가해라.

```java
@ConfigurationProperties(prefix = "another")
@Bean
public AnotherComponent anotherComponent() {
	...
}
```

`another` 접두어를 사용하여 정의된 속성은 이전의 `AcmeProperties` 예제와 [유사한/비슷한] 방식으로 `AnotherComponent` 빈에 매핑된다.

### 24.8.2 유연한 바인딩

스프링부트는 `@ConfigurationProperties`빈에서 `Environment` 바인딩에 대한 유연한 규칙을 사용한다. 그래서 `Environment` 속성 이름과 빈 속성 이름이 정확하게 일치할 필요가 없다. 유용한 공통의 예는 대시(`-`)로 구분된 환경 속성(예, `context-path`는 `contextPath`에 바인드한다.) 과 대문자로 쓰는 환경 속성(예, `PORT`가 `port`에 바인드)을 포함한다. 

예를 들어서, 다음의 `@ConfigurationProperties` 클래스를 고려해라.

```java
@ConfigurationProperties(prefix="acme.my-project.person")
public class OwnerProperties {

	private String firstName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
```

앞선 예에서, 다음의 속성 이름은 모두 사용할 수 있다.


  ##### 테이블 24.1 유연한 바인딩
  속성 | 뜻
  --- | ---
  `acme.my-project.person.first-name` | Kebab case, `.properties`와 `.yml`파일에서 사용하는 것을 추천한다.
  `acme.myProject.person.firstName` | 표준 camel 케이스 구문
  `acme.my_project.person.first_name` | 밑줄 표기법, `.properties`와 `.yml`파일에서 사용하는 대안의 포맷
  `ACME_MYPROJECT_PERSON_FIRSTNAME` | 대문자 형식, 시스템 변수에서 사용할 때 추천.

  > 어노테이션에 대한 `prefix` 값은 kebab case이여야 한다.(`acme.my-project.person`처럼 소문자형식과 `-`로 분리된.)

  ##### 테이블 24.2 속성 소스에 대한 유연한 바인딩 규칙 
  속성 소스 | Simple | List
  --- | --- | ---
  Properties 파일 | Camel case, kebab case, 또는 underscore 표기법 | `[ ]`를 사용한 표준 목록 구문이나 콤마로 나눠진 값
  YAML 파일 | Camel case, kebab case, or underscore 표기법 | 표준 YAML 나열 구문이나 콤마로 나눠진 값
  환경 변수 | 구분자로서 밑줄과 사용한 Upper case. `_`는 속성 이름에서 사용하면 안된다.| `MY_ACME_1_OTHER = my.acme[1].other` 같은 밑줄로 둘러쌓인 숫자 값, 
  시스템 속성 | Camel case, kebab case, or underscore 표기법 | 표준 목록 구문을 사용한 `[ ]` 또는 콤마로 나눠진 값

  > 가능하면, 속성은 lower-case kebab 포맷으로 저장하는 것을 추천한다. `my.property-name=acme`처럼.

`Map` 속성에 바인딩할 때, 만약 `key`를 글자와 숫자를 lowercase로 적거나 `-`를 [포함한다면/포함되어있는경우], 원래의 값을 보존하도록 하려면 괄호 표기법을 사용해라. key가 `[]`로 둘러쌓여 있지 않다면, 글자와 숫자가 아닌 문자나 `-`가 제거된다. 예를들어서, `Map`에 다음의 속성을 바인딩하는것을 고려해라.

```
acme:
  map:
    "[/key1]": value1
    "[/key2]": value2
    /key3: value3
```

위의 속성은 `Map`에 map에 key들로 `/key1`, `/key2`와 `key3`가 바인딩 될 것이다.

### 24.8.3 복잡한 타입 합치기 (YAML)
### 24.8.4 속성 변환

스프링 부트는 `@ConfigurationProperties` 빈들에 바인드 될 때 외부 어플리케이션 속성을 올바른 타입으로 강요하도록 시도한다. 만약 사용자 정의 타입 변형이 필요하면, `ConversionService` 빈(`conversionService`의 이름으로 된 빈)을 제공하거나, 속성 편집(`CustomEditorConfigurer`빈을 통해서)을 커스텀하거나 `Converters`(`@ConfigurationPropertiesBinding`같이 어노테이트 된 빈 정의)를 커스텀을 할 수 있다.

> As this bean is requested very early during the application lifecycle, make sure to limit the dependencies that your ConversionService is using. Typically, any dependency that you require may not be fully initialized at creation time. You may want to rename your custom ConversionService if it is not required for configuration keys coercion and only rely on custom converters qualified with @ConfigurationPropertiesBinding. 

### 지속기간 변환하기
스프링 부트는 지속기간 표현에 대한 헌신적인 지원을 한다. 만약 `java.time.Duration`속성을 드러내면, 어플리케이션 속성에 있는 다음의 포맷이 사용가능하다.

- `long`(밀리세컨즈 `@DurationUnit`가 지정되지 않은 경우에 기본 단위로 밀리초를 사용한다.)
- `java.time.Duration`이 사용된 표준 ISO-8601 포맷
- 값과 단위로 연결된 더 읽기 쉬운 포맷 (`10s`는 10초라는 뜻)

다음의 예를 고려해봐라
```java
@ConfigurationProperties("app.system")
public class AppSystemProperties {

	@DurationUnit(ChronoUnit.SECONDS)
	private Duration sessionTimeout = Duration.ofSeconds(30);

	private Duration readTimeout = Duration.ofMillis(1000);

	public Duration getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(Duration sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public Duration getReadTimeout() {
		return this.readTimeout;
	}

	public void setReadTimeout(Duration readTimeout) {
		this.readTimeout = readTimeout;
	}

}
```
30초의 세션 타임아웃을 정하기 위해서, `30`, `PT30S` 그리고 `30s`는 모두 [똑같다./동등하다.] 다음 형식: `500`, `PT0.5S`그리고 `500ms`으로 500ms의 읽기 타임아웃을 지정할 수 있다.

지원되는 단위의 모든것들을 사용할 수 있다.

- `ns` for nanoseconds
- `us` for microseconds
- `ms` for milliseconds
- `s` for seconds
- `m` for minutes
- `h` for hours
- `d` for days

기본 단위는 밀리초와 위의 샘플에 나와있는 것처럼 `@DurationUnit`을 사용해서 재정의할 수 있다.

> 지속기간을 표현하기위해 `Long` 간단히 사용하는 이전의 버전에서 업그레이드를 하는 경우, `Duration`으로 전환할 때 밀리초가 아닌 경우에는 반드시 단위를 정의해라.(`@DurationUnit`을 사용해서) . 이렇게 하면 많은 풍부한 포맷을 지원하는 동안에 투명한 업그레이드 경로를 얻는다.

### 데이터 사이즈 변환하기

스프링 프레임워크는 바이트로 사이즈를 표현하는것을 허용하는 `DataSize` 값 타입을 가지고 있다. `DataSize` 속성을 드러내면, 다음의 어플리케이션 속성에 있는 포맷은 사용가능하다.:

- 규칙적인 `long` 표현(`@DataSizeUnit`으로 지정되어 있지않는 한 기본적으로 bytes를 사용한다.)
- 값과 단위로 연결된 더 읽기 쉬운 포맷(예,`10MB`는 10megabytes라는 뜻)

다음의 예를 고려해봐라

```java
@ConfigurationProperties("app.io")
public class AppIoProperties {

	@DataSizeUnit(DataUnit.MEGABYTES)
	private DataSize bufferSize = DataSize.ofMegabytes(2);

	private DataSize sizeThreshold = DataSize.ofBytes(512);

	public DataSize getBufferSize() {
		return this.bufferSize;
	}

	public void setBufferSize(DataSize bufferSize) {
		this.bufferSize = bufferSize;
	}

	public DataSize getSizeThreshold() {
		return this.sizeThreshold;
	}

	public void setSizeThreshold(DataSize sizeThreshold) {
		this.sizeThreshold = sizeThreshold;
	}

}
```

10메가바이트의 버퍼사이즈를 명시하려면, `10` 과 `10MB`과 동일하게 하면 된다. 256바이트의 한계 사이즈는 `256`, `256B`처럼 지정할 수 있다.

단위를 지원하는 모든 것을 사용할 수도 있다. 
- `B` for bytes
- `KB` for kilobytes
- `MB` for megabytes
- `GB` for gigabytes
- `TB` for terabytes

기본 단위는 바이트이고 위의 예제에 삽입된 것처럼 `@DataSizeUnit`를 사용하여 재정의할 수 있다.

> `Long`을 사용하여 간단하게 사이즈를 표현하는 이전의 버전에서 업그레이드를 하는경우, `DataSize`로 전환할 때 바이트가 아닌 경우에는 반드시 단위를 사용해라. (`@DataSizeUnit`을 사용) 이렇게하면 풍부한 포맷을 지원하는동안 에 투명한 업그레이드 경로를 얻는다.

### 24.8.5 @ConfigurationProperties 검증

스프링 부트는 스프링의 `@Validated` 어노테이션이을 사용할 때 `@ConfigurationProperties` 클래스를 검증하는것을 시도한다. 구성 클래스에 제한 어노테이션인 JSR-303 `javax.validation`을 직접적으로 사용할 수 있다. 그렇게 하기 위해서, 다음에 보여지는 예제와 같이 JSR-303에 부응하는 구현체가 클래스패스에 있는지 확인하고 그러고나서 제약 어노테이션을 필드에 추가해야한다.    

```java
@ConfigurationProperties(prefix="acme")
@Validated
public class AcmeProperties {

	@NotNull
	private InetAddress remoteAddress;

	// ... getters and setters

}
```

> `@Validated`를 사용하여 설정 속성을 생성하는 `@Bean`메소드를 사용하여 검증을 트리거할 수도 있다. 중첩된 속성도 바운드 될 때 검증되지만 `@Valid`처럼 관련 필드를 어노테이트하는것도 좋은 방법이다. 중첩된 속성을 찾지 못하더라도 검증이 트리거되는것을 보장한다. 다음의 예제는 이전의 `AcmeProperties`예제를 기반으로 한다.

```java
@ConfigurationProperties(prefix="acme")
@Validated
public class AcmeProperties {

	@NotNull
	private InetAddress remoteAddress;

	@Valid
	private final Security security = new Security();

	// ... getters and setters

	public static class Security {

		@NotEmpty
		public String username;

		// ... getters and setters

	}

}
```

`configurationPropertiesValidator`를 호출한 빈 정의를 생성하여 사용자정의 스프링 `Validator`를 추가할 수도 있다. `@Bean` 메소드는 `static`으로 선언되어야 한다. 설정 파일 검증자는 어플리케이션의 생명주기에서 가장 빨리 생성되고 static같이 `@Bean` 메소드를 선언한다. static으로 `@Bean`메소드를 선언하면 빈이 `@Configuration`클래스를 인스턴스화 할 필요없이 빈이 생성된다. 이렇게 하면 초기 인스턴스로 발생할 수 있는 문제들을 피할 수 있다. 이 [속성 검증 예제](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-samples/spring-boot-sample-property-validation)는 설정 방법을 보여준다.

> `spring-boot-actuator` 모듈은 모든 `@ConfigurationProperties` 빈을 드러내는 끝점을 포함한다. 웹브라우저에 `/actuator/configprops`를 하거나 동일한 JMX 끝점을 사용해라. 자세한 사항들은 ["생산 준비 기능"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints) 에서 봐라. 


### 24.8.6 @ConfigurationProperties vs. @Value

`@Value` 어노테이션은 코어 컨테이너 특징이다. 그리고 설정 속성 타입세이프로서 동일한 기능을 제공하지 않는다. 다음은 `@ConfigurationProperties`와 `@Value`에 대해서 지원하는 특징을 요약한 테이블이다.

특징 | `@ConfigurationProperties` | `@Value`
--- | --- | ---
유연한 바인딩 | O | X
메타 데이터 지원 | O | X
`SpEL` 평가 | X | O

컴포넌트에 대해서 설정 키의 구성을 정의한다면, `@ConfigurationProperties`를 사용하여 어노테이트한 POJO에 그룹화 하는 것을 추천한다.

마지막으로, `@Value`안에 `SpEL` 표현식을 사용할 수 있는 동안, 이런 표현식은 [어플리케이션 속성 파일](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-application-property-files)에서 처리되지 않는다.

## 25. 프로파일
스프링 프로파일은 어플리케이션 설정의 부분을 분리하는 방법과 확실한 환경에서만 가능하도록 만들어주는 방법을 제공한다. 다음에 보여지는 예제에서, `@Component`나 `@Configuration`은 프로파일을 불러올 때 제한하는 `@Profile`를 사용하여 표시할 수 있다.

```java
@Configuration
@Profile("production")
public class ProductionConfiguration {

	// ...

}
```
프로파일을 실행하는 것을 지정하기 위해서 `spring.profiles.active` `Environment` 속성을 사용할 수 있다. 이 챕터에 앞서 설명한 방법들에서 속성을 지정할 수 있다. 예를 들어, 다음에 보여지는 예와 같이, `application.properties`에 속성을 포함할 수 있다.

```
spring.profiles.active=dev,hsqldb
```

다음의 스위치를 사용해서 커맨드 라인에서도 속성을 지정할 수 있다.: `--spring.profiles.active=dev,hsqldb.`

### 25.1 활성 프로파일 추가하기
`spring.profiles.active` 속성은 다른 속성들로서 동일한 순서의 규칙을 따른다: 가장 높은 `PropertySource`가 우선이다.(가장 높은 우선순위이다.) `application.properties`에 활성 프로파일을 정의할 수 있고, 커맨드 라인 스위치를 사용해서 이것들을 대체할 수 있다는 뜻이다. 

때때로, 활성 프로파일을 이것을 대체하는것 보다는 프로파일-specific 속성에 활성 프로파일을 추가하는 것이 유용하다. `spring.profiles.include` 속성은 활성 프로파일을 추가하는것을 무조건 사용할 수 있다.    `SpringApplication` 진입점 또한 추가적인 프로파일 설정에 대한 Java API를 갖고 있다. [SpringApplication](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/SpringApplication.html)안에 있는 `setAdditionalProfiles()` 메소드를 참고해라.

예를 들어서, 스위치를 사용함으로써 다음의 속성을 사용하여 어플리케이션을 실행할 때, `--spring.profiles.active=prod`, `proddb`와 `prodmq` 프로파일도 실행된다.

```
---
my.property: fromyamlfile
---
spring.profiles: prod
spring.profiles.include:
  - proddb
  - prodmq
```

> `spring.profiles` 속성은 YAML 문서에 정의되어 특정한 문서가 언제 설정에 포함되었는지를 확인할 수 있음을 기억해라. 자세한 사항들은 [77.7 "환경에 의존하고있는 설정 바꾸기"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-change-configuration-depending-on-the-environment)을 참고해라.

### 25.2 프로그래밍방식으로 프로파일 세팅하기

어플리케이션을 구동하기 전에 `SpringApplication.setAdditionalProfiles(...)`를 호출하여 프로그래밍 방식으로 실행 프로파일을 설정할 수 있다. 스프링의 `ConfigurableEnvironment` 인터페이스를 사용함으로써 프로파일을 실행하는것 또한 가능하다.

### 25.3 프로파일-specific 구성 파일

`application.properties`(또는 `application.yml`)와 참조된 파일 두 개 모두의 프로파일-specific 변형은 `@ConfigurationProperties`를 통해서 파일로 [고려되고/간주되고] 불러와진다. 자세한 사항은 [24.4 "프로파일-specific 속성"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-profile-specific-properties)을 참조해라. 

## 26. 로깅

스프링 부트는 모든 내부 로깅에 대해 Commons Logging을 사용하지만 기본 로그 구현은 그대로 둔다. 기본 설정에 Java Util Logging, Log4J2 그리고 Logback이 제공된다. 각각의 경우에, 로거는 선택적인 파일을 사용한 콘솔 출력을 사용하기 위해 미리 설정도 가능하다.

기본적으로, "스타터"를 사용하는 경우에는 logging에 대해서 Logback 이 사용된다. Java Util Logging, Commons Logging, Log4J 또는 SLF4J를 사용하는 의존 라이브러리가 모두 올바르게 작동하도록 하는 적절한 Logback 라우팅도 포함한다.

> Java에 대해 사용가능한 많은 로깅 프레임워크가 있다. 위의 목록이 혼란스러울 것 같아도 걱정하지마라. 일반적으로, 로깅 의존성을 바꿀 필요는 없고 스프링 부트의 기본값으로 잘 작동한다.

### 26.1 로그 포맷

다음의 예제는 스프링부트에서의 기본 로그 출력과 유사하다.

```
2014-03-05 10:57:51.112  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1358 ms
2014-03-05 10:57:51.698  INFO 45469 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
2014-03-05 10:57:51.702  INFO 45469 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
```

다음의 아이템이 출력된다:
- 날짜와 시간 : 정밀한 밀리세컨드와 쉽게 분류할 수 있음
- 로그 레벨 : `ERROR`, `WARN`, `INFO`, `DEBUG`, 또는 `TRACE`
- 프로세스 ID
- 실제 로그 메시지의 시작을 구별하는 `---` 분리자
- 쓰레드 이름 : 네모 괄호([])로 에워싸여있다.(콘솔 출력을 위해 잘릴 수도 있다.)
- 로거 이름 : 보통 소스 클래스 이름 (자주 생략됨)
- 로그 메시지

> Logback에는 `FATAL`레벨이 없다. `ERROR`로 매핑된다.

### 26.2 콘솔 출력

기본 로그 설정은 메시지가 쓰일 때 콘솔에 메시지를 출력(echoes)한다. 기본적으로 `ERROR`-레벨, `WARN`-레벨 그리고 `INFO`-레벨 메시지가 로그된다. `--debug` 플래그를 사용하여 어플리케이션을 사용하면   "debug" 모드를 활성화할 수도 있다.

`$ java -jar myapp.jar --debug`

> `application.properties`에서 `debug=true`로 지정할 수도 있다.

debug 모드가 활성화 될 때, 코어 로거의 선택(임베디드 컨테이너, Hibernate, 스프링 부트)이 더 많은 정보를 출력하기 위해 설정된다. debug 모드를 활성화하는 것은 어플리케이션에 `DEBUG`레벨을 사용하여 모든 메시지를 로그하도록 설정하지는 않는다.

대신에, `--trace` 플래그(또는 `application.properties`에서 `trace=true`)`를 사용해서 어플리케이션을 실행하면 "trace" 모드를 활성화 할 수 있다. 이렇게 하면 코어 로거의 선택에 대한 trace 로깅이 활성화 된다. (임베디드 컨테이너, Hibernate 스키마 생성 그리고 전체 스프링 포트폴리오(?))

<<<<<<< HEAD
## 26.2.1 컬러 코드 출력
ANSI를 지원하는 터미널인 경우, 읽기 쉽게 지원하는 컬러 출력을 사용할 수 있다.  `spring.output.ansi.enabled`를 지원되는 값으로 설정해서 자동 탐지를 재정의할 수 있다.(You can set spring.output.ansi.enabled to a supported value to override the auto detection.)
=======
### 26.2.1 컬러 코드 출력
### 26.3 파일 출력
>>>>>>> 23c3ef9283168a52f49e15e02c798eadd1459f19

`%clr` ~ 단어를 사용함으로서 컬러 코딩이 설정된다. 다음의 예제와 같이, 가장 단순한 형태로, 컨버터는 로그 레벨에 따라 출력을 색칠한다.

`%clr(%5p)`

다음의 표는 로그 레벨을 색깔에 매핑하는 법을 설명한다.

레벨 | 색깔
--- | ---
FATAL | Red
ERROR | Red
WARN | Yellow
INFO | Green
DEBUG | Green
TRACE | Green

대신에, 개조하기 위한 옵션으로 제공되어 있는 것을 사용새야만 색깔이나 스타일을 지정할 수 있다. 예를 들어서, 텍스트를 노란색으로 만드려면, 다음의 세팅을 사용해라

`%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){yellow}`

다음은 지원되는 색깔과 스타일이다.

- `blue`
- `cyan`
- `faint`
- `green`
- `magenta`
- `red`
- `yellow`


### 26.3 파일 출력

기본적으로, 스프링 부트는 오직 콘솔에서만 로그를 하고 로그 파일에는 쓰지 않는다. 콘솔 출력에 더불어 로그 파일에 쓰이길 원한다면, `logging.file`이나 `logging.path` 속성을 설정하면 된다. (예를 들어,  `application.properties`)

다음의 표는 어떻게 `logging.*` 속성이 함께 사용되는지를 보여준다.

Table 26.1. Logging properties

logging.file | logging.path | 예 | 설명
--- | --- | --- | ---
(none) | (none) |  | 콘솔에만 로깅한다.
특정 파일 | (none) | my.log | 지정된 로그파일에 로깅한다. 이름은 정확한 위치이거나 현재 디렉토리에 상대적일 수 있다.
(none) | 특정 디렉토리 | /var/log | 지정된 디렉토리에 `spring.log`을 쓴다. 이름은 정확한 위치이거나 현재 디렉토리에 상대적일 수 있다.


로그 파일은 10 MB에 도달할 때 파일이 rotate된다. 그리고 콘솔 출력과 마찬가지로 `ERROR`-레벨, `WARN`-레벨 그리고 `INFO`-레벨 메시지가 기본적으로 로그된다. 사이즈 한계는 `logging.file.max-size` 속성을 사용하면 변경할 수 있다. 이전에 rotate된 파일은 `logging.file.max-history` 속성을 이용해서 설정을 하지 않는 한 무한으로 보관된다.

> 로깅 시스템은 어플리케이션 생명주기에서 초기에 초기화된다. 따라서, 로깅 속성은 `@PropertySource` 어노테이션을 통해서 불러온 속성 파일에서 찾을 수 없다.

> 로깅 속성은 실제의 로깅 인프라와는 독립적이다. 결과적으로, 특정 설정 키(Logback에 대한 `logback.configurationFile` 같은)는 스프링 부트에 의해 관리되지 않는다.

### 26.4 로그 그룹

로그 그룹은 동시에 모든 것을 설정하도록 관련된 로거를 모두 그룹화 할 수 있어서 유용할 때가 많다. 예를 들어서, 보통 모든 Tomcat 관련 로거에 대한 로깅 레벨을 변경할 수 있지만, 최상위 패키지를 쉽게 기억할 수는 없다.

이를 돕기 위해, 스프링 부트는 스프링 `Environment`에서 로깅 그룹을 정의하는것을 허용한다. 예로, `application.properties` 에 추가하여 "tomcat" 그룹을 어떻게 정의할 수 있는지를 보여준다.


`logging.group.tomcat=org.apache.catalina, org.apache.coyote, org.apache.tomcat`

한 번 정의하면, 한 줄로 그룹의 모든 로거에 대해 레벨을 변경할 수 있다.

`logging.level.tomcat=TRACE`

스프링 부트는 out-of-the-box로 사용할 수 있는 미리 정의된 로깅 그룹 포함한다. 

Name | Loggers
--- | ---
web | org.springframework.core.codec, org.springframework.http, org.springframework.web
sql | org.springframework.jdbc.core, org.hibernate.SQL


### 26.6 커스텀 로그 설정

다양한 로깅 시스템은 클래스패스에서 적절한 라이브러리를 포함하여 활성화 할 수 있고 더 나아가 클래스패스의 루트에 있는 적절한 설정 파일이나 스프링 `Environment` 속성인 `logging.config`에 따라 지정된 위치에 제공하여 커스텀을 할 수 있다.

스프링 부트에서  `org.springframework.boot.logging.LoggingSystem` 시스템 속성을 사용하여 특정한 로깅 시스템을 사용도록 강요할 수 있다. 값은 `LogginsSystem` 구현체의 클래스 이름이어야 한다. `none`의 값을 사용하면 스프링 부트의 로깅 설정 전부를 비활성화 할 수도 있다.

> `ApplicationContext`가 생성되기 이전에 로깅이 초기화되기 때문에, 스프링 `@Configuration` 파일의 `@PropertySource`에서 로깅을 조작하는 것이 불가능하다. 로깅 시스템을 변경하거나 완전히 비활성화 하는 방법은 시스템 속성을 통해서 할 수 있다.

로깅 시스템에 따르면, 다음의 파일이 불러와진다.

Logging System | Customization
Logback | `logback-spring.xml`, `logback-spring.groovy`, `logback.xml`, 이나 `logback.groovy`
Log4j2 | `log4j2-spring.xml` 이나 `log4j2.xml`
JDK (Java Util Logging) | `logging.properties`

> 가능하면, 로깅 설정에서 `-spring`을 사용하는 것을 추천한다. (예를 들어, `logback.xml`대신에 `logback-spring.xml`) 기본적인 구성 위치에서 사용하는 경우, 스프링은 로그 초기화룰 완전히 조작할 수 없다.

> 'executable jar'에서 실행할 때 야기되는 문제인 Java Util Logging을 사용한 클래스로딩 이슈가 있다. 가능하다면 'executable jar'에서 실행할 때 피하는것을 추천한다.



사용자 정의를 돕기 위해, 다음에 설명된 테이블처럼 일부 다른 속성이 스프링 `Environment`에서 시스템 속성으로 이동된다.



Spring Environment | System Property | Comments
--- | --- | ---
`logging.exception-conversion-word` | `LOG_EXCEPTION_CONVERSION_WORD` | The conversion word used when logging exceptions.
`logging.file` | `LOG_FILE` | If defined, it is used in the default log configuration.
`logging.file.max-size` | `LOG_FILE_MAX_SIZE` | Maximum log file size (if LOG_FILE enabled). (Only supported with the default Logback setup.)
`logging.file.max-history` | `LOG_FILE_MAX_HISTORY` | Maximum number of archive log files to keep (if LOG_FILE enabled). (Only supported with the default Logback setup.)
`logging.path` | `LOG_PATH` | If defined, it is used in the default log configuration.
`logging.pattern.console` | `CONSOLE_LOG_PATTERN` | The log pattern to use on the console (stdout). (Only supported with the default Logback setup.)
`logging.pattern.dateformat` | `LOG_DATEFORMAT_PATTERN` | Appender pattern for log date format. (Only supported with the default Logback setup.)
`logging.pattern.file` | `FILE_LOG_PATTERN` | The log pattern to use in a file (if LOG_FILE is enabled). (Only supported with the default Logback setup.)
`logging.pattern.level` | `LOG_LEVEL_PATTERN` | The format to use when rendering the log level (default %5p). (Only supported with the default Logback setup.)
`PID` | `PID` | The current process ID (discovered if possible and when not already defined as an OS environment variable).

지원되는 모든 로깅시스템은 설정 파일들을 파싱할 때 시스템 속성을 참조할 수 있다.  예는, `spring-boot.jar`에 있는 기본 설정을 봐라.

- [Logback](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/logback/defaults.xml)
- [Log4j 2](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/log4j2/log4j2.xml)
- [Java Util logging](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/java/logging-file.properties)


> 로깅 속성안에서 플레이스홀더를 사용하고 싶다면, 기본 프레임워크의 문법이 아닌 스프링 부트의 문법을 사용해야 한다. 특히, Logback을 사용하는 경우에는, `:-`를 사용하지 않고 기본 값과 속성 이름사이에 구분자로서 `:`를 사용해야 한다.

> `LOG_LEVEL_PATTERN`(또는 Logback을 사용해서 `logging.pattern.level`)만 재정의함으로써 로그 라인에 ad-hoc 컨텐트와 라인과 MDC를 추가할 수 있다. 예를 들면, `logging.pattern.level=user:%X{user} %5p`를 사용하는 경우에는, 다음 예와 같이 기본 로그 포맷에 "user"에 대한 MDC 항목이 포함되어 있다.
2015-09-30 12:30:04.031 user:someone INFO 22174 --- [  nio-8080-exec-0] demo.Controller
Handling authenticated request

### 26.7 Logback 확장 기능
스프링 부트는 Logback에 고급 설정을 사용을 도와줄 수 있는 수많은 확장 기능을 포함하고 있다. `logback-spring.xml` 설정 파일에 이런 확장기능을 사용할 수 있다.

> 왜냐하면 표준 `logback.xml` 설정 파일은 아주 일찍 로드되기 떄문에, 확장 기능을 사용할 수 없다. `logging.config` 속성을 정의하거나 `logback-spring.xml`을 사용해야 한다.

> 확장 기능은 Logback의 설정 스캐닝이 사용될 수 없다. 만약 시도하면, 설정 파일을 변경하면 다음중 하나와 비슷한 에러가 발생한다.

```
ERROR in ch.qos.logback.core.joran.spi.Interpreter@4:71 - no applicable action for [springProperty], current ElementPath is [[configuration][springProperty]]
ERROR in ch.qos.logback.core.joran.spi.Interpreter@4:71 - no applicable action for [springProfile], current ElementPath is [[configuration][springProfile]]
```

### 26.7.1 프로파일-specific 설정

`<<springProfile>` 태그는 스프링 프로파일에 기반해서 실행한 설정 부분을 제외하거나 선택적으로 포함할 수 있다. 프로파일 부분은 `<configuration>` 요소내의 어디에서나 지원된다. 설정 프로파일을 받아들이는것을 지정하기 위해서 `name` 속성을 써라. `<springProfile>`태그는 간단한 프로파일 이름(예를 들어 `staging`)이나 프로파일 표현식을 포함할 수 있다. 프로파일 표현식은 더 복잡한 프로파일 로직이 표현되도록 허용한다. 예를 들어 `production & (eu-central | eu-west)`. 더 자세한 것들은 [레퍼런스 가이드](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/core.html#beans-definition-profiles-java)를 확인해봐라. 다음 리스트는 3개의 프로파일 예를 보여준다.

```xml
<springProfile name="staging">
	<!-- configuration to be enabled when the "staging" profile is active -->
</springProfile>

<springProfile name="dev | staging">
	<!-- configuration to be enabled when the "dev" or "staging" profiles are active -->
</springProfile>

<springProfile name="!production">
	<!-- configuration to be enabled when the "production" profile is not active -->
</springProfile>
```

### 26.7.2 환경 프로파일
`<springProperty>`태그는 Logback내에서 사용하기 위해 스프링 `Environment`에서 프로퍼티를 노출할 수 있다. 이렇게 하면 만약 Logback 구성에서 `application.properties` 파일의 값에 접근하고 싶은 경우에 유용할 수 있다. 태그는 Logback의 표준 `<property>` 태그와 비슷한 방식으로 작동한다. 하지만,  직접 `value`를 지정하지 않고 속성의 `source`(`Environment`에서)를 지정한다. `local` 스코프가아닌 다른 어딘가에 속성을 저장해야 하는 경우에는, `scope` 속성을 사용해라. 폴백 값이 필요한 경우에는(`Environment`에서 속성을 설정하지 않은 경우), `defaultValue` 속성을 사용해라. 다음의 예는 Logback에서 사용할 속성을 노출하는 방법을 보여준다.

```xml
<springProperty scope="context" name="fluentHost" source="myapp.fluentd.host"
		defaultValue="localhost"/>
<appender name="FLUENT" class="ch.qos.logback.more.appenders.DataFluentAppender">
	<remoteHost>${fluentHost}</remoteHost>
	...
</appender>
```

> `source`는 케밥 케이스로 정의되어야 한다.(`my.property-name`과 같이). 하지만, 속성은 유연한 방법을 사용해서 `Environment`를 추가할 수 있다.

## 27. Internationalization. 국제화
스프링 부트는 어플리케이션은 다른 언어 설정의 사용자에게 서비스할 수 있게 하도록 지역화된 메시지를 지원한다. 기본적으로, 스프링 부트는 클래스패스의 상위에 있는 `message` 리소스 번들의 존재를 찾는다.

> 자동-설정은 구성된 리소스 번들에 대해 기본 속성 파일이 사용가능할 때 적용된다 (즉, 기본적으로 `messages.properties). 리소스 번들이 지정된 언어만 속성파일에 포함되는 경우, 기본값에 추가해야 한다.

다음 보여지는 예처럼, 리소스 번들의 베이스네임은 몇몇의 다른 속성들 처럼 `spring.messages` 네임스페이스를 사용하여 구성할 수 있다.

```
spring.messages.basename=messages,config.i18n.messages
spring.messages.fallback-to-system-locale=false
```

> `spring.messages.basename`은 패키지 한정자나 클래스패스 상위에서 확인된 리소스 둘 다에서 쉼표로 구분된 위치의 목록을 지원한다.
  - ??? spring.messages.basename supports comma-separated list of locations, either a package qualifier or a resource resolved from the classpath root.

더 지원되는 옵션에 대한것은 [`MessageSourceProperties`](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/context/MessageSourceProperties.java)를 봐라

## 28. JSON
스프링 부트는 3개의 JSON 매핑 라이브러리 통합을 제공한다

- Gson
- Jackson
- JSON-B

Jackson은 기본 라이브러리이고 더 선호된다.

### 28.1 Jackson
Jackson에 대한 자동 설정은 제공되고 Jackson은 `spring-boot-starter-json`의 한 부분이다. Jackson이 클래스패스에 있으면 [ObjectMapper] 빈이 자동으로 설정된다. [`ObjectMapper`의 설정 커스터마이징하기]위해서 몇몇의 설정 속성은 제공된다.(https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-customize-the-jackson-objectmapper)

### 28.2 Gson
Gson에 대한 자동 설정은 제공된다. Gson이 클래스패스에 있을 때 `Gson` 빈이 자동으로 설정된다. 설정을 커스터마이즈하기 위해서 몇몇의 `spring.gson.*` 설정 속성은 제공된다. 더 조작하려면, 하나 이상의 `GsonBuilderCustomizer` 빈들을 사용할 수 있다.

### 28.3 JSON-B
JSON-B에 대한 자동설정은 제공된다. JSON-B API와 구현이 클래스패스에 있으면 `Jsonb` 빈은 자동으로 설정된다. JSON-B 구현은 의존성 관리가 제공되는 Apache Johnzon가 선호된다.

## 29. 웹 어플리케이션 개발하기
스프링 부트는 웹 어플리케이션 개발에 대해 매우 적합하다. embedded Tomcat, Jetty, Undertow, 또는 Netty를 사용해서 자체 포함 HTTP 서버를 만들 수 있다. 대부분의 웹 어플리케이션은 구동과 빠른 실행을 위해 `spring-boot-starter-web` 모듈을 사용한다. 또한 `spring-boot-starter-webflux` 모듈을 사용해서 리액티브 웹 어플리케이션을 만드는것을 선택할 수 있다.

Spring Boot 웹 어플리케이션을 개발해보지 않았다면, [시작하기](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application) 섹션에 있는 예제 "Hello World!"를 따라하면 된다.

### 29.1 "Spring Web MVC Framework"
Spring Web MVC Framework(간단하게 "Spring MVC"라고 자주 불린다.)는 풍부한 "model view controller" 웹 프레임워크이다. Spring MVC는 들어오는 HTTP 요청을 다루기위해 특별한 `@Controller`이나 `@RestController`빈을 생성할 수 있다. 컨트롤러에 있는 메소드는 `@RequestMapping` 어노테이션을 사용함으로써 HTTP에 매핑한다.

다음의 코드는 JSON 데이터를 제공하는 일반적인 `@RestController`을 보여준다.

```java
@RestController
@RequestMapping(value="/users")
public class MyRestController {

	@RequestMapping(value="/{user}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long user) {
		// ...
	}

	@RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
	List<Customer> getUserCustomers(@PathVariable Long user) {
		// ...
	}

	@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable Long user) {
		// ...
	}

}
```

Spring MVC는 핵심 스프링 프레임워크의 일부분이다. 그리고 더 자세한 정보들은 [참고 서적](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/web.html#mvc)에서 확인할 수 있다. 또한, [spring.io/guides](https://spring.io/guides)에서 Spring MVC를 사용할 수 있는 몇몇의 가이드가 있다.

### 29.1.1 Spring MVC 자동 설정

스프링 부트는 대부분 어플리케이션에서 잘 작동하는 Spring MVC에 대한 자동 설정을 제공한다. 

자동 설정은 Spring의 기본값 위에 다음의 특징들을 추가한다.

- `ContentNegotiatingViewResolver`와 `BeanNameViewResolver`빈의 포함.
- WebJars에 대한 지원을 포함한 정적 자원을 제공하는 것을 지원한다. ([뒤에서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-web-binding-initializer) 다룰 내용)
- `Converter`, `GenericConverter`및 `Formatter`빈들의 자동 등록 
- `HttpMessageConverters`에 대한 지원 ([뒤에서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-message-converters) 다룰 내용)
- `MessageCodesResolver`의 자동 등록([뒤에서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-message-codes) 다룰 내용)
- 정적 `index.html` 지원
- 사용자 정의 `Favicon` 지원 ([뒤에서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-favicon) 다룰 내용)
- `ConfigurableWebBindingInitializer`빈의 자동 사용([뒤에서](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-web-binding-initializer) 다룰 내용)

Spring Boot MVC 특징을 계속 사용하고 싶고, 추가적인 [MVC 설정](https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/web.html#mvc)(인터셉터, 포맷터, 뷰 컨트롤러, 다른 특징들)을 추가하고 싶다면,   `@EnableWebMvc`가 아닌 `WebMvcConfigurer` 타입의 `@Configuration` 클래스를 추가해라. `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter`, 또는 `ExceptionHandlerExceptionResolver`의 사용자 정의 인스턴스를 제공하고 싶으면, 컴포넌트 같은 것을 제공하는 `WebMvcRegistrationsAdapter` 인스턴스를 선언해라.

Spring MVC의 완벽하게 조작하고 싶으면, `@EnableWebMvc`를 사용해서 `@Configuration` 어노테이션을 추가해라.

### 29.1.2 HttpMessageConverters
스프링 부트는 HTTP 요청과 응답을 변환하는 `HttpMessageConverter` 인터페이스를 사용한다. 합리적인 기본값은 즉시 포함되어있다.(Sensible defaults are included out of the box.) 예를 들어서, 오브젝트는 자동으로 JSON(Jackson 라이브러리를 사용해서)이나 XML(가능한 경우, Jackson XML 확장 기능을 사용하거나 Jackson XML 확장 기능이 불가능한 경우 JAXB를 사용해서)로 변환될 수 있다. 기본적으로, 문자열은 `UTF-8`로 인코딩 되어있다.

사용자 정의한 컨버터를 추가하고 싶은 경우에는, 다음의 목록에 나와있는 것 처럼 스프링 부트의 `HttpMessageConverters` 클래스를 사용할 수 있다.

```java
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.*;

@Configuration
public class MyConfiguration {

	@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = ...
		HttpMessageConverter<?> another = ...
		return new HttpMessageConverters(additional, another);
	}

}
```

컨텍스트에 존재하는 `HttpMessageConverter` 빈은 컨버터의 목록에 추가된다. 또한, 같은 방법으로 기본 컨버터를 재정의 할 수 있다.

### 29.1.3 JSON Serializers와 Deserializers 사용자 정의하기
JSON 데이터를 직렬화하고 비직렬화하기 위해 Jackson을 사용하는 경우, `JsonDeserializer`클래스와 `JsonSerializer`에 써야한다. 사용자 정의한 serializers는 보통 모듈을 통해서 Jackson에 등록되지만, 스프링 부트는 대신에 Spring 빈들을 직접 등록하는 것이 쉽게 해주는 `@JsonComponent` 어노테이션을 제공한다.

`JsonSerializer`나 `JsonDeSerializer` 구현체에서 직접 `@JsonComponent` 어노테이션을 사용할 수 있다. 또한, 다음 예와 같이 이너 클래스로서 serializers/deserializers가 포함된 클래스에서도 사용할 수 있다.

```java
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.jackson.*;

@JsonComponent
public class Example {

	public static class Serializer extends JsonSerializer<SomeObject> {
		// ...
	}

	public static class Deserializer extends JsonDeserializer<SomeObject> {
		// ...
	}

}
```

`ApplicationContext`안에 있는 모든 `@JsonComponent` 빈들은 Jackson에 자동으로 등록된다. 왜냐하면 `@JsonComponent`는 보통의 컴포넌트-스캔 방법을 지원하는 `@Component`를 사용한 메타 어노테이션이기 때문이다.

또한 스프링 부트는 [`JsonObjectSerializer`](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/jackson/JsonObjectSerializer.java)와 [`JsonObjectDeserializer`](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/jackson/JsonObjectDeserializer.java)의 기본 클래스들을 제공해서 오브젝트를 직렬화할 때 표준 Jackson 버전에 유용한 대안을 제공한다. 자세한 것들은 Javadoc에 있는 [`JsonObjectSerializer`](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/jackson/JsonObjectSerializer.html)와 [`JsonObjectDeserializer`](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/api/org/springframework/boot/jackson/JsonObjectDeserializer.html)를 참조해라.

### 29.1.4 MessageCodesResolver

Spring MVC은 바인딩 오류에서 에러 메시지를 렌더링하기위한 에러 코드를 생성하는 전략을 가지고 있다: `MessageCodesResolver`. `spring.mvc.message-codes-resolver.format` 속성의 `PREFIX_ERROR_CODE`나 `POST_ERROR_CODE`를 설정할 경우, 스프링 부트는 하나를 생성한다([`DefaultMessageCodesResolver.Format`](https://docs.spring.io/spring/docs/5.1.8.RELEASE/javadoc-api/org/springframework/validation/DefaultMessageCodesResolver.Format.html)에 있는 열거를 봐라).

### 29.1.5 정적 컨텐츠

기본적으로, 스프링 부트는 `ServletContext`의 최상위 또는 클래스 패스에 있는 `/static`(또는 `/public`나 `/resources`나 `/META-INF/resources`)으로 불리는 디렉토리로 부터 정적 컨텐츠를 제공한다. `addResourceHandlers`메소드를 재정의하고 `WebMvcConfigurer`를 추가함으로써 수정하도록 할 수 있도록 Spring MVC에서 `ResourceHttpRequestHandler`를 사용한다. 

독립형 웹 어플리케이션에서, 컨테이너에 있는 기본 서블릿은 사용가능하고 폴백으로서 작용하며 Spring이 다루지 않기로 결정하면 `ServletContext`의 최상위에서 컨텐츠를 제공한다. 거의 대부분 Spring은 `DispatcherServlet`을 통해서 항상 요청을 다루기 때문에 이런 일이 일어나지 않는다.

기본적으로, 리소스는 `/**`으로 매핑되지만 `spring.mvc.static-path-pattern` 속성을 사용해서 조정할 수 있다. 예를 들어서 다음과 같이 모든 리소스들은 `/resources/**`로 재배치할 수 있다.

```
spring.mvc.static-path-pattern=/resources/**
```

`spring.resources.static-locations` 속성을 사용해서 정적 리소스 위치를 커스터마이즈 할 수도 있다(디렉토리 위치의 목록으로 기본 값을 대체). 상위 Servlet 컨텍스트 패스 `"/"`는 적합한 위치로 자동으로 추가된다.

이전에 언급된 "standard" 정적 리소스 위치 외에도 [Webjars content](https://www.webjars.org/)에 만들어진 특별한 경우가 있다. `/webjars/**`인 경로를 사용한 리소스들은 Webjars 포맷에서 패키지된 경우 jar 파일에서 저장된다.

> jar로 패키지된 어플리케이션일 경우, `src/main/webapp` 디렉토리를 사용하지 마라. 비록 이 디렉토리는 일반적인 표준이지만, 오직 war 패키징에서만 작동하고, jar로 생성하면 대부분의 빌드 툴에 의해서 조용히 무시된다.

또한, 스프링 부트는 Spring MVC에서 제공되는 고급 리소스를 조작하는 기능을 지원하고 cache-busting 정적 리소스 또는 Webjars에 대한 버전에 구속받지 않는 URLs 사용같은 경우를 허용한다.

Webjars에 대해 버전에 구속받지 않는 URLs을 사용하기 위해서, `webjars-locator-core` 의존성을 추가해라. 그러고나서 Webjar를 선언해라. JQuery를 사용한 예처럼, `"/webjars/jquery/jquery.min.js"`를 추가하면 `"/webjars/jquery/x.y.z/jquery.min.js"`가 된다. 여기서 `x.y.z`는 Webjar 버전이다.

> JBoss를 사용한다면 `webjars-locator-core`대신에 `webjars-locator-jboss-vfs` 의존성을 선언해라. 그렇지 않으면, 모든 Webjars는 `404`가 된다.


### 29.1.11 에러 핸들링
~
#### 커스텀 에러 페이지
주어진 상태 코드에 대해서 커스텀 HTML 에러 페이지를 보여주고 싶은 경우에는, `/error` 폴더에 파일을 추가해라. 에러 페이지 정적 HTML(static resource 폴더의 아래에 추가된)이거나 템플릿을 사용하여 만들수 있다. 파일의 이름은 상태 코드나 series maskdhk 정확히 일치해야 한다.

예를 들어서, `404`를 정적 HTML 파일에 매핑하기 위해서는 다음과 같은 폴더 구조가 된다.
```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- public/
             +- error/
             |   +- 404.html
             +- <other public assets>
```

`5xx` 에러들을 FreeMarker 템플릿을 사용한 것들에 매핑하려면, 다음과 같은 폴더 구조가 된다.
```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- templates/
             +- error/
             |   +- 5xx.ftl
             +- <other templates>
```

다음에 보여지는 예와같이 보다 복잡한 매핑은, `ErrorViewResolver` 인터페이스를 구현한 빈을 추가할 수도 있다.

```
public class MyErrorViewResolver implements ErrorViewResolver {

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request,
			HttpStatus status, Map<String, Object> model) {
		// Use the request or status to optionally return a ModelAndView
		return ...
	}

}
```

`@ExceptionHandler`메소드와 `@ControllerAdvice`와 같은 규칙적인 Spring MVC 를 사용할 수도 있다. 그런 다음에 `ErrorController`는 처리 되지 않은 예외를 잡아낸다.

#### Spring MVC의 외부의 에러 페이지 매핑하기
Spring MVC를 사용하지 않은 어플리케이션에 대해서, `ErrorPages`를 직접 등록하기위해 `ErrorPageRegistrar` 인터페이스를 사용할 수 있다. 이 


### 29.1.6 Welcome Page
스프링 부트는 static 과 template으로 구성된 welcome 페이지 둘 다 지원한다. 스프링 부트는 정적 컨텐트 위치로 설정되어있는 곳에서 `index.html` 파일을 제일 먼저 찾는다. 찾지 못한다면, `index` template를 찾는다. 만약 둘 중 하나를 찾는다면, 어플리케이션의 welcome page로 자동으로 사용된다.

### 29.1.7 Favicon 커스텀하기
스프링 부트는 정적 컨텐트 위치로 설정된 곳과 클래스패스의 최상위(그 다음에)에서 `favicon.ico`를 찾는다. 파일이 존재하면, 어플리케이션의 favicon으로 자동으로 사용된다.

--- 

##### 단어  

result in : 그 결과 ~가 되다
result in sth : (결과적으로) ~을 낳다[야기하다], 
In addition to : ~외에도, ~에 더하여  
Most of the time : 대부분, 거의  
In a stand-alone : 독립형  
might want to = should  
if available : 사용 가능한 경우, 가능한 경우  
out of the box : 즉시, 발군의, 특별 취급의  
rich : 풍부한  
one or more : 하나 이상의  
cater : 서비스하는, 공급하다, 
be required to : ~하라는 요구를 받다, ~하도록 요구되다  
optionally : 마음대로, 선택적으로  
result : (~의 결과로) 발생하다[생기다]  
Notably : 특히, 현저히, 뚜렷이  
consult : 참조하다, 상의하다, 상담하다  
underlying : 근본적인, 근원적인, 기본  
auto completion : 자동 완성  
appendix : 부록  
in that order : 차례로, 그 다음에  
if at all possible : 가능하면, 가능한  
When possible : 가능하다면, 가능하면  
via : 경유하여, 통하여  
entirely : 전적으로, 완전히, 전부  
fully : 완전히, 충분히  
activated : 활성화 된  
commonly : 흔히, 보통  
by : ~에 의해서  
Consequently : 그 결과, 따라서  
as with : ~와 같이, ~에서처럼, ~와 마찬가지로  
reach : ~에 이르다.[닿다/도달하다]  
rotate : 회전하다, 교대로 하다, 순환하다  
In its simplest form : 가장 단순한 형태로, 가장 간단한 형태로
aid : 원조, 지원  
as : (자격, 기능 등이) ~로(서) -> 때  
  - as a child : 어렸을 때

truncate : 자르다, 줄이다, 짧게 하다
abbreviated : 단축된, 생략된, 짧게 한  
enclosed : 에워싸인, 동봉된  
sortable : 분류할 수 있는, 선별할 수 있는  
precision : 정밀, 정확(성)  
just fine : 잘  
Appropriate : 적절한  
In each case : 각각의 경우에  
leave : 그대로 두다  
underlying : 기본, 근원적인, 근본적인, 밑에 있는  
that is : 즉, 말하자면  
entry point : 진입점  
unconditionally : 무조건적으로, 절대적으로  
segregate : 분리하다, 구분하다, 떼어놓다.  
set things up : 세팅하다, 세팅하자  
instantiate : (학설 등을) 예를 들어 설명하다, 예시하다  
build on sth : sth을 기반으로 하다  
even if : ~에도 불구하고[~이긴 하지만], ...라 하더라도  
it’s good practice to ~ : ~하는것은 좋은 방법이다. ~하는 것이 좋다.  
compliant : 순응하는, 따르는, 준수하는, 부응하는  
illustrated : 삽화된  
threshold : 한계점  
representation : 묘사  
richer : 풍부한  
Doing so ~ : 이렇게 하면, 그렇게 하면  
alongside : ~옆에, 나란히, ~화 함께, ~와 동시에  
make sure ~ : 반드시 (~하도록) 하다  
equivalent : 동등한, 맞먹는  
so that : ~하도록 하다  
preserved : 보존된  
bracket : 괄호  
alpha-numeric : 글자와 숫자를 쓴  
when possible : 가능하면, 가능하다면, 가능한  
delimiter : 구분자  
Numeric : 수  
per : ~에 대하여, 각, 마다, 당  
Underscore notation : 밑줄 표기법  
capitalized : 대문자로 시작하다, 대문자로 쓰다.  
As well as -ing : ~하는 것 뿐만 아니라  
In particular : 특히, 특별히, 특별한  
be coerced from : ~로 부터 강요받다  
  - coerce : 강압하다, 강제하다, 강요하다  

cumbersome : 다루기 힘든, 복잡하고 느린, 번거로운, 길고 복잡한  
whether or not : 여하튼, 어쨌든, 여하간, 반드시, 어떻게 됐든, 어떻든지  
In other words : 다시 말하면, 다시 말해서, 즉, 다르게 말하면, 바꿔 말하면  
explicit : 명쾌한, 명확한, 분명한  
by precedence : 우선순위  
abstraction : 관념  
externalized : 외부  
may be implemented : 구현 될 수 있다.  
be passed by : 전달하다, 전달되다  
can be used :  사용할 수 있다.  
discussed earlier : 앞에서 논의한/설명한/언급한  
whereas : 반면[에], 그렇지만  
take complete control : 완전히 제어하다.  
otherwise : 그렇지 않으면, 그 외에는  
determine : 알아내다, 밝히다, 결정하다, 확인하다  
fairly : 꽤, 상당히  
on your behalf : (사용자) ~대신  
Internally : 내부로, 내면적으로, 심적으로  
indicate : 나타내다, 보여주다.  
regardless of : ~에 개의치[상관하지] 않고, 구애받지 않고  
In addition to : ~에 더하여, ~에 더불어, ~에 덧붙여  
restriction : 제한, 제약  
lets you ~ : 할 수 있다.  
be sure to do sth : 반드시 ~을 해라  
concrete : 구체적인, 사실에 의거한  
delegate : 위임하다.  
You might want to ~ : ~하는게 좋을 것이다, ~해야할 것이다.  
so that : ~하도록  
in place : 제자리에  
Do not necessarily : 반드시 ~할 필요 없다.  
necessarily : 필연적으로, 어쩔 수 없이  
rely on : ~에 의지[의존]하다, ~을 필요로 하다  
be in favor of : ~에 유리한, ~에 우호적이다  
depend on : ~에 달려 있다, 좌우되다, ~나름이다  
Note that S + V : S가 V하다는 걸 알아라, 주목해라, 주의해라  
by default : 자동적으로, 자연스럽게, 기본적으로  
whenever : ~할 때마다(매번), ~할 때는 언제든지  
For a complete + N, visit/see: N의 전체 목록은 (보려면) , 참조하세요/방문하세요  
  - For a complete list of ~ : ~의 전체 속성 리스트는

are applied by : 적용될  
outcome : 결과  
rather than : ~보다는, ~대신에, ...하지말고  
prevent from : ~할 수 없도록 만들다. ~을 막다ㅡ ~할 수 없다  
If that does not apply to you : 당신에게 적용되지 않는다면  
be considered : ~로 간주되다  
somewhat : 어느 정도, 약간, 다소  
work out of the box : 즉시 사용 가능  
Exploded form : 분해된 형태, 분리된 형태  
attach : 첨부하다, 부여하다, 붙이다, 추가하다, 첨가하다, 덧붙이다.  
accidentally : 우연히, 뜻하지 않게, 잘못하여  
generate : 발생시키다, 만들어 내다, 생기게 하다  
vary : (상황에 따라)다르다, 달라지다  
mandatory : 정해진, 의무적인  
equivalent : 동등한, 맞먹는  
subsequently : 그 뒤에, 나중에  
be marked as : ~로 표시된  
For simplicity : 간단히 말해서, 간단히 말하자면, 정리하면  
Disabling : 무력화, 비활성화  
back away : 사라지다, 손을 떼다, 후퇴하다, 물러서다  
At any point : 어떠한 관점에서, 어느 지점  
Gradually : 서서히, 점진적으로  
by ~ing : ~함으로써  
Alternatively : 그 대신에, 그렇지 않으면  
equivalent : 상응하는, 동등한, 맞먹는  
certain items : 특정 항목들  
implicitly : 암암리에, 무조건, 절대적으로, 넌지시  
be placed on : ~에 놓이다  
reversed : 거꾸로 된, 반대의, 뒤집은    
consistent : 한결같은, 일관된, 변함없는  
hunt : 찾다, 뒤지다  
one-stop : 한 곳에서, 다 할 수 있는  
a set of + N : N 세트  
explicitly : 분명하게, 명쾌하게, 명백하게  
executable : 실행 가능한  
preceding : 이전의, 앞선  
Note that : 참고로  
Sensible : 합리적인, 실용적인  
execution : 실행, 수행  
omit : 빠뜨리다, 생략하다, 누락시키다.  
start out : 시작하다  
?when followed : 따라서  
particularly : 특히, 특별히  
go into detail : 상세히 설명하다.  
