/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador implements ActionListener{
    private Vista view;
    private Modelo model;
    
    public Controlador(Vista view, Modelo model){
        this.view = view;
        this.model = model;
        this.view.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("API CALL");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println("Hello World!");
        model.setBusqueda(view.txtBusqueda.getText());
        try {
            model.buscar();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.txtResultado.setText(model.getRespuesta());
    }
}
