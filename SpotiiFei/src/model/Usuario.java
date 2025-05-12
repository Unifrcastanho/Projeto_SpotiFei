/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Usuario {
    private String nome;
    private String id;
    private String senha;

    public Usuario(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }
}
