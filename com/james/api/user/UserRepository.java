package com.james.api.user;

import com.james.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    private static UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance() {return instance;}

    private Connection connection;

    public UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jamesdb",
                "james",
                "password"
        );
        pstmt = null;
        rs = null;
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from articles";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<User> ls = new ArrayList<>();
        if (rs.next()){
            do {System.out.printf("ID : %d\t Title : %s\t Content : %s\t Writer : %s \n",
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("writer"));
                System.out.println();
            }while (rs.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }
        return ls;
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20),\n" +
                "    password VARCHAR(20),\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate()==0) ? Messenger.SUCCESS  : Messenger.FAIL ;
//    String msg = "";
//    if(result==0){
//        msg = "테이블 생성 완료";
//    }
//    else{
//        msg = "테이블 생성 실패";
//    }
//^ return에 3항 연산으로 바로 담아버림
    }

    public Messenger putUsers(Scanner scanner) throws SQLException {
        String sql = "insert into user values(id,?,?,?,?,?,?,?)";
        pstmt = connection.prepareStatement(sql);
        for (int i = 1; i < 8; i++) {
            pstmt.setString(i,scanner.next());
        }
        pstmt.executeUpdate();
        return Messenger.SUCCESS;
    }

    public Messenger deleteTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS users;";
        pstmt = connection.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        return (result==0) ? Messenger.SUCCESS : Messenger.FAIL ;
    }
}
