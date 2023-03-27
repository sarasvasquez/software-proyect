import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    }

    public void actionPerformed(ActionEvent e) {
        String mensaje = "";

        if (e.getSource() == botonRosal) {
            mensaje += "Rosal\n";
            mensaje += "• En maceta regarlo cada día en verano y cada tres días en los meses fríos.\n";
            mensaje += "• El control de plagas eficaz es rápido y simple con insecticidas comprobados de la marca Sevin®\n";
            mensaje += "• Los rosales son las plantas de exterior más bonitas.";
        } else if (e.getSource() == botonAveDeParaiso) {
            mensaje += "Ave de paraíso\n";
            mensaje += "• El riego es moderado en verano, necesita agua 1 o 2 veces por semana. Es recomendable siempre esperar a que la superficie de la tierra esté totalmente seca antes de volver a regar.\n";
            mensaje += "• Cualquier plaga de ave del paraíso grande, como las orugas y los caracoles, se puede eliminar a mano. Los pulgones se pueden eliminar de la planta con un rocío constante de agua. Las escamas y las cochinillas se pueden eliminar con alcohol.\n";
            mensaje += "• Esta planta tropical vive bien tanto en interior como en exterior.";
        } else if (e.getSource() == botonAnturio) {
            mensaje += "Anturio\n";
            mensaje += "• Se debe regar cada 4-5 días y pulverizar las hojas con agua en un ambiente cálido y seco.\n";
            mensaje += "• El control de plagas es importante para la salud de la planta. Es recomendable aplicar un insecticida suave en caso de necesidad.\n";
            mensaje += "• El anturio es una planta de interior o exterior, pero debe mantenerse en un lugar con luz indirecta y evitar la exposición directa al sol.";
        }
        textAreaInfo.setText(mensaje);
    }
    
    public static void main(String[] args) {
        PlantasGUI gui = new PlantasGUI();
        gui.setVisible(true);
    }
}    