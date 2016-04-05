package com.ejb.dao;

import com.ejb.entitybean.User;

import javax.ejb.Remote;

/**
 * Created by gao on 16-4-5.
 */
@Remote
public interface UserDAORemote {
    public boolean insert(User user);
}
