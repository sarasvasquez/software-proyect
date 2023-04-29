import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Insets;

public class InterfazPrincipal extends JFrame implements ActionListener {
    private JButton buttonForo;
    private JButton buttonLista;
    private JButton buttonPlantas;

    public InterfazPrincipal() {
        // Configuración de la ventana principal
        setTitle("Interfaz Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes de la interfaz
        buttonForo = new JButton("Foro");
        buttonLista = new JButton("Lista");
        buttonPlantas = new JButton("Plantas");

        // Configuración del diseño de la interfaz
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(buttonForo, c);

        c.gridx = 0;
        c.gridy = 1;
        add(buttonLista, c);

        c.gridx = 0;
        c.gridy = 2;
        add(buttonPlantas, c);

        // Agregar oyentes de eventos
        buttonForo.addActionListener(this);
        buttonLista.addActionListener(this);
        buttonPlantas.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonForo) {
            foro f = new foro();
            f.setVisible(true);
            dispose();
        } else if (e.getSource() == buttonLista) {
            Lista l = new Lista();
            l.setVisible(true);
            dispose();
        } else if (e.getSource() == buttonPlantas) {
            PlantasGUI j = new PlantasGUI();
            j.setVisible(true);
            dispose();
        }
    }
    
}
