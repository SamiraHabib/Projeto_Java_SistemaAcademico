/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesgranrio.lp5.sisacademico.services;

import cesgranrio.lp5.sisacademico.dao.PerfilDao;
import cesgranrio.lp5.sisacademico.models.Perfil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rogerps
 */
public class PerfilService {
    
    private ObservableList<Perfil> perfis = FXCollections.observableArrayList();

    public ObservableList<Perfil> getPerfis() {
        return perfis;
    }

    public PerfilService() {
        perfis.addAll(PerfilDao.getPerfis());
    }

    public void adicionaUsuario(Perfil perfil) {
        PerfilDao.adicionaPerfil(perfil);
        perfis.add(perfil);
    }
}
