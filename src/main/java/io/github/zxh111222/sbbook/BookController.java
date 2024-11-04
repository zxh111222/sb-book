package io.github.zxh111222.sbbook;

import io.github.zxh111222.sbbook.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.github.zxh111222.sbbook.App.getBookInfoByISBNForApi;
import static io.github.zxh111222.sbbook.App.getBookInfoByISBNForSpiders;

@RestController
public class BookController {
    @GetMapping("/book/add")
    public String add() {
        return "add";
    }

    @GetMapping("/book/delete")
    public String delete() {
        return "delete";
    }

    @GetMapping("/book/edit")
    public String edit() {
        return "edit";
    }

    @GetMapping("/book/search")
    public String search() {
        return "search";
    }



    @GetMapping("/isbn/{isbn}")
    public Book isbn(@PathVariable String isbn, @RequestParam(required = false) String apiKey) {
        System.out.println(apiKey);

        return new Book();

        //"9787521308716"
//        String bookInfo = getBookInfoByISBNForApi(isbn);
//        Book bookInfoByISBNForSpiders = getBookInfoByISBNForSpiders(isbn);
//
//        return bookInfoByISBNForSpiders;
    }
}
