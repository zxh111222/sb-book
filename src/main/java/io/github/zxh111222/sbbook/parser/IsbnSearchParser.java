package io.github.zxh111222.sbbook.parser;


import io.github.zxh111222.sbbook.pojo.Book2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IsbnSearchParser implements Parser {
    @Override
    public Book2 parse(String url) {
        List<Book2> isbnInfoList = new ArrayList<>();
        Book2 book = new Book2();

        try {
            // 从指定 URL 获取网页内容
            Document document = Jsoup.connect(url).get();


            // 提取书籍信息
            String title = document.select("h1").text();
            String isbn13 = document.select("strong:contains(ISBN-13) + a").attr("href").replace("/isbn/", "");
            String isbn10 = document.select("strong:contains(ISBN-10) + a").attr("href").replace("/isbn/", "");
            String author = document.select("strong:contains(Author) + p").text().trim();
            String binding = document.select("strong:contains(Binding) + p").text().trim();
            String publisher = document.select("strong:contains(Publisher) + p").text().trim();
            String publishedYear = document.select("strong:contains(Published) + p").text().trim();
            String imageUrl = document.select(".image img").attr("src");

            // 创建 IsbnInfo 对象并添加到列表中
            Book2 isbnInfo = new Book2(title, isbn13, isbn10, author, binding, publisher, publishedYear, imageUrl);
            isbnInfoList.add(isbnInfo);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return book;
    }
}
