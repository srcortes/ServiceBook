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
	/*@Modifying
	@Query(value = "SELECT "+
			"B.ID_BOOK, B.TITLE, G.ID_GENRE, G.DESCRIPTION, E.ID_EDITORIAL, E.NAME_EDITORIAL, A.ID_AUTHOR, A.NAME_AUTHOR,  B.TITLE, B.PRICE, B.DATE_PUBLICATION "+
			"FROM LIBRARY.BOOK B "+
			"JOIN LIBRARY.GENRE G ON G.ID_GENRE = B.ID_GENRE  "+
			"JOIN LIBRARY.AUTHOR A ON A.ID_AUTHOR = B.ID_AUTHOR  "+
			"JOIN LIBRARY.EDITORIAL E ON E.ID_EDITORIAL = B.ID_EDITORIAL",nativeQuery = true )
	List<Book> informationBook();*/
}
