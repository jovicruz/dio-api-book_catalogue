package jovicruz.dio.book_catalogue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jovicruz.dio.book_catalogue.model.Book;
import jovicruz.dio.book_catalogue.service.BookService;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        var book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
        var bookname = bookService.deleteBookById(id);
        return ResponseEntity.ok("Book '" + bookname + "' has been deleted");
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book bookCreated = bookService.createBook(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(bookCreated.getId())
        .toUri();

        return ResponseEntity.created(location).body(bookCreated);
    }
    
    @PatchMapping()
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book bookPatched = bookService.updateBook(book);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(bookPatched.getId())
        .toUri();

        return ResponseEntity.created(location).body(bookPatched);
    }
}
