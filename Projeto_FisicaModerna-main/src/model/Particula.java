/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.lang.Math;
import static java.lang.Math.sin;
/**
 *
 * @author beatr
 */
public class Particula {
    private double A, K, Xp;

    public Particula(double A, double K, double Xp) {
        this.A = A;
        this.K = K;
        this.Xp = Xp;
    }

    public ResultadosConta contas(double A, double K, double Xp){
        //largura da caixa
        double L = 2 / (Math.pow(A, 2)); 
        //nível quântico
        double n = Math.abs((K * L)/ Math.PI);
        int nArred = (int) Math.round(n);
        //probabilidade de encontrar a partícula na caixa
        double funcaoOnda = ((Math.pow(A, 2))*(Math.pow(Math.sin(K * Xp * L), 2))); // *L pois ta em funcao de L
        
        return new ResultadosConta(L, nArred, funcaoOnda);
        //System.out.println("Largura: "+ L + "\n" + "Numero quantico: " + nInt + "\n" + "Probabilidade: " + funcaoOnda);
    } 
}