/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.LoginFrame;

import DAO.UsuariosDAO;
import DAO.Conexao;
import DAO.ArtistasDAO;
import DAO.MusicasDAO;
import DAO.PlaylistsDAO;
import DAO.HistoricoDAO;
import DAO.CurtidasDAO;
import DAO.DescurtidasDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Musicas;
import model.Artistas;
import model.Playlists;
import model.Usuarios;
import model.Historico;
import model.Curtidas;
import model.Descurtidas;
import view.SpotifeiFrame;

/**
 *
 * @author unifrcastanho
 */
public class ControllerSpotifei {
    private SpotifeiFrame view;

    public ControllerSpotifei(SpotifeiFrame view) {
        this.view = view;
    }
}
