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
 * Servlet implementation class ModificarProducto
 */
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombreProducto = request.getParameter("nombreProducto");
        String nuevaSeccion = request.getParameter("nuevaSeccion");
        double nuevoPrecio = Double.parseDouble(request.getParameter("nuevoPrecio"));
        int nuevoStock = Integer.parseInt(request.getParameter("nuevoStock"));

        // Instanciar el servicio de la tienda
        TiendaService tiendaService = new TiendaService();

        // Modificar el producto
        tiendaService.modificarProducto(nombreProducto, nuevaSeccion, nuevoPrecio, nuevoStock);

        // Redirigir a la página de listado actualizado
        List<Producto> productos = tiendaService.getListaProductos();
        request.setAttribute("productos", productos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listado.jsp");
        dispatcher.forward(request, response);
    }

}
