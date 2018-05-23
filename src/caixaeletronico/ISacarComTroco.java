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
public interface ISacarComTroco {

    //Deve ser uma interface pois se surgirem Caixas com 1 bandeja so com notas de 100 ou Caixas com 2 bandejas 
    // Somente com notas de 100 e 50 nao faz muito sentido utilizar o sacar com troco pois nao teram notas trocadas 
    
    void sacarTroco(double valor);

    Boolean verificaSacarTroco(double valor);

}
