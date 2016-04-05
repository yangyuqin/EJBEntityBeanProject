package com.ejb.test;


import com.ejb.dao.UserDAORemote;
import com.ejb.entitybean.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by gao on 16-4-5.
 */
public class UserDAOClient {
    private static final Logger log = Logger.getLogger(UserDAOClient.class.getName());

    public static void main(String[] args) throws NamingException {
        UserDAORemote userDAORemote = lookupRemoteStatelessEjbBean();
        User user = new User();
        user.setUserName("yangyuqin");
        user.setPassword("123456");
        user.setEmail("abc@163.com");
        log.info("待插入的用户信息为：" + user);
        userDAORemote.insert(user);
        log.info("已经插入一条用户记录！！");
    }

    private static UserDAORemote lookupRemoteStatelessEjbBean() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "EntityBeanModule_war_exploded";
        final String distinctName = "";
        final String beanName = "UserDAOEJB";
        final String viewClassName = UserDAORemote.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        return (UserDAORemote) context.lookup(namespace);
    }
}
