package com.example.MVC.service;

import com.example.MVC.dao.IDao;
import com.example.MVC.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo) throws Exception {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listar() throws Exception{
        return odontologoIDao.listarTodo();
    }

    public void eliminar(Integer id) throws Exception {
        odontologoIDao.eliminar(id);
    }

    public Odontologo buscar(Integer id) throws Exception {
        return odontologoIDao.buscar(id);
    }

    public Odontologo modificar(Odontologo odontologo) throws Exception {
        return odontologoIDao.modificar(odontologo);
    }
}
