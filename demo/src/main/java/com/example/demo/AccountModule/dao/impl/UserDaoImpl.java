package com.example.demo.AccountModule.dao.impl;


import com.example.demo.AccountModule.Entity.UserEntity;
import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String savePerson(UserEntity userEntity) {
        int isSuccess =(int) getSession().save(userEntity);
        if(isSuccess >= 1){
            return "Success";
        }else{
            return "Error while Saving Person";
        }

    }


    public List<UserEntity> getUserEntity() {
        Criteria criteria = sessionFactory.openSession().createCriteria(UserEntity.class);
        return criteria.list();
    }

    public UserEntity findUserById(String userId) {
        UserEntity UserEntity = null;
        Criteria criteria = sessionFactory.openSession().createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("name", userId));
        List<UserEntity> entityList = criteria.list();
        if(!entityList.isEmpty()) {
            UserEntity = entityList.get(0);
        }
        return UserEntity;
    }


    @SuppressWarnings("unchecked")
    public List<UserEntity> getAllUsers() {
        return getSession().createQuery("from UserEntity").list();
    }

}
