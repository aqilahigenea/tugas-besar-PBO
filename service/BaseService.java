package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import database.DatabaseConnection;

public abstract class BaseService {
    protected Scanner input = new Scanner(System.in);

    protected Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }
}

