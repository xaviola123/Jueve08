<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.curso.model.Producto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <link rel="stylesheet"  href="css/estilosListado.css">
</head>
<body>
    <h1>Lista de Productos</h1>

    <% 
        String error = (String) session.getAttribute("error");
        if (error != null) {
    %>
            <p><%= error %></p>
    <% 
        } else {
    %>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Sección</th>
                    <th>Precio</th>
                    <th>Stock</th>
                </tr>
                <% 
                    List<Producto> productos = (List<Producto>) session.getAttribute("productos");
                
                    if (productos != null) {
                        for (Producto producto : productos) {
                %>
                            <tr>
                                <td><%= producto.getNombre() %></td>
                                <td><%= producto.getSeccion() %></td>
                                <td><%= producto.getPrecio() %></td>
                                <td><%= producto.getStock() %></td>
                            </tr>
                <% 
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="4">No hay productos disponibles</td>
                        </tr>
                <% 
                    }
                %>
            </table>
    <% 
        }
    %>
    <a href="index.html"><button>INICIO</button></a><br>
    <h1>Buscar por sección</h1>
    <form action="BuscarProductos" method="post">
        <input type="text" name="buscar">
        <input type="submit" value="BUSCAR">
    </form>
</body>
</html>
