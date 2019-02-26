package me.yujun.ex02AdapterPattern;

public class Main {
/**
 * Adapter Pattern
 * 알고리즘을 요구사항에 맞춰서 변경
 *
 * Math 클래스에서는 double타입의 인자를 받는 메서드가 있지만
 * 내가 원하는 것은 Float타입의 인자를 주고 싶음.
 * 그래서 내가 구현하고 싶은 형태의 메서드를 인터페이스에 정의해서
 * Math에 정의되어있는 기능에 맞게 변경함.
 *
 * -> 직접적으로 Math클래스의 method에 접근하지않고 AdapterImpl(Adapter)로
 *    접근해서 메서드를 호출함
 *
 *    Adapter : 원하는 기능
 *    AdpaterImpl : 원하는 기능을 구현(Math.twiceOf~)
 *
 *
 *
 *
 *    클래스방식 : 클래스를 extends해서 호출, 사용
 *                클래스 자체의 인터페이스 변경. 상속을 사용한 어댑터 ( 대부분 다중 상속 모양으로 만들어진다. )
 *
 *    객체방식 :  상속을 받지 않고 바로 내부 멤버 변수에 객체 인스턴스를 가지고 있으면 됨
 *               이미 존재하는 객체의 인터페이스를 변경. ( 주로 포함을 사용해서 구현한다. )
 *
 *
 *  단점 :
 *      클래스어뎁터(특정 어뎁티만 적용)
 *      객체어뎁터(코드량이 클래스어뎁터보단 많다)
 *
 *
 * */
    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();

        System.out.println(adapter.twiceOf(100f));
        System.out.println(adapter.halfOf(88f));
    }
}
