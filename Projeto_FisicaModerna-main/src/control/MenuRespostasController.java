/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Dimension;
import javax.swing.JFrame;
import model.FuncaoDeOnda;
import view.MenuRespostas;
import view.Respostas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author luana
 */
public class MenuRespostasController {
    private MenuRespostas view;
    private FuncaoDeOnda dados;

    public MenuRespostasController(MenuRespostas view, FuncaoDeOnda dados) {
        this.view = view;
        this.dados = dados;
    }
    
    public void botaoA(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("a)");
        r.getLblResposta().setText("ψi(x) = " + 
                String.format("%.3E",dados.getA()) + "*sen(" + 
                String.format("%.3E",dados.getkI()) + "*X)");
        r.getLblResposta1().setText("ψf(x) = " + 
                String.format("%.3E",dados.getA()) + "*sen(" + 
                String.format("%.3E",dados.getkF()) + "*X)");
        r.getLblJustificativa().setText("<html> Para conseguirmos a função de "
                + "onda com as informações dadas apenas<br>substituimos as entradas"
                + " na formula ψ(x)= √(2/L)*sen(k*x), onde k é n*pi/L.");
        r.setVisible(true);
        view.setVisible(false);
    }
    public void botaoB(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("b)");
        String eij = String.format("%.3E",dados.getEnergiaIJ());
        r.getLblResposta().setText("<html>E(n" + dados.getNi() + ") = " + 
                eij + "J<br>" + "E(n" + dados.getNi() + ") = " + 
                String.format("%.3E", dados.getEnergiaIeV()) + "ev");
        r.getLblResposta1().setText("<html>E(n" + dados.getNf() + ") = " + 
                String.format("%.3E",dados.getEnergiaFJ()) + "J<br>" + "E(n" + dados.getNf() + ") = " + 
                String.format("%.3E", dados.getEnergiaFeV()) + "ev");
        r.getLblJustificativa().setText("<html> Valores conseguidos a partir da formula"
                + "(h²/8*m*L²)*n², onde h é uma contante que em jaule tem o valor de"
                + " 6.626e-34, e m é a massa da particula.");
        r.setVisible(true);
        view.setVisible(false);
    }
    
    public void botaoC(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("c)");
        r.getLblResposta().setText("Houve uma " + dados.getFoton() + 
                ", onde o Foton teria energia igual a " + 
                String.format("%.3E", dados.geteFoton()) + "ev");
        r.getLblResposta1().setText("<html>A frequencia desse foton será de " + 
                String.format("%.3E", dados.getfFoton()) + "Hz<br> e seu lambda será " +
                String.format("%.3E", dados.getLambdaFoton()) + "m");
        r.getLblJustificativa().setText("<html>O valor da energia foi alcançado "
                + "fazendo a energia final menos a inicial, ja a frequencia "
                + "pela formula EnergiaFoton/h, e o lambda pela formula c*h/EnergiaFoton,"
                + "onde c é a velocida da luz (3e8) e h é uma constante que tem o valor de 4.136e-15 em ev");
        r.setVisible(true);
        view.setVisible(false);
    }
    
    public void botaoD(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("d)");
        r.getLblResposta().setText("V(n" + dados.getNi() + ") = " + String.format("%.3E", 
                dados.getVelocidadeI()) + "m/s");
        r.getLblResposta1().setText("V(n" + dados.getNf() + ") = " + String.format("%.3E", 
                dados.getVelocidadeF()) + "m/s");
        r.getLblJustificativa().setText("<html> Tal resultado foi alcançado "
                + "usando a formula k = m*v²/2, pois quando a particula esta "
                + "confinada na caixa sua unica energia é a cinética(k), "
                + "assim podemos substituir o k da formula na Energia da particula.");
        r.setVisible(true);
        view.setVisible(false);
    }
    
    public void botaoE(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("e)");
        r.getLblResposta().setText("𝜆(n" + dados.getNi() + ") = " + String.format("%.3E", 
                dados.getLambdaBrolieI()) + "m");
        r.getLblResposta1().setText("𝜆(n" + dados.getNf() + ") = " + String.format("%.3E", 
                dados.getLambdaBrolieF()) + "m");
        r.getLblJustificativa().setText("<html> Valores alcançados pela formula"
                + " 2*L/n");
        r.setVisible(true);
        view.setVisible(false);
    }
    
