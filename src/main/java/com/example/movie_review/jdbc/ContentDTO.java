package com.example.movie_review.jdbc;

import lombok.Data;

@Data
public class ContentDTO {
    private int num;
    private String movie;
    private String title;
    private String review;
    private String writer;
}