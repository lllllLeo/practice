# 파트3. 스프링 부트 사용
이번 섹션은 어떻게 스프링 부트를 사용해야 하는지에 대해 더 자세하게 설명한다. 빌드 시스템, auto-configuration과 어플리케이션 실행방법과 같은 주제를 다룬다. 또한 스프링 부트의 가장 좋은 연습을 다룬다. 비록 스프링 부트에 대한 특별한 것은 없지만, 따라서 개발 진행에 조금 더 쉽게할 수 있도록 몇가지 추천사항이 있다. 

스프링 부트를 시작한다면, 아마도 이 섹션에 들어가기 전에 시작하기(링크) 가이드를 읽어야 한다.

## 13. 빌드 시스템
dependency management를 지원하고 "Maven Central" 저장소에 배포된 아티펙트를 사용할 수 있는 빌드시스템을 강력히 추천한다. Maven이나 Gradle을 선택하는 것을 추천한다. 스프링 부트가 다른 빌드 시스템과 작동하는 것은 가능하지만 특별히 잘 지원되지 않는다.

## 13.1 Maven
Maven 유저는 `spring-boot-starter-parent` 프로젝트에서 상속하여 합리적인 기본값을 얻을 수 있다. 부모 프로젝트는 다음과 같은 특징을 제공합니다:
- 기본 컴파일러 레벨은 Java 1.8
- UTF-8 소스 인코딩
- spring-boot-dependencies pom에서 상속하는 의존성 관리 섹션은, 공통의 의존성 버전을 관리한다. 이 의존성 관리는 pom에서 사용될 때 \<version> 태그를 생략할 수 있다.
- An execution of the repackage goal with a repackage execution id.
- 합리적인 리소스 필터링
- 합리적인 플러그인 구성 
- 프로파일 관련 파일을 포함한 `application.properties`과 `application.yml`을 대한 합리적인 리소스 필터링(예를 들면, `application-dev.properties` and `application-dev.yml`)
참고로


---
go into detail : 상세히 설명하다.
particularly : 특히, 특별히
?when followed : 따라서
start out : 시작하다
omit : 빠뜨리다, 생략하다, 누락시키다.
execution : 실행, 수행
Sensible : 합리적인, 실용적인
Note that : 참고로