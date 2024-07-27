package jovicruz.dio.book_catalogue.service.impl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jovicruz.dio.book_catalogue.model.Book;
import jovicruz.dio.book_catalogue.repository.BookRepository;
import jovicruz.dio.book_catalogue.service.*;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookrepo;

    public BookServiceImpl(BookRepository bookrepo){
        this.bookrepo = bookrepo;
    }


    @Override
    public Book findById(Long id) {
        return bookrepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book createBook(Book book) {
        if (bookrepo.existsByName(book.getName())) {
            throw new IllegalArgumentException("This book is already saved");
        }
        else{
            bookrepo.save(book);
            return book;
        }
        
    }


    @Override
    public List<Book> findAll() {
       return bookrepo.findAll();
    }


    @Override
    public String deleteBookById(Long id) {
        Optional<Book> book = bookrepo.findById(id);
        String bookname;
        if (book.isPresent()) {
            bookname = book.get().getName();
        }
        else{
            throw new NoSuchElementException();
        }

        bookrepo.deleteById(id);
        return bookname;
    }


    @Override
public Book updateBook(Book newBook) {
    Optional<Book> bookToBePatched = bookrepo.findById(newBook.getId());
    if (bookToBePatched.isPresent()) {
        Book existingBook = bookToBePatched.get();
        
        if (newBook.getAuthor() != null) {
            existingBook.setAuthor(newBook.getAuthor());
        }
        if (newBook.getCover_img() != null) {
            existingBook.setCover_img(newBook.getCover_img());
        }
        if (newBook.getCurrent_page() != null) {
            existingBook.setCurrent_page(newBook.getCurrent_page());
        }
        if (newBook.getName() != null) {
            existingBook.setName(newBook.getName());
        }
        if (newBook.getPub_date() != null) {
            existingBook.setPub_date(newBook.getPub_date());
        }
        if (newBook.getRating() != null) {
            existingBook.setRating(newBook.getRating());
        }
        if (newBook.getStatus() != null) {
            existingBook.setStatus(newBook.getStatus());
        }
        if (newBook.getTotal_pages() != null) {
            existingBook.setTotal_pages(newBook.getTotal_pages());
        }
        
        return bookrepo.save(existingBook);
    } else {
        throw new NoSuchElementException();
    }
}
    }
    

