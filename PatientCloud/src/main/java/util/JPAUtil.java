package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static  final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("patient_cloud");

    public  static EntityManager getEntityMAnager(){
        return FACTORY.createEntityManager();
    }

}
