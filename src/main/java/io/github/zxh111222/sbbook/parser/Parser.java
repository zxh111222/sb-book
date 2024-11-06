package io.github.zxh111222.sbbook.parser;

import io.github.zxh111222.sbbook.pojo.Book2;

public interface Parser {
    Book2 parse(String html);
}
