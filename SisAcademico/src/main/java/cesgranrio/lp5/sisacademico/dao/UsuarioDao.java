/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesgranrio.lp5.sisacademico.dao;

import cesgranrio.lp5.sisacademico.models.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author rogerps
 */
public class UsuarioDao {
  
    public static void adicionaUsuario(Usuario usuario) {
        try {
            DaoUtils.manager.getTransaction().begin();
            DaoUtils.manager.persist(usuario);
            DaoUtils.manager.getTransaction().commit();
        } catch (Exception e) {
            DaoUtils.manager.getTransaction().rollback();
        }
    }
 
    public static void atualizaUsuario(Usuario usuario) {
        try {
            DaoUtils.manager.getTransaction().begin();
            DaoUtils.manager.merge(usuario);
            DaoUtils.manager.getTransaction().commit();
        } catch (Exception e) {
            DaoUtils.manager.getTransaction().rollback();
        }
    }
 
    public static void removeUsuario(Usuario usuario) {
        try {
            DaoUtils.manager.getTransaction().begin();
            DaoUtils.manager.remove(usuario);
            DaoUtils.manager.getTransaction().commit();
        } catch (Exception e) {
            DaoUtils.manager.getTransaction().rollback();
        }
    }

    public static List<Usuario> getUsuarios() {
        Query query = DaoUtils.manager.createQuery("from Usuario p");
        return query.getResultList();
    }  
}
