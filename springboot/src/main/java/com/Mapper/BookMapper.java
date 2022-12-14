package com.Mapper;

import com.controller.request.BaseRequest;
import com.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void updateById(Book user);

    void deleteById(Integer id);

    Book getByNo(@Param("bookNo")String bookNo);

    void updateNumByNo(@Param("bookNo")String bookNo);

}
