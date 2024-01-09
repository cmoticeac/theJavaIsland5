package TheJavaIslandProd5.Vista;

import TheJavaIslandProd5.Controlador.Controlador;
import TheJavaIslandProd5.Modelo.*;
import TheJavaIslandProd5.Modelo.DAO.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.lang.Double;
import java.util.Optional;

import static java.lang.String.valueOf;

public class Aplicacion extends Application {
    private Controlador controlador;
    public Aplicacion() {
        ArticuloDAO articuloDAO = new ArticuloDAOImpl();
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        PedidoDAO pedidoDAO = new PedidoDAOImpl();
        controlador = new Controlador(articuloDAO, clienteDAO, pedidoDAO);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("TheJavaIsland");

        // maximizar
        stage.setMaximized(true);

        // Layout principal
        VBox mainLayout = new VBox();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setSpacing(20);

        // Bloques de gestión
        Label tituloArticulos = new Label("Gestión de Artículos");
        tituloArticulos.setFont(new Font("Arial", 20));
        GridPane gestionArticulos = createGestionArticulos();

        Label tituloClientes = new Label("Gestión de Clientes");
        tituloClientes.setFont(new Font("Arial", 20));
        GridPane gestionClientes = createGestionClientes();

        Label tituloPedidos = new Label("Gestión de Pedidos");
        tituloPedidos.setFont(new Font("Arial", 20));
        GridPane gestionPedidos = createGestionPedidos();

        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setFont(new Font("Arial", 16));
        btnSalir.setOnAction(e -> stage.close());

        // Agregar todo al layout principal
        mainLayout.getChildren().addAll(
                tituloArticulos,
                gestionArticulos,
                tituloClientes,
                gestionClientes,
                tituloPedidos,
                gestionPedidos,
                btnSalir
        );

        // Crear y mostrar la escena
        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createGestionArticulos() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // creamos botón y funcionalidad para añadir articulo
        Button btnAddArticulo = new Button("Añadir Artículo");
        btnAddArticulo.setOnAction(e -> crearArticulo());

        // creamos botón y funcionalidad para mostrar articulos
        Button btnMostrarArticulos = new Button("Mostrar Artículos");
        btnMostrarArticulos.setOnAction(e ->  mostrarArticulos());

        //Gestion Botones
        grid.add(btnAddArticulo, 0, 0);
        grid.add(btnMostrarArticulos, 0, 1);

        return grid;
    }

