
<%@page import="Modelo.inventario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Inventario</h1>
            <a class="btn btn-success" href="Controlador1?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Clave</th>
                        <th class="text-center">Descripcion</th> 
                        <th class="text-center">Lote</th>
                        <th class="text-center">Caducidad</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<inventario>list=dao.listar();
                    Iterator<inventario>iter=list.iterator();
                    inventario inv=null;
                    while(iter.hasNext()){
                        inv=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= inv.getClave()%></td>
                        <td class="text-center"><%= inv.getDescripcion()%></td>
                        <td class="text-center"><%= inv.getLote()%></td>
                        <td class="text-center"><%= inv.getCaducidad()%></td>
                        <td class="text-center"><%= inv.getCantidad()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador1?accion=editar&id=<%= inv.getIdInventario()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador1?accion=eliminar&id=<%= inv.getIdInventario()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
