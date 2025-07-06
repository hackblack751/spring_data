package org.huy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Integer bookId;
    private String title;
    private BigDecimal price;
    private String isbn;
    private String bookType;
}
