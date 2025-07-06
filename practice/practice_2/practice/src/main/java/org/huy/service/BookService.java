package org.huy.service;

import org.huy.dto.BookResponse;
import org.huy.mapper.BookMapper;
import org.huy.persistence.entity.Book;
import org.huy.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookResponse getBookById(Integer bookId) {
        Optional<Book> result = this.bookRepository.findById(bookId);
        if(result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book id " + bookId + " not exist");
        }

        Book entity = result.get();
        BookResponse response = this.bookMapper.toBookResponse(entity);

        return response;
    }
}
