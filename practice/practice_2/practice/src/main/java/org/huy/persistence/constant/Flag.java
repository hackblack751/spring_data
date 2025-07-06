package org.huy.persistence.constant;

public enum Flag {

    ON("1"),
    OFF("0"),;

    private final String code;

    public String getCode() {
        return this.code;
    }

    Flag(String code) {
        this.code = code;
    }

    public static Flag fromCode(String code) {
        for(Flag flag : Flag.values()) {
            if(flag.getCode().equals(code)) {
                return flag;
            }
        }

        throw new IllegalArgumentException("Unknown Flag code: " + code);
    }
}
