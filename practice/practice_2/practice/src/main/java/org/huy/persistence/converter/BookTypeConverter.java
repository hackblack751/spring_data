package org.huy.persistence.converter;

import jakarta.persistence.AttributeConverter;
import org.huy.persistence.constant.BookType;

public class BookTypeConverter implements AttributeConverter<BookType, String> {

    @Override
    public String convertToDatabaseColumn(BookType bookType) {
        return bookType == null ? null : bookType.getCode();
    }

    @Override
    public BookType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : BookType.fromCode(dbData);
    }
}
