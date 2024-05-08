/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import model.Particula;
import view.Caixa;
import view.ResultadosFuncaoOnda;

/**
 *
 * @author beatr
 */
public class ControllerCaixa {
    private Caixa view;
    private double L, probabilidade;
    private int n;
    

    public ControllerCaixa(Caixa view) {
        this.view = view;
    }
    public void valores(){
 
       double A = Double.parseDouble(view.getTxtA().getText());
       double K = Double.parseDouble(view.getTxtK().getText());
       double Xp = Double.parseDouble(view.getTxtXp().getText());
       Particula p = new Particula(A, K, Xp);
       
       ResultadosFuncaoOnda res = new ResultadosFuncaoOnda();
       res.setVisible(true);
       res.getTxtResultadoL().setText(String.format("%.3E",p.contas(A, K, Xp).getLargura()));
       res.getTxtResultadoN().setText(String.valueOf(p.contas(A, K, Xp).getNivelQuantico()));
       res.getTxtResultadoProb().setText(String.format("%.3E", p.contas(A, K, Xp).getProbabilidade()));
       view.setVisible(false);
    }
}
