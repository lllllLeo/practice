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
   - 최종 커밋 취소. 그러나 변경된 파일은 남아있음.  
     `git reset HEAD^`  

   - 최종 커밋 취소하고 파일 까지 복구한다.    
    `git reset --hard HEAD^`

   - 마지막 n개의 커밋을 취소 한다. 그러나 변경된 파일은 남아있음. (n: 숫자 )  
     `git reset HEAD~n`

   - 마지막 n개의 커밋을 취소. 파일 또한 복구됨.  
     `git reset --hard HEAD~n`

---
`-f` : `--force`