import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class foro extends JFrame implements ActionListener {
    private JLabel labelNombre;
    private JTextField inputNombre;
    private JButton buttonAgregarMensajes;
    private JTextArea textAreaForo;
    private JScrollPane scrollPaneForo;

    private String[] foro;

    public foro() {
        // Configuración de la ventana principal
        setTitle("Aplicación de foros");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        labelNombre = new JLabel("Nombre:");
        inputNombre = new JTextField(20);
        buttonAgregarMensajes = new JButton("Agregar mensajes");
        textAreaForo = new JTextArea(10, 30);
        scrollPaneForo = new JScrollPane(textAreaForo);

        // Configuración de los componentes de la interfaz
        textAreaForo.setEditable(false);

        // Configuración del diseño de la interfaz
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(labelNombre, c);

        c.gridx = 1;
        c.gridy = 0;
        add(inputNombre, c);

        c.gridx = 2;
        c.gridy = 0;
        add(buttonAgregarMensajes, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneForo, c);

        // Agregar oyentes de eventos
        buttonAgregarMensajes.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAgregarMensajes) {
            String nombre = inputNombre.getText();
            String mensaje = JOptionPane.showInputDialog("Ingrese el mensaje:");

            if (foro == null) {
                foro = new String[1];
                foro[0] = nombre + ": " + mensaje;
            } else {
                String[] nuevoForo = new String[foro.length + 1];
                for (int i = 0; i < foro.length; i++) {
                    nuevoForo[i] = foro[i];
                }
                nuevoForo[foro.length] = nombre + ": " + mensaje;
                foro = nuevoForo;
            }

            textAreaForo.setText("");
            for (int i = 0; i < foro.length; i++) {
                textAreaForo.append(foro[i] + "\n");
            }
        }
    }

    public static void main(String[] args) {
        foro ventana = new foro();
        ventana.setVisible(true);
    }
}
