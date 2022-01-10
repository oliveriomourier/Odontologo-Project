package com.company;
import java.sql.*;

public class Test {
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE("
            + "ID INT PRIMARY KEY,"
            + "NAME VARCHAR(20) NOT NULL,"
            + "LASTNAME VARCHAR(20) NOT NULL,"
            + "BIRTHDAY DATETIME,"
            + "DNI LONG NOT NULL"
            + ")";
    private static final String INSERT_VALUES = "INSERT INTO PACIENTE(ID, NAME, LASTNAME, BIRTHDAY, DNI) VALUES (?,?,?,?,?)";
    public static final String UPDATE_VALUES = "UPDATE PACIENTE SET NAME = ? WHERE ID = ?";

    public static final Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try{
            connection = getConnection();
            Statement stm = connection.createStatement();
            stm.execute(CREATE_TABLE);
            connection.setAutoCommit(false);

            PreparedStatement psInsert = connection.prepareStatement(INSERT_VALUES);
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Oliverio");
            psInsert.setString(3, "Mourier");
            psInsert.setDate(4, Date.valueOf("2001-02-21"));
            psInsert.setLong(5, 12345);
            psInsert.execute();

            PreparedStatement psUpdate = connection.prepareStatement(UPDATE_VALUES);
            psUpdate.setString(1, "Clementina");
            psUpdate.setLong(2, 1);
            psUpdate.execute();

            connection.commit();
            connection.setAutoCommit(true);

            String sql = "SELECT * FROM PACIENTE";
            ResultSet rd = stm.executeQuery(sql);
            while (rd.next()){
                System.out.println(rd.getInt(1)+" "+rd.getString(2)+" "+rd.getString(3)+" "+rd.getDate(4)+" "+rd.getLong(5));
            }

        }catch(Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            connection.close();
        }
    }
}
