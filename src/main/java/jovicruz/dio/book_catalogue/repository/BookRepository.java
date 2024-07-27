package jovicruz.dio.book_catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jovicruz.dio.book_catalogue.model.Book;

public interface BookRepository  extends JpaRepository<Book, Long>{
    boolean existsByName(String name);
    boolean existsById(Long id);
}
