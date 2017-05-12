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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.japo.java.events.AEM;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {
    // Tamaño de la ventana
    public static final int VENTANA_ANC = 300;
    public static final int VENTANA_ALT = 200;
    
    // Referencia a componentes
    private JPanel pnlPpal;

    public GUI() {
        // Inicialización PREVIA
        beforeInit();

        // Creación del interfaz
        initComponents();

        // Inicialización POSTERIOR
        afterInit();
    }

    // Construcción del IGU
    private void initComponents() {
        // Fuente de texto
        String nombreFuente = "Calibri";
        int estiloFuente = Font.BOLD;
        int tallaFuente = 30;
        Font f = new Font(nombreFuente, estiloFuente, tallaFuente);

        // Gestor de eventos de acción
        AEM aem = new AEM(this);

        // Otros componentes
        JTextField txfColor = new JTextField();
        txfColor.setFont(f);
        txfColor.setColumns(10);
        txfColor.setHorizontalAlignment(JTextField.CENTER);
        txfColor.addActionListener(aem);
        
        // Panel Principal
        pnlPpal = new JPanel();
        pnlPpal.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlPpal.add(txfColor);
        
        // Ventana principal
        setTitle("Campo Texto Centrado");
        setContentPane(pnlPpal);
        setSize(VENTANA_ANC, VENTANA_ALT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    // Inicialización antes del IGU
    private void beforeInit() {

    }

    // Inicialización después del IGU
    private void afterInit() {

    }

    public void gestionarAceptarTexto(ActionEvent e) {
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
        }
        
        // Borrar el campo de texto
        txfActual.setText("");
    }

}
