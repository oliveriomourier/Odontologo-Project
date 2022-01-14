package com.example.MVC.controller;

import com.example.MVC.dao.ConfiguracionJDBC;
import com.example.MVC.dao.impl.odontologoDaoH2;
import com.example.MVC.model.Odontologo;
import com.example.MVC.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
@RestController
public class OdontologoController {
    private OdontologoService odontologoService = new OdontologoService(new odontologoDaoH2(new ConfiguracionJDBC()));

    @PostMapping("/guardar")
    public Odontologo guardar(@RequestBody Odontologo odontologo) throws Exception {
        return odontologoService.guardar(odontologo);
    }

    @GetMapping("/listar")
    public List<Odontologo> listarTodo() throws Exception {
        return odontologoService.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) throws Exception {
        ResponseEntity response = null;
        if(odontologoService.buscar(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/{id}")
    public Odontologo buscar(@PathVariable Integer id) throws Exception {
        return odontologoService.buscar(id);
    }

    @PutMapping("/modificar")
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo) throws Exception {
        ResponseEntity response = null;
        if(odontologoService.buscar(odontologo.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoService.modificar(odontologo), HttpStatus.OK);
        }
        return response;
    }
}
