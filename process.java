import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Configurar o banco de dados
        String jdbcUrl = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "secret";
        ProductService productService = new ProductService(jdbcUrl, username, password);

        // Definir a rota para processar o formulário
        post("/process", (request, response) -> {
            String name = request.queryParams("name");
            String email = request.queryParams("email");
            String message = request.queryParams("message");
            productService.addProduct(name, email, message);
            return "Produto adicionado com sucesso!";
        });
    }
}
