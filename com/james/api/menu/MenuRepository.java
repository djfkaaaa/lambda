package com.james.api.menu;

import com.james.api.enums.Messenger;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRepository {
    @Getter
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jamesdb",
                "james",
                "password");
        pstmt = null;
        rs = null;
    }

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.SQL_ERROR;
        }
    }

    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())    menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public List<Menu> selectTable() throws SQLException {
        List<Menu> ls = new ArrayList<>();
        String sql = "select * from menus where category = 'navigate'";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
            if (rs.next()) {
                do {
                    ls.add(Menu.builder()
                            .item(rs.getString("item"))
                            .build());
                } while (rs.next());
            } else {
                System.out.println("카테고리가 없습니다.");}
        return ls;
    }





//    public List<?> makeFoobar() {
//        String sql = "";
//        pstmt = conn.prepareStatement(sql);
//        rs = pstmt.executeQuery();
//        List<?> ls = new ArrayList<>();
//        if (rs.next()){
//            do {
//                Menu m = Menu.builder()
//                        .item(rs.getString("item"))
//                        .category(rs.getString("category"))
//                        .build();
//            }while (rs.next());
//        }else {
//            System.out.println("No Data");
//        }
//        return ls;
//    }
}
