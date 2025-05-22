/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Artistas {
    private String artistanome;
    private int artistaid;

    public Artistas() {
    }

    public Artistas(int artistaid, String artistanome) {
        this.artistaid = artistaid;
        this.artistanome = artistanome;
    }

    public int getArtistaid() {
        return artistaid;
    }

    public String getArtistanome() {
        return artistanome;
    }

    public void setArtistaid(int artistaid) {
        this.artistaid = artistaid;
    }

    public void setArtistanome(String artistanome) {
        this.artistanome = artistanome;
    }
    
    @Override
    public String toString() {
        return "Artista{" + "nome artista=" + artistanome + ", artista id=" + artistaid + '}';
    }
}
