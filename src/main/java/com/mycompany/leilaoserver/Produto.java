/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leilaoserver;

/**
 *
 * @author aluno
 */
public class Produto {
    private String nome;
    private String caracteristica;
    private double precoInicial;
    public Produto(String nome, String carac, double precoInicial){
        this.nome = nome;
        this.caracteristica = carac;
        this.precoInicial = precoInicial;       
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }
    @Override
    public String toString(){
        return this.nome+";"+this.precoInicial+";"+this.caracteristica;
    }
    
}