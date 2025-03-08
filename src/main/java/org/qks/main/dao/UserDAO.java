package org.qks.main.dao;

import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import org.qks.main.dao.po.UserPo;

@Singleton
public class UserDAO {
    @Inject
    @PersistenceUnit("second_db")
    EntityManager entityManager;

    public UserPo findById(Long id) {
        return entityManager.find(UserPo.class, id);
    }
}
