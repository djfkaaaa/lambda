package com.james.api.enums;

import com.james.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("0",scanner -> {
        System.out.println("exit");
        return 0;
    }),
    JOIN("1",scanner -> {
        System.out.println("===join===");
        System.out.println("result : " + UserController.getInstance().save(scanner));
        System.out.println("===success===");
        return 1;
    }),
    LOGIN("2",scanner -> {
        System.out.println("===login===");
        System.out.println("result : " + UserController.getInstance().login(scanner));
        System.out.println("===success===");
        return 1;
    }),
    SEARCH_ID("3",scanner -> {
        System.out.println("===fint id===");
        System.out.println("result : " + UserController.getInstance().findById(scanner));
        System.out.println("===success===");
        return 1;
    }),
    PW_CHANGE("4",scanner -> {
        System.out.println("===change pw===");
        System.out.println("result : " + UserController.getInstance().updatePassword(scanner));
        System.out.println("===success===");
        return 1;
    }),
    REMOVE("5",scanner -> {
        System.out.println("===remove===");
        System.out.println("result : " + UserController.getInstance().delete(scanner));
        System.out.println("===success===");
        return 1;
    }),
    SEARCH_NAME("6",scanner -> {
        System.out.println("===fint name===");
        System.out.println("result : " + UserController.getInstance().findUsersByName(scanner));
        System.out.println("===success===");
        return 1;
    }),
    SEARCH_JOB("7",scanner -> {
        System.out.println("===fint job===");
        System.out.println("result : " + UserController.getInstance().findUsersByJobFromMap(scanner));
        System.out.println("===success===");
        return 1;
    }),
    COUNT("8",scanner -> {
        System.out.println("===user count===");
        System.out.println("result : " + UserController.getInstance().count());
        System.out.println("===success===");
        return 1;
    }),
    LIST("ls",scanner -> {
        System.out.println("===user list===");
        System.out.println("result : " + UserController.getInstance().findAll());
        System.out.println("===success===");
        return 1;
    }),
    CREATE_TABLE("touch",scanner -> {
        System.out.println("===create table===");
        try {
            System.out.println("result : " + UserController.getInstance().createTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===success===");
        return 1;
    }),
    DELETE_TABLE("rm",scanner -> {
        System.out.println("===delete table===");
        try {
            System.out.println("result : " + UserController.getInstance().deleteTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===success===");
        return 1;
    }),
    PUT_DATA("create",scanner -> {
        System.out.println("===insert data===");
        try {
            System.out.println("result : " + UserController.getInstance().putUsers(scanner));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===success===");
        return 1;
    }),
    USER_ROUTER_ERROR("router error",scanner -> {
        System.out.println("===wrong input===");
        return 1;
    }),

    ;

    private final String string;
    private final Function<Scanner,Integer> function;
    UserRouter(String string, Function<Scanner, Integer> function) {
        this.string = string;
        this.function = function;
    }
    public static Integer userrouter(Scanner sc){
        System.out.println("[사용자메뉴] 0-종료\n " +
                "1-회원가입\n " +
                "2-로그인\n " +
                "3-ID검색\n " +
                "4-비번변경\n" +
                "5-탈퇴\n " +
                "ls-회원목록\n " +
                "6-이름검색\n" +
                "7-직업검색\n" +
                "8-회원수\n"+
                "touch-테이블생성\n"+
                "rm-테이블삭제\n"+
                "create-테이블에 데이터삽입");
        String s = sc.next();
        return Stream.of(values())
                .filter(o -> o.string.equals(s))
                .findFirst()
                .orElse(USER_ROUTER_ERROR)
                .function
                .apply(sc);
    }
}

