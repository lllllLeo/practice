package me.yujun.ex04FactoryMethodPattern.concrete;

import me.yujun.ex04FactoryMethodPattern.framework.Item;
import me.yujun.ex04FactoryMethodPattern.framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {
    @Override
    protected void requestItemsInfo() {
        System.out.println("데이터베이스에서 체력 회복 물약의 정보를 가져온다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("체력 회복 물약을 새로 생성 했습니다."+ new Date());
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}
