package main;

import java.util.EnumSet;

public class EnumSetTest {

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    enum Trash {
        GIBUM
    }

    public static void main(String[] args) {

        EnumSet es = EnumSet.allOf(Day.class);
        EnumSet es2 = es.clone();
        System.out.println(es2);
        System.out.println(es.contains(Day.SATURDAY));
        es2.of(Trash.GIBUM);
        System.out.println(es2);
        es2 = EnumSet.noneOf(Day.class);
        EnumSet es3 = EnumSet.copyOf(es);
        System.out.println(es3);
    }
}
