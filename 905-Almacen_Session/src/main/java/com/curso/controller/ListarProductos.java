package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.curso.model.Producto;
import com.curso.service.TiendaService;

/**
 * Servlet implementation class ListarProductos
 */

public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Creamos una instancia del servicio de tienda
        TiendaService tiendaService = new TiendaService();
        
        // Obtenemos la lista de productos
        List<Producto> productos = TiendaService.getListaProductosMetodo();
        
        // Agregamos la lista de productos al request
        HttpSession session = request.getSession();
        session.setAttribute("productos", productos);
        
        // Enviamos la lista de productos al JSP para mostrarlos
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listado.jsp");
        dispatcher.forward(request, response);
    }
}
