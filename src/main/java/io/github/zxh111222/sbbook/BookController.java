package io.github.zxh111222.sbbook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zxh111222.sbbook.pojo.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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
    public Book isbn(@PathVariable String isbn, @RequestParam(required = true) String apiKey) {
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

        Book book = null;
        String result;
        String apikey = "sb.250.s.j.b";
        String url = "http://120.24.69.59:8083/book/isbn/" + isbn + "?apikey=" + apikey;
        System.out.println(url);
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
                    .ignoreContentType(true)
                    .get();
            result = document.text();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode originBookInfo = mapper.readTree(result);
            if (originBookInfo != null && originBookInfo.has("ret") && originBookInfo.get("ret").asInt() == 0) {
                JsonNode data = originBookInfo.get("data");

                String title = data.path("name").asText(null);
                String author = data.path("author").asText(null);
                String authorIntro = data.path("authorIntro").asText(null);
                String publisher = data.path("publishing").asText(null);
                String published = data.path("published").asText(null);
                String description = data.path("description").asText(null);
                String coverImage = data.path("photoUrl").asText(null);
                String price = data.path("price") != null ? data.path("price").asText().replace("元", "") : null;
                String doubanScore = data.path("doubanScore").asText(null);
                String page = data.path("pages").asText(null);

                book = new Book();
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setAuthor(author);
                book.setAuthorIntro(authorIntro);
                book.setPublisher(publisher);
                book.setPublishDate(published);
                book.setDescription(description);
                book.setCoverImage(coverImage);
                book.setPrice(price);
                book.setDoubanScore(doubanScore);
                book.setPage(page);
            }
        } catch (IOException e) {
            e.printStackTrace();
            book = new Book();
            book.setDescription("解析异常(" + url +")：" + e.getMessage());
        }
        return book;
    }

    @GetMapping("isbn")
    public String isbnWithParam(@RequestParam(required = false) String q) {
        return "isbn=" + q;
    }
}
