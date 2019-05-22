Git 정리
=========

- ### 원격 저장소에서 파일 삭제하기
   - 원격/로컬저장소 파일 삭제  
    `git rm [file name]`  
   - 원격저장소 파일 삭제  
    `git rm --cached [file name]`  
   - 원격저장소 폴더 하위의 모든 파일 삭제  
    `git rm --cached -r [file name]`

- ### 원격저장소의 브랜치 삭제하기
 1. `git push origin --delete [삭제할 브랜치]`

 2. `git branch -d [삭제할 브랜치]`  
    `git push origin [삭제할 브랜치]`

- ### 원격 저장소 URL 변경하기
 1. `git remote -v` 로 확인  
 2. `git remote set-url [기존 원격 저장소 이름]  [원격저장소 URL]`  
 3. `git remove -v` 로 변경된 걸 확인할 수 있다.

- ### 원격 저장소 연결 해제하기
  `git remote remove [기존 원격 저장소 이름]`

- ### ㅈ같은 workspace
  `git rm -f .idea/workspace.xml`

- ### 원격 저장소 URL 변경하기
  `git remote set-url origin [원격저장소 URL]`

- ### 원격저장소 연결하기
  `git remote add origin [원격저장소 URL]`

- ### 실수로 pull 해서 commit ID를 입력해서 해당 시점으로 되돌아가는법. 입력한 commitID 이후 데이터는 다 사라짐
  `git reflog`
  `git reset --hard $commitID`

- ### git에서 특정 branch만 clone하는 방법
  `git clone -b [브랜치 이름] --single-branch [원격저장소 URL]`

- ### git에 branch 이름으로 photo로 사용하겠다 (없으면 만들고 사용)
  `git checkout -b photo`

- ### commit 취소
  - commit을 취소하고 해당 파일들은 **staged** 상태로 워킹 디렉터리에 보존
    `git reset --soft HEAD^`
  - commit을 취소하고 해당 파일들은 **unstaged** 상태로 워킹 디렉터리에 보존
    `git reset --mixed HEAD^` // default
    `git reset HEAD^` // 위와 동일
    `git reset HEAD~2` // 마지막 2개의 commit을 취소
  - commit을 취소하고 해당 파일들은 **unstaged** 상태로 워킹 디렉터리에서 삭제
    `git reset --hard HEAD^`
  
  - **git reset 옵션**
    – **soft** : index 보존(add한 상태, **staged** 상태), 워킹 디렉터리의 파일 보존. 즉 모두 보존.
    – **mixed** : index 취소(add하기 전 상태, **unstaged** 상태), 워킹 디렉터리의 파일 **보존** (default))
    – **hard** : index 취소(add하기 전 상태, **unstaged** 상태), 워킹 디렉터리의 파일 **삭제**. 즉 모두 취소.

- ### commit 메시지 변경
  `git commit --amend`

- ### 강제 push
  `git -f push [원격 저장소 이름] [로컬 저장소 이름]`
  
- ### ~~~/.git/index.lock': File exists
  `rm -f ./.git/index.lock` 하고 다시 `git add .` 하면 됨
  - 보통 최상위경로인 practice에서 git을 쓰는데 git새로운 내용 추가하고 git 폴더에서 git을 썼다가 practice에서 다시 git을 사용하려하는데 저런 에러가 났었음.
   > fatal: Unable to create '/path/my_proj/.git/index.lock': File exists.
   > If no other git process is currently running, this probably means a git process crashed in this repository earlier. Make sure no other git process is running and remove the file manually to continue.
   
  - https://stackoverflow.com/questions/7860751/git-fatal-unable-to-create-path-my-project-git-index-lock-file-exists

- ### reset했다가 다시 취소 하고 싶을 경우
  `git reflog`로 내역을 보고 **HEAD@{n}** 을 보고 reset 다시 하면됨
  `git reset --hard HEAD@{1}` 이런식으로
  
  
---

`-f` : `--force`