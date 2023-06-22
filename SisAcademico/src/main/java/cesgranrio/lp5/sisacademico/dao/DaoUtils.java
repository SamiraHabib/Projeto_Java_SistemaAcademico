/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cesgranrio.lp5.sisacademico.dao;

import javax.persistence.*;

/**
 *
 * @author rogerps
 */
public class DaoUtils {

    public static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("SisAcademicoPU");
    public static final EntityManager manager = managerFactory.createEntityManager();
}
