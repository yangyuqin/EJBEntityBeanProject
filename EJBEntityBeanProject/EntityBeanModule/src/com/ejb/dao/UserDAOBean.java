package com.ejb.dao;

import com.ejb.entitybean.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Created by gao on 16-4-5.
 */
@Stateless(name = "UserDAOEJB")
public class UserDAOBean implements UserDAORemote {
    @PersistenceContext(unitName = "abc1")
    private EntityManager em;

    public UserDAOBean() {
    }

    @Override
    public boolean insert(User user) {
        try {
            em.persist(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
