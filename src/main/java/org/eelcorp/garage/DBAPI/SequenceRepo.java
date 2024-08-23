package org.eelcorp.garage.DBAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void restartSequence(Integer depth) {
        String query = "ALTER SEQUENCE parkplatz_id_seq RESTART WITH " + depth;
        entityManager.createNativeQuery(query).executeUpdate();
    }
}

