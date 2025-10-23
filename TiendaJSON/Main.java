import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader("tienda.json")) {
            // Cargar JSON
            TiendaData data = gson.fromJson(reader, TiendaData.class);

            // Mostrar tienda
            System.out.println("Tienda: " + data.tienda.nombre);

            // Mostrar productos
            for (Categoria cat : data.tienda.categorias) {
                System.out.println("\nCategoría: " + cat.nombre);
                for (Producto prod : cat.productos) {
                    System.out.println(" - " + prod.nombre + " | $" + prod.precio + " | Inventario: " + prod.inventario);
                }
            }

            // Mostrar usuarios
            for (Usuario user : data.tienda.usuarios) {
                System.out.println("\nUsuario: " + user.nombre + " | Email: " + user.email);
            }

            // Compra: Juan 
            Usuario juan = data.tienda.usuarios.get(0);
            Producto smartphone = data.tienda.categorias.get(0).productos.get(0);

            int cantidad = 2;
            if (smartphone.inventario >= cantidad) {
                smartphone.inventario -= cantidad;
                juan.historialCompras.add(new Compra(smartphone.id, cantidad, LocalDate.now().toString()));
                System.out.println("\nCompra realizada: " + juan.nombre + " compró " + cantidad + " " + smartphone.nombre);
            } else {
                System.out.println("\nNo hay suficiente inventario para la compra.");
            }

            // Guardar cambios en el JSON
            try (FileWriter writer = new FileWriter("tienda.json")) {
                gson.toJson(data, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
