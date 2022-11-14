package pl.edu.pjwstk.booksmpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/get")
    public ResponseEntity<Book> getBookByIdRequestParam(@RequestParam (name = "id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBookById(@RequestParam("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping ("{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.updateBookById(id, book));
    }
}