    public void botaoF(){
        Respostas r = new Respostas(dados);
        r.getLblAlternativa().setText("f)");
        r.getLblResposta().setText("P(n" + dados.getNi() + ") = " + String.format("%.3f", 
                dados.getProbabilidadePorcentagemI()) + "%");
        r.getLblResposta1().setText("P(n" + dados.getNf() + ") = " + String.format("%.3f", 
                dados.getProbabilidadePorcentagemF()) + "%");
        r.getLblJustificativa().setText("<html> Valores alcançados ao fazer a "
                + "integral definida da função de onda ao quadrado, estando "
                + "definida pelo valor de b e a");
        r.setVisible(true);
        view.setVisible(false);
    }
    
    public void botaoG(){
        // Criar os dados da função
        XYSeries series = new XYSeries("Função");
        for (double x = 0; x <= dados.getL(); x += 0.001e-9) {
            series.add(x,dados.getA()*Math.sin(dados.getkI()*x)); 
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Criar o gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Função de Onda n = " + dados.getNi(),
                "x(m)",
                "ψi(x)",
                dataset
        );
        
        XYPlot plot = (XYPlot) chart.getPlot();
        // Definir o zoom inicial para os eixos X e Y
        plot.getDomainAxis().setRange(0, dados.getL()); // Zoom no eixo X
//        plot.getRangeAxis().setRange(-1, 1); // Zoom no eixo Y

        // Criar um painel de gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        // Criar uma nova janela para o gráfico
        JFrame frame = new JFrame("Gráfico de Função de Onda");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void botaoH(){
        // Criar os dados da função
        XYSeries series = new XYSeries("Função");
        for (double x = 0; x <= dados.getL(); x += 0.001e-9) {
            series.add(x,dados.getA()*Math.sin(dados.getkF()*x)); 
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Criar o gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Função de Onda n = " + dados.getNf(),
                "x(m)",
                "ψi(x)",
                dataset
        );
        
        XYPlot plot = (XYPlot) chart.getPlot();
        // Definir o zoom inicial para os eixos X e Y
        plot.getDomainAxis().setRange(0, dados.getL()); // Zoom no eixo X

        // Criar um painel de gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        // Criar uma nova janela para o gráfico
        JFrame frame = new JFrame("Gráfico de Função de Onda");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void botaoI(){
        // Criar os dados da função
        XYSeries series = new XYSeries("Função");
        for (double x = 0; x <= dados.getL(); x += 0.001e-9) {
            series.add(x,Math.pow(dados.getA()*Math.sin(dados.getkI()*x),2)); 
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Criar o gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico da função distribuição de probabilidade n = " + dados.getNi(),
                "x(m)",
                "|ψi(x)|²",
                dataset
        );
        
        XYPlot plot = (XYPlot) chart.getPlot();
        // Definir o zoom inicial para os eixos X e Y
        plot.getDomainAxis().setRange(0, dados.getL()); // Zoom no eixo X

        // Criar um painel de gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        // Criar uma nova janela para o gráfico
        JFrame frame = new JFrame("Gráfico da função distribuição de probabilidade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void botaoJ(){
        // Criar os dados da função
        XYSeries series = new XYSeries("Função");
        for (double x = 0; x <= dados.getL(); x += 0.001e-9) {
            series.add(x,Math.pow(dados.getA()*Math.sin(dados.getkF()*x),2)); 
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Criar o gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico da função distribuição de probabilidade n = " + dados.getNf(),
                "x(m)",
                "|ψi(x)|²",
                dataset
        );
        
        XYPlot plot = (XYPlot) chart.getPlot();
        // Definir o zoom inicial para os eixos X e Y
        plot.getDomainAxis().setRange(0, dados.getL()); // Zoom no eixo X

        // Criar um painel de gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        // Criar uma nova janela para o gráfico
        JFrame frame = new JFrame("Gráfico da função distribuição de probabilidade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
   
    
}
