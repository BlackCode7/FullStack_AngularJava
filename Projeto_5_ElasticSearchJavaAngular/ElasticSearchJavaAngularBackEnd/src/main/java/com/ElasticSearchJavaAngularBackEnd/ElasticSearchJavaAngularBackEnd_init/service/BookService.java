package com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.model.Book;

import co.elastic.clients.elasticsearch.ml.Page;

public interface BookService {
	
	Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    //Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);

}
