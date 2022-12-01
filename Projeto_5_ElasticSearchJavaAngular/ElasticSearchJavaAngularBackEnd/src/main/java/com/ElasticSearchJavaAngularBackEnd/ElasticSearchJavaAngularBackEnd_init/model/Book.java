package com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mkyong", replicas = 1)
public class Book {
	
	@Id
    private Integer id;
    private String title;
    private String author;
    private String releaseDate;
    
    public Book() {
    }

    public Book(Integer id, String title, String author, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    //getters and setters

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

}
