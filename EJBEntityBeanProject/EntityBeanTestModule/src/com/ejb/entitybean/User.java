package com.ejb.entitybean;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by gao on 16-4-5.
 */
//ʵ��Beanͨ����Ҫʵ��Serializable�ӿڣ������Ϳ�����EJB�ͻ��˴����ö��󣬲����ö����͵�����ˣ�
// ��������java.io.InvalidClassException�쳣��
@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    @Id
    @GeneratedValue
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "username", length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", length= 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="email",length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
