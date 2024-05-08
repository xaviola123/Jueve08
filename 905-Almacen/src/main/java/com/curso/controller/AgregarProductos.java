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
        TiendaService tiendaService = new TiendaService();
        
        String nombre = request.getParameter("nombre");
        String seccion = request.getParameter("seccion");
        String precioStr = request.getParameter("precio");
        String stockStr = request.getParameter("stock");
        
        HttpSession session = request.getSession(true);
        
       /**
        * Si los campos estan vacios
        */
        if (nombre.isEmpty() || seccion.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
        	
            request.setAttribute("error", "Producto no agregado correctamente. Todos los campos son obligatorios.");
            
            RequestDispatcher despachador = request.getRequestDispatcher("/errorAlta.jsp");
            despachador.forward(request, response);
            
            
        }
        
        double precio = Double.parseDouble(precioStr);
        int stock = Integer.parseInt(stockStr);
        
        //LLamo al metodo agregar producto del service y agrego ese producto nuevo.
        tiendaService.agregarProductos(nombre, seccion, precio, stock);
        
        // Obtener la lista actualizada de productos
        List<Producto> productos = tiendaService.getListaProductos();
      
       
        
        // Agregar la lista de productos al request
        request.setAttribute("productos", productos);
        
        // Agregar el producto al carrito de la sesión
        session.setAttribute("productos", productos);
        
        // Redirige a la pagina de listado despues de agregar el producto
        RequestDispatcher despachador = request.getRequestDispatcher("/listado.jsp");
        despachador.forward(request, response);
    }

   }


