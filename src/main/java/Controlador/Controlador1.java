/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package Controlador;

import Modelo.inventario;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GEOVANNI
 */
public class Controlador1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp"; 
    inventario inv=new inventario();
    PersonaDAO dao=new PersonaDAO();
    int id;
    int i = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            String aux1=request.getParameter("txtIdInventario");
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
            request.setAttribute("IdInventario",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
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
            System.out.println("Prueba de funcina actualizar");
            dao.edit(inv);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            
            id=Integer.parseInt(request.getParameter("id"));
            System.out.print(id);
            inv.setIdInventario(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //ArrayList<inventario>list=new ArrayList<>();
        //inventario inv=new inventario();
        
        
        String aux1=request.getParameter("IdInventario");
            String Clave=request.getParameter("Clave");
            String Descripcion=request.getParameter("Descripcion");
            String Lote=request.getParameter("Lote");
            String Caducidad=request.getParameter("Caducidad");
            String aux2=request.getParameter("Cantidad");
            int IdInventario=Integer.parseInt(aux1);
            int Cantidad=Integer.parseInt(aux2);
            
            System.out.println("id max"+dao.maxid()+1);
            inv.setIdInventario(dao.maxid()+1);
            inv.setClave(Clave);
            inv.setDescripcion(Descripcion);
            inv.setLote(Lote);
            inv.setCaducidad(Caducidad);
            inv.setCantidad(Cantidad);
            
            if(request.getParameter("Activador").equals("YA")){
                dao.add(inv); 
                System.out.println("Añadio elemento desde el celular");
            }
            
        
        
           System.out.println("EL dato traido por IdInventario " + request.getParameter("IdInventario"));
            System.out.println("EL dato traido por Clave " + request.getParameter("Clave"));
            System.out.println("EL dato traido por Descripcion " + request.getParameter("Descripcion"));
            System.out.println("EL dato traido por Lote " + request.getParameter("Lote"));
            System.out.println("EL dato traido por Caducidad " + request.getParameter("Caducidad"));
            System.out.println("EL dato traido por Cantidad " + request.getParameter("Cantidad"));
            System.out.println("incremento " + i);
            i=i+1;
            
            System.out.println("--------------------------------------------------------------------------");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
