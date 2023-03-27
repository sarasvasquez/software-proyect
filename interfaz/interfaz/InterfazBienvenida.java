

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazBienvenida extends JFrame implements ActionListener {
    private JButton bIniciarSesion;
    private JButton bRegistrarse;

    public InterfazBienvenida() {
        // Construct components
        bIniciarSesion = new JButton("Iniciar sesión");
        bRegistrarse = new JButton("Registrarse");

        // Set components properties
        setLayout(new GridLayout(2, 1));
        add(bIniciarSesion);
        add(bRegistrarse);
        bIniciarSesion.addActionListener(this);
        bRegistrarse.addActionListener(this);

        // Set window properties
        setTitle("Bienvenido");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bIniciarSesion) {
            new InterfazInicioSesion();
            dispose();
        } else if (e.getSource() == bRegistrarse) {
            new InterfazRegistro();
            dispose();
        }
    }

    public static void main(String[] args) {
        new InterfazBienvenida();
    }
}

class InterfazInicioSesion extends JFrame implements ActionListener {
    private JLabel jcomp1;
    private JTextField tNombre;
    private JLabel jcomp3;
    private JPasswordField tContraseña;
    private JButton bIngresar;

    public InterfazInicioSesion() {
        // Construct components
        jcomp1 = new JLabel("Nombre:");
        tNombre = new JTextField(5);
        jcomp3 = new JLabel("Contraseña:");
        tContraseña = new JPasswordField(5);
        bIngresar = new JButton("Ingresar");

        // Set components properties
        setLayout(new GridLayout(3, 2));
        add(jcomp1);
        add(tNombre);
        add(jcomp3);
        add(tContraseña);
        add(bIngresar);
        bIngresar.addActionListener(this);

        // Set window properties
        setTitle("Iniciar sesión");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String nombre = tNombre.getText();
        char[] contraseña = tContraseña.getPassword();
        // Verificar si el usuario está registrado
        if (usuarioEstaRegistrado(nombre, contraseña)) {
            JOptionPane.showMessageDialog(null, "¡Bienvenido " + nombre + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no registrado. Por favor regístrese.");
            new InterfazRegistro();
            dispose();
        }
    }

    // Esta función verifica si un usuario está registrado
    private boolean usuarioEstaRegistrado(String nombre, char[] contraseña) {
        // Aquí iría la lógica para verificar si el usuario está registrado en tu sistema
        // Por ejemplo, podrías consultar una base de datos
        // Por ahora, siempre regresamos true para poder probar la interfaz de bienvenida
        return true;
    }
}

class InterfazRegistro extends JFrame implements ActionListener {
    private JLabel jcomp1;
    private JTextField tCorreo;
    private JLabel jcomp2;
    private JTextField tNombre;
    private JLabel jcomp3;
    private JPasswordField tContraseña;
    private JButton bRegistrar;

    public InterfazRegistro() {
        // Construct components
        jcomp1 = new JLabel("Correo:");
           tCorreo = new JTextField(5);
    jcomp2 = new JLabel("Nombre:");
    tNombre = new JTextField(5);
    jcomp3 = new JLabel("Contraseña:");
    tContraseña = new JPasswordField(5);
    bRegistrar = new JButton("Registrar");

    // Set components properties
    setLayout(new GridLayout(4, 2));
    add(jcomp1);
    add(tCorreo);
    add(jcomp2);
    add(tNombre);
    add(jcomp3);
    add(tContraseña);
    add(bRegistrar);
    bRegistrar.addActionListener(this);

    // Set window properties
    setTitle("Registro");
    setSize(200, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
}

public void actionPerformed(ActionEvent e) {
    String correo = tCorreo.getText();
    String nombre = tNombre.getText();
    char[] contraseña = tContraseña.getPassword();
    // Registrar el usuario en el sistema
    if (registrarUsuario(correo, nombre, contraseña)) {
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
        new InterfazInicioSesion();
        dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el usuario. Por favor intente de nuevo.");
    }
}

// Esta función registra un nuevo usuario en el sistema
private boolean registrarUsuario(String correo, String nombre, char[] contraseña) {
    // Aquí iría la lógica para registrar un nuevo usuario en tu sistema
    // Por ejemplo, podrías insertar los datos en una base de datos
    // Por ahora, siempre regresamos true para poder probar la interfaz de bienvenida
    return true;
}
}