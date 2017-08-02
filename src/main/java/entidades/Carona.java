/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class Carona {
    private int idUsuario; 
    private String origem;
    private String destino;
    private Time hora;
    private Date data;
    private float ajudaDeCusto;
    List <Pontos> listaPontos;

    public Carona() {
    }

    public Carona(int idUsuario, String origem, String destino, Time hora, Date data, float ajudaDeCusto, List<Pontos> listaPontos) {
        this.idUsuario = idUsuario;
        this.origem = origem;
        this.destino = destino;
        this.hora = hora;
        this.data = data;
        this.ajudaDeCusto = ajudaDeCusto;
        this.listaPontos = listaPontos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(float ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public List<Pontos> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(List<Pontos> listaPontos) {
        this.listaPontos = listaPontos;
    }

    

    
    
}
