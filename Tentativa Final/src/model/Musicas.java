/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Musicas {
    private String musicid, musictitulo, musicgenero;

    public Musicas() {
    }

    public Musicas(String musicid, String musictitulo, String musicgenero) {
        this.musicid = musicid;
        this.musictitulo = musictitulo;
        this.musicgenero = musicgenero;
    }

    public String getMusicgenero() {
        return musicgenero;
    }

    public String getMusicid() {
        return musicid;
    }

    public String getMusictitulo() {
        return musictitulo;
    }

    public void setMusicgenero(String musicgenero) {
        this.musicgenero = musicgenero;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public void setMusictitulo(String musictitulo) {
        this.musictitulo = musictitulo;
    }
    
    @Override
    public String toString() {
        return "Musica{" + "titulo=" + musictitulo + ", genero=" + musicgenero + ", musica id=" + musicid + '}';
    }
}