    public void crearArticulo(){
        Stage stage = new Stage();
        stage.setTitle("Añadir Artículo");

        TextField txtCodigo = new TextField();
        TextField txtDescripcion = new TextField();
        TextField txtPrecioVenta = new TextField();
        TextField txtGastosEnvio = new TextField();
        TextField txtTiempoPreparacion = new TextField();
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(ev -> {
            try {
                int codigo = Integer.valueOf(txtCodigo.getText());
                String desc = txtDescripcion.getText();
                Double pv =  Double.valueOf(txtPrecioVenta.getText());
                Double ge = Double.valueOf(txtGastosEnvio.getText());
                Double tp =  Double.valueOf(txtTiempoPreparacion.getText());
                Articulo a = new Articulo(codigo, desc, pv, ge, tp);
                controlador.añadirArticulo(a);
                Alert aletapedidocon = new Alert(Alert.AlertType.CONFIRMATION);
                aletapedidocon.setTitle("Confirmado");
                aletapedidocon.setHeaderText(null);
                aletapedidocon.setContentText("El articulo ha sido creado correctamente.");
                ButtonType botonCancelar = new ButtonType("Aceptar");
                aletapedidocon.getButtonTypes().setAll(botonCancelar);
                Optional<ButtonType> resultado = aletapedidocon.showAndWait();
                stage.close();

            } catch (Exception exc) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error al agregar el artículo: " + exc.getMessage());
                alert.showAndWait();
            }
        });

        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_articulo_add -> stage.close());

        VBox layout = new VBox(10,
                new Label("Codigo:"), txtCodigo,
                new Label("Descripcion:"), txtDescripcion,
                new Label("Precio de Venta:"), txtPrecioVenta,
                new Label("Gastos de Envio:"), txtGastosEnvio,
                new Label("Tiempo de Preparacion:"), txtTiempoPreparacion,
                btnGuardar,
                btnSalir
        );
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public void mostrarArticulos(){
        Stage stage = new Stage();
        stage.setTitle("Artículos");

        ListView<String> listView = new ListView<>();

        // Obtenemos los artículos desde el controlador
        List<Articulo> articulos = controlador.obtenerArticulos();
        for (Articulo articulo : articulos) {
            // Añadimos cada artículo al listView
            String resultado = "Codigo: " + articulo.getCodigo() + "Descripcion: " + articulo.getDescripcion() + "\n";
            listView.getItems().add(resultado);
        }

        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_articulo_show -> stage.close());

        VBox layout = new VBox(10, listView, btnSalir);
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private GridPane createGestionClientes() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // creamos botón y funcionalidad para añadir cliente
        Button btnAddCliente = new Button("Añadir Cliente");
        btnAddCliente.setOnAction(e -> crearCliente());

        // creamos botón y funcionalidad para mostrar todos los clientes
        Button btnMostrarClientes = new Button("Mostrar Clientes");
        btnMostrarClientes.setOnAction(e -> mostrarClientes());

        // creamos botón y funcionalidad para mostrar clientes estándar
        Button btnMostrarClientesEstandar = new Button("Mostrar Clientes Estándar");
        btnMostrarClientesEstandar.setOnAction(e -> mostrarClientesEstandar());

        // creamos botón y funcionalidad para mostrar clientes premium
        Button btnMostrarClientesPremium = new Button("Mostrar Clientes Premium");
        btnMostrarClientesPremium.setOnAction(e -> mostrarClientesPremium());

        // Eventos botones
        grid.add(btnAddCliente, 0, 0);
        grid.add(btnMostrarClientes, 0, 1);
        grid.add(btnMostrarClientesEstandar, 0, 2);
        grid.add(btnMostrarClientesPremium, 0, 3);

        return grid;
    }
    public void crearCliente(){
        Stage stage = new Stage();
        stage.setTitle("Añadir Cliente");

        TextField txtClienteNombre = new TextField();
        TextField txtClienteDomicilio = new TextField();
        TextField txtClienteNif = new TextField();
        TextField txtClienteEmail = new TextField();
        TextField txtPremiumDescuento = new TextField();
        TextField txtPremiumCuota = new TextField();
        TextField txtTipoCliente = new TextField();

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(ev -> {
            try {
                String nombre = txtClienteNombre.getText();
                String domicilio = txtClienteDomicilio.getText();
                String nif = txtClienteNif.getText();
                String email = txtClienteEmail.getText();
                Boolean premium = Boolean.parseBoolean(txtTipoCliente.getText());
                if(!premium){
                    ClienteEstandar ce = new ClienteEstandar(nombre, domicilio, nif, email);
                    controlador.añadirCliente(ce);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Cliente Añadido");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Cliente añadido exitosamente.");
                    alerta.showAndWait();
                    stage.close();
                    return;
                }
                if(premium){
                    double descuentoAnual = 0;
                    double cuotaMensual = 0;
                    ClientePremium cp = new ClientePremium(nombre, domicilio, nif, email, descuentoAnual, cuotaMensual);
                    controlador.añadirCliente(cp);
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Cliente Añadido");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Cliente añadido exitosamente.");
                    alerta.showAndWait();
                    stage.close();
                    return;
                }
            } catch (Exception exc) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error al agregar el cliente: " + exc.getMessage());
                alert.showAndWait();
            }
        });

        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_cliente_add -> stage.close());

        VBox layout = new VBox(10,
                new Label("Email:"), txtClienteEmail,
                new Label("NIF:"), txtClienteNif,
                new Label("Nombre:"), txtClienteNombre,
                new Label("Domicilio:"), txtClienteDomicilio,
                new Label("Es premium (true / false):"), txtTipoCliente,
                btnGuardar,
                btnSalir
        );
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout));
        stage.show();
    }
    public void mostrarClientes(){
        Stage stage = new Stage();
        stage.setTitle("Clientes");
        ListView<String> listView = new ListView<>();

        // Obtenemos los artículos desde el controlador
        List<Cliente> clientes = controlador.conseguirClientes();
        for (Cliente cliente : clientes) {
            // Añadimos cada artículo al listView
            listView.getItems().add(cliente.getNombre());
        }
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_articulo_show -> stage.close());

        VBox layout = new VBox(10, listView, btnSalir);
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public void mostrarClientesEstandar(){
        Stage stage = new Stage();
        stage.setTitle("Clientes Estándar");
        ListView<String> listView = new ListView<>();
        // Obtenemos los artículos desde el controlador
        List<ClienteEstandar> clientes = controlador.conseguirEstandar();
        for (ClienteEstandar ce: clientes){
            // Añadimos cada artículo al listView
            listView.getItems().add(ce.getNombre());
        }
        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_articulo_show -> stage.close());
        VBox layout = new VBox(10, listView, btnSalir);
        layout.setPadding(new Insets(15));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public void mostrarClientesPremium(){
        Stage stage = new Stage();
        stage.setTitle("Clientes Premium");
        ListView<String> listView = new ListView<>();
        // Obtenemos los artículos desde el controlador
        List<ClientePremium> clientes = controlador.conseguirPremium();
        for (ClientePremium cp: clientes){
            // Añadimos cada artículo al listView
            listView.getItems().add(cp.getNombre());
        }
        // Botón para salir
        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e_articulo_show -> stage.close());
        VBox layout = new VBox(10, listView, btnSalir);
        layout.setPadding(new Insets(15));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    private GridPane createGestionPedidos() {



        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // creamos botón y funcionalidad para añadir pedido
        Button btnAddPedido = new Button("Añadir Pedido");
        btnAddPedido.setOnAction(e -> {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Escoja una opcion");
            alert.setHeaderText("Opcion Cliente");
            ButtonType bcc = new ButtonType("Crear Cliente");
            ButtonType bce = new ButtonType("Usar Cliente Existente");
            ButtonType bc = new ButtonType("Cancelar");
            alert.getButtonTypes().setAll(bcc, bce, bc);
            alert.showAndWait().ifPresent(response -> {
                if (response == bcc) {
                    crearClienteYPedido();
                }
                if (response == bce) {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Ingresar NIF");
                    dialog.setHeaderText("Por favor, ingrese el NIF del cliente:");
                    dialog.setContentText("NIF:");
                    Optional<String> resultadoOptional = dialog.showAndWait();
                    String resultado = resultadoOptional.orElse("");
                    if (resultado.describeConstable().isPresent()) {
                        if (!controlador.clienteExistente(resultado)) {
                            Alert alertaError = new Alert(Alert.AlertType.ERROR);
                            alertaError.setTitle("Error");
                            alertaError.setHeaderText(null);
                            alertaError.setContentText("El cliente introducido no existe.");
                            ButtonType botonCancelar = new ButtonType("Aceptar");
                            alertaError.getButtonTypes().setAll(botonCancelar);
                            alertaError.showAndWait();
                            return;
                        }
                        Cliente c = controlador.conseguirClienteNif(resultado);
                        crearClientePedido(c);
                    }
                }
                if (response == bc) {
                    alert.close();
                    return;
                }
            });
        });


        // creamos botón y funcionalidad para eliminar pedido
        Button btnEliminarPedido = new Button("Eliminar Pedido");
        btnEliminarPedido.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Eliminar Pedido");

            TextField txtPedidoNumeroAEliminar = new TextField();

            Button btnGuardar = new Button("Eliminar");
            btnGuardar.setOnAction(ev -> {
                try {
                    Integer numero = Integer.parseInt(txtPedidoNumeroAEliminar.getText());
                    controlador.eliminarPedido(numero);
                    Alert aletapedidocon = new Alert(Alert.AlertType.CONFIRMATION);
                    aletapedidocon.setTitle("Confirmado");
                    aletapedidocon.setHeaderText(null);
                    aletapedidocon.setContentText("El pedido ha sido creado correctamente.");
                    ButtonType botonCancelar = new ButtonType("Aceptar");
                    aletapedidocon.getButtonTypes().setAll(botonCancelar);
                    Optional<ButtonType> resultado = aletapedidocon.showAndWait();
                    stage.close();
                } catch (Exception exc) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error al eliminar el pedido: " + exc.getMessage());
                    alerta.showAndWait();
                }
            });

            // Botón para salir
            Button btnSalir = new Button("Salir");
            btnSalir.setOnAction(e_cliente_add -> stage.close());

            VBox layout = new VBox(10,
                    new Label("Número de Pedido a eliminar:"), txtPedidoNumeroAEliminar,
                    btnGuardar,
                    btnSalir
            );
            layout.setPadding(new Insets(15));

            stage.setScene(new Scene(layout));
            stage.show();
        });



        // creamos botón y funcionalidad para mostrar pedidos pendientes
        Button btnMostrarPedidosPendientesEnvio = new Button("Mostrar Pedidos Pendientes Envío");
        btnMostrarPedidosPendientesEnvio.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Pedidos pendientes de envío");

            ListView<String> listView = new ListView<>();
            for(Pedido p: controlador.obtenerPedidosPendientesClase()){
                String resultado = "Numero Pedido: " + p.getNumeroPedido() + " Precio Total: " + p.getPrecioTotal() + "\n";
                listView.getItems().add(resultado);
            }


            // Botón para salir
            Button btnSalir = new Button("Salir");
            btnSalir.setOnAction(e_articulo_show -> stage.close());

            VBox layout = new VBox(10, listView, btnSalir);
            layout.setPadding(new Insets(15));

            stage.setScene(new Scene(layout));
            stage.show();
        });


        // creamos botón y funcionalidad para mostrar pedidos enviados
        Button btnMostrarPedidosEnviados = new Button("Mostrar Pedidos Enviados");
        btnMostrarPedidosEnviados.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Pedidos enviados");

            ListView<String> listView = new ListView<>();

            // Obtenemos los artículos desde el controlador
            for(Pedido p: controlador.obtenerPedidosEnviadosClase()){
                String resultado = "Numero Pedido: " + p.getNumeroPedido() + " Precio Total: " + p.getPrecioTotal() + "\n";
                listView.getItems().add(resultado);
            }

            // Botón para salir
            Button btnSalir = new Button("Salir");
            btnSalir.setOnAction(e_articulo_show -> stage.close());

            VBox layout = new VBox(10, listView, btnSalir);
            layout.setPadding(new Insets(15));

            stage.setScene(new Scene(layout));
            stage.show();
        });



        // Aquí puedes agregar los eventos de los botones...

        grid.add(btnAddPedido, 0, 0);
        grid.add(btnEliminarPedido, 0, 1);
        grid.add(btnMostrarPedidosPendientesEnvio, 0, 2);
        grid.add(btnMostrarPedidosEnviados, 0, 3);

        return grid;
    }

    public void crearClientePedido(Cliente cl){
            Stage stage = new Stage();
            stage.setTitle("Añadir Pedido");

            TextField txtPedidoNumero = new TextField();
            TextField txtPedidoCodigo = new TextField();
            TextField txtPedidoCantidad = new TextField();
            TextField txtPedidoEnviado = new TextField();

            Button btnGuardar = new Button("Guardar");
            btnGuardar.setOnAction(ev -> {
                try {
                    Integer numero = Integer.parseInt(txtPedidoNumero.getText());
                    String codigo = txtPedidoCodigo.getText();
                    Integer cantidad = Integer.parseInt(txtPedidoCantidad.getText());
                    if(controlador.existeArticulo(codigo) == false){
                        Alert alertaError = new Alert(Alert.AlertType.ERROR);
                        alertaError.setTitle("Error");
                        alertaError.setHeaderText(null);
                        alertaError.setContentText("El articulo introducido no existe.");
                        ButtonType botonCancelar = new ButtonType("Aceptar");
                        alertaError.getButtonTypes().setAll(botonCancelar);
                        return;
                    }

                    Articulo a = controlador.obtenerArticuloCodigo(codigo);
                    Pedido p = new Pedido(numero, cl, a, cantidad, LocalDateTime.now(), false);
                    if(cl instanceof ClientePremium){
                        p.setPrecioTotal(a.getPrecioDeVenta() * cantidad + a.getGastosDeEnvio() - (a.getGastosDeEnvio() * ((ClientePremium) cl).getDescuentoEnvio())/100);
                    }
                    if(cl instanceof ClienteEstandar){
                        p.setPrecioTotal(a.getPrecioDeVenta() * cantidad + a.getGastosDeEnvio());
                    }
                    controlador.añadirPedido(p);
                    Alert aletapedidocon = new Alert(Alert.AlertType.CONFIRMATION);
                    aletapedidocon.setTitle("Confirmado");
                    aletapedidocon.setHeaderText(null);
                    aletapedidocon.setContentText("El pedido ha sido creado correctamente.");
                    ButtonType botonCancelar = new ButtonType("Aceptar");
                    aletapedidocon.getButtonTypes().setAll(botonCancelar);
                    Optional<ButtonType> resultado = aletapedidocon.showAndWait();
                    stage.close();

                } catch (Exception exc) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error al agregar el pedido: " + exc.getMessage());
                    alerta.showAndWait();
                }
            });

            // Botón para salir
            Button btnSalir = new Button("Salir");
            btnSalir.setOnAction(e_cliente_add -> stage.close());

            VBox layout = new VBox(10,
                    new Label("Número de Pedido:"), txtPedidoNumero,
                    new Label("Código de Artículo:"), txtPedidoCodigo,
                    new Label("Cantidad:"), txtPedidoCantidad,
                    btnGuardar,
                    btnSalir
            );
            layout.setPadding(new Insets(15));

            stage.setScene(new Scene(layout));
            stage.show();
    }


    public synchronized Cliente crearClienteYPedido() {
        final Object lock = new Object();
        synchronized (lock) {
            crearCliente();
            Cliente c = controlador.obtenerUltimoCliente();
            crearClientePedido(c);
            return c;
        }
    }



    public static void main(String[] args) {
        launch();
    }
}