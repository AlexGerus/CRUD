package project.dbService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBHelper {
    private EntityManagerFactory emf;
    private static DBHelper singlton = new DBHelper();

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        return singlton;
    }

    public EntityManagerFactory getEmf() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        }
        return emf;
    }
}
