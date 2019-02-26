package me.yujun.ex04FactoryMethodPattern.concrete;

import me.yujun.ex04FactoryMethodPattern.framework.Item;
import me.yujun.ex04FactoryMethodPattern.framework.ItemCreator;

public class Main {

    public static void main(String[] args) {
        ItemCreator creator;
        Item item;

        creator = new HpCreator();
        item = creator.create();
        item.use();

        creator = new MpCreator();
        creator.create();
        item.use();
    }
}
