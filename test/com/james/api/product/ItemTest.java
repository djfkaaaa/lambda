package com.james.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("--->" + s3);
        Assertions.assertEquals(s.systemOut(),"helllo");
    }

    @org.junit.jupiter.api.Test
    void add() {
    }
}