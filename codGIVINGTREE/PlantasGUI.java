import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PlantasGUI extends JFrame implements ActionListener {
    private JButton botonRosal;
    private JButton botonAveDeParaiso;
    private JButton botonAnturio;
    private JTextArea textAreaInfo;

    public PlantasGUI() {
        // Configuración de la ventana principal
        setTitle("Información de plantas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        botonRosal = new JButton("Rosal");
        botonAveDeParaiso = new JButton("Ave de paraíso");
        botonAnturio = new JButton("Anturio");
        textAreaInfo = new JTextArea(10, 70);
        JScrollPane scrollPane = new JScrollPane(textAreaInfo);
        JButton botonRegresar = new JButton("Regresar");

        // Configuración de los componentes de la interfaz
        textAreaInfo.setEditable(false);

        // Configuración del diseño de la interfaz
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(botonRosal, c);

        c.gridx = 1;
        c.gridy = 0;
        add(botonAveDeParaiso, c);

        c.gridx = 2;
        c.gridy = 0;
        add(botonAnturio, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPane, c);

        // Agregar oyentes de eventos
        botonRosal.addActionListener(this);
        botonAveDeParaiso.addActionListener(this);
        botonAnturio.addActionListener(this);
        
       // Agregamos el ActionListener del botón de regresar
    botonRegresar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose(); // Cerramos la ventana actual
            InterfazPrincipal principal = new InterfazPrincipal(); // Creamos una nueva instancia de InterfazPrincipal
            principal.setVisible(true); // Hacemos visible la nueva instancia de InterfazPrincipal
        }
    });
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        add(botonRegresar, c);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        String filename = "plantas.txt";
        String message = "";
        
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(buttonName)) {
                    message = line.substring(buttonName.length() + 1).replace(",", "\n");
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }
        
        textAreaInfo.setText(message);
    }
    
    
}


