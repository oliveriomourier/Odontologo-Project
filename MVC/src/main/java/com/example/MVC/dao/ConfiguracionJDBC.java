package com.example.MVC.dao;

import java.sql.*;

public class ConfiguracionJDBC {
    private String jdbc;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenia;

    public ConfiguracionJDBC() {
        this.jdbc = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1 ";
        this.nombreUsuario = "sa";
        this.contrasenia = "";
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenia);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
