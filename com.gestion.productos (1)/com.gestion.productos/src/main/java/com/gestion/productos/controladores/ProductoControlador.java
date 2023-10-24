package com.gestion.productos.controladores;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.servicios.ProductoServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/producto")

    public List<Producto> listarProductos(){

        return servicio.listarProductos();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try {
            Producto producto = servicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/producto")
    public void guardarProductos(@RequestBody Producto producto){
        servicio.guardarProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto ,@PathVariable Integer id){
        try{
            Producto productoActual = servicio.obtenerProductoPorId(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            servicio.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/producto/{id}")

    public void eliminarProducto(@PathVariable Integer id){

        servicio.eliminarProducto(id);

    }

}

