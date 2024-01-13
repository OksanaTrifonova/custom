package com.laba.book_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class BookDTO {

    private Long id;

    private String title;
    private BigDecimal price;
    private String author;

    public BookDTO() {
    }
}
