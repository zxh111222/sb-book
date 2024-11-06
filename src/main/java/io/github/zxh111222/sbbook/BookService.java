package io.github.zxh111222.sbbook;

import io.github.zxh111222.sbbook.pojo.Book;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface BookService {
    Book getBookByIsbn(String isbn) throws IOException;
}
