package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Books;

@Mapper
public interface BooksMapper {
	List<Books> selectAll();
	Books selectById(@Param("id") Integer id);
	void insert(Books books);
	void delete(@Param("id") Integer id);
}
