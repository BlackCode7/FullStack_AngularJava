/*

 package com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.model.Book;
import com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.repository.BookRepository;

import co.elastic.clients.elasticsearch.ml.Page;

public class BookServiceImpl implements BookService {
	
	private BookRepository  bookRepository; 

	@Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
    
    public Book findOne(String id) {
        return bookRepository.findOne(id);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}


 */