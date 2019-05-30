# CodeUp 문제풀이


#### code1031
 - `%o` : 8진수 정수의 형식으로 출력
 - `%x`or`%X` : 16진수 정수의 형식으로 출력
   - `%x`는 소문자,  `%X`는 대문자
   > 몰랐었음.
 
 - `System.out.printf` vs `System.out.format` -> 같다고 보면 됨
   - `System.out.printf`
     ```java
     public PrintStream printf(String format, Object ... args) {
               return format(format, args);
      }
     ```
   - `System.out.format`
     ```java
     public PrintStream format(String format, Object ... args)
     ```
   > "An invocation of this method of the form out.printf(l, format, args) behaves in exactly the same way as the invocation  out.format(l, format, args)"  
   > https://stackoverflow.com/questions/16234448/system-out-printf-vs-system-out-format

#### codeup1034
 - 정수형 -> 문자열 2,8,16진수로 변환
   ```java
    Integer.toBinaryString(int);
    Integer.toOctalString(int);
    Integer.toHexString(int);
   ```

 - 문자열 -> 정수형 2,8,16진수로 변환
   ```java
    Integer.valueOf(string,2);
    Integer.valueOf(string,8);
    Integer.valueOf(string,16);
   ```
   
#### codeup1047
 - 시프트연산자
   - `data<<1` 은 data(2진수 형태)에서 왼쪽으로 1칸 이동(맨 오른쪽에서 0 추가)   
   - `data>>1` 은 data(2진수 형태)에서 오른쪽으로 1칸 이동(맨 왼쪽에서 0 추가)
   - 범위(32비트)를 넘어가서 이동되는 비트는 삭제됨.
   
#### codeup1048
 - a<<b는 a * 2^(b)
 - a>>b는 a / 2^(b)
 
#### codeup1051  
 - c, c++ 에서는 `true`는 `1`, `false`는 `0`으로 표현할 수 있지만  
 Java는 안됨 논리형만 됨.
 > 그래서 `System.out.printf("%b",a>b);` 안됨
 
  구분 | 자료형 | 참 | 거짓
  --- | --- | --- | ---
  C | - | 1 | 0 
  C++ | boolean | 1 TRUE true | 0 FALSE false
  JAVA | boolean | true | false
  C# | bool | true | false
  python | - | True 1 | False 0
  Kotlin | Boolean | true | false
  JSON | - | true | false
  JavaScript | - | true 1 | false 0

#### codeup1059
 - `~` 틸드 연산자
   - 0을 1로, 1을 0으로 바꿈
   - `num = 1` num -> 00000001 (1) / ~num -> 11111110 (-2)
   
#### codeup1060
 - `&` ampersand
   - 같으면 1, 다르면 0
#### codeup1061
 - `^` xor
   - 같으면 0, 다르면 1
#### codeup1062
 - `|` or
   - 하나라도 1이면 1(같아도 1), 0 0 이면 0 
#### codeup  
#### codeup  
#### codeup   

---

`Error:(1, 1) java: illegal character: '\ufeff'`
  - 코드업에서 푼 문제들 `.java`로 받고 **IntelliJ**로 옮겼는데 위와 같은 에러 떠서 보니까
    BOM(Byte Order Mark) 형 유니코드라는데 텍스트 파일용으로 정의되기 위해 사용되는 유니코드라서 Eclipse나 IntelliJ에서는 사용 못한다고 되어있다.

    -> Notepad++를 이용해서 메뉴에서 인코딩 -> UTF-8(BOM없음으로 변환) 하면 된다.

    > https://stackoverflow.com/questions/23211589/error1-1illegalcharacter-ufeff-when-compiling-on-android-studio  
    > 매번 이래야하네 으으으으
