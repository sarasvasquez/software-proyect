/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lista extends JFrame implements ActionListener {
    private JLabel labelNombre;
    private JLabel labelTareas;
    private JLabel labelTareaRealizada;
    private JTextField inputNombre;
    private JTextField inputNumTareas;
    private JTextField inputTareaRealizada;
    private JButton buttonAgregarTareas;
    private JButton buttonMarcarHecho;
    private JTextArea textAreaAgenda;
    private JScrollPane scrollPaneAgenda;
    private JButton buttonRegresar;

    private String[] agenda;

    public Lista() {
        // Configuración de la ventana principal
        setTitle("Aplicación de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        labelNombre = new JLabel("Nombre:");
        labelTareas = new JLabel("Número de tareas:");
        labelTareaRealizada = new JLabel("Tarea realizada:");
        inputNombre = new JTextField(20);
        inputNumTareas = new JTextField(5);
        inputTareaRealizada = new JTextField(5);
        buttonAgregarTareas = new JButton("Agregar tareas");
        buttonMarcarHecho = new JButton("Marcar como hecho");
        textAreaAgenda = new JTextArea(10, 30);
        scrollPaneAgenda = new JScrollPane(textAreaAgenda);
        buttonRegresar = new JButton("Regresar");

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
        add(labelTareaRealizada, c);

        c.gridx = 1;
        c.gridy = 2;
        add(inputTareaRealizada, c);

        c.gridx = 2;
        c.gridy = 2;
        add(buttonMarcarHecho, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneAgenda, c);
        

        
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(buttonRegresar, c);
        

        // Agregar oyentes de eventos
        buttonAgregarTareas.addActionListener(this);
        buttonMarcarHecho.addActionListener(this);
        buttonRegresar.addActionListener(this);
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
                textAreaAgenda.append("Tarea " + (i + 1)+ ": " + agenda[i] + "\n");
}
} else if (e.getSource() == buttonMarcarHecho) {
String tareaRealizada = inputTareaRealizada.getText();
boolean tareaEncontrada = false;
      for (int i = 0; i < agenda.length; i++) {
          if (agenda[i].equals(tareaRealizada)) {
              agenda[i] = "Hecho: " + agenda[i];
              tareaEncontrada = true;
              break;
          }
      }

      if (tareaEncontrada) {
          textAreaAgenda.setText("Agenda actualizada\n");

          for (int i = 0; i < agenda.length; i++) {
              textAreaAgenda.append("Tarea " + (i + 1) + ": " + agenda[i] + "\n");
          }
      } else {
          JOptionPane.showMessageDialog(this, "La tarea no se encuentra en la agenda.");
      }
  } else if (e.getSource() == buttonRegresar) {
        InterfazPrincipal ip = new InterfazPrincipal(); // crea una instancia de InterfazPrincipal
        ip.setVisible(true); // muestra la ventana InterfazPrincipal
        dispose(); // cierra la ventana actual
    }
}


}*//* 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Lista extends JFrame implements ActionListener {
    private JLabel labelNombre;
    private JLabel labelTareas;
    private JLabel labelTareaRealizada;
    private JTextField inputNombre;
    private JTextField inputNumTareas;
    private JTextField inputTareaRealizada;
    private JButton buttonAgregarTareas;
    private JButton buttonMarcarHecho;
    private JTextArea textAreaAgenda;
    private JScrollPane scrollPaneAgenda;
    private JButton buttonRegresar;
    private JButton buttonGuardar;
    
    private String[] agenda;

    public Lista() {
        // Configuración de la ventana principal
        setTitle("Aplicación de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        labelNombre = new JLabel("Nombre:");
        labelTareas = new JLabel("Número de tareas:");
        labelTareaRealizada = new JLabel("Tarea realizada:");
        inputNombre = new JTextField(20);
        inputNumTareas = new JTextField(5);
        inputTareaRealizada = new JTextField(5);
        buttonAgregarTareas = new JButton("Agregar tareas");
        buttonMarcarHecho = new JButton("Marcar como hecho");
        textAreaAgenda = new JTextArea(10, 30);
        scrollPaneAgenda = new JScrollPane(textAreaAgenda);
        buttonRegresar = new JButton("Regresar");
        buttonGuardar = new JButton("Guardar");

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
        add(labelTareaRealizada, c);

        c.gridx = 1;
        c.gridy = 2;
        add(inputTareaRealizada, c);

        c.gridx = 2;
        c.gridy = 2;
        add(buttonMarcarHecho, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneAgenda, c);
        

        
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(buttonRegresar, c);
        
        c.gridx = 2;
        c.gridy = 3;
        add(buttonGuardar, c);

        // Agregar oyentes de eventos
        buttonAgregarTareas.addActionListener(this);
        buttonMarcarHecho.addActionListener(this);
        buttonRegresar.addActionListener(this);
        buttonGuardar.addActionListener(this);
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
                textAreaAgenda.append("Tarea " + (i + 1)+ ": " + agenda[i] + "\n");
}
} else if (e.getSource() == buttonMarcarHecho) {
String tareaRealizada = inputTareaRealizada.getText();
boolean tareaEncontrada = false;
      for (int i = 0; i < agenda.length; i++) {
          if (agenda[i].equals(tareaRealizada)) {
              agenda[i] = "Hecho: " + agenda[i];
              tareaEncontrada = true;
              break;
          }
      }

      if (tareaEncontrada) {
          textAreaAgenda.setText("Agenda actualizada\n");

          for (int i = 0; i < agenda.length; i++) {
              textAreaAgenda.append("Tarea " + (i + 1) + ": " + agenda[i] + "\n");
          }
      } else {
          JOptionPane.showMessageDialog(this, "La tarea no se encuentra en la agenda.");
      }
  } else if (e.getSource() == buttonRegresar) {
        InterfazPrincipal ip = new InterfazPrincipal(); // crea una instancia de InterfazPrincipal
        ip.setVisible(true); // muestra la ventana InterfazPrincipal
        dispose(); // cierra la ventana actual
    }
    else if (e.getSource() == buttonGuardar) {
        guardarAgenda();
        JOptionPane.showMessageDialog(this, "Agenda guardada en archivo agenda.txt");
    }
    

}

