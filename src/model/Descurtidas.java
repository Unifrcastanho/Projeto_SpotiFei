/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Descurtidas {
    private String musicid;

    public Descurtidas() {
    }

    public Descurtidas(String musicid) {
        this.musicid = musicid;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    @Override
    public String toString() {
        return "Descurtidas{" + "Musica=" + musicid + '}';
    }
    
    
}
