package me.yujun.ex03TempalteMethodPattern.main;

import me.yujun.ex03TempalteMethodPattern.game.AbstGameConnectHelper;
import me.yujun.ex03TempalteMethodPattern.game.DefaultGameConnectHelper;

public class Main {

    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();
        helper.requestConnection("아이디 암호 등 접속 정보");
    }
}
