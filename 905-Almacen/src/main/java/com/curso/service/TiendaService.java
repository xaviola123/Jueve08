package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import com.curso.model.Producto;

public  class TiendaService {

	List<Producto> listaProductos = new ArrayList<>();

	public  void TiendaService() {
		inicializarProductos();

	}

	private List<Producto> inicializarProductos() {
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

		return listaProductos;
	}

	public void agregarProductos(String nombre, String seccion, double precio, int stock) {

		listaProductos.add(new Producto(nombre, seccion, precio, stock));
		
		return ;
	};

	public List<Producto> getListaProductos() {
	
		return listaProductos;
	}
/**
 * meotodo que busca por seccion 
 * @param seccion
 * @return
 */
	
	   public List<Producto> listarProductosPorSeccion(String seccion) {
	        List<Producto> productosPorSeccion = new ArrayList<>();
	        
	        for (Producto producto : listaProductos) {
	            if (producto.getSeccion().equalsIgnoreCase(seccion)) {
	                productosPorSeccion.add(producto);
	            }
	        }
	        
	        return productosPorSeccion;
	    }
	
	/*
	 public List<Producto> listarProductosPorSeccion(List<Producto> productos, String seccion) {
	        List<Producto> productosPorSeccion = new ArrayList<>();
	        
	        for (Producto producto : productos) {
	            if (producto.getSeccion().equalsIgnoreCase(seccion)) {
	                productosPorSeccion.add(producto);
	            }
	        }
	        
	        return productosPorSeccion;
	    }
	    */
/**
 * metodos que buscar en la lista y eliminar por nombre
 * @param nombreProducto
 * @return 
 */
	

	public List<Producto> eliminarProductoPorNombre(String nombreProducto) {
	    Producto productoAEliminar = null;
	    for (Producto producto : listaProductos) {
	        if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
	            productoAEliminar = producto;
	            break;
	        }
	    }
	    if (productoAEliminar != null) {
	        listaProductos.remove(productoAEliminar);
	    }
	    return listaProductos;
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
