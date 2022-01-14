package com.example.MVC.dao.impl;

import com.example.MVC.dao.ConfiguracionJDBC;
import com.example.MVC.dao.IDao;
import com.example.MVC.model.Odontologo;
import com.example.MVC.service.OdontologoService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class odontologoDaoH2 implements IDao<Odontologo> {
    private ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();

    public odontologoDaoH2(ConfiguracionJDBC configuracionJDBC) {
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws Exception {
        Connection connection = configuracionJDBC.getConnection();
        Statement stm = connection.createStatement();
        String guardar = String.format("INSERT INTO odontologos(nombre, apellido) VALUES('%s', '%s')", odontologo.getNombre(), odontologo.getApellido());

        try{
            stm.execute(guardar, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                odontologo.setId(rs.getInt(1));
            }
            stm.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() throws Exception {
        Connection connection = configuracionJDBC.getConnection();
        Statement stm = connection.createStatement();
        String listar = String.format("SELECT * FROM odontologos");
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            ResultSet rs = stm.executeQuery(listar);
            while(rs.next()){
                odontologos.add(new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologos;
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) throws Exception {
        Connection connection = configuracionJDBC.getConnection();
        Statement stm = connection.createStatement();
        String modificar = String.format("UPDATE odontologos SET nombre = '%s', apellido = '%s' WHERE id = '%s'",
                odontologo.getNombre(), odontologo.getApellido(), odontologo.getId());

        try{
            stm.execute(modificar);
            stm.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        Connection connection = configuracionJDBC.getConnection();
        Statement stm = connection.createStatement();
        String eliminar = String.format("DELETE FROM ODONTOLOGOS WHERE ID = '%s'", id);

        try{
            stm.execute(eliminar);
            connection.close();
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Odontologo buscar(Integer id) throws Exception {
        Connection connection = configuracionJDBC.getConnection();
        Statement stm = connection.createStatement();
        String buscar = String.format("SELECT * FROM odontologos WHERE ID = '%s'", id);
        Odontologo odontologo = null;
        try{
            ResultSet rs = stm.executeQuery(buscar);
            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologo;
    }


}
