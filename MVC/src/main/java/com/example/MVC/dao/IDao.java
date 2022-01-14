package com.example.MVC.dao;

import java.util.List;

public interface IDao <T>{
    public T guardar(T t) throws Exception;
    public List<T> listarTodo() throws Exception;
    public T modificar(T t) throws Exception;
    public void eliminar(Integer id) throws Exception;
    public T buscar(Integer id) throws Exception;
}
