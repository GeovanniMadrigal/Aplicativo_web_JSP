
<%@page import="Modelo.inventario"%>
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
            <div class="col-lg-6">
              <%
              PersonaDAO dao=new PersonaDAO();
              //int id=request.getAttribute("IdInventario");
              int id=Integer.parseInt((String)request.getAttribute("IdInventario"));
              //System.out.println("variable" +id);
              inventario inv=(inventario)dao.list(id);
          %>    
            <h1>Modificar Producto</h1>
            <form action="Controlador1">
                Clave:<br>
                <input class="form-control" type="text" name="txtClave" value="<%= inv.getClave()%>"><br>
                Descripcion: <br>
                <input class="form-control" type="text" name="txtDescripcion" value="<%= inv.getDescripcion()%>"><br>
                Lote: <br>
                <input class="form-control" type="text" name="txtLote" value="<%= inv.getLote()%>"><br>
                Caducidad: <br>
                <input class="form-control" type="text" name="txtCaducidad" value="<%= inv.getCaducidad()%>"><br>
                Cantidad: <br>
                <input class="form-control" type="text" name="txtCantidad" value="<%= inv.getCantidad()%>"><br>
                
                <input type="hidden" name="txtid" value="<%=inv.getIdInventario()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador1?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
