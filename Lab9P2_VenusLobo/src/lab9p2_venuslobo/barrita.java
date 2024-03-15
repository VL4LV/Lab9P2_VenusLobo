/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2_venuslobo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author ADMIN
 */
public class barrita extends Thread {

    private JProgressBar progBar;
    private File archivoSeleccionado;
    private JTextArea area_texto;
    private JFrame caller;

    public barrita(JProgressBar progBar, File archivoSeleccionado, JTextArea area_texto, JFrame caller) {
        this.progBar = progBar;
        this.archivoSeleccionado = archivoSeleccionado;
        this.area_texto = area_texto;
        this.caller = caller;
    }

    
    @Override
    public void run() {
        progBar.setStringPainted(true);
        progBar.setMaximum(100);
        progBar.setMinimum(0);

        try {
            // Crear un lector de archivos
            FileReader fr = new FileReader(archivoSeleccionado);
            BufferedReader br = new BufferedReader(fr);

            StringBuilder contenido = new StringBuilder();
            String linea;
            int x = 0;
            int y = 0;

            // Calcular el tamano del archivo
            while ((linea = br.readLine()) != null) {
                x += linea.length() + 1; 
            }

            // Volver a abrir el archivo
            fr = new FileReader(archivoSeleccionado);
            br = new BufferedReader(fr);

            
            progBar.setValue(0);
            // Leer el contenido del archivo
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
                y += linea.length() + 1; 

                int pro = (int) ((double) y / x * 100);
                progBar.setValue(pro);
                
                // tiempo de la barrita
                Thread.sleep(50);
            }

            // Cerrar el lector de archivos
            br.close();

            // Establecer el contenido en el JTextArea
            area_texto.setText(contenido.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(caller, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String leerArchivo(File archivoSeleccionado) {
        StringBuilder contenido = new StringBuilder();
        try {
            // Crear un lector de archivos
            FileReader fr = new FileReader(archivoSeleccionado);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            // Cerrar el lector de archivos
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }//FIN IF

}
