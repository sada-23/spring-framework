package com.company.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Comment {

    private String author;
    private String text;
}
