/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author beatr
 */
//para fazer meotodo contas() retornar mais de um valor:
public class ResultadosConta {
    private double largura;
    private int nivelQuantico;
    private double probabilidade;

    public ResultadosConta(double largura, int nivelQuantico, double probabilidade) {
        this.largura = largura;
        this.nivelQuantico = nivelQuantico;
        this.probabilidade = probabilidade;
    }    

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public int getNivelQuantico() {
        return nivelQuantico;
    }

    public void setNivelQuantico(int nivelQuantico) {
        this.nivelQuantico = nivelQuantico;
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(double probabilidade) {
        this.probabilidade = probabilidade;
    }
    
}
