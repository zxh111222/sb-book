package io.github.zxh111222.sbbook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zxh111222.sbbook.pojo.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }


    @GetMapping("/isbn/{isbn}")
    public Book isbn(@PathVariable String isbn, @RequestParam(required = false) String apikey) throws IOException {
        Book book = bookRepository.findByIsbn(isbn).orElse(bookService.getBookByIsbn(isbn));
        if (book.getId() == null) {
            System.out.println("数据库中还没有 isbn=" + isbn + " 的图书，执行入库操作");
            book = bookRepository.save(book);
            System.out.println("isbn=" + isbn + " 的图书入库成果");
        }
        return book;
    }

    @GetMapping("isbn")
    public String isbnWithParam(@RequestParam(required = false) String q) {
        return "isbn=" + q;
    }

}
