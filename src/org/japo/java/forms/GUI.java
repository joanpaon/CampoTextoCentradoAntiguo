/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.japo.java.events.AEM;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {

    // Propiedades App
    public static final String PRP_LOOK_AND_FEEL = "look_and_feel";
    public static final String PRP_FAVICON = "favicon";

    // Valores por Defecto
    public static final String DEF_LOOK_AND_FEEL = UtilesSwing.LNF_NIMBUS;
    public static final String DEF_FAVICON = "img/favicon.png";

    // Referencias
    private Properties prp;
    private JPanel pnlPpal;
    private JTextField txfColor;

    // Constructor
    public GUI(Properties prp) {
        // Inicialización Anterior
        initBefore(prp);

        // Creación Interfaz
        initComponents();

        // Inicializacion Posterior
        initAfter();
    }

    // Construcción del IGU
    private void initComponents() {
        // Campo de Texto
        txfColor = new JTextField();
        txfColor.setFont(new Font("Indie Flower", Font.BOLD, 30));
        txfColor.setColumns(10);
        txfColor.setHorizontalAlignment(JTextField.CENTER);
        txfColor.addActionListener(new AEM(this));

        // Panel Principal
        pnlPpal = new JPanel(new GridBagLayout());
        pnlPpal.add(txfColor);

        // Ventana principal
        setContentPane(pnlPpal);
        setTitle("Swing Manual #05");
        setResizable(false);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inicialización Anterior    
    private void initBefore(Properties prp) {
        // Memorizar Referencia
        this.prp = prp;

        // Establecer LnF
        UtilesSwing.establecerLnF(prp.getProperty(PRP_LOOK_AND_FEEL, DEF_LOOK_AND_FEEL));
    }

    // Inicialización Anterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty(PRP_FAVICON, DEF_FAVICON));
    }

    public void procesarTexto(ActionEvent e) {
        // Generador del evento
        JTextField txfActual = (JTextField) e.getSource();

        // Determinar el color
        switch (txfActual.getText().toUpperCase()) {
            case "BLANCO":
                pnlPpal.setBackground(Color.WHITE);
                break;
            case "NEGRO":
                pnlPpal.setBackground(Color.BLACK);
                break;
            case "ROJO":
                pnlPpal.setBackground(Color.RED);
                break;
            case "VERDE":
                pnlPpal.setBackground(Color.GREEN);
                break;
            case "AZUL":
                pnlPpal.setBackground(Color.BLUE);
                break;
            case "AMARILLO":
                pnlPpal.setBackground(Color.YELLOW);
                break;
            case "GRIS":
                pnlPpal.setBackground(Color.GRAY);
                break;
            case "ROSA":
                pnlPpal.setBackground(Color.PINK);
                break;
            case "TURQUESA":
                pnlPpal.setBackground(Color.CYAN);
                break;
            case "MAGENTA":
                pnlPpal.setBackground(Color.MAGENTA);
                break;
            case "NARANJA":
                pnlPpal.setBackground(Color.ORANGE);
                break;
            default:
                pnlPpal.setBackground(new Color(240, 240, 240));
        }

        // Borrar el campo de texto
        txfActual.setText("");
    }
}
