/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifrcastanho
 */
public class Playlists {
    private String playlistid, playlistnome;

    public Playlists() {
    }

    public Playlists(String playlistid, String playlistnome) {
        this.playlistid = playlistid;
        this.playlistnome = playlistnome;
    }

    public String getPlaylistid() {
        return playlistid;
    }

    public String getPlaylistnome() {
        return playlistnome;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }

    public void setPlaylistnome(String playlistnome) {
        this.playlistnome = playlistnome;
    }
    
    @Override
    public String toString() {
        return "Playlist{" + "playlist nome=" + playlistnome + ", playlist id=" + playlistid + '}';
    }
}
