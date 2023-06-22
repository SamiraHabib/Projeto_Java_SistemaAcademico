/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesgranrio.lp5.sisacademico.dao;

import cesgranrio.lp5.sisacademico.models.Perfil;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rogerps
 */
public class PerfilDao {

    public static void adicionaPerfil(Perfil perfil) {
        try {
            DaoUtils.manager.getTransaction().begin();
            DaoUtils.manager.persist(perfil);
            DaoUtils.manager.getTransaction().commit();
        } catch (Exception e) {
            DaoUtils.manager.getTransaction().rollback();
        }
    }

    public static List<Perfil> getPerfis() {
        Query query = DaoUtils.manager.createQuery("from Perfil p");
        return query.getResultList();
    }
}
