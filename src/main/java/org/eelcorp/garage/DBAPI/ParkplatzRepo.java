package org.eelcorp.garage.DBAPI;

import jakarta.transaction.Transactional;
import org.eelcorp.garage.FreeSpots;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The repository for working with Parkplatz objects in the DB.
 */
public interface ParkplatzRepo extends CrudRepository<Parkplatz, Long> {
    int countByIstBesetzt(boolean istBesetzt);

    List<Parkplatz> findByOrderById();

    List<Parkplatz> findByIstBesetzt(boolean istBesetzt);

    Parkplatz findByNummernschild_Nummernschild(String nummernschild);

    boolean existsByNummernschild_Nummernschild(String nummernschild);

    /**
     * Constructs a native query to the database to get free spots per floor.
     * @return a projection of free spots on every floor wrapped in a simple FreeSpots record with etage:freiePlaetze fields.
     */
    @Query("SELECT new org.eelcorp.garage.FreeSpots(p.etage, COUNT(p.id)) " +
            "FROM Parkplatz p " +
            "WHERE p.istBesetzt = false " +
            "GROUP BY p.etage " +
            "ORDER BY p.etage")
    List<FreeSpots> findFreeSpotsByFloor();

    /**
     * Flushes the parkplatz table.
     */
    @Transactional
    @Modifying
    @Query(value = "TRUNCATE TABLE parkplatz", nativeQuery = true)
    void truncateTable();

    /**
     * Resets the id-generating sequence for parking spots IDs back to 0.
     * Used when flushing and remaking the database.
     */
    @Transactional
    @Query(value = "SELECT setval('public.parkplatz_id_seq', 0, true)", nativeQuery = true)
    void restartSequence();

}
