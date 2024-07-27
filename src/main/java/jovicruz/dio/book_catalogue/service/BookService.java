package jovicruz.dio.book_catalogue.service;

import java.util.List;

import jovicruz.dio.book_catalogue.model.Book;

public interface BookService {
    public Book findById(Long id);
    public Book createBook(Book book);
    public Book updateBook(Book book);
    public List<Book> findAll();
    public String deleteBookById(Long id);
}
