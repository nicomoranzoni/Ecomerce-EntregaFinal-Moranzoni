package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Controller;


import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Cliente> mostrarTodosLosClientes (){
        return clienteService.buscarTodosLosClientesDisponibles();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Cliente mostrarClientePorId(@PathVariable Integer id){
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping(value = "/crear", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Cliente crearNuevoCliente (@RequestBody Cliente cliente) throws Exception{
        return clienteService.crearNuevoCliente(cliente);
    }

    @PutMapping(value = "/actualizar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Cliente modificarCliente (@RequestBody Cliente cliente) throws Exception{
        return clienteService.actualizarClienteExistente(cliente);
    }

    @DeleteMapping (value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> borrarClientePorId(@PathVariable(name = "id") Integer id){
        clienteService.eliminarClientePorId(id);
        return ResponseEntity.ok().body("El cliente con el ID: " + id + " ha sido eliminado");
    }



}
