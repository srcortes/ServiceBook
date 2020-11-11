package com.appgate.test.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
