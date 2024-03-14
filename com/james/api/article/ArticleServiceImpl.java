package com.james.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    public static ArticleServiceImpl getInstance() {return instance;}
    ArticleRepository repository;
    public ArticleServiceImpl() {repository = ArticleRepository.getInstance();}

    @Override
    public List<?> findUsers() throws SQLException {
        return repository.findUsers();
    }
}
