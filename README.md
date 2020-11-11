# Software Engineer Practical Test
This repository contains technical test development sources, for AppGate  Software Enginners vacancy

# Indications
* For data load, csv file used this file is located in the following path (ServiceBook/src/main/resources/data/book.csv), here is some test data.
* The file is loaded using BEANIO there is a file(.xml) inside the project(ServiceBook/src/main/resources/book.xml) that is used for the validation of the csv file
* The file structure must have the following order:
   * Name_Book, Genre, Author, Price, Date_publication(yyyy-MM-dd), example (Harry potter y El legado maldito,fantasia,J.k. Rowling,39.000,prueba,2020-01-31)
* The services contains the methods:
   * POST /createBook
   * DELETE /deleteBook/{idBook}
   * GET /getInformationBooks
   * PATCH /updateBook/{idBook}
 * The context for app is (url/ManagerApi/swagger-ui.html).
 * The services is deploy for test in https://book-technical-test-appgate.herokuapp.com/ManagerApi/swagger-ui.html
# Description project   
In this project I used, Spring Boot, Java 8, ModdelMapper, JpaRepository, Junit and Mockito, Maven, Beanio, for the persistence use H2 in the application.properties it's found configuration DB

# Considerations
* In the classes there aren't comments and  blank lines, I'm following this post https://www.yegor256.com/2014/11/03/empty-line-code-smell.html and https://blog.usejournal.com/stop-writing-code-comments-28fef5272752
