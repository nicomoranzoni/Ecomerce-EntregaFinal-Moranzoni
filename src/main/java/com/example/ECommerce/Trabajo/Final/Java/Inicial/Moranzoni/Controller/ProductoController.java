package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Controller;


import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Producto;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Producto.ProductoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Producto> mostrarTodosLosProductos(){
        return productoService.mostrarTodosLosProductos();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Producto mostrarProductoPorId(Integer id){
        return productoService.buscarProductoPorId(id);
    }

    @PostMapping(value = "/crear" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Producto cargarNuevoProducto(@RequestBody Producto producto) throws Exception{
        return productoService.crearNuevoProducto(producto);
    }

    @PutMapping(value = "/modificar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Producto modificarProducto (@RequestBody Producto producto) throws Exception{
        return productoService.modificarProducto(producto);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable(name = "id")Integer id){
        productoService.eliminarProductoPorid(id);
        return ResponseEntity.ok().body("El producto con el Id: " + " ha sido eliminado");
    }



}
