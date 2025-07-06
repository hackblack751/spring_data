package org.huy.persistence.converter;

import jakarta.persistence.AttributeConverter;
import org.huy.persistence.constant.Flag;

public class FlagConverter implements AttributeConverter<Flag, String> {
    @Override
    public String convertToDatabaseColumn(Flag flag) {
        return flag == null ?  null : flag.getCode();
    }

    @Override
    public Flag convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Flag.fromCode(dbData);
    }
}
