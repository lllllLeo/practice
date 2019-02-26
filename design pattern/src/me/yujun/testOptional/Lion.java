package me.yujun.testOptional;

public class Lion {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Lion lion = new Lion();
        System.out.println(lion.getName());
    }
}
