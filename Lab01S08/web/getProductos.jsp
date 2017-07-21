<%-- 
    Document   : getProductos
    Created on : 05-nov-2015, 13:39:40
    Author     : renecruz
--%>

<%@page import="java.util.List"%>
<%@page import="mx.uaemex.model.Producto"%>
<%@page import="mx.uaemex.dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1>
        <%
            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> productos = productoDAO.getProductos();
            for (Producto producto : productos) {
                    out.println("Producto ID: " + producto.getIdProducto());
                    out.println("Nombre: " + producto.getNombre());
                    out.println("<br>");
                }
            %>
    </body>
</html>
