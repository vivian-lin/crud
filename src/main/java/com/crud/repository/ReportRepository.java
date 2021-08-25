package com.crud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.crud.domain.ReportEntity;
import com.crud.exception.ResourceNotFoundException;

@Repository
public class ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ReportEntity findOne(int id) {
        TypedQuery<ReportEntity> query =
                entityManager.createQuery("Select r from ReportEntity r where r.id = :id", ReportEntity.class)
                        .setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            throw new ResourceNotFoundException("cannot find resource with id " + id);
        }
    }

    public List<ReportEntity> getMany() {
        TypedQuery<ReportEntity> query = entityManager.createQuery("Select r from ReportEntity", ReportEntity.class);

        try {
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}
