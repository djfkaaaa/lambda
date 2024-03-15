package com.james.api.user;

import com.james.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scanner) throws SQLException {
        while (UserRouter.userrouter(scanner) != 0);
    }
}
