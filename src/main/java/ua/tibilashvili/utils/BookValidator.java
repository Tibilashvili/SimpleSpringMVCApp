package ua.tibilashvili.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.tibilashvili.models.Book;
import ua.tibilashvili.services.BookService;

@Component
public class BookValidator implements Validator {

    private final BookService bookService;

    @Autowired
    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        if (bookService.getByTitle(book.getTitle()).isPresent()) {
            if (book.getId() != bookService.getByTitle(book.getTitle()).get().getId()) {
                errors.rejectValue("title", "", "The book with that name already exists");
            }
        }
    }
}

