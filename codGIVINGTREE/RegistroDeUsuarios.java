import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegistroDeUsuarios extends JFrame {
    private JButton btnInicioSesion, btnRegistrarse, btnAceptar, btnCancelar;
    private JLabel lblTitulo, lblCorreo, lblUsuario, lblContrasena;
    private JTextField txtCorreo, txtUsuario;
    private JPasswordField txtContrasena;
    private JPanel pnlInicioSesion, pnlRegistro;
    private CardLayout cardLayout;
    private static final String INICIO_SESION = "InicioSesion";
    private static final String REGISTRO = "Registro";
    private static final String ARCHIVO_EXCEL = "usuarios.csv";
    private static final String[] COLUMNAS = { "Correo", "Usuario", "Contraseña" };

    public RegistroDeUsuarios() {
        super("Registro de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear botones de la pantalla de bienvenida
        btnInicioSesion = new JButton("Iniciar Sesión");
        btnRegistrarse = new JButton("Registrarse");

        // Crear paneles de inicio de sesión y registro
        cardLayout = new CardLayout();
        pnlInicioSesion = new JPanel(new BorderLayout());
        pnlRegistro = new JPanel(new GridLayout(4, 2));
        pnlRegistro.add(lblCorreo = new JLabel("Correo:"));
        pnlRegistro.add(txtCorreo = new JTextField());
        pnlRegistro.add(lblUsuario = new JLabel("Usuario:"));
        pnlRegistro.add(txtUsuario = new JTextField());
        pnlRegistro.add(lblContrasena = new JLabel("Contraseña:"));
        pnlRegistro.add(txtContrasena = new JPasswordField());
        pnlRegistro.add(btnAceptar = new JButton("Aceptar"));
        pnlRegistro.add(btnCancelar = new JButton("Cancelar"));

        // Agregar paneles al frame
        getContentPane().setLayout(cardLayout);
        getContentPane().add(INICIO_SESION, pnlInicioSesion);
        getContentPane().add(REGISTRO, pnlRegistro);

        // Agregar eventos a los botones de la pantalla de bienvenida
        btnInicioSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), INICIO_SESION);
            }
        });
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), REGISTRO);
            }
        });

        // Agregar evento al botón de registro
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String correo = txtCorreo.getText();
                    String usuario = txtUsuario.getText();
                    String contrasena = new String(txtContrasena.getPassword());

                    // Guardar información en el archivo CSV
                    BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_EXCEL, true));
                    writer.write(correo + "," + usuario + "," + contrasena + "\n");
                    writer.close();

                    // Mostrar mensaje de éxito y volver a la pantalla de inicio de sesión
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                    cardLayout.show(getContentPane(), INICIO_SESION);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnInicioSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean inicioSesionExitoso = false;
                String usuario = JOptionPane.showInputDialog("Usuario:");
                String contrasena = JOptionPane.showInputDialog("Contraseña:");

                // Validar si el usuario está registrado
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_EXCEL));
                    String linea;

                    while ((linea = reader.readLine()) != null) {
                        String[] campos = linea.split(",");
                        if (campos.length == 3 && campos[1].equals(usuario) && campos[2].equals(contrasena)) {
                            inicioSesionExitoso = true;
                            break;
                        }
                    }

                    reader.close();

                    // Si el usuario está registrado, mostrar mensaje de éxito y cambiar a la
                    // interfaz principal
                    if (inicioSesionExitoso) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                        dispose(); // Cerrar la ventana actual de RegistroDeUsuarios
                        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
                        interfazPrincipal.setVisible(true);
                    } else {
                        // Si el usuario no está registrado, mostrar mensaje de error
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Mostrar pantalla de bienvenida
        pnlInicioSesion.add(lblTitulo = new JLabel("Bienvenido"), BorderLayout.NORTH);
        pnlInicioSesion.add(btnInicioSesion, BorderLayout.WEST);
        pnlInicioSesion.add(btnRegistrarse, BorderLayout.EAST);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}