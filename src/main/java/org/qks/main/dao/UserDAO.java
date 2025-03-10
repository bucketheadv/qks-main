package org.qks.main.dao;

//import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import org.qks.main.dao.po.UserPo;

@Singleton
public class UserDAO extends BaseDAO<UserPo> {
    public UserDAO(
//            @PersistenceUnit("second_db")
            EntityManager entityManager) {
        super(entityManager);
    }
}
