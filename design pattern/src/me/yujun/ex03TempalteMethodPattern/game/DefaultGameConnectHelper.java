package me.yujun.ex03TempalteMethodPattern.game;

// 하위 클래스에서 나눠진 메소드들을 구현한다.
public class DefaultGameConnectHelper extends AbstGameConnectHelper {
    @Override
    protected String doSecurity(String string) {
        System.out.println("강화된 알고리즘을 이용한 디코드");
        return string;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디 / 비번 확인 과정");
        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 확인");
//        서버에서 유저이름 유저의 나이를 알 수 있다.
//        나이를 확인하고 시간을 확인하고 성인이 아니고 10시가 지났다면
//        권한이 없는 것으로 한다.
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("final connection");
        return null;
    }
}
