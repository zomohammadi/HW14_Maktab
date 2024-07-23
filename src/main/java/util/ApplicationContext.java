package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationContext {
    public ApplicationContext() {
    }

    private static ApplicationContext applicationContext;

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    private EntityManagerFactory enf;
    private EntityManager em;

    public EntityManagerFactory getEntityManagerFactory() {
        if (enf == null) {
            enf = Persistence.createEntityManagerFactory("default");
        }
        return enf;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }
}
