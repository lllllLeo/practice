package me.yujun.ex03TempalteMethodPattern.game;

public abstract class AbstGameConnectHelper {


    /*
    위 알고리즘들은 외부에 노출이 되면 안된다. 외부에서 호출하면 안되는데 하위클래스
    에서 사용할 수 있게 해야한다 -> protected
    */
//    템플릿 메소드 (알고리즘을 수행할 템플릿 메소드 생성)

    public String requestConnection(String encodedInfo){

//        보안작업 -> 암호화 된 문자열을 복호화한다.
        String decodedInfo = doSecurity(encodedInfo);
//        반환된 것을 가지고 아이디, 암호를 할당한다.
        String id = "aaa";
        String password = "bbb";

        if(!authentication(id, password)){
            throw new Error("아이디 암호 불일치");
        }
        String userName = "userName";
        int i = authorization(userName);


        switch (i){
            case -1:
                throw new Error("셧다운"); //나이 때문에
            case 0: //게임매니저
                break;
            case 1: // 유료 회원
                break;
            case 2: //무료 회원
                break;
            case 3: //권한 없음
                break;
            default: //기타상황 일떄
                break;
        }
        return connection(decodedInfo);
    }

    protected abstract String doSecurity(String string);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(String info);

}
