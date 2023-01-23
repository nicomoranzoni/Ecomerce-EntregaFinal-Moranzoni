package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Controller;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Comprobante;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories.ClienteRepository;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteResponse;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Comprobante.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {

    @Autowired
    ComprobanteService comprobanteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/all")
    public List<Comprobante> mostrarTodos() throws Exception{
        if (comprobanteService.mostrarTodos().size() != 0){
            return comprobanteService.mostrarTodos();
        }else throw new Exception("Por el momento no encontramos ningun comprobante!");
    }

    @GetMapping("/{id_comprobate}")
    public Comprobante buscarComprobantePorId(@PathVariable Integer id_comprobante) throws Exception{
        if (comprobanteService.buscarComprobantePorID(id_comprobante)!=null){
            return comprobanteService.buscarComprobantePorID(id_comprobante);
        }else throw new Exception("Por el momento no encontramos ningun comprobante bajo ese ID!");
    }

    @PostMapping("/crear")
    public ComprobanteResponse crearComprobante(@RequestBody ComprobanteRequest request) throws Exception{
        return comprobanteService.crearCromprobante(request);
    }

    @PutMapping("/actualizar")
    public Comprobante modificarComprobante(@RequestBody Comprobante comprobante) throws Exception{
        return comprobanteService.actualizarComprobante(comprobante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> borrarComprobantePorId(@PathVariable(name = "id") Integer id){
        comprobanteService.eliminarComprobantePorId(id);
        return ResponseEntity.ok().body("El comprobante con el ID: " + id + " ha sido eliminado correctamnete!");
    }
}
