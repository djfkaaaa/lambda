package com.james.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    ArticleServiceImpl service;
    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }

    public static ArticleController instance = new ArticleController();
    public static ArticleController getInstance() {
        return instance;
    }


    public List<?> findUsers() throws SQLException {
        return service.findUsers();
    }
}
