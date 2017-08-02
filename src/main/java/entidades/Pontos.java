/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Reginaldo
 */
public class Pontos {
    private int idCarona;
    private String ponto;

    public Pontos() {
    }

    public Pontos(int idCarona, String ponto) {
        this.idCarona = idCarona;
        this.ponto = ponto;
    }

    public int getIdCarona() {
        return idCarona;
    }

    public void setIdCarona(int idCarona) {
        this.idCarona = idCarona;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }
    
    
}
