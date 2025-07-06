package org.huy.mapper;

import org.huy.dto.BookResponse;
import org.huy.persistence.constant.BookType;
import org.huy.persistence.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Mapping(target = "bookType", source = "bookType", qualifiedByName = "bookTypeToCode")
    public abstract BookResponse toBookResponse(Book book);

    @Named("bookTypeToCode")
    protected String mapBookTypeToCode(BookType bookType) {
        return bookType == null ? null : bookType.getCode();
    }
}
