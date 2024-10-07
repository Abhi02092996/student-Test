package com.api.payload;

import java.util.Date;

public class ErrorDto {
    private String massage;
    private Date date;
    private String uri;

    public ErrorDto(String massage, Date date, String uri) {
        this.massage = massage;
        this.date = date;
        this.uri = uri;
    }

    public String getMassage() {
        return massage;
    }

    public Date getDate() {
        return date;
    }

    public String getUri() {
        return uri;
    }
}
