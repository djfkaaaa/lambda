package com.james.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleRepository getInstance() {return instance;}

    private Connection connection;

    public ArticleRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jamesdb",
                "james",
                "password"
        );
    }

    public List findUsers() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rslt = pstmt.executeQuery();
        if (rslt.next()){
            do{
                ls.add(Article.builder()
                        .id(rslt.getLong("id"))
                        .title(rslt.getString("title"))
                        .content(rslt.getString("content"))
                        .writer(rslt.getNString("writer"))
                        .registerDate(rslt.getString("registerDate"))
                        .build());
            }while (rslt.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }
        pstmt.close();
        rslt.close();
        connection.close();
        return ls;
    }
}
