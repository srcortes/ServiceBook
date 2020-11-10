package com.appgate.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appgate.test.entities.Book;

/**
 * 
 * @author srcortes
 *
 */
@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}
