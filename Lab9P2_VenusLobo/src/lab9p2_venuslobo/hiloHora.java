/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2_venuslobo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class hiloHora implements Runnable{

    private JLabel hora;

    public hiloHora(JLabel hora) {
        this.hora = hora;
    }

    @Override
    public void run() {
        while (true) {
            Date h = new Date();
            DateFormat f = new SimpleDateFormat("hh:mm:ss");
            hora.setText(f.format(h));
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }
        }
    }

}
