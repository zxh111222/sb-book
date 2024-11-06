package io.github.zxh111222.sbbook.parser;


import io.github.zxh111222.sbbook.pojo.Book2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ZhuashuParser implements Parser{
    @Override
    public Book2 parse(String html) {
        Book2 book = new Book2();


        try {
            // 从指定 URL 获取网页内容
            Document document = Jsoup.connect(html).get();

            // 提取书籍信息
            String title = document.select("li:contains(书名)").text().trim().replace("书名：", "").trim();
            String cip = document.select("li:contains(cip)").text().trim().replace("cip：", "").trim();
            String isbn = document.select("li:contains(isbn)").text().trim().replace("isbn：", "").trim();
            String publisher = document.select("li:contains(出版社)").text().trim().replace("出版社：", "").trim();
            String publicationPlace = document.select("li:contains(出版地)").text().trim().replace("出版地：", "").trim();
            String publishedYear = document.select("li:contains(出版时间)").text().trim().replace("出版时间：", "").trim();
            String price = document.select("li:contains(出版价格)").text().trim().replace("出版价格：", "").trim();
            String imageUrl = document.select(".fll.fengmian img").attr("src");

            // 创建 IsbnInfo 对象并添加到列表中
            book = new Book2(title, isbn, cip, publisher, publicationPlace, publishedYear, price, imageUrl);


        } catch (IOException e) {
            e.printStackTrace();
            // 如果网络问题导致解析失败，提示用户检查链接或稍后重试
            System.out.println("网络问题导致无法解析网页，请检查链接的合法性或稍后重试。");
        }

        return book;
    }
}

