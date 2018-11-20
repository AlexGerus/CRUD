package project.dao;

import project.dbHelper.DBHelper;
import project.module.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserHibernateDAO implements UserDAO{
    private EntityManager em;

    public UserHibernateDAO(){
        em = DBHelper.getInstance().getEmf().createEntityManager();
    }

    public User findUserById(long id){
        return em.find(User.class, id);
    }

    public long saveUser(User user){
        em.getTransaction().begin();
        if (!em.contains(user)){
            em.persist(user);
            em.flush();
        }
        em.getTransaction().commit();
        return user.getId();
    }

    public void updateUser(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.flush();
        em.getTransaction().commit();
    }

    public void deleteUser(long id){
        User user = findUserById(id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public List<User> findAllUsers(){
        return em.createQuery("from User").getResultList();
    }
}
