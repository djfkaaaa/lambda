package com.james.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner scanner) throws SQLException {
        ArticleController controller = new ArticleController();
        while (true){
            System.out.println("===메뉴목록===\n" +
                    "0 - 종료\n" +
                    "1 - 기사목록");
            switch (scanner.next()){
                case "0" :
                    System.out.println("종료");return;
                case "1" :
                    System.out.println("기사목록");
                    controller.findUsers().forEach(i -> System.out.println(i));
                    break;
            }
        }
    }
}
