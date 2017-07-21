<%-- 
    Document   : showProductoToUpdate
    Created on : 05-nov-2015, 15:45:15
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
        <h1>Actualización de producto</h1>
        <%
            int id = Integer.valueOf(request.getParameter("txtID"));
            ProductoDAO productoDAO = new ProductoDAO();
            Producto producto = productoDAO.getProductoByID(id);
            if (producto != null) {              
        %> 
        <form action="updateProducto.jsp" method="post">
            ID: <%=id%> 
            <input type="hidden" name="txtID" value="<%=id%>">
            Nombre: <input type="text" size="20" name="txtNombre" value="<%=producto.getNombre()%>"><br>
            Descripción: <input type="text" size="20" name="txtDesc"  value="<%=producto.getDescripcion()%>"><br>
            Unidad: <input type="text" size="20" name="txtUnidad"  value="<%=producto.getUnidad()%>"><br>
            Precio Unitario: <input type="text" size="20" name="txtPrecio"  value="<%=producto.getPrecioUnitario()%>"><br>
            <input type="submit" value="Actualizar">            
        </form>
        <%
            } else {
                out.println("Producto inexistente...");
            }
        %>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
