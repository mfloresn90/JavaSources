<%-- 
    Document   : deleteProducto
    Created on : 05-nov-2015, 15:17:32
    Author     : renecruz
--%>

<%@page import="mx.uaemex.dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminación de producto</h1>
        <% 
            int id = Integer.valueOf(request.getParameter("txtID"));
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.deleteProducto(id);
            out.println("Producto con id: " + id + " eliminado");
            %>
            <a href="index.jsp">Inicio</a>
    </body>
</html>
