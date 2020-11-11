package com.appgate.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appgate.test.entities.Editorial;
/**
 * 
 * @author srcortes
 *
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long>{
}
