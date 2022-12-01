package com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ElasticSearchJavaAngularBackEnd.ElasticSearchJavaAngularBackEnd_init.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, Integer>{
	
	 //Page<Book> findByAuthor(String author, Pageable pageable);

	   // List<Book> findByTitle(String title);

}
