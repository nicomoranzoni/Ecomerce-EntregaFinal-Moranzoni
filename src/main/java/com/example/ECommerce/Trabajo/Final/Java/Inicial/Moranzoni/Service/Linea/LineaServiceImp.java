package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Linea;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Producto;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ClienteRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.LineaRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ProductoRespository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaResponse;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaServiceImp implements LineaService {

    @Autowired
    LineaRepository lineaRepository;

    @Autowired
    ProductoRespository productoRespository;

    @Autowired
    ProductoService productoService;

    @Autowired
    ClienteRepository clienteRepository;




    @Override
    public List<Linea> mostrarTodasLasVentas() {
        return lineaRepository.findAll();
    }

    @Override
    public Linea buscarVentaPorId(Integer id_venta) {
        return lineaRepository.findById(id_venta).orElse(null);
    }

    @Override
    public LineaResponse realizarVenta(LineaRequest venta) throws Exception {

        Producto producto = productoRespository.findById(venta.getCodigoProducto()).orElse(null);

        if (verificarCliente(venta.getId_cliente())==false){
            throw new Exception("El cliente deseado no existe!");
        }
        if (producto == null) {
            throw new Exception("El producto deseado no existe!");
        }

        Linea ventaARealizar;

        ventaARealizar = new Linea().builder()
                .id_linea(generarId())
                .codigo(producto.getId_product())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .cantidad(venta.getCantidadComprada())
                .id_comprobante(venta.getNumeroComprobante())
                .build();

        if (producto.getCantidadDisponible() >= venta.getCantidadComprada()){
            int nuevoStock = producto.getCantidadDisponible() - venta.getCantidadComprada();
            producto.setCantidadDisponible(nuevoStock);
            productoService.modificarProducto(producto);
        }else if (producto.getCantidadDisponible()<venta.getCantidadComprada()){
            throw new Exception("Lamentablemente no contamos con el stock suficiente para realizar la venta");
        }

        if (buscarVentaPorId(ventaARealizar.getId_linea())  == null){
            lineaRepository.save(ventaARealizar);

            LineaResponse ventaSaliente = new LineaResponse();
            ventaSaliente.setIdVenta(ventaARealizar.getId_linea());
            ventaSaliente.setCodigoProducto(ventaARealizar.getCodigo());
            ventaSaliente.setDescripcionProducto(ventaARealizar.getDescripcion());
            ventaSaliente.setPrecioProdcuto(ventaARealizar.getPrecio());
            ventaSaliente.setCantidadComprada(ventaARealizar.getCantidad());
            ventaSaliente.setIdComprobante(ventaARealizar.getId_comprobante());

            return ventaSaliente;

        }else throw new Exception("Esta venta ya ha sido registada");



    }



    private boolean verificarCliente(Integer id_cliente){
        Cliente verificarCliente = clienteRepository.findById(id_cliente).orElse(null);
        if (verificarCliente == null){
            return false;
        } else return true;
    }

    private int generarId (){
        return lineaRepository.findAll().size()+1;
    }
}
