package com.james.api.enums;

import com.james.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum AccountRouter {
    Exit("x",scanner -> {
        System.out.println("Exit");
        return 0;
    }),
    Create("cat",scanner -> {
        System.out.println("create account table");
        AccountController.getInstance().createAccount(scanner);
        return 1;
    }),
    Deposit("depo",scanner -> {
        System.out.println("deposit ");
        AccountController.getInstance().deposit(scanner);
        return 1;
    }),
    Withdraw("with",scanner -> {
        System.out.println("withdraw");
        AccountController.getInstance().withdraw(scanner);
        return 1;
    }),
    Getbalance("bal",scanner -> {
        System.out.println("getbalance");
        AccountController.getInstance().getBalance(scanner);
        return 1;
    }),
    Delete("rm",scanner -> {
        System.out.println("delete");
        AccountController.getInstance().delete(scanner);
        return 1;
    }),
    GetAccount("ls-a",scanner -> {
        System.out.println("getaccount");
        AccountController.getInstance().getAccounts();
        return 1;
    }),
    CreateTable("touch",scanner -> {
        System.out.println("create table");
        return 1;
    })
    ;
    private final String string;
    private final Function<Scanner,Integer> function;

    AccountRouter(String string, Function<Scanner, Integer> function) {
        this.string = string;
        this.function = function;
    }

    public static Integer menu(Scanner sc) {
        System.out.println("menu 선택");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.string.equals(s))
                .findFirst().orElseThrow()
                .function.apply(sc);
    }
}
