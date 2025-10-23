import java.util.List;


public class TiendaData {
    public Tienda tienda;
}


class Tienda {
    public String nombre;
    public List<Categoria> categorias;
    public List<Usuario> usuarios;
}


class Categoria {
    public int id;
    public String nombre;
    public List<Producto> productos;
}


class Producto {
    public int id;
    public String nombre;
    public double precio;
    public String descripcion;
    public Caracteristicas caracteristicas;
    public int inventario;
}


class Caracteristicas {
    public String pantalla;
    public String camara;
    public String bateria;
}


class Usuario {
    public int id;
    public String nombre;
    public String email;
    public Direccion direccion;
    public List<Compra> historialCompras;
}


class Direccion {
    public String calle;
    public int numero;
    public String ciudad;
    public String pais;
}


class Compra {
    public int productoId;
    public int cantidad;
    public String fecha;

    public Compra(int productoId, int cantidad, String fecha) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
}
