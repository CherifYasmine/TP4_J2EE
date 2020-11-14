package com.appa.metier;

import com.app.dao.GestionUserDAO;

import java.util.Vector;

public class GestionUser {
    GestionUserDAO dao;

    public GestionUser() {
        dao = new GestionUserDAO();
    }

    public Utilisateur Chercher(String login, String pass) {
        return dao.loadUser(login, pass);
    }

    public void ajouter(Utilisateur u) {
        dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
    }

    public Vector lister() {
        return dao.selectAll();
    }
}
