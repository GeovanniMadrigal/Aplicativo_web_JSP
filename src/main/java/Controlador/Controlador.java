
package Controlador;

import Modelo.inventario;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    inventario inv=new inventario();
    PersonaDAO dao=new PersonaDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        System.out.println("imprimiento la accion ....."+action);
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String aux1=request.getParameter("txtIdinventario");
            String Clave=request.getParameter("txtClave");
            String Descripcion=request.getParameter("txtDescripcion");
            String Lote=request.getParameter("txtLote");
            String Caducidad=request.getParameter("txtCaducidad");
            String aux2=request.getParameter("txtCantidad");
            int IdInventario=Integer.parseInt(aux1);
            int Cantidad=Integer.parseInt(aux2);
            
            
            inv.setIdInventario(IdInventario);
            inv.setClave(Clave);
            inv.setDescripcion(Descripcion);
            inv.setLote(Lote);
            inv.setCaducidad(Caducidad);
            inv.setCantidad(Cantidad);
            
            dao.add(inv);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtIdInventario"));
            String Clave=request.getParameter("txtClave");
            String Descripcion=request.getParameter("txtDescripcion");
            String Lote=request.getParameter("txtLote");
            String Caducidad=request.getParameter("txtCaducidad");
            String aux2=request.getParameter("txtCantidad");
            int Cantidad=Integer.parseInt(aux2);
            inv.setIdInventario(id);
            inv.setClave(Clave);
            inv.setDescripcion(Descripcion);
            inv.setLote(Lote);
            inv.setCaducidad(Caducidad);
            inv.setCantidad(Cantidad);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("IdInventario"));
            inv.setIdInventario(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
