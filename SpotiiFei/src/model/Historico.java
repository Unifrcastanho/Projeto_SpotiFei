/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Historico {
    private String musicid, id;

    public Historico() {
    }

    public Historico(String musicid, String id) {
        this.musicid = musicid;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    @Override
    public String toString() {
        return "Historico{" + "Musica=" + musicid + ", ordem=" + id + '}';
    }
    
    
}
