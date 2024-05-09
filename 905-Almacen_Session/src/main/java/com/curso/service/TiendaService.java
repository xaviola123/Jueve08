package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import com.curso.model.Producto;

public class TiendaService {
    
    private static List<Producto> listaProductos = new ArrayList<>(); // Inicializar la lista aquí

    public static void inicializarProductos() {
        if (listaProductos.isEmpty()) {
            Producto p1 = new Producto("yogur", "alimentacion", 3.60, 6);
            Producto p2 = new Producto("limpia_Cristales", "hogar", 3.60, 6);
            Producto p3 = new Producto("silla", "hogar", 3.60, 6);
            Producto p4 = new Producto("televisor", "electronica", 3.60, 6);
            Producto p5 = new Producto("lavadora", "electrodomesticos", 150, 3);

            listaProductos.add(p1);
            listaProductos.add(p2);
            listaProductos.add(p3);
            listaProductos.add(p4);
            listaProductos.add(p5);
        }
    }

    public static void agregarProductos(String nombre, String seccion, double precio, int stock) {
        listaProductos.add(new Producto(nombre, seccion, precio, stock));
    }

    public static List<Producto> getListaProductosMetodo() {
        return listaProductos;
    }

    public List<Producto> listarProductosPorSeccion(String seccion) {
        List<Producto> productosPorSeccion = new ArrayList<>();
        
        if (listaProductos == null) {
            inicializarProductos();
        }
        
        for (Producto producto : getListaProductosMetodo()) {
            if (producto.getSeccion().equalsIgnoreCase(seccion)) {
                productosPorSeccion.add(producto);
            }
        }
        
        return productosPorSeccion;
    }


    public List<Producto> eliminarProductoPorNombre(String nombreProducto) {
        List<Producto> productosActualizados = new ArrayList<>();
        for (Producto producto : getListaProductosMetodo()) {
            if (!producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productosActualizados.add(producto);
            }
        }
        return productosActualizados;
    }

    public void modificarProducto(String nombreProducto, String nuevaSeccion, double nuevoPrecio, int nuevoStock) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setSeccion(nuevaSeccion);
                producto.setPrecio(nuevoPrecio);
                producto.setStock(nuevoStock);
                break;
            }
        }
    }
}
