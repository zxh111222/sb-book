package io.github.zxh111222.sbbook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zxh111222.sbbook.pojo.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class OtherIsbnBookService implements BookService{

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle("牛逼");
        return book;
    }
}
