package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Reviews;

@Mapper
public interface ReviewsMapper {
	List<Reviews> selectAll();
	Reviews selectById(@Param("book_id") Integer id);
	void insert(Reviews reviews);
	void update(Reviews reviews);
	void delete(@Param("book_id") Integer id,String emp_id);
	void deleteAll(@Param("book_id") Integer id);
}
