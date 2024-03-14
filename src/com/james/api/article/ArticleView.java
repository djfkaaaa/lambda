package com.james.api.article;

import com.james.api.enums.ArticleRouter;
import com.james.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner scanner) throws SQLException {
        while (ArticleRouter.menu(scanner) != 0);
    }


}
