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
 * Servlet implementation class BuscarProductos
 */
public class BuscarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String seccionBuscar = request.getParameter("buscar");

        HttpSession session = request.getSession();
        TiendaService tiendaService = new TiendaService();

        List<Producto> productosFiltrados = tiendaService.listarProductosPorSeccion(seccionBuscar);

        if (productosFiltrados.isEmpty()) {
            request.setAttribute("error", "No se encontraron productos para la sección: " + seccionBuscar);
        }

        request.setAttribute("productos", productosFiltrados);

        RequestDispatcher despachador = request.getRequestDispatcher("/listado.jsp");
        despachador.forward(request, response);
    }
}


