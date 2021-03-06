# 1장
 
## 미디어 타입
- HTTP는 웹에서 전송되는 객체 각각에 신중하게 `MIME` 타입이라는 데이터 포맷 라벨을 붙인다.  
- `MIME(Multipurpose Internet Mail Extensions, 다목적 인터넷 메일 확장)`은 원래 각기 다른 전자메일 시스템 사이에서 메시지를 오갈 때 겪는 문제점을 해결하기 위해 설계됨. `MIME`은 이메일에서 워낙 잘 동작했기 때문에, HTTP에서도 멀티미디어 콘텐츠를 기술하고 라벨을 붙이기 위해 채택되었다.  
- 웹 서버는 모든 HTTP 객체 데이터에 `MIME` 타입을 붙인다. 웹브라우저는 서버로부터 객체를 돌려받을 때, 다룰 수 있는 객체인지 `MIME` 타입을 통해 확인한다.  
- 형식 : 주 타입/부 타입  

## HTTP 메시지
- 요청 / 응답 메시지
- 단순한 줄 단위의 문자열이다.
- 시작줄 : 메시지의 첫 줄은 시작줄로, 요청이라면 무엇을 해야 하는지 응답이라면 무슨 일이 일어났는지 나타낸다.

## 헤더
- 시작줄 다음에는 0개 이상의 헤더 필드가 이어진다.
- 각 헤더 필드는 쉬운 구문분석을 위해 쌍점(:)으로 구분되어 있는 하나의 이름과 하나의 값으로 구성된다. 
- 헤더 필드를 추가하려면 한 줄을 더하기만 하면 된다.
- 헤더는 빈 줄로 끝난다. (헤더 값이 2개면 2줄 + 빈 줄 해서 총 3줄)

## 본문
- 본문에 데이터를 실어 보내거나 / 반환받는다.
- 문자열이며 구조적인 시작줄이나 헤더와 달리, 본문은 임의의 이진 데이터를 포함할 수 있다.(텍스트, 이미지, 비디오, 오디오 트랙, 응용 소프트웨어).

## 사유 구절
- `OK`, `BAD_REQUEST` 같은 것들

## TCP/IP
- HTTP는 `애플리케이션 계층` 프로토콜이다.
- HTTP는 네트워크 통신의 핵심적인 세부사항에 대해서 신경 쓰지 않고 대중적이고 신뢰성이 있는 인터넷 전송 프로토콜인 `TCP/IP`에게 맡긴다.

  ### TCP
  - 오류 없는 데이터 전송
  - 순서에 맞는 전달 (데이터는 언제나 보낸 순서대로 도착한다)
  - 조각나지 않는 데이터 스트림 (언제든 어떤 크기로든 보낼 수 있다.)
  - 인터넷 자체가 전 세계의 컴퓨터와 네트워크 장치들 사이에서 대중적으로 사용되는 TCP/IP에 기초하고 있다.
  - TCP/IP는 TCP와 IP가 층을 이루는, 패킷 교환 네트워크 프로토콜의 집합이다. 
  - TCP/IP는 각 네트워크와 하드웨어의 특성을 숨기고, 어떤 종류의 컴퓨터나 네트워크든 서로 **신뢰성** 있는 의사소통을 하게 해준다.
  - TCP 커넥션이 맺어지면, 클라이언트와 서버 컴퓨터 간에 교환되는 메시지가 없어지거나, 손상되거나, 순서가 뒤바뀌어 수신되는 일은 결코 없다.

## 프락시
- 웹 보안, 애플리케이션 통합, 성능 최적화를 위한 중요한 구성요소이다. 
- 프락시는 클라이언트와 서버 사이에 위치한다. 
- 주로 보안을 위해 사용된다. 즉, 모든 웹 트래픽 흐름 속에서 신뢰할 만한 중개자 역할을 한다. 
- 프락시는 요청과 응답을 필터링한다. 
  - 회사에서 무엇인가를 다운 받을 때 애플리케이션 바이러스를 검출
  - 초등학교 학생들에게서 성인 콘텐츠를 차단


# 2장

