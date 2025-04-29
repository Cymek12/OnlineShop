package com.mysite.adapters.in.web.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private Date date;
}