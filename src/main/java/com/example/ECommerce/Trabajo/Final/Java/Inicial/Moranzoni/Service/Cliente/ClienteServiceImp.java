package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Cliente;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearNuevoCliente(Cliente cliente) throws Exception {
        if (buscarClientePorId(cliente.getId_cliente())==null){
            return clienteRepository.save(cliente);
        }else {
            throw new Exception("El cliente que desea agregar ya existe!");
    }
    }

    @Override
    public Cliente actualizarClienteExistente(Cliente cliente) throws Exception {
        if (buscarClientePorId(cliente.getId_cliente())!=null){
            return clienteRepository.save(cliente);
        }else {
            throw new Exception("eal cliente que desea actualizar no existe!");
        }
    }

    @Override
    public List<Cliente> buscarTodosLosClientesDisponibles() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }

    @Override
    public void eliminarClientePorId(Integer id_cliente) {
        clienteRepository.deleteById(id_cliente);

    }
}
