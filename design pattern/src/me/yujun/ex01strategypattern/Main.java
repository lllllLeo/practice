package me.yujun.ex01strategypattern;

public class Main {

    public static void main(String[] args) {
        GameCharacter gameCharacter = new GameCharacter();

        gameCharacter.attack();

        gameCharacter.setWeapon(new Knife());
        gameCharacter.attack();

        gameCharacter.setWeapon(new Sword());
        gameCharacter.attack();


        // 이렇게 쉽게 추가할 수 있다.
        gameCharacter.setWeapon(new Ax());
        gameCharacter.attack();
    }
}
