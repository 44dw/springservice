package com.a44dw.springservice.model;

public enum OrderStatus {
    SHEDULED("Запланирован"),
    DONE("Выполнен"),
    ACCEPTED("Принят");

    private String val;

    OrderStatus(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
