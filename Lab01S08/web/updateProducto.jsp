<%-- 
    Document   : updateProducto
    Created on : 05-nov-2015, 15:52:54
    Author     : renecruz
--%>

<%@page import="mx.uaemex.dao.ProductoDAO"%>
<%@page import="mx.uaemex.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Guardar Producto</h1>
        <%
            Integer idProducto = new Integer(request.getParameter("txtID"));
            String nombre = request.getParameter("txtNombre");
            String descripcion = request.getParameter("txtDesc");
            String unidad = request.getParameter("txtUnidad");
            Float precioUnitario = new Float(request.getParameter("txtPrecio"));
            
            
            

            //Producto producto =  //new Producto(nombre, descripcion, unidad, precioUnitario);
            ProductoDAO productoDAO = new ProductoDAO();
            
            Producto producto = productoDAO.getProductoByID(idProducto);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setUnidad(unidad);
            producto.setPrecioUnitario(precioUnitario);
            
            productoDAO.updateProducto(producto);
            out.println("Producto actualizado correctamente <br>");
        %>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
