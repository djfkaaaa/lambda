package com.james.api.menu;

import com.james.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    @Getter
    private static MenuController instance = new MenuController();
    public static MenuController getInstance(){return instance;}
    private final MenuService ms;
    private MenuController(){
        ms = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable(){
        return ms.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return ms.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return ms.getMenusByCategory(category);
    }


    public List<Menu> selectTable() throws SQLException {return ms.selectTable();}
//    public List<?> makeFoobaar(){
//        return ms.makeFoobar();
//    }
}
