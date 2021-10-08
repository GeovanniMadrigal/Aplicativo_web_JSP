
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
                <h1>Agregar nuevo producto</h1>
                <form action="Controlador1">
                    IdInventario:<br>
                    <input class="form-control" type="text" name="txtIdInventario"><br>
                    Clave:<br>
                    <input class="form-control" type="text" name="txtClave"><br>
                    Descripcion: <br>
                    <input class="form-control" type="text" name="txtDescripcion"><br>
                    Lote: <br>
                    <input class="form-control" type="text" name="txtLote"><br>
                    Caducidad: <br>
                    <input class="form-control" type="text" name="txtCaducidad"><br>
                    Cantidad: <br>
                    <input class="form-control" type="text" name="txtCantidad"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador1?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
