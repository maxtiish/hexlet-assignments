package exercise.service;

import exercise.dto.*;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookDTO> getAll() {
        var books = repository.findAll();
        return books.stream()
                .map(b -> mapper.map(b))
                .toList();
    }

    public BookDTO create(BookCreateDTO dto) {
        var book = mapper.map(dto);
        var author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
        book.setAuthor(author);
        repository.save(book);
        return mapper.map(book);
    }

    public BookDTO show(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));

        var dto = mapper.map(book);

        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setAuthorId(book.getAuthor().getId());

        return dto;
    }

    public BookDTO update(BookUpdateDTO dto, Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
        var author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
        book.setAuthor(author);
        mapper.update(dto, book);
        repository.save(book);
        return mapper.map(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
