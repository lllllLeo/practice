package me.yujun.ex01strategypattern;

public class GameCharacter {

    // 접근점
    private Weapon weapon;

    // 교환 가능
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void attack(){
        // 델리게이트 - 난 내가 들고있는거에따라 공격이 변경된다.

        if (weapon == null) {
            System.out.println("맨손 공격");
        } else {
            weapon.attack();
        }
    }


}
