package com.james.api.strategy;

import java.sql.ResultSet;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("i",i->"mon"),
    Tuesday("i",i->"tue"),
    Wendsday("i",i->"wed"),
    Thursday("i",i->"tur"),
    Friday("i",i->"fri"),
    Saturday("i",i->"sat"),
    Sunday("i",i->"sun"),

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
                .findAny().orElseGet(()->Wrong)
                .function.apply(s);
    }
}
