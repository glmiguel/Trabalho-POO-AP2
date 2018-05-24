/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

/**
 *
 * @author Gabriel Luis Miguel da Silva
 */
public class Bandeja {

     // <editor-fold defaultstate="collapsed" desc="Atributos">
    
    private double valorFace;
    public int quantidadeCedula;
    private double saldo;
  
//</editor-fold>

     // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set">
    
    public double getValorFace() {
        return this.valorFace;
    }

    public int getQuantidadeCedula() {
        return this.quantidadeCedula;
    }

    public void setQuantidadeCedula(int quantidadeCedula) {
        this.quantidadeCedula = quantidadeCedula;
    }

    public void setvalorFace(double valorFace) {
        this.valorFace = valorFace;
    }

     //</editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Construtor">
    
    public Bandeja(double valorFace, int quantidadeCedula) {

        this.valorFace = valorFace;
        this.quantidadeCedula = quantidadeCedula;
        this.saldo = valorFace * quantidadeCedula;
    }
    
    //</editor-fold>

     // <editor-fold defaultstate="collapsed" desc="Metodo Saldo da Bandeja">
    
    public double saldoBandeja() {
        return this.saldo;
    }
    
    //</editor-fold>

     // <editor-fold defaultstate="collapsed" desc="Sacar da Bandeja">
    public void sacarBandeja(int quantidadeSacar) {

        quantidadeCedula -= quantidadeSacar;
        saldo = valorFace * quantidadeCedula;

    }
//</editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Metodo Recalcula o saldo da Bandeja">
    
    public void reCalculaSaldo() {

        this.saldo = valorFace * quantidadeCedula;
    }
//</editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Metodo Depositar na Bandeja">
    
    public void depositoBandeija(int quantidade) {

        this.quantidadeCedula += quantidade;
        this.saldo = valorFace * quantidadeCedula;
    }

    //</editor-fold>
    
}
