package com.james.api.strategy;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1",i->"mon"),
    Tuesday("2",i->"tue"),
    Wendsday("3",i->"wed"),
    Thursday("4",i->"tur"),
    Friday("5",i->"fri"),
    Saturday("6",i->"sat"),
    Sunday("7",i->"sun"),
    Wrong("i",i->"wrong");

    private final String name;
    private final Function<String,String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String excute(Scanner sc) {
        System.out.println("1~7 입력");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findAny().orElseGet(()->Wrong)
                .function.apply(s);
    }
}
