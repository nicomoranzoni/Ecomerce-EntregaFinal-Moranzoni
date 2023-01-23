package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Cliente;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente crearNuevoCliente(Cliente cliente) throws Exception;

    Cliente actualizarClienteExistente (Cliente cliente) throws  Exception;

    List<Cliente> buscarTodosLosClientesDisponibles();

    Cliente buscarClientePorId (Integer id_cliente);

    void eliminarClientePorId(Integer id_cliente);
}
