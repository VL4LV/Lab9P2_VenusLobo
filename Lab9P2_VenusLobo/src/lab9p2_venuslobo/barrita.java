/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2_venuslobo;

import javax.swing.JProgressBar;

/**
 *
 * @author ADMIN
 */
public class barrita extends Thread{
    private JProgressBar progBar;
    private boolean avanzar;
    private boolean vive;

    public barrita(JProgressBar progBar) {
        this.progBar = progBar;
        avanzar = true;
        vive = true;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public void setVida(boolean vive) {
        this.vive = vive;
    }

    @Override
    public void run() {
        while (vive) {
            if (avanzar) {
                progBar.setValue(progBar.getValue() + 1);
                //activar y modificar propiedad stringPainted para que esto funciones
                progBar.setString(Integer.toString(progBar.getValue()) + " Minutos");

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }

    }
    
}
