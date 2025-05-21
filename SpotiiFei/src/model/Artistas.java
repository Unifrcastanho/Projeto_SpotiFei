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
    private String artistaid, artistanome;

    public Artistas() {
    }

    public Artistas(String artistaid, String artistanome) {
        this.artistaid = artistaid;
        this.artistanome = artistanome;
    }

    public String getArtistaid() {
        return artistaid;
    }

    public String getArtistanome() {
        return artistanome;
    }

    public void setArtistaid(String artistaid) {
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
