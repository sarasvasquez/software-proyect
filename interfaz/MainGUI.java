import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JFrame implements ActionListener {
    private JLabel labelNombre;
    private JLabel labelTareas;
    private JLabel labelVerTarea;
    private JTextField inputNombre;
    private JTextField inputNumTareas;
    private JTextField inputVerTarea;
    private JButton buttonAgregarTareas;
    private JButton buttonVerTarea;
    private JTextArea textAreaAgenda;
    private JScrollPane scrollPaneAgenda;

    private String[] agenda;

    public MainGUI() {
        // Configuración de la ventana principal
        setTitle("Aplicación de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        labelNombre = new JLabel("Nombre:");
        labelTareas = new JLabel("Número de tareas:");
        labelVerTarea = new JLabel("Número de tarea a ver:");
        inputNombre = new JTextField(20);
        inputNumTareas = new JTextField(5);
        inputVerTarea = new JTextField(5);
        buttonAgregarTareas = new JButton("Agregar tareas");
        buttonVerTarea = new JButton("Ver tarea");
        textAreaAgenda = new JTextArea(10, 30);
        scrollPaneAgenda = new JScrollPane(textAreaAgenda);

        // Configuración de los componentes de la interfaz
        textAreaAgenda.setEditable(false);

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

        c.gridx = 0;
        c.gridy = 1;
        add(labelTareas, c);

        c.gridx = 1;
        c.gridy = 1;
        add(inputNumTareas, c);

        c.gridx = 2;
        c.gridy = 1;
        add(buttonAgregarTareas, c);

        c.gridx = 0;
        c.gridy = 2;
        add(labelVerTarea, c);

        c.gridx = 1;
        c.gridy = 2;

        add(inputVerTarea, c);
    
        c.gridx = 2;
        c.gridy = 3;
        add(buttonVerTarea, c);
    
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneAgenda, c);
    
        // Agregar oyentes de eventos
        buttonAgregarTareas.addActionListener(this);
        buttonVerTarea.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAgregarTareas) {
            int numTareas = Integer.parseInt(inputNumTareas.getText());
            agenda = new String[numTareas];
    
            for (int i = 0; i < numTareas; i++) {
                String tarea = JOptionPane.showInputDialog("Ingrese la tarea " + (i + 1) + ":");
                agenda[i] = tarea;
            }
    
            textAreaAgenda.setText("Agenda actualizada\n");
    
            for (int i = 0; i < agenda.length; i++) {
                textAreaAgenda.append("Tarea " + (i + 1) + ": " + agenda[i] + "\n");
            }
        } else if (e.getSource() == buttonVerTarea) {
            int numTarea = Integer.parseInt(inputVerTarea.getText());
    
            if (agenda != null && numTarea >= 1 && numTarea <= agenda.length) {
                JOptionPane.showMessageDialog(this, "Tarea " + numTarea + ": " + agenda[numTarea - 1]);
            } else {
                JOptionPane.showMessageDialog(this, "Número de tarea inválido");
            }
        }
    }
    
    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
        gui.setVisible(true);
    }
    }

    