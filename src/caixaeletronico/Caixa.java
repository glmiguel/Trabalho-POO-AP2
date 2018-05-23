/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;
public abstract class Caixa {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    
    private String codigo;
    private String bairro;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private double saldoCaixa;
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos GET e SET">
    
    public String getCodigo() {
        return this.codigo;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }
    
    public void setSaldoCAIXA(double saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }

    public double getSaldoCixa() {
        return this.saldoCaixa;
    }
    
    
    
        //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Construtor">
    public Caixa(String codigo, String bairro, String rua, String numero, String cidade, String estado) {

        this.codigo = codigo;
        this.bairro = bairro;
        this.codigo = codigo;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;

    }
 //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Abstratos">
   
    public abstract void sacarCaixa(double valor);

    public abstract double saldoTotal();

    public abstract Boolean verificaSaque(double valorSaque);
    
    //</editor-fold>

}
