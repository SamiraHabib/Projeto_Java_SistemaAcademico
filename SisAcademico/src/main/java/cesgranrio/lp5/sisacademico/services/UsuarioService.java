/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesgranrio.lp5.sisacademico.services;

import cesgranrio.lp5.sisacademico.dao.UsuarioDao;
import cesgranrio.lp5.sisacademico.models.Usuario;
import javafx.collections.*;

/**
 *
 * @author rogerps
 */
public class UsuarioService {

    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }

    public UsuarioService() {
        usuarios.addAll(UsuarioDao.getUsuarios());
    }

    public void adicionaUsuario(Usuario usuario) {
        UsuarioDao.adicionaUsuario(usuario);
        usuarios.add(usuario);
    }

    public void atualizaUsuario(Usuario usuario) {
        UsuarioDao.atualizaUsuario(usuario);
        usuarios.set(usuarios.indexOf(usuario), usuario);
    }

    public void removeUsuario(Usuario usuario) {
        UsuarioDao.removeUsuario(usuario);
        usuarios.remove(usuario);
    }
}