private void guardarAgenda() {
    try {
        FileWriter writer = new FileWriter("agenda.txt");
        for (int i = 0; i < agenda.length; i++) {
            writer.write(agenda[i] + "\n");
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
*/ //guardar
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Insets;

public class Lista extends JFrame implements ActionListener {
    private JLabel labelNombre;
    private JLabel labelTareas;
    private JLabel labelTareaRealizada;
    private JTextField inputNombre;
    private JTextField inputNumTareas;
    private JTextField inputTareaRealizada;
    private JButton buttonAgregarTareas;
    private JButton buttonMarcarHecho;
    private JTextArea textAreaAgenda;
    private JScrollPane scrollPaneAgenda;
    private JButton buttonRegresar;
    private JButton buttonGuardar;
    private JButton buttonConsultar;

    private String[] agenda;

    public Lista() {
        // Configuración de la ventana principal
        setTitle("Aplicación de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        labelNombre = new JLabel("Nombre:");
        labelTareas = new JLabel("Número de tareas:");
        labelTareaRealizada = new JLabel("Tarea realizada:");
        inputNombre = new JTextField(20);
        inputNumTareas = new JTextField(5);
        inputTareaRealizada = new JTextField(5);
        buttonAgregarTareas = new JButton("Agregar tareas");
        buttonMarcarHecho = new JButton("Marcar como hecho");
        textAreaAgenda = new JTextArea(10, 30);
        scrollPaneAgenda = new JScrollPane(textAreaAgenda);
        buttonRegresar = new JButton("Regresar");
        buttonGuardar = new JButton("Guardar");
        buttonConsultar = new JButton("Consultar");

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

        c.gridx = 2;
        c.gridy = 0;
        add(buttonConsultar, c);

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
        add(labelTareaRealizada, c);

        c.gridx = 1;
        c.gridy = 2;
        add(inputTareaRealizada, c);

        c.gridx = 2;
        c.gridy = 2;
        add(buttonMarcarHecho, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneAgenda, c);

        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(buttonRegresar, c);

        c.gridx =3;
        c.gridy = 4;
        add(buttonGuardar, c);
            // Configuración de los listeners
    buttonAgregarTareas.addActionListener(this);
    buttonMarcarHecho.addActionListener(this);
    buttonRegresar.addActionListener(this);
    buttonGuardar.addActionListener(this);
    buttonConsultar.addActionListener(this);

    // Inicialización del arreglo de tareas
    agenda = new String[0];
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonAgregarTareas) {
        String numTareasStr = inputNumTareas.getText();
        int numTareas = Integer.parseInt(numTareasStr);
        ArrayList<String> tareas = new ArrayList<String>();

        for (int i = 0; i < numTareas; i++) {
            String tarea = JOptionPane.showInputDialog(this, "Ingrese la tarea " + (i + 1));
            tareas.add(tarea);
        }

        // Agregar las tareas al arreglo
        String[] tempAgenda = new String[agenda.length + tareas.size()];
        System.arraycopy(agenda, 0, tempAgenda, 0, agenda.length);

        for (int i = 0; i < tareas.size(); i++) {
            tempAgenda[agenda.length + i] = tareas.get(i);
        }

        agenda = tempAgenda;

        // Mostrar las tareas en la interfaz
        textAreaAgenda.setText("");
        for (int i = 0; i < agenda.length; i++) {
            textAreaAgenda.append((i+1) + ". " + agenda[i] + "\n");
        }

    } else if (e.getSource() == buttonMarcarHecho) {
        String tareaRealizada = inputTareaRealizada.getText();
        boolean encontrado = false;

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i].equals(tareaRealizada)) {
                encontrado = true;
                agenda[i] += " (hecho)";
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró la tarea especificada");
        } else {
            // Mostrar las tareas en la interfaz
            textAreaAgenda.setText("");
            for (int i = 0; i < agenda.length; i++) {
                textAreaAgenda.append((i+1) + ". " + agenda[i] + "\n");
            }
        }

    } else if (e.getSource() == buttonRegresar) {
        InterfazPrincipal ip = new InterfazPrincipal(); // crea una instancia de InterfazPrincipal
        ip.setVisible(true); // muestra la ventana InterfazPrincipal
        dispose(); // cierra la ventana actual
    }
    else if (e.getSource() == buttonGuardar) {
        // Guardar las tareas en un archivo de texto
        String nombreArchivo = "tareas.txt";
        String nombre = inputNombre.getText();
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre");
        } else {
            try {
                FileWriter writer = new FileWriter(nombreArchivo, true);
                String tarea = nombre + ",";
                for (int i = 0; i < agenda.length; i++) {
                    tarea += agenda[i] + ",";
                }
                tarea = tarea.substring(0, tarea.length() - 1); // Eliminar última coma
                writer.write(tarea + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
            }
        }
    }
    
    
    else if (e.getSource() == buttonConsultar) {
        // Leer el archivo de texto
        String nombreArchivo = "tareas.txt";
        try {
            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);
            String nombre = inputNombre.getText();
            boolean encontrado = false;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes[0].equals(nombre)) {
                    String tareas = "";
                    for (int i = 1; i < partes.length; i++) {
                        tareas += partes[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(this, tareas);
                    encontrado = true;
                    break;
                }
            }
            scanner.close();
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "No se encontraron tareas para el nombre ingresado");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encontró el archivo");
        }
    }
}
}    