package me.yujun.ex01strategypattern;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("검 공격");
    }
}
