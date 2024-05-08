package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.curso.model.Producto;
import com.curso.service.TiendaService;

/**
 * Servlet implementation class EliminarProductos
 */
public class EliminarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Obtener el nombre del producto a eliminar del formulario
	    String nombreProducto = request.getParameter("productoEliminar");
	    
	    // Instanciar el servicio de la tienda
	    TiendaService tiendaService = new TiendaService();
	    
	 
	    List<Producto> productos = tiendaService.eliminarProductoPorNombre(nombreProducto);
	    
	    // Agregar la lista de productos actualizada al request
	    request.setAttribute("productos", productos);
	    
	    // Redirigir a la página de listado actualizado
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/listado.jsp");
	    dispatcher.forward(request, response);
	}

}
