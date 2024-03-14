package com.james.api.enums;

import com.james.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

public enum ArticleRouter{
    Exit("x",scanner -> {
        System.out.println("종료합니다");
        return 0;
    }),
    List("l",scanner -> {
        System.out.println("리스트를 출력합니다");
        try {
            ArticleController.getInstance().findUsers().forEach(i -> System.out.println(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    })
    ;
    private final String name;
    private final Function<Scanner,Integer> function;

    ArticleRouter(String name, Function<Scanner, Integer> function) {
        this.name = name;
        this.function = function;
    }

    public static Integer menu(Scanner scanner) {
        System.out.println("x-exit ,l-list 입력");
        String s = scanner.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findFirst().orElseThrow(()->new IllegalArgumentException("올바른값이 아닙니다."))
                .function.apply(scanner);
    }
}
