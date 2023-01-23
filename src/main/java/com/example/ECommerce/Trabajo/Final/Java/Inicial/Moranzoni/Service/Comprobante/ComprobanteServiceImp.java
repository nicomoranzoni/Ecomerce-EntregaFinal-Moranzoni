package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Comprobante;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Comprobante;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ClienteRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ComprobanteRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.LineaRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ComprobanteServiceImp implements ComprobanteService{

    @Autowired
    ComprobanteRepository comprobanteRepository;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    private LineaRepository lineaRepository;



    @Override
    public List<Comprobante> mostrarTodos() {
        return comprobanteRepository.findAll();
    }

    @Override
    public Comprobante buscarComprobantePorID(Integer id) {
        return comprobanteRepository.findById(id).orElse(null);
    }

    @Override
    public ComprobanteResponse crearCromprobante(ComprobanteRequest request) throws Exception {
        Cliente cliente = new Cliente();
        if (comprobanteRepository.findById(request.getId_cliente())!= null){
            cliente = clienteRepository.findById(request.getId_cliente()).orElse(null);

        }else throw new Exception("No pudimos encontrar ningun cliente con el codig ingresado!");

        String nombreCompletoCliente = cliente.getNombre() + cliente.getApellido();

        Date fecha = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        String fechaDelComprobante = dateFormat.format(fecha);

        List<Linea> listaDeTodasLasLineas = new ArrayList<>();
        listaDeTodasLasLineas = lineaRepository.findAll();

        List<Linea> comprasRealizadasPorCliente =new ArrayList<>();
        for (Linea venta : listaDeTodasLasLineas){
            int idComprobante = venta.getId_comprobante();
            int numeroComprobante = request.getNumeroComprobante();
            if (idComprobante==numeroComprobante){
                comprasRealizadasPorCliente.add(venta);
            }
        }

        Float valorDelTotalVendido = valorTotalVendido(comprasRealizadasPorCliente);

        Integer totalUnidadesVendidas = totalCantidad(comprasRealizadasPorCliente);

        ComprobanteResponse comprobanteResponse = new ComprobanteResponse();
        comprobanteResponse.setId_cliente(request.getNumeroComprobante());
        comprobanteResponse.setFecha(fechaDelComprobante);
        comprobanteResponse.setId_cliente(request.getId_cliente());
        comprobanteResponse.setNombreCompleto(nombreCompletoCliente);
        comprobanteResponse.setCompraRealizada(comprasRealizadasPorCliente);
        comprobanteResponse.setTotal(valorDelTotalVendido);
        comprobanteResponse.setTotalArticulos(totalUnidadesVendidas);

        Comprobante comprobanteAGuardar = new Comprobante();
        comprobanteAGuardar.setId_comprobante(comprobanteResponse.getId_comprobate());
        comprobanteAGuardar.setId_cliente(comprobanteResponse.getId_cliente());
        comprobanteAGuardar.setNombreCompleto(comprobanteResponse.getNombreCompleto());
        comprobanteAGuardar.setFecha(fecha);
        comprobanteAGuardar.setTotal(comprobanteResponse.getTotal());

        comprobanteRepository.save(comprobanteAGuardar);

        return comprobanteResponse;

    }

    @Override
    public Comprobante actualizarComprobante(Comprobante comprobante) throws Exception {
        if (buscarComprobantePorID(comprobante.getId_comprobante())!=null){
            return comprobanteRepository.save(comprobante);
        }else {
            throw new Exception("El comprobante que desea actualizar no existe!");
        }
    }

    @Override
    public void eliminarComprobantePorId(Integer id) {
        comprobanteRepository.deleteById(id);
    }


    private Float valorTotalVendido(List<Linea> comprasRealizadasPorCliente) {
        Float valorTotalVendido = 0F;
        Float precioPorVenta;
        int cantidadComprada;

        for (Linea venta : comprasRealizadasPorCliente){
            precioPorVenta = venta.getPrecio();
            cantidadComprada = venta.getCantidad();
            valorTotalVendido += (precioPorVenta * cantidadComprada);
        }
        return valorTotalVendido;
    }

    private Integer totalCantidad (List<Linea> comprasRealizadasPorCliente){
        Integer cantidad = 0;

        for (Linea venta : comprasRealizadasPorCliente){
            cantidad += venta.getCantidad();
        }

        return cantidad;
    }
}
