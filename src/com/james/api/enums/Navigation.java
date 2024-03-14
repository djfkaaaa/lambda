package com.james.api.enums;

import com.james.api.account.AccountView;
import com.james.api.article.ArticleView;
import com.james.api.board.BoardView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("x",scanner -> {
        System.out.println("exit");
        return 0;}),
    ARTICLE("a",scanner -> {
        try {
            ArticleView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    ACCOUNT("ac",scanner -> {
        AccountView.main(scanner);
        return 1;
    }),
    BOARD("b",scanner -> {
        BoardView.main(scanner);
        return 1;
    }),
    CRAWLER("c",scanner -> {
        try {
            CrawlerView.main(scanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    USER("u",scanner -> {
        try {
            UserView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }),
    NAVIGATION_ERROR("navigation_error", scan -> {
        System.out.println("Wrong Input");
        return 1;
    });


    private final String string;
    private final Function<Scanner,Integer> function;

    Navigation(String string, Function<Scanner, Integer> function) {
        this.string = string;
        this.function = function;
    }

    public static Integer navigate(Scanner scanner){
        System.out.println("x-Exit, a-Article, ac-Account, b-Board, c-Crawler, u-User");
        String s = scanner.next();
        return Stream.of(values()) //Strea.of 는 반환 타입이 Stream<int[]>
                // ^ values() == navigation.values / enum 요소 전체 하나의 values
                // values의 값이 배열로 떨어졌기에 Stream 사용 lab-listofisgood클래스 참고
                .filter(o -> o.string.equals(s)) // 조건 , values 가 조건에 맞다면
                .findFirst() // 조건에 맞는것 가져오기, 가져오는것은 values 전체 , 조건에 맞지않는것은 다 걸러낸 상태에서 하나 찝어옴
                .orElse(NAVIGATION_ERROR)
                .function // 가져온 values에서 조건을 확인하는 string 뒤 funtion을 실행
                .apply(scanner);// apply는 함수의 추상메서드 매개변수 하나를 입력받아 작업 후 반환
    }
}
