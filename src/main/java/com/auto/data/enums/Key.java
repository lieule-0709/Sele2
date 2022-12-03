package com.auto.data.enums;

public enum Key {

    PLAT_FORM("platform");

    private String text;

    Key(String key) {
        this.text = key;
    }

    public String getText() {
        return text;
    }
}
