package com.james.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationC {
    ;

    private final String string;
    private final Consumer<Scanner> consumer;

    NavigationC(String string, Consumer<Scanner> consumer) {
        this.string = string;
        this.consumer = consumer;
    }


    public static String navigate(Scanner sc) {
        return "";
    }
}
