package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.util.List;

public class MenuServiceImpl implements MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();
    public static MenuServiceImpl getInstance(){return instance;}
    MenuRepository mr;
    private MenuServiceImpl(){
        mr = MenuRepository.getInstance();
    }
@Override
public Messenger makeMenuTable(){
    mr.makeTable();
    this.insertMenus();
    return Messenger.SUCCESS;
}

@Override
public Messenger removeTable() {
    return mr.removeTable();
}

@Override
public List<?> getMenusByCategory(String category){
    return mr.getMenusByCategory(category);
}

private void insertMenus(){
//    String[] categories = {"navigate", "article", "account", "board", "user", "soccer"};
//    String[][] menus = {{"x-Exit", "a-Article", "ac-Account", "c-Crawler", "b-board", "u-User"},
//            {"x-Exit", "ls-List"},
//            {"x-Exit", "mkdir-create account table",  "cr-Create Account", "2-Deposit","3-Withdraw","4-Balance","rm-Cancel Account","ls-Account List"},
//            {"x-Exit", "mkdir-create board table",  "ls-music List", "lg-login", "3-Search ID", "pc-PW Update",
//                    "rm-remove", "ls-List", "7-Search ID", "8-Find Job", "9-count"},
//            {"x-Exit", "mkdir-create table", "cr-join", "lg-login", "3-Search ID", "pc-PW 변경", "rm-탈퇴", "ls-회원목록", "6-이름 검색", "7-직업 검색",
//                    "8-회원수","rmrf-테이블 삭제","create-데이터 삽입"},
//            {"x-Exit", "mkdir-create soccer table"},
//            {}};
    String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
    String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
            {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                    "ls-a", "ls-n", "ls-job", "cnt"},
            {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
            {"x", "mk"},
            {"x", "mk"},
            {"x", "mk"},
            {}};

    for(int i = 0; i < menus.length; i++)
        for(int j = 0; j < menus[i].length; j++)
            mr.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
