# Docker

Docker는 클라이언트/서버 아키텍쳐로 이루어져 있다. (Docker 클라이언트와 Docker 서버가 Remote API를 경유하여 연결되어 있다.) 즉, docker 명령은 서버로 보내져 처리된다.

#### Docker 컨테이너 작성 및 실행 명령어
`docker container run ubuntu:latest /bin/echo 'Hello world`
- Docker 컨테이너의 바탕이 되는 ubuntu의 Docker 이미지가 로컬 환경에 있는지 확인 후 없다면 Docker repository에서 Docker 이미지를 다운로드한다.  
- 'ubuntu:latest'는 Ubuntu의 최신 버전의 이미지를 다운한다는 것  
- 다운로드가 완료되면 컨테이너가 시작되고, echo 명령 실행

> docker container run <Docker 이미지명> <실행할 명령>
  1. docker container run : 컨테이너를 작성 및 실행
  2. <Docker 이미지명> : 바탕이 되는 Docker 이미지
  3. <실행할 명령> : 컨테이너 안에서 실행할 명령

#### Docker 버전 확인 (docker version)
`docker version`
- Docker, Go 언어, OS, 아키텍처의 버전들을 확인할 수 있다.

#### Docker 실행 환경 확인(docker system info)
`docker system info`
- 컨테이너. 이미지의 개수, Docker 버전, OS 등 확인할 수 있다

#### Docker 디스크 이용 상황
`docker system df`
- Docker가 사용하고 있는 디스크의 이용 상황이 표시됨
- 상세 내용 확인하고 싶으면 `-v` 옵션 사용

#### Docker 이미지 지정
`이미지명 [:태그명]`
- 태그에 `latest` 지정 가능

#### Docker 이미지 다운로드
`docker image pull [옵션] 이미지명 [:태그명]`
 - ex) `docker image pull centos:7`
 - 태그명을 생략하면 lastest를 취득함 

`docker image pull -a centos`
  - `-a` 옵션을 사용하면 모든 태그의 Docker 이미지 취득. 단, `-a` 옵션을 지정할 때는 Docker 이미지명에 태그를 지정할 수 없음

`docker image pull gcr.io.tensorflow/tensorflow`  
- 이미지명에 이미지를 취득할 URL을 지정할 수도 있음.(프로토콜(https://) 제외하고 지정)

#### Docker 이미지 목록 표시
`docker image ls [옵션] [repository명]`  
- 취득한 이미지의 목록을 보여줌

옵션 | 설명
--- | ---
`-all`, `-a` | 모든 이미지를 표시
`--digests` | 다이제스트를 표시할지 말지
`--no-trunc` | 결과를 모두 표시
`--quiet`,`-q` | Docker 이미지 ID만 표시

##### docker image ls 명령 결과

항목 | 설명
--- | ---
REPOSITORY | 이미지 이름
TAG | 이미지 태그명
IMAGE ID | 이미지 ID
CREATED | 작성일
SIZE | 이미지 크기

Docker 이미지를 작성하면 고유한 IMAGE ID(랜덤한 문자열)가 부여된다.

#### docker 이미지 상세 정보 확인
`docker image inspect 이미지명:태그명`  
- IMAGE ID, 작성일, Docker 버전, CPU 아키텍쳐 등의 정보가 표시됨
- JSON 형식

`docker image inspect --format="{{ .Os}}" centos:7`  
linux
- OS의 값을 취득하고 싶을때 `--format` 옵션을 활용해서 지정하여 사용

#### docker 이미지 태그 설정
- 이미지에 표식이 되는 태그를 붙임. 누가 만든 어떤 이미지인지 바로 알 수 있음. 일반적으로 식별하기 쉽게 버전명을 붙임

`docker image tag 이미지명 <Docker Hub 사용자명>/이미지명: [태그명]`
- `docker image tag nginx yujun/webserver:1.0` 후 `docker image ls`하면 이미지 리스트가 나오는데 지정한 태그와 nginx 한 쌍으로 보여지는데 이미지에 별명을 붙일 뿐 이미지 자체를 복사하거나 이름을 바꾼 것이 아니다. 그저 태그를 붙인 것 뿐
