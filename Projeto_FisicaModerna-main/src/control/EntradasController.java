/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;
import model.FuncaoDeOnda;
import view.EntradasMenu;
import view.MenuRespostas;

/**
 *
 * @author luana
 */
public class EntradasController {
    private EntradasMenu view;

    public EntradasController(EntradasMenu view) {
        this.view = view;
    }
    
    public FuncaoDeOnda guarda(){
        double largura = Double.parseDouble(view.getTxtEntradaLargura().getText());
        int ni = Integer.parseInt(view.getTxtEntradaNI().getText());
        int nf = Integer.parseInt(view.getTxtEntradaNF().getText());
        double pa = Double.parseDouble(view.getTxtEntradaProbA().getText());
        double pb = Double.parseDouble(view.getTxtEntradaProbB().getText());
        boolean massa;
        FuncaoDeOnda f = null;
            if(view.getBtjEletron().isSelected()){
                massa = true;
                if(pa>largura || pa<0 || pb>largura || pb<0){
                    JOptionPane.showMessageDialog(view,"Valores de probabilidade invalidos(fora da caixa)");
                }else{
                    f = new FuncaoDeOnda(largura,pa,pb,ni,nf,massa);
                    f.calculos();
                    MenuRespostas m = new MenuRespostas(f);
                    m.setVisible(true);
                    view.setVisible(false);
                    return f;
                }
            }else if(view.getBtjProton().isSelected()){
                massa = false; 
                if(pa>largura || pa<0 || pb>largura || pb<0){
                    JOptionPane.showMessageDialog(view,"Valores de probabilidade invalidos(fora da caixa)");
                }else{
                    f = new FuncaoDeOnda(largura,pa,pb,ni,nf,massa);
                    f.calculos();
                    MenuRespostas m = new MenuRespostas(f);
                    m.setVisible(true);
                    view.setVisible(false);
                    return f;
                }
        }else{
            JOptionPane.showMessageDialog(view,"Tipo de Particula não expecificado");
        }
        return f; 
    }
    
}
