package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Producto;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto crearNuevoProducto(Producto producto) throws Exception;

    List<Producto> mostrarTodosLosProductos();

    Producto buscarProductoPorId(Integer id);

    Producto modificarProducto (Producto producto) throws  Exception;

    void eliminarProductoPorid(Integer id);


}
