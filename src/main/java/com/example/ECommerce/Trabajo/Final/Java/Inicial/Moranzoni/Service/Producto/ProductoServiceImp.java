package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Producto;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Producto;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {


    @Autowired
    private ProductoRespository productoRespository;


    @Override
    public Producto crearNuevoProducto(Producto producto) throws Exception {
        if (buscarProductoPorId(producto.getId_product())==null) {
            return productoRespository.save(producto);
        }else {
            throw new Exception("El producto que desea agregar ya existe!");
        }
    }

    @Override
    public List<Producto> mostrarTodosLosProductos() {
        return productoRespository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRespository.findById(id).orElse(null);
    }

    @Override
    public Producto modificarProducto(Producto producto) throws Exception {
        if (buscarProductoPorId(producto.getId_product())!= null) {
            return productoRespository.save(producto);
        }else throw new Exception("El producto que desea modificar no existe");
    }

    @Override
    public void eliminarProductoPorid(Integer id) {
        productoRespository.deleteById(id);
    }
}