## URL (Uniform Resource Locator)
- 인터넷의 리소스를 가리키는 표준이름
- URL은 전자정보 일부를 가리키고 그것이 어디에 있고 어떻게 접근할 수 있는지 알려줌
- URL은 인터넷에 있는 모든 리소스가 여러 프로토콜을 통해서 전달될 수 있도록, 각 리소스에 유일한 이름을 지을 수 있게 설계되었다. 모든 프로토콜이 데이터를 전송하기 위해서 서로 다른 장치를 가지고 있기 때문에, 어떤 인터넷 프로토콜을 통해서든 안전하게 전송될 수 있도록 URL을 설계하는 것은 중요했다.

## URI (통합 자원 식별자 Uniform Resource Identifier)
- URL보다 더 일반화 된 부류의 부분집합
- URI는 두 가지 주요 부분집합인, URL과 URN으로 구성된 종합적인 개념

### `URN`은 현재 그 리소스가 어디에 존재하든 상관없이 그 이름만으로 리소스를 식별하는데 비해 `URL`은 리소스가 어디 있는지 설명해서 리소스를 식별한다.

> 예) http://www.yujun.me/seasonal/index-fall.html
>  - `http`는 URL의 scheme
>    - `scheme`는 웹 클라이언트가 리소스에 어떻게 접근하는지 알려준다. 이 경우에, URL이 HTTP 프로토콜을 사용한다.
>    - scheme(어떻게)  
>  - `www.yujun.me`는 서버의 위치
>    - 이는 웹 클라이언트가 리소스가 어디에 호스팅 되어 있는지 알려준다. 
>    - 호스트(어디에)
>  - `/seasonal/index-fall.html` 은 리소스의 경로
>    - 경로는 서버에 존재하는 로컬 리소스들 중에서 요청받은 리소스가        무엇인지 알려준다. 
>    - 경로(무엇을)

>예)   
    mailto:president@whitehouse.gov 는 이메일 주소를  
    ftp://ftp.lots-o-books.com/pub/complete-price-list.xls 는 FTP서버에 올라가 있는 파일을  
    rtsp://www.yujun.me:554/interview/cto_video 는 스트리밍을 제공하기 위해 비디오 서버에 호스팅하고 있는 영화를 가리킴  
    **대부분 URL은 동일하게 `스키마://서버위치/경로` 구조로 이루어져 있다.**

## 안전한 전송
- 정보가 유실될 위험 없이 URL을 전송할 수 있다는 것을 의미

## https
- https 스키마는 http 스키마와 거의 같다.
- 다른 점은 https는 HTTP의 커넥션의 양 끝단에서 암호화하기 위해 넷스케이프에서 개발한 `보안 소켓 계층(Secure Sockets Layer, SSL)`을 사용한다는 것 뿐이다.

## ftp
- ftp 서버에 있는 파일을 내려 받거나 올리고, ftp 서버의 디렉토리에 있는 콘텐츠 목록을 가져오는 데 사용할 수 있다. - ftp는 웹과 URL이 출현하기 전부터 있었다.

## 인코딩
- URL에 있는 안전하지 않은 문자들을 표현할 수 있는 인코딩 방식이 고안됨
- 인코딩은 안전하지 않은 문자를 퍼센티지 기호 (%)로 시작해, ASCII코드로 표현되는 두 개의 16진수 숫자로 이루어진 `이스케이프` 문자로 바꾼다.


