/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Usuarios {
    private String usernome, userid, usersenha;

    public Usuarios() {
    }

    public Usuarios(String usernome, String userid, String usersenha) {
        this.usernome = usernome;
        this.userid = userid;
        this.usersenha = usersenha;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsernome() {
        return usernome;
    }

    public String getUsersenha() {
        return usersenha;
    }

    public void setUsersenha(String usersenha) {
        this.usersenha = usersenha;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsernome(String usernome) {
        this.usernome = usernome;
    }
    
    @Override
    public String toString() {
        return "User{" + "nome=" + usernome + ", id=" + userid + ", senha=" + usersenha + '}';
    }
}
