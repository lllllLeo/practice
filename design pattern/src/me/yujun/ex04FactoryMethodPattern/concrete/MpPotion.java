package me.yujun.ex04FactoryMethodPattern.concrete;

import me.yujun.ex04FactoryMethodPattern.framework.Item;

public class MpPotion implements Item {
    @Override
    public void use() {
        System.out.println("마력 회복");
    }
}
