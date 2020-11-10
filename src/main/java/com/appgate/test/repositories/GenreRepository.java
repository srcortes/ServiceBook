package com.appgate.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appgate.test.entities.Genre;
/**
 * 
 * @author srcortes
 *
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
