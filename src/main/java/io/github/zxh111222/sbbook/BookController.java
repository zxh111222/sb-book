package io.github.zxh111222.sbbook;

import io.github.zxh111222.sbbook.pojo.Book;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("book")
public class BookController {
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
    public String isbn(@PathVariable String isbn, @RequestParam(required = false) String apiKey) {
//        System.out.println(apiKey);
//
//        return new Book();

        //"9787521308716"
//        String bookInfo = getBookInfoByISBNForApi(isbn);
//        Book bookInfoByISBNForSpiders = getBookInfoByISBNForSpiders(isbn);
//
//        return bookInfoByISBNForSpiders;

        return "isbn/" + isbn;
    }
}
