package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.service.AuthorService;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> index() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO show(@PathVariable Long id) {
        return bookService.show(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@Valid @RequestBody BookCreateDTO dto) {
        return bookService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@RequestBody BookUpdateDTO dto, @PathVariable Long id) {
        return bookService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
    // END
}
