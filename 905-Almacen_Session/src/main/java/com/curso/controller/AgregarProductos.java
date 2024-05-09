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
 * Servlet implementation class AgregarProductos
 */
public class AgregarProductos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String seccion = request.getParameter("seccion");
        String precioStr = request.getParameter("precio");
        String stockStr = request.getParameter("stock");

        TiendaService tiendaService = new TiendaService();
        HttpSession session = request.getSession(true);

        if (nombre.isEmpty() || seccion.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
            request.setAttribute("error", "Producto no agregado correctamente. Todos los campos son obligatorios.");
            RequestDispatcher despachador = request.getRequestDispatcher("/errorAlta.jsp");
            despachador.forward(request, response);
            return; // Agregamos un return para evitar que continúe después del despachador
        }

        double precio = Double.parseDouble(precioStr);
        int stock = Integer.parseInt(stockStr);

        tiendaService.inicializarProductos(); // Inicializa la lista de productos

        tiendaService.agregarProductos(nombre, seccion, precio, stock);

        session.setAttribute("productos", tiendaService.getListaProductosMetodo());

        RequestDispatcher despachador = request.getRequestDispatcher("/listado.jsp");
        despachador.forward(request, response);
    }

   }


