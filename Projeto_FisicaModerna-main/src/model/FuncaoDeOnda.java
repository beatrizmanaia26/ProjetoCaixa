/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luana
 */
public class FuncaoDeOnda {
    private double l,pa,pb;
    private String funcaoOndaI, funcaoOndaF;
    private int ni, nf;
    private String foton;
    private double massa;
    private double energiaIJ, energiaFJ, energiaIeV, energiaFeV,eFoton,
            fFoton,lambdaFoton,velocidadeI,velocidadeF, lambdaBrolieI, 
            lambdaBrolieF, kI,kF, a, probabilidadePorcentagemI, 
            probabilidadePorcentagemF;
    private double h_j = 6.626e-34;
    private double h_ev = 4.136e-15;

    public FuncaoDeOnda(double l, double pa, double pb, int ni, int nf,boolean qualMassa) {
        this.l = l;
        this.pa = pa;
        this.pb = pb;
        this.ni = ni;
        this.nf = nf;
        if(qualMassa == true){
            this.massa = 9.11e-31;//eletron
        }else{
            this.massa = 1.673e-27;//proton
        }
        a = Math.sqrt(2/l);//l não pode ser 0;
        kI = ni*Math.PI/l;
        kF = nf*Math.PI/l;
        if(nf>ni){
            foton = "Absorção";
        }else{
            foton = "Emissão";
        }
        
    }

    public String getFoton() {
        return foton;
    }
    
    public double getMassa() {
        return massa;
    }
    public void setMassa(double massa) {
        this.massa = massa;
    }
    public double getL() {
        return l;
    }
    public void setL(double l) {
        this.l = l;
    }
    public double getPa() {
        return pa;
    }
    public void setPa(double pa) {
        this.pa = pa;
    }
    public double getPb() {
        return pb;
    }
    public void setPb(double pb) {
        this.pb = pb;
    }
    public int getNi() {
        return ni;
    }
    public void setNi(int ni) {
        this.ni = ni;
    }
    public int getNf() {
        return nf;
    }
    public void setNf(int nf) {
        this.nf = nf;
    }

    public void fucaoOnda(){
        funcaoOndaI = "ψi(x) = " + a + 
                ".sen(" + kI + ".X)";
        funcaoOndaF = "ψf(x) = " +
                a + ".sen(" + kF + ".X)";
    }

    public String getFuncaoOndaI() {
        return funcaoOndaI;
    }
    
    public String getFuncaoOndaF() {
        return funcaoOndaF;
    }

    public double getEnergiaIJ() {
        return energiaIJ;
    }

    public double getEnergiaFJ() {
        return energiaFJ;
    }

    public double getEnergiaIeV() {
        return energiaIeV;
    }

    public double getEnergiaFeV() {
        return energiaFeV;
    }

    public double geteFoton() {
        return eFoton;
    }

    public double getfFoton() {
        return fFoton;
    }

    public double getLambdaFoton() {
        return lambdaFoton;
    }

    public double getVelocidadeI() {
        return velocidadeI;
    }

    public double getVelocidadeF() {
        return velocidadeF;
    }

    public double getLambdaBrolieI() {
        return lambdaBrolieI;
    }

    public double getLambdaBrolieF() {
        return lambdaBrolieF;
    }

    public double getkI() {
        return kI;
    }

    public double getkF() {
        return kF;
    }

    public double getA() {
        return a;
    }

    public double getProbabilidadePorcentagemI() {
        return probabilidadePorcentagemI;
    }

    public double getProbabilidadePorcentagemF() {
        return probabilidadePorcentagemF;
    }

    public double getH_j() {
        return h_j;
    }

