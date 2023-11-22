package com.example.proiectcolectiv731_be.repository;

import com.example.proiectcolectiv731_be.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query(value = "{CALL usp_get_active_offers()}", nativeQuery = true)
    List<Offer> findActiveOffers();

    /*
    - create the stored procedure within the database
    MySQL:
    USE `TheUsedDBName`;
    DROP procedure IF EXISTS `usp_get_active_offers`;

    DELIMITER $$
    USE `TheUsedDBName`$$
    CREATE PROCEDURE `usp_get_active_offers` ()
    BEGIN
	    SELECT * FROM offers WHERE is_active = b'1';
    END$$

    DELIMITER ;
   */
}
