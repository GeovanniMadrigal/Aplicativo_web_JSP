
package Intefaces;

import Modelo.inventario;
import java.util.List;


public interface CRUD {
    public List listar();
    public inventario list(int id);
    public boolean add(inventario inv);
    public boolean edit(inventario inv);
    public boolean eliminar(int id);
}
