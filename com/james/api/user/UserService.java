package com.james.api.user;

import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface UserService {
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();

    Messenger putUsers(Scanner scanner) throws SQLException;

    public Messenger createTable() throws SQLException;
    public Messenger deleteTable() throws SQLException;
}
