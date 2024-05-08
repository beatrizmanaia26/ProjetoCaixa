/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.*;
import model.FuncaoDeOnda;

/**
 *
 * @author luana
 */
public class Visao extends javax.swing.JFrame implements ActionListener{
    private FuncaoDeOnda dados;

    /**
     * Creates new form Visao
     */
    public Visao(FuncaoDeOnda f) {
        initComponents();
        setLocationRelativeTo(null);
        dados = f;
        timer = new Timer(30, this);
        timer.start();
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       if(xBola >= 800 || xBola<100){
           xVelocidadeBola = xVelocidadeBola * -1;
           contador += 1;
       }
       
       xFoton += velocidadeFoton;
       yFoton += yVelocidadeFoton;
       xBola += xVelocidadeBola;
       yEmissao = yBola;
       yEmissao -=yVelocidadeEmissao;
       repaint();
    }
     public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) buffer.getGraphics();
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
            if( yBola == yFoton){
                yFoton = 1000;
                yBola = 40;
                xVelocidadeBola = 50;
                contador = 0;
                contadorFoton +=1;
  
            }
            if(contador == 2 ){
 
                switch (yBola) {
                 
                         
                case 440:
                    yBola = 440;
                    yFoton = 0;
                    xFoton = 0;
                    if(contadorFoton == 1){
                        velocidadeFoton = 6;
                    }
                    if(contadorFoton == 2){
                        velocidadeFoton = 4;
                    }
                    break;
                case 340:
                    yBola += 100;
                    g2d.setPaint(Color.black);
                    g2d.drawLine(xBola, yBola, xBola+60, yBola-200);
                    xVelocidadeBola -= 3;
                    contador = 0;
                    break;
                default:
                    yBola += 100;
                    g2d.setPaint(Color.black);
                    g2d.drawLine(xBola, yBola, xBola+60, yBola-200);
                    xVelocidadeBola -=15;
                    contador = 0;
                    break;
                }
                if(contadorFoton == 2){
                    yBola = 440;
                    g2d.setPaint(Color.black);
                    g2d.drawLine(xBola, yBola, xBola+60, yBola-200);
                    xVelocidadeBola = 2;
                    contador = 0;
                }
                if(contadorFoton == 3){
                    yBola += 100;
                    xVelocidadeBola -= 30;
                 
                    if(yBola == 440){
                        xVelocidadeBola = 2;
                        yBola = 440;
                        contador = 40;
                    }
                }

          
            }

           double e = dados.geteFoton();
           double l = dados.getL();
           g2d.setPaint(Color.pink);
           g2d.setStroke(new BasicStroke(5));
           g2d.drawLine(100, 450, 800, 450);
           g2d.setPaint(Color.black);
           g2d.drawString(Double.toString(e - 0.4),70, 450);
           g2d.setPaint(Color.cyan);
           g2d.drawLine(100, 350, 800, 350);
           g2d.setPaint(Color.black);
           g2d.drawString(Double.toString(e-0.3), 70, 350);
           g2d.setPaint(Color.red);
           g2d.drawLine(100, 250, 800, 250);
           g2d.setPaint(Color.black);
           g2d.drawString("e(EV)", 40, 230);
           g2d.drawString(Double.toString(e-0.2), 70, 250);
           g2d.setPaint(Color.yellow);
           g2d.drawLine(100, 150,800,150);
           g2d.setPaint(Color.black);
           g2d.drawString(Double.toString(e-0.1), 70, 150);
           g2d.setPaint(Color.magenta);
           g2d.drawLine(100, 50, 800, 50);
           g2d.setPaint(Color.black);
           g2d.drawString(Double.toString(e), 70, 50);
           g2d.drawString("x(m)", 425 ,500 );
           g2d.fillOval(xBola, yBola, 20, 20);
           g2d.drawOval(xFoton, yFoton, 20,20);

           g2d.drawString("E5", 810, 50 );
           g2d.drawString("E4", 810, 150);
           g2d.drawString("E3", 810, 250);
           g2d.drawString("E2", 810, 350);
           g2d.drawString("E1", 810, 450);
           g2d.drawString(Double.toString(l-5), 120, 480);
           g2d.drawString(Double.toString(l-4), 236, 480);
           g2d.drawString(Double.toString(l-3), 352, 480);
           g2d.drawString(Double.toString(l-2), 468, 480);
           g2d.drawString(Double.toString(l-1), 584, 480);
           g2d.drawString(Double.toString(l), 690, 480);

           g.drawImage(buffer,0,0,this);
          
    }
    

    /**
     * @param args the command line arguments
     */
    private int xEmissao;
    private BufferedImage buffer;
    private Image foton;
    private int velocidadeFoton = 2;
    private int yVelocidadeFoton = 4;
    private int yEmissao;
    private int yVelocidadeEmissao = 20;
    private int xFoton = 0;
    private int yFoton = 0;
    private int xBola = 100;
    private int yBola = 440;
    private int xVelocidadeBola = 1;
    private Timer timer;
    private Graphics g;
    private Graphics2D g2d = (Graphics2D) g;
    private int contador = 0;
    private int contadorFoton = 0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(830, 510));
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Visao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Visao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Visao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Visao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Visao().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