    public double getH_ev() {
        return h_ev;
    }
    
    
    public void calculoEnergias(){
        energiaIJ = (Math.pow(h_j, 2)/(8*massa*Math.pow(l, 2)))*Math.pow(ni,2);
        energiaFJ = (Math.pow(h_j, 2)/(8*massa*Math.pow(l, 2)))*Math.pow(nf,2);
        energiaIeV =energiaIJ/1.602e-19;
        energiaFeV =energiaFJ/1.602e-19;
        
//        System.out.println("JAULE");
//        System.out.println(energiaIJ);
//        System.out.println(energiaFJ);
//        System.out.println("EV");
//        System.out.println(energiaIeV);
//        System.out.println(energiaFeV);
    }
    public void calculoFoton(){
        eFoton = Math.abs(energiaFeV) - Math.abs(energiaIeV);
        fFoton =eFoton/h_ev;
        lambdaFoton = 3e8*h_ev/eFoton;
        
//        System.out.println("Foton");
//        System.out.println(eFoton);
//        System.out.println(fFoton);
//        System.out.println(lambdaFoton);
    }
    public void calculoVelocidade(){
        velocidadeI = Math.sqrt(energiaIJ*2/massa);
        velocidadeF = Math.sqrt(energiaFJ*2/massa);
        
//        System.out.println("Velocidade");
//        System.out.println(velocidadeI);
//        System.out.println(velocidadeF);
        
    }
    public void calculoLambdaBrolie(){
        lambdaBrolieI = 2*l/ni;
        lambdaBrolieF = 2*l/nf;
        
//        System.out.println("Lambda");
//        System.out.println(lambdaBrolieI);
//        System.out.println(lambdaBrolieF);
    }
    public void calculoProbabilidade(){
        double deltaAi = ((ni*Math.PI)/l)*pa;
        double deltaBi = ((ni*Math.PI)/l)*pb;
        double deltaAf = ((nf*Math.PI)/l)*pa;
        double deltaBf = ((nf*Math.PI)/l)*pb;
        probabilidadePorcentagemI = 100*(((2/(Math.PI*ni))*(0.5*deltaBi - 
                0.25*(Math.sin(2*deltaBi))))-((2/(Math.PI*ni))*(0.5*deltaAi - 
                0.25*(Math.sin(2*deltaAi)))));
        probabilidadePorcentagemF = 100*(((2/(Math.PI*nf))*(0.5*deltaBf - 
                0.25*(Math.sin(2*deltaBf))))-((2/(Math.PI*nf))*(0.5*deltaAf - 
                0.25*(Math.sin(2*deltaAf)))));
        
//        System.out.println("Probabilidade");
//        System.out.println(probabilidadePorcentagemI);
//        System.out.println(probabilidadePorcentagemF);
    }
    
    public void calculos(){
        this.calculoEnergias();
        this.calculoFoton();
        this.calculoLambdaBrolie();
        this.calculoProbabilidade();
        this.calculoVelocidade();
        this.fucaoOnda();
    }

//    @Override
//    public String toString() {
//        return "FuncaoDeOnda{" + "l=" + l + ", pa=" + pa + ", pb=" + pb + ", funcaoOnda=" + funcaoOnda + ", ni=" + ni + ", nf=" + nf + ", massa=" + massa + ", energiaIJ=" + energiaIJ + ", energiaFJ=" + energiaFJ + ", energiaIeV=" + energiaIeV + ", energiaFeV=" + energiaFeV + ", eFoton=" + eFoton + ", fFoton=" + fFoton + ", lambdaFoton=" + lambdaFoton + ", velocidadeI=" + velocidadeI + ", velocidadeF=" + velocidadeF + ", lambdaBrolieI=" + lambdaBrolieI + ", lambdaBrolieF=" + lambdaBrolieF + ", kI=" + kI + ", kF=" + kF + ", a=" + a + ", probabilidadePorcentagemI=" + probabilidadePorcentagemI + ", probabilidadePorcentagemF=" + probabilidadePorcentagemF + ", h_j=" + h_j + ", h_ev=" + h_ev + '}';
//    }
    
   
    
    
}
