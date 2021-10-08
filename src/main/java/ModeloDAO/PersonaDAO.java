
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    inventario inv=new inventario();
    int idmax=0;
    
    @Override
    public List listar() {
        ArrayList<inventario>list=new ArrayList<>();
        String sql="select * from inventario"; 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                inventario inv=new inventario();
                inv.setIdInventario(rs.getInt("IdInventario")); 
                inv.setClave(rs.getString("Clave"));
                inv.setDescripcion(rs.getString("Descripcion"));
                inv.setLote(rs.getString("Lote"));
                inv.setCaducidad(rs.getString("Caducidad"));
                inv.setCantidad(rs.getInt("Cantidad"));
                list.add(inv);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public inventario list(int id) {
        String sql="select * from inventario where IdInventario="+id; 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                inv.setIdInventario(rs.getInt("IdInventario"));
                inv.setClave(rs.getString("Clave"));
                inv.setDescripcion(rs.getString("Descripcion"));
                inv.setLote(rs.getString("Lote"));
                inv.setCaducidad(rs.getString("Caducidad"));
                inv.setCantidad(rs.getInt("Cantidad"));
                
            }
        } catch (Exception e) {
        }
        return inv;
    }

    @Override
    public boolean add(inventario inv) {
       String sql="INSERT INTO inventario (IdInventario,Clave,Descripcion,Lote,Caducidad,Cantidad) " + "values('"+inv.getIdInventario()+"','"+inv.getClave()+"','"+inv.getDescripcion()+"','"+inv.getLote()+"','"+inv.getCaducidad()+"','"+inv.getCantidad()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al añadir elemento"+e);
        }
       return false;
    }

    @Override
    public boolean edit(inventario inv) { 
         String sql="update inventario set IdInventario='"+inv.getIdInventario()+"',Clave='"+inv.getClave()+"',Descripcion='"+inv.getDescripcion()+"',Lote='"+inv.getLote()+"',Caducidad='"+inv.getCaducidad()+"',Cantidad='"+inv.getCantidad()+"' where IdInventario="+inv.getIdInventario();
         System.out.println(sql);
         try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) { 
        String sql="delete from inventario where IdInventario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public int maxid(){
        String sql="SELECT MAX(IdInventario) AS IdInventario FROM inventario";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                idmax=rs.getInt(1);
                System.out.println("ultimo id"+idmax);
            }
            
        } catch (Exception e) {
        }
        return idmax;
    }
    
}
