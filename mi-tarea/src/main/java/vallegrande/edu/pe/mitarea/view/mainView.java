package vallegrande.edu.pe.mitarea.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class mainView extends BorderPane {

    private final Button btnInicio;
    private final Button btnUsuarios;
    private final Button btnProductos;
    private final Button btnVentas;
    private final Button btnReportes;
    private final Button btnConfiguracion;

    private Button botonActivo;

    private final String estiloNormal =
            "-fx-background-color: transparent;" +
                    "-fx-text-fill: #CBD5E1;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 13 16;" +
                    "-fx-background-radius: 9;" +
                    "-fx-cursor: hand;";

    private final String estiloHover =
            "-fx-background-color: #1E293B;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 13 16;" +
                    "-fx-background-radius: 9;" +
                    "-fx-cursor: hand;";

    private final String estiloActivo =
            "-fx-background-color: #2563EB;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 13 16;" +
                    "-fx-background-radius: 9;" +
                    "-fx-cursor: hand;";

    public mainView() {

        setStyle(
                "-fx-background-color: #F4F7FB;"
        );

        VBox menu = new VBox(15);

        menu.setPrefWidth(250);

        menu.setPadding(
                new Insets(28, 18, 25, 18)
        );

        menu.setStyle(
                "-fx-background-color: #0F172A;"
        );

        // LOGO

        Label logo = new Label("JM");

        logo.setAlignment(Pos.CENTER);

        logo.setPrefSize(65, 65);

        logo.setStyle(
                "-fx-background-color: #2563EB;" +
                        "-fx-background-radius: 50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 21px;" +
                        "-fx-font-weight: bold;"
        );

        Label nombreSistema = new Label(
                "MI SISTEMA"
        );

        nombreSistema.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;"
        );

        Label descripcionSistema = new Label(
                "Panel administrativo"
        );

        descripcionSistema.setStyle(
                "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 11px;"
        );

        VBox logoBox = new VBox(
                7,
                logo,
                nombreSistema,
                descripcionSistema
        );

        logoBox.setAlignment(
                Pos.CENTER
        );

        // TÍTULO DEL MENÚ

        Label menuTitulo = new Label(
                "MENÚ PRINCIPAL"
        );

        menuTitulo.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;"
        );

        // BOTONES

        btnInicio = crearBoton(
                "⌂     Inicio"
        );

        btnUsuarios = crearBoton(
                "●     Usuarios"
        );

        btnProductos = crearBoton(
                "■     Productos"
        );

        btnVentas = crearBoton(
                "▣     Ventas"
        );

        btnReportes = crearBoton(
                "▤     Reportes"
        );

        btnConfiguracion = crearBoton(
                "⚙     Configuración"
        );

        VBox opciones = new VBox(
                7,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnVentas,
                btnReportes,
                btnConfiguracion
        );

        VBox.setVgrow(
                opciones,
                Priority.ALWAYS
        );

        // USUARIO

        Label usuario = new Label(
                "José Manuel"
        );

        usuario.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;"
        );

        Label rol = new Label(
                "Administrador"
        );

        rol.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 10px;"
        );

        VBox usuarioBox = new VBox(
                3,
                usuario,
                rol
        );

        usuarioBox.setPadding(
                new Insets(12)
        );

        usuarioBox.setStyle(
                "-fx-background-color: #172033;" +
                        "-fx-background-radius: 10;"
        );

        Label version = new Label(
                "Versión 1.0  •  JavaFX"
        );

        version.setStyle(
                "-fx-text-fill: #475569;" +
                        "-fx-font-size: 9px;"
        );

        menu.getChildren().addAll(
                logoBox,
                menuTitulo,
                opciones,
                usuarioBox,
                version
        );

        setLeft(menu);

        mostrarInicio();
    }

    // =====================================
    // BOTONES DEL MENÚ
    // =====================================

    private Button crearBoton(String texto) {

        Button boton = new Button(texto);

        boton.setMaxWidth(
                Double.MAX_VALUE
        );

        boton.setAlignment(
                Pos.CENTER_LEFT
        );

        boton.setStyle(
                estiloNormal
        );

        boton.setOnMouseEntered(event -> {

            if (boton != botonActivo) {
                boton.setStyle(estiloHover);
            }
        });

        boton.setOnMouseExited(event -> {

            if (boton != botonActivo) {
                boton.setStyle(estiloNormal);
            }
        });

        return boton;
    }

    private void seleccionarBoton(
            Button boton
    ) {

        btnInicio.setStyle(estiloNormal);
        btnUsuarios.setStyle(estiloNormal);
        btnProductos.setStyle(estiloNormal);
        btnVentas.setStyle(estiloNormal);
        btnReportes.setStyle(estiloNormal);
        btnConfiguracion.setStyle(estiloNormal);

        boton.setStyle(estiloActivo);

        botonActivo = boton;
    }

    // =====================================
    // INICIO
    // =====================================

    public void mostrarInicio() {

        seleccionarBoton(
                btnInicio
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Dashboard",
                "Resumen general del sistema"
        );

        // ESTADÍSTICAS

        HBox estadisticas = new HBox(18);

        VBox tarjetaUsuarios =
                crearEstadistica(
                        "USUARIOS",
                        "03",
                        "Registrados",
                        "#2563EB"
                );

        VBox tarjetaProductos =
                crearEstadistica(
                        "PRODUCTOS",
                        "03",
                        "Disponibles",
                        "#7C3AED"
                );

        VBox tarjetaVentas =
                crearEstadistica(
                        "VENTAS",
                        "15",
                        "Este mes",
                        "#EA580C"
                );

        VBox tarjetaSistema =
                crearEstadistica(
                        "SISTEMA",
                        "100%",
                        "Operativo",
                        "#16A34A"
                );

        estadisticas.getChildren().addAll(
                tarjetaUsuarios,
                tarjetaProductos,
                tarjetaVentas,
                tarjetaSistema
        );

        HBox.setHgrow(
                tarjetaUsuarios,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                tarjetaProductos,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                tarjetaVentas,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                tarjetaSistema,
                Priority.ALWAYS
        );

        // BIENVENIDA

        VBox bienvenida = new VBox(12);

        bienvenida.setPadding(
                new Insets(28)
        );

        bienvenida.setStyle(
                "-fx-background-color: linear-gradient(to right, #1D4ED8, #2563EB);" +
                        "-fx-background-radius: 18;"
        );

        Label sistemaActivo = new Label(
                "● SISTEMA ACTIVO"
        );

        sistemaActivo.setStyle(
                "-fx-text-fill: #BFDBFE;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;"
        );

        Label bienvenidaTitulo = new Label(
                "¡Bienvenido, José Manuel!"
        );

        bienvenidaTitulo.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 25px;" +
                        "-fx-font-weight: bold;"
        );

        Label bienvenidaTexto = new Label(
                "Desde este panel puedes gestionar usuarios, productos, " +
                        "ventas y reportes de una manera rápida y organizada."
        );

        bienvenidaTexto.setWrapText(true);

        bienvenidaTexto.setStyle(
                "-fx-text-fill: #DBEAFE;" +
                        "-fx-font-size: 13px;"
        );

        bienvenida.getChildren().addAll(
                sistemaActivo,
                bienvenidaTitulo,
                bienvenidaTexto
        );

        // ACCIONES RÁPIDAS

        Label accionesTitulo = crearSubtitulo(
                "Acciones rápidas"
        );

        HBox acciones = new HBox(12);

        Button nuevoUsuario =
                crearBotonAccion(
                        "+ Nuevo usuario"
                );

        Button nuevoProducto =
                crearBotonAccion(
                        "+ Nuevo producto"
                );

        Button nuevaVenta =
                crearBotonAccion(
                        "+ Registrar venta"
                );

        Button verReportes =
                crearBotonAccion(
                        "Ver reportes"
                );

        nuevoUsuario.setOnAction(
                event -> mostrarUsuarios()
        );

        nuevoProducto.setOnAction(
                event -> mostrarProductos()
        );

        nuevaVenta.setOnAction(
                event -> mostrarVentas()
        );

        verReportes.setOnAction(
                event -> mostrarReportes()
        );

        acciones.getChildren().addAll(
                nuevoUsuario,
                nuevoProducto,
                nuevaVenta,
                verReportes
        );

        // ACTIVIDAD

        Label actividadTitulo = crearSubtitulo(
                "Actividad reciente"
        );

        VBox actividades = new VBox(10);

        actividades.getChildren().addAll(

                crearActividad(
                        "✓",
                        "Sistema iniciado correctamente",
                        "La aplicación está funcionando correctamente."
                ),

                crearActividad(
                        "U",
                        "Nuevo usuario registrado",
                        "Se agregó un nuevo usuario al sistema."
                ),

                crearActividad(
                        "P",
                        "Producto actualizado",
                        "El stock de un producto fue actualizado."
                )
        );

        contenido.getChildren().addAll(
                encabezado,
                estadisticas,
                bienvenida,
                accionesTitulo,
                acciones,
                actividadTitulo,
                actividades
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // USUARIOS
    // =====================================

    public void mostrarUsuarios() {

        seleccionarBoton(
                btnUsuarios
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Usuarios",
                "Administración de usuarios registrados"
        );

        HBox tarjetas = new HBox(18);

        VBox usuario1 = crearUsuario(
                "CP",
                "Carlos Pérez",
                "Administrador",
                "carlos@sistema.com"
        );

        VBox usuario2 = crearUsuario(
                "ML",
                "María López",
                "Vendedora",
                "maria@sistema.com"
        );

        VBox usuario3 = crearUsuario(
                "PR",
                "Piero Ramos",
                "Supervisor",
                "piero@sistema.com"
        );

        tarjetas.getChildren().addAll(
                usuario1,
                usuario2,
                usuario3
        );

        HBox.setHgrow(
                usuario1,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                usuario2,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                usuario3,
                Priority.ALWAYS
        );

        contenido.getChildren().addAll(
                encabezado,
                tarjetas
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // PRODUCTOS
    // =====================================

    public void mostrarProductos() {

        seleccionarBoton(
                btnProductos
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Productos",
                "Catálogo general de productos"
        );

        HBox tarjetas = new HBox(18);

        VBox producto1 = crearProducto(
                "Laptop Lenovo",
                "Tecnología",
                "S/ 2,500",
                "12 unidades"
        );

        VBox producto2 = crearProducto(
                "Mouse Logitech",
                "Accesorios",
                "S/ 80",
                "25 unidades"
        );

        VBox producto3 = crearProducto(
                "Teclado Mecánico",
                "Accesorios",
                "S/ 180",
                "18 unidades"
        );

        tarjetas.getChildren().addAll(
                producto1,
                producto2,
                producto3
        );

        HBox.setHgrow(
                producto1,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                producto2,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                producto3,
                Priority.ALWAYS
        );

        contenido.getChildren().addAll(
                encabezado,
                tarjetas
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // VENTAS
    // =====================================

    public void mostrarVentas() {

        seleccionarBoton(
                btnVentas
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Ventas",
                "Control de ventas realizadas"
        );

        HBox resumen = new HBox(18);

        VBox totalVentas = crearEstadistica(
                "TOTAL VENTAS",
                "15",
                "Este mes",
                "#2563EB"
        );

        VBox ingresos = crearEstadistica(
                "INGRESOS",
                "S/ 8,450",
                "Este mes",
                "#16A34A"
        );

        VBox promedio = crearEstadistica(
                "PROMEDIO",
                "S/ 563",
                "Por venta",
                "#EA580C"
        );

        resumen.getChildren().addAll(
                totalVentas,
                ingresos,
                promedio
        );

        HBox.setHgrow(
                totalVentas,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                ingresos,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                promedio,
                Priority.ALWAYS
        );

        Label titulo = crearSubtitulo(
                "Últimas ventas"
        );

        VBox ventas = new VBox(10);

        ventas.getChildren().addAll(

                crearActividad(
                        "01",
                        "Laptop Lenovo",
                        "Venta registrada por S/ 2,500"
                ),

                crearActividad(
                        "02",
                        "Mouse Logitech",
                        "Venta registrada por S/ 80"
                ),

                crearActividad(
                        "03",
                        "Teclado Mecánico",
                        "Venta registrada por S/ 180"
                )
        );

        contenido.getChildren().addAll(
                encabezado,
                resumen,
                titulo,
                ventas
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // REPORTES
    // =====================================

    public void mostrarReportes() {

        seleccionarBoton(
                btnReportes
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Reportes",
                "Resumen de información del sistema"
        );

        HBox reportes = new HBox(18);

        VBox reporteUsuarios = crearReporte(
                "Reporte de usuarios",
                "Consulta los usuarios registrados.",
                "03 registros"
        );

        VBox reporteProductos = crearReporte(
                "Reporte de productos",
                "Consulta el inventario disponible.",
                "03 productos"
        );

        VBox reporteVentas = crearReporte(
                "Reporte de ventas",
                "Consulta las ventas realizadas.",
                "15 ventas"
        );

        reportes.getChildren().addAll(
                reporteUsuarios,
                reporteProductos,
                reporteVentas
        );

        HBox.setHgrow(
                reporteUsuarios,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                reporteProductos,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                reporteVentas,
                Priority.ALWAYS
        );

        contenido.getChildren().addAll(
                encabezado,
                reportes
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // CONFIGURACIÓN
    // =====================================

    public void mostrarConfiguracion() {

        seleccionarBoton(
                btnConfiguracion
        );

        VBox contenido = crearContenido();

        HBox encabezado = crearEncabezado(
                "Configuración",
                "Configuración general del sistema"
        );

        VBox configuracion = crearTarjetaBase();

        Label titulo = new Label(
                "Información del sistema"
        );

        titulo.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label sistema = new Label(
                "Nombre: Sistema Empresarial"
        );

        Label version = new Label(
                "Versión: 1.0"
        );

        Label tecnologia = new Label(
                "Tecnología: JavaFX"
        );

        Label desarrollador = new Label(
                "Desarrollador: José Manuel"
        );

        sistema.setStyle(
                "-fx-text-fill: #64748B;"
        );

        version.setStyle(
                "-fx-text-fill: #64748B;"
        );

        tecnologia.setStyle(
                "-fx-text-fill: #64748B;"
        );

        desarrollador.setStyle(
                "-fx-text-fill: #64748B;"
        );

        Button guardar = crearBotonPrincipal(
                "Guardar configuración"
        );

        configuracion.getChildren().addAll(
                titulo,
                sistema,
                version,
                tecnologia,
                desarrollador,
                guardar
        );

        contenido.getChildren().addAll(
                encabezado,
                configuracion
        );

        mostrarContenido(contenido);
    }

    // =====================================
    // COMPONENTES GENERALES
    // =====================================

    private VBox crearContenido() {

        VBox contenido = new VBox(23);

        contenido.setPadding(
                new Insets(30, 35, 30, 35)
        );

        contenido.setStyle(
                "-fx-background-color: #F4F7FB;"
        );

        return contenido;
    }

    private void mostrarContenido(
            VBox contenido
    ) {

        ScrollPane scroll = new ScrollPane(
                contenido
        );

        scroll.setFitToWidth(true);

        scroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scroll.setStyle(
                "-fx-background: #F4F7FB;" +
                        "-fx-background-color: #F4F7FB;" +
                        "-fx-border-color: transparent;"
        );

        setCenter(scroll);
    }

    private HBox crearEncabezado(
            String titulo,
            String descripcion
    ) {

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox textos = new VBox(4);

        Label tituloLabel = new Label(
                titulo
        );

        tituloLabel.setStyle(
                "-fx-font-size: 29px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label descripcionLabel = new Label(
                descripcion
        );

        descripcionLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 13px;"
        );

        textos.getChildren().addAll(
                tituloLabel,
                descripcionLabel
        );

        Region espacio = new Region();

        HBox.setHgrow(
                espacio,
                Priority.ALWAYS
        );

        Label perfil = new Label(
                "JM   José Manuel"
        );

        perfil.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: #334155;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 17;" +
                        "-fx-background-radius: 20;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.07), 10, 0, 0, 3);"
        );

        header.getChildren().addAll(
                textos,
                espacio,
                perfil
        );

        return header;
    }

    private VBox crearEstadistica(
            String titulo,
            String numero,
            String descripcion,
            String color
    ) {

        VBox tarjeta = new VBox(8);

        tarjeta.setPadding(
                new Insets(20)
        );

        tarjeta.setMaxWidth(
                Double.MAX_VALUE
        );

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 14;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 14;" +
                        "-fx-effect: dropshadow(gaussian, rgba(15,23,42,0.08), 12, 0, 0, 3);"
        );

        Label tituloLabel = new Label(
                titulo
        );

        tituloLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;"
        );

        Label numeroLabel = new Label(
                numero
        );

        numeroLabel.setStyle(
                "-fx-text-fill: " + color + ";" +
                        "-fx-font-size: 27px;" +
                        "-fx-font-weight: bold;"
        );

        Label descripcionLabel = new Label(
                descripcion
        );

        descripcionLabel.setStyle(
                "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 11px;"
        );

        tarjeta.getChildren().addAll(
                tituloLabel,
                numeroLabel,
                descripcionLabel
        );

        return tarjeta;
    }

    private VBox crearTarjetaBase() {

        VBox tarjeta = new VBox(12);

        tarjeta.setPadding(
                new Insets(25)
        );

        tarjeta.setMaxWidth(
                Double.MAX_VALUE
        );

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 15;" +
                        "-fx-effect: dropshadow(gaussian, rgba(15,23,42,0.07), 12, 0, 0, 3);"
        );

        return tarjeta;
    }

    private VBox crearUsuario(
            String iniciales,
            String nombre,
            String rol,
            String correo
    ) {

        VBox tarjeta = crearTarjetaBase();

        tarjeta.setAlignment(
                Pos.CENTER
        );

        Label avatar = new Label(
                iniciales
        );

        avatar.setAlignment(
                Pos.CENTER
        );

        avatar.setPrefSize(
                65,
                65
        );

        avatar.setStyle(
                "-fx-background-color: #DBEAFE;" +
                        "-fx-background-radius: 50;" +
                        "-fx-text-fill: #2563EB;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        Label nombreLabel = new Label(
                nombre
        );

        nombreLabel.setStyle(
                "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label rolLabel = new Label(
                rol
        );

        rolLabel.setStyle(
                "-fx-text-fill: #2563EB;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 12px;"
        );

        Label correoLabel = new Label(
                correo
        );

        correoLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 11px;"
        );

        Label estado = new Label(
                "● Activo"
        );

        estado.setStyle(
                "-fx-background-color: #DCFCE7;" +
                        "-fx-text-fill: #16A34A;" +
                        "-fx-padding: 5 10;" +
                        "-fx-background-radius: 10;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;"
        );

        Button editar = crearBotonPrincipal(
                "Editar usuario"
        );

        tarjeta.getChildren().addAll(
                avatar,
                nombreLabel,
                rolLabel,
                correoLabel,
                estado,
                editar
        );

        return tarjeta;
    }

    private VBox crearProducto(
            String nombre,
            String categoria,
            String precio,
            String stock
    ) {

        VBox tarjeta = crearTarjetaBase();

        Label categoriaLabel = new Label(
                categoria.toUpperCase()
        );

        categoriaLabel.setStyle(
                "-fx-text-fill: #2563EB;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;"
        );

        Label nombreLabel = new Label(
                nombre
        );

        nombreLabel.setStyle(
                "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label precioLabel = new Label(
                precio
        );

        precioLabel.setStyle(
                "-fx-font-size: 23px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #16A34A;"
        );

        Label stockLabel = new Label(
                "Stock: " + stock
        );

        stockLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 12px;"
        );

        Button ver = crearBotonPrincipal(
                "Ver producto"
        );

        tarjeta.getChildren().addAll(
                categoriaLabel,
                nombreLabel,
                precioLabel,
                stockLabel,
                ver
        );

        return tarjeta;
    }

    private VBox crearReporte(
            String titulo,
            String descripcion,
            String cantidad
    ) {

        VBox tarjeta = crearTarjetaBase();

        Label tituloLabel = new Label(
                titulo
        );

        tituloLabel.setStyle(
                "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        Label descripcionLabel = new Label(
                descripcion
        );

        descripcionLabel.setWrapText(true);

        descripcionLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                        "-fx-font-size: 12px;"
        );

        Label cantidadLabel = new Label(
                cantidad
        );

        cantidadLabel.setStyle(
                "-fx-text-fill: #2563EB;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;"
        );

        Button boton = crearBotonPrincipal(
                "Ver reporte"
        );

        tarjeta.getChildren().addAll(
                tituloLabel,
                descripcionLabel,
                cantidadLabel,
                boton
        );

        return tarjeta;
    }

    private HBox crearActividad(
            String icono,
            String titulo,
            String descripcion
    ) {

        HBox fila = new HBox(15);

        fila.setAlignment(
                Pos.CENTER_LEFT
        );

        fila.setPadding(
                new Insets(13)
        );

        fila.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 10;"
        );

        Label iconoLabel = new Label(
                icono
        );

        iconoLabel.setAlignment(
                Pos.CENTER
        );

        iconoLabel.setPrefSize(
                38,
                38
        );

        iconoLabel.setStyle(
                "-fx-background-color: #EFF6FF;" +
                        "-fx-text-fill: #2563EB;" +
                        "-fx-background-radius: 10;" +
                        "-fx-font-weight: bold;"
        );

        VBox informacion = new VBox(3);

        Label tituloLabel = new Label(
                titulo
        );

        tituloLabel.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-text-fill: #334155;"
        );

        Label descripcionLabel = new Label(
                descripcion
        );

        descripcionLabel.setStyle(
                "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 11px;"
        );

        informacion.getChildren().addAll(
                tituloLabel,
                descripcionLabel
        );

        fila.getChildren().addAll(
                iconoLabel,
                informacion
        );

        return fila;
    }

    private Button crearBotonAccion(
            String texto
    ) {

        Button boton = new Button(
                texto
        );

        boton.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: #2563EB;" +
                        "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 16;" +
                        "-fx-background-radius: 9;" +
                        "-fx-border-color: #DBEAFE;" +
                        "-fx-border-radius: 9;" +
                        "-fx-cursor: hand;"
        );

        return boton;
    }

    private Button crearBotonPrincipal(
            String texto
    ) {

        Button boton = new Button(
                texto
        );

        boton.setStyle(
                "-fx-background-color: #2563EB;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 12px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 16;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );

        return boton;
    }

    private Label crearSubtitulo(
            String texto
    ) {

        Label label = new Label(
                texto
        );

        label.setStyle(
                "-fx-font-size: 17px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #0F172A;"
        );

        return label;
    }

    // =====================================
    // GETTERS
    // =====================================

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnUsuarios() {
        return btnUsuarios;
    }

    public Button getBtnProductos() {
        return btnProductos;
    }

    public Button getBtnVentas() {
        return btnVentas;
    }

    public Button getBtnReportes() {
        return btnReportes;
    }

    public Button getBtnConfiguracion() {
        return btnConfiguracion;
    }
}