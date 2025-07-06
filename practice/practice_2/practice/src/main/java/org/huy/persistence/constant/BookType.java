package org.huy.persistence.constant;

public enum BookType {

    EBOOK("1"),
    MAGAZINE("2"),
    COMIC("3"),;

    private final String code;

    public String getCode() {
        return this.code;
    }

    BookType(String code) {
        this.code = code;
    }

    public static BookType fromCode(String code) {
        for(BookType bookType : BookType.values()) {
            if(bookType.getCode().equals(code)) {
                return bookType;
            }
        }

        throw new IllegalArgumentException("Unknown book type code: " + code);
    }
}
