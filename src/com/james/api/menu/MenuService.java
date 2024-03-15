package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);



//    List<?> makeFoobar();
}