컴포넌트 | 설명 | 기본값
--- | --- | --- |    
스키마 | 리소스를 가져오려면 어떤 프로토콜을 사용하여 서버에 접근해야 하는지 가리킨다. | 없음
사용자의 이름	| 몇몇 스키마는 리소스에 접근을 하기 위해 사용자 이름을 필요로 한다. |	anonymous
비밀번호 | 사용자의 비밀번호를 가리키며, 사용자 이름에 콜론(:)으로 이어서 기술한다.	| <이메일 주소>
호스트 | 리소스를 호스팅하는 서버의 호스트 명이나 IP 주소 |	없음
포트	| 리소스를 호스팅하는 서버가 열어놓은 포트번호. 많은 스키마가 기본 포트를 가지고 있다.	| 스키마에 따라 다름
경로	| 이전 컴포넌트와 빗금(/)으로 구분되어 있으며, 서버 내 리소스가 서버 어디에 있는지를 가리킨다. 경로 컴포넌트의 문법은 서버와 스키마에 따라 다르다.	| 없음
파라미터 |	특정 스키마들에서 입력 파라미터를 기술하는 용도로 사용한다. 파라미터는 이름/값을 쌍으로 가진다. 파라미터는, 다른 파라미터나 경로의 일부와 세미콜론(;)으로 구분하여 기술하며, 여러 개를 가질 수 있다. |	없음
질의 |	스키마에서 애플리케이션(DB, 게시판, 검색엔진)에 파라미터를 전달하는데 쓰인다. 질의 컴포넌트를 작성하는데 쓰이는 공통 포맷은 없다. 이는 URL의 끝에 "?"로 구분한다. |	없음
프래그먼트 |	리소스의 조각이나 일부분을 가리키는 이름이다. URL이 특정 객체를 가리킬경우에 프래그먼트 필드는 서버에 전달되지 않는다. 이는 클라이언트에서만 사용한다. URL의 끝에서 "#"문자로 구분한다. | 	


# 3장

## Method
- 모든 서버가 모든 메서드를 구현하지는 않는다는 것에 주의

## GET
- 주로 서버에게 리소르를 달라고 요청하기 위해 쓰임

## HEAD
- 정확히 GET처럼 행동하지만, 서버는 응답으로 헤더만을 돌려준다. 엔터티 본문은 결코 반환되지 않는다.
  - 리소스를 가져오지 않고도 그에 대해 무엇인가(타입이라거나)를 알아낼 수 있다.
  - 응답의 상태 코드를 통해, 개체가 존재하는지 확인할 수 있다.
  - 헤더를 확인하여 리소스가 변경되었는지 검사할 수 있다.
- HTTP/1.1 준수를 위해서는 HEAD 메서드가 반드시 구현되어 있어야 한다.

## PUT
- 서버가 요청의 본문을 가지고 요청 URL의 이름대로 새 문서를 만들거나, 이미 URL이 존재한다면 본문을 사용해서 교체하는 것

## POST
- 서버에 입력 데이터를 전송하기 위해 설계

> **POST**는 서버에 데이터를 보내기 위해 사용. **PUT**은 서버에 있는 리소스에 데이터를 입력하기 위해 사용.

## TRACE
- 클라이언트에게 자신의 요청이 서버에 도달했을 떄 어떻게 보이게 되는지 알려준다.
- TRACE 요청은 목적지 서버에서 '루프백' 진단을 시작한다. 요청 전송의 마지막 단계에 있는 서버는 자신이 받은 요청 메시지를 본문에 넣어 TRACE 응답을 되돌려준다. 클라이언트는 자신과 목적지 서버 사이에 있는 모든 HTTP 애플리케이션의 요청/응답 연쇄를 따라가면서 자신이 보낸 메시지가 망가졌거나 수정되었는지, 만약 그렇다면 어떻게 변경되었는지 확인할 수 있다.
- TRACE 메서드는 주로 **진단**을 위해 사용. 예를 들면 요청이 의도한 요청/응답 연쇄를 거쳐가는지 검사할 수 있다. 또한 프락시나 다른 애플리케이션들이 요청에 어떤 영향을 미치는지 확인해보고자 할 때도 좋은 도구다.
- TRACE 요청은 어떠한 엔터티 본문도 보낼 수 없다. TRACE 응답의 엔터티 본문에는 서버가 받은 요청이 그대로 들어있다.

## OPTIONS
- 웹 서버에게 여러 가지 종류의 지원 범위에 대해 물어봄
-  서버에게 특정 리소스에 대해 어떤 메서드가 지원되는지 물어볼 수 있다. (몇몇 서버는 특정 종류의 객체에 대해 특정 동작만을 지원한다). 
- 여러 리소스에 대해 실제로 접근하지 않고도 그것들을 어떻게 접근하는 것이 최선인지 확인할 수 있는 수단을 클라이언트 애플리케이션에게 제공한다.
  > (응답메시지 Allow: GET, POST, PUT, OPTIONS)

## DELETE
- 서버에게 요청 URL로 지정한 리소스를 삭제할 것을 요청. 그러나 클라이언트는 삭제가 수행되는 것을 보장하지 못한다.
