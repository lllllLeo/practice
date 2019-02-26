package me.yujun.ex02AdapterPattern;

public class AdapterImpl implements Adapter{

//    Math에 static 이라서
//    Math math;

    @Override
    public Float twiceOf(Float f) {

        /*
        Float 타입의 f를 double로 변환해줘서 twoTime(double num)에
        다시 (float)로 형변환한다
        지금은 이렇게 하면 간단하지만 인자가 많아지고하면 불편
        */
//        return (float) Math.twoTime(f.doubleValue());
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        System.out.println("절반 함수 호출");
        return (float) Math.half(f.doubleValue());
    }
}
