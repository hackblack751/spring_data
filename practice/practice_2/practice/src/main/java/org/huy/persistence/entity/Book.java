package org.huy.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.huy.persistence.constant.BookType;
import org.huy.persistence.constant.Flag;
import org.huy.persistence.converter.BookTypeConverter;
import org.huy.persistence.converter.FlagConverter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "book_type", nullable = false)
    @Convert(converter = BookTypeConverter.class)
    private BookType bookType;

    @Column(name = "deleted_flag", nullable = false)
    @Convert(converter = FlagConverter.class)
    private Flag deletedFlag;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if(this.deletedFlag == null) {
            this.deletedFlag = Flag.OFF;
        }
    }
}
