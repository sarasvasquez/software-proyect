package interfaz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazRegistroLogin extends JPanel implements ActionListener {
    private JTextField tNombre;
    private JTextField tEmail;
    private JPasswordField tContrasena;
    private JButton bRegistro;
    private JButton bLogin;
    private JLabel jcomp5;

    public InterfazRegistroLogin() {
        //construct components
        tNombre = new JTextField(10);
        tEmail = new JTextField(10);
        tContrasena = new JPasswordField(10);
        bRegistro = new JButton("Registrarse");
        bLogin = new JButton("Iniciar sesión");
        jcomp5 = new JLabel("Introduzca sus datos de registro o inicio de sesión:");

        //set components properties
        tContrasena.setEchoChar('*');

        //adjust size and set layout
        setPreferredSize(new Dimension(300, 150));
        setLayout(new GridLayout(4, 2));

        //add components
        add(new JLabel("Nombre:"));
        add(tNombre);
        add(new JLabel("Email:"));
        add(tEmail);
        add(new JLabel("Contraseña:"));
        add(tContrasena);
        add(bRegistro);
        bRegistro.addActionListener(this);
        add(bLogin);
        bLogin.addActionListener(this);
        add(jcomp5);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRegistro) {
            System.out.println("Registrarse");
            String nombre = tNombre.getText();
            String email = tEmail.getText();
            String contrasena = String.valueOf(tContrasena.getPassword());

            // Aquí se agregaría el código para registrar al usuario en la base de datos
        }
        if (e.getSource() == bLogin) {
            System.out.println("Iniciar sesión");
            String email = tEmail.getText();
            String contrasena = String.valueOf(tContrasena.getPassword());

            // Aquí se agregaría el código para verificar el inicio de sesión del usuario en la base de datos
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InterfazRegistroLogin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new InterfazRegistroLogin());
        frame.pack();
        frame.setVisible(true);
    }
}


