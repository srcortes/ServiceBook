package com.appgate.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appgate.test.entities.Author;
/**
 * 
 * @author srcortes
 *
 */
@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long>{
}
