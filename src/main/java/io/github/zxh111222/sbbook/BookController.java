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
    public Book isbn(@PathVariable String isbn, @RequestParam(required = true) String apikey) throws IOException {
//        System.out.println(apiKey);
//
//        return new Book();

//        Book bookInfo = null;
//
//        //"9787521308716" "1234567890"
//        if ("123456790".equals(apiKey)){
//            bookInfo = getBookInfoByISBNForSpiders(isbn);
//        } else {
//
//        }
//        return bookInfo;

//        Book book = new MyIsbnBookService().getBookByIsbn(isbn);
//        Book book = new OtherIsbnBookService().getBookByIsbn(isbn);
        Book book = bookService.getBookByIsbn(isbn);
        return book;
    }

    @GetMapping("isbn")
    public String isbnWithParam(@RequestParam(required = false) String q) {
        return "isbn=" + q;
    }
}
