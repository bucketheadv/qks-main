package org.qks.main.repository.hibernate.dao;

import jakarta.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDAO<T> {

    protected EntityManager entityManager;

    public BaseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T findById(Long id) {
        return entityManager.find(getGenericClass(this.getClass(), 0), id);
    }

    public T updateById(T entity) {
        return entityManager.merge(entity);
    }

    public T insert(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteById(T entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getGenericClass(Class<?> clazz, int index) {
        return (Class<T>) ((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[index];
    }
}
