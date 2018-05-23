/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;


/**
 *
 * @author User
 */
import java.util.Collection;
import java.util.ArrayList;

public class Caixa4Bandejas extends Caixa implements ISacarComTroco {


    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private Bandeja b1, b2, b3, b4;
    private int[] quantidades = new int[4];
    
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get / SET">
    public int[] getQuantidades() {
        return quantidades;
    }

  
    public void setQuantidades(int[] quantidades) {
        this.quantidades = quantidades;
    }
    
      //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Construtor">
    public Caixa4Bandejas(String codigo, String bairro, String rua, String numero, String cidade, String estado, Bandeja gaveta1, Bandeja gaveta2, Bandeja gaveta3, Bandeja gaveta4) {
        super(codigo, bairro, rua, numero, cidade, estado);

        this.b1 = gaveta1;
        this.b2 = gaveta2;
        this.b3 = gaveta3;
        this.b4 = gaveta4;
        this.setSaldoCAIXA(b1.saldoBandeja() + b2.saldoBandeja() + b3.saldoBandeja() + b4.saldoBandeja());
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo Depositar Na Bandeja">
    public void depositarBandeja(Bandeja b1, int quantidade) {

        b1.depositoBandeija(quantidade);

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo Saldo do Caixa">
    @Override
    public double saldoTotal() {

        return this.getSaldoCixa();

    }
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo Verifica Saque">
    @Override
    public Boolean verificaSaque(double valorSaque) {
        if (valorSaque > 0 && valorSaque <= this.getSaldoCixa()) {

            this.sacarCaixa(valorSaque);

            double Controle = (getQuantidades()[0] * b1.getValorFace()) + (getQuantidades()[1] * b2.getValorFace()) + (getQuantidades()[2] * b3.getValorFace()) + (getQuantidades()[3] * b4.getValorFace());

            if (valorSaque - Controle == 0) {
                return true;
            } else {
                if (getQuantidades()[0] > 0) {
                    b1.depositoBandeija(getQuantidades()[0]);
                    b1.reCalculaSaldo();
                } else if (getQuantidades()[1] > 0) {
                    b2.depositoBandeija(getQuantidades()[1]);
                    b2.reCalculaSaldo();
                } else if (getQuantidades()[2] > 0) {
                    b3.depositoBandeija(getQuantidades()[2]);
                    b3.reCalculaSaldo();
                } else if (getQuantidades()[3] > 0) {
                    b4.depositoBandeija(getQuantidades()[3]);
                    b4.reCalculaSaldo();
                }
                return false;
            }
        }
        return false;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodo Sacar">
    @Override
    public void sacarCaixa(double valor) {

        this.zeraQauntidades();

        while (valor >= b1.getValorFace() && b1.getQuantidadeCedula() > 0) {
            valor -= b1.getValorFace();
            b1.quantidadeCedula--;
            getQuantidades()[0]++;
           // saldoCaixa -= b1.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b1.getValorFace());

        }

        while (valor >= b2.getValorFace() && b2.quantidadeCedula > 0) {
            valor -= b2.getValorFace();
            b2.quantidadeCedula--;
            getQuantidades()[1]++;
            //saldoCaixa -= b2.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b2.getValorFace());
        }

        while (valor >= b3.getValorFace() && b3.quantidadeCedula > 0) {
            valor -= b3.getValorFace();
            b3.quantidadeCedula--;
            getQuantidades()[2]++;
            //saldoCaixa -= b3.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b3.getValorFace());
        }

        while (valor >= b4.getValorFace() && b4.quantidadeCedula > 0) {
            valor -= b4.getValorFace();
            b4.quantidadeCedula--;
            getQuantidades()[3]++;
            //saldoCaixa -= b4.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b4.getValorFace());

        }

        b1.reCalculaSaldo();
        b2.reCalculaSaldo();
        b3.reCalculaSaldo();
        b4.reCalculaSaldo();

    }

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodo Sacar com Troco">  
    @Override
    public void sacarTroco(double valor) {

        this.zeraQauntidades();

        // sacar com troco 
        // Exemplo quero sacar 500 Reais , mais nao quero so notas de 100
        
        
        for (int i = 0; i < 1; i++) {
            if (valor >= b1.getValorFace() && b1.quantidadeCedula > 0) {
                valor -= b1.getValorFace();
                b1.quantidadeCedula--;
                getQuantidades()[0]++;
               // saldoCaixa -= b1.getValorFace();
               this.setSaldoCAIXA(this.getSaldoCixa() - b1.getValorFace());
            }
        }

        for (int i = 0; i < 1; i++) {
            if (valor >= b2.getValorFace() && b2.quantidadeCedula > 0) {
                valor -= b2.getValorFace();
                b2.quantidadeCedula--;
                getQuantidades()[1]++;
               // saldoCaixa -= b2.getValorFace();
               this.setSaldoCAIXA(this.getSaldoCixa() - b2.getValorFace());
            }
        }

        for (int i = 0; i < 1; i++) {
            if (valor >= b3.getValorFace() && b3.quantidadeCedula > 0) {
                valor -= b3.getValorFace();
                b3.quantidadeCedula--;
                getQuantidades()[2]++;
               // saldoCaixa -= b3.getValorFace();
               this.setSaldoCAIXA(this.getSaldoCixa() - b3.getValorFace());
            }
        }

        for (int i = 0; i < 1; i++) {
            if (valor >= b4.getValorFace() && b4.quantidadeCedula > 0) {
                valor -= b4.getValorFace();
                b4.quantidadeCedula--;
                getQuantidades()[3]++;
                //saldoCaixa -= b4.getValorFace();
                this.setSaldoCAIXA(this.getSaldoCixa() - b4.getValorFace());
            }
        }

        while (valor >= b1.getValorFace() && b1.quantidadeCedula > 0) {
            valor -= b1.getValorFace();
            b1.quantidadeCedula--;
            getQuantidades()[0]++;
          //  saldoCaixa -= b1.getValorFace();
          this.setSaldoCAIXA(this.getSaldoCixa() - b1.getValorFace());
        }

        while (valor >= b2.getValorFace() && b2.quantidadeCedula > 0) {
            valor -= b2.getValorFace();
            b2.quantidadeCedula--;
            getQuantidades()[1]++;
           // saldoCaixa -= b2.getValorFace();
           this.setSaldoCAIXA(this.getSaldoCixa() - b2.getValorFace());
        }

        while (valor >= b3.getValorFace() && b3.quantidadeCedula > 0) {
            valor -= b3.getValorFace();
            b3.quantidadeCedula--;
            getQuantidades()[2]++;
            //saldoCaixa -= b3.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b3.getValorFace());
        }

        while (valor >= b4.getValorFace() && b4.quantidadeCedula > 0) {
            valor -= b4.getValorFace();
            b4.quantidadeCedula--;
            getQuantidades()[3]++;
            //saldoCaixa -= b4.getValorFace();
            this.setSaldoCAIXA(this.getSaldoCixa() - b4.getValorFace());

        }

        b1.reCalculaSaldo();
        b2.reCalculaSaldo();
        b3.reCalculaSaldo();
        b4.reCalculaSaldo();

    }

//</editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="Zera Array Quantidades">
    private void zeraQauntidades() {
        for (int i = 0; i < getQuantidades().length; i++) {
            this.getQuantidades()[i] = 0;
        }

    }
//</editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Metodo Saldo da Bandeja">
    public double saldoBandeja(Bandeja b1) {

        return b1.saldoBandeja();

    }
//</editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Metodo Verifica Saque com Troco">
    @Override
    public Boolean verificaSacarTroco(double valorSaque) {
        if (valorSaque > 0 && valorSaque <= this.getSaldoCixa()) {

            this.sacarTroco(valorSaque);

            double Controle = (getQuantidades()[0] * b1.getValorFace()) + (getQuantidades()[1] * b2.getValorFace()) + (getQuantidades()[2] * b3.getValorFace()) + (getQuantidades()[3] * b4.getValorFace());

            if (valorSaque - Controle == 0) {
                return true;
            } else {
                 if(getQuantidades()[0] > 0) {
                    b1.depositoBandeija(getQuantidades()[0]);
                    b1.reCalculaSaldo(); }
                else if (getQuantidades()[1] > 0) {
                    b2.depositoBandeija(getQuantidades()[1]);
                    b2.reCalculaSaldo(); }
                else if (getQuantidades()[2] > 0) {
                    b3.depositoBandeija(getQuantidades()[2]);
                    b3.reCalculaSaldo(); }
                else if (getQuantidades()[3] > 0) {
                    b4.depositoBandeija(getQuantidades()[3]);
                    b4.reCalculaSaldo(); }
                return false;
            }
        }
        return false;
    }
    //</editor-fold>  
}
