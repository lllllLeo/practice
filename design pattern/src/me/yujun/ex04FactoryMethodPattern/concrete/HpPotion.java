package me.yujun.ex04FactoryMethodPattern.concrete;

import me.yujun.ex04FactoryMethodPattern.framework.Item;

public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
