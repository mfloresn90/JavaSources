<%-- 
    Document   : getProductoByID
    Created on : 05-nov-2015, 14:20:46
    Author     : renecruz
--%>

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
        <h1>Producto</h1>
        <%
            int id = Integer.valueOf(request.getParameter("txtID"));
            ProductoDAO productoDAO = new ProductoDAO();
            Producto producto = productoDAO.getProductoByID(id);
            if (producto != null) {
                out.println("ID: " + producto.getIdProducto() + "<br>");
                out.println("Nombre: " + producto.getNombre() + "<br>");
                out.println("Descripción: " + producto.getDescripcion()+ "<br>");
                out.println("Unidad: " + producto.getUnidad()+ "<br>");
                out.println("Precio Unitario: " + producto.getPrecioUnitario()+ "<br>");
            } else {
                out.println("Producto inexistente...");
            }
            %>
            <a href="index.jsp">Inicio</a>
    </body>
</html>
