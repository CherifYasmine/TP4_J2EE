package com.app.dao;

import com.appa.metier.Utilisateur;

import java.sql.*;
import java.util.Vector;

public class GestionUserDAO {
    public Utilisateur loadUser(String login, String pass) {
        Connection conn = Utilitaire.getConnection();
        Utilisateur u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from utilisateurs where login=? and pass=?");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rsUser = ps.executeQuery();
            if (rsUser.next()) {
                u = new Utilisateur();
                u.setIdUser(rsUser.getInt("id_user"));
                u.setLogin(rsUser.getString("login"));
                u.setPass(rsUser.getString("pass"));
                u.setEmail(rsUser.getString("email"));
                u.setVille(rsUser.getString("ville"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void addUser(String l, String p, String e, String v) {
        Connection conn = Utilitaire.getConnection();
        Utilisateur u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("insert into utilisateurs (login,pass,email,ville) values(?,?,?,?)");
            ps.setString(1, l);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, v);
            ps.executeUpdate();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public Vector selectAll() {
        Connection conn = Utilitaire.getConnection();
        Vector users = new Vector();
        Utilisateur u = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from utilisateurs");
            ResultSet rsUser = ps.executeQuery();
            while (rsUser.next()) {
                u = new Utilisateur();
                u.setIdUser(rsUser.getInt("id_user"));
                u.setLogin(rsUser.getString("login"));
                u.setPass(rsUser.getString("pass"));
                u.setEmail(rsUser.getString("email"));
                u.setVille(rsUser.getString("ville"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
