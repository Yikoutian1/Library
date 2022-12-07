package com.service;

import com.controller.request.BaseRequest;
import com.entity.Book;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface IBookService {
    
    List<Book> list();

    PageInfo<Book> page(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void update(Book obj);

    void deleteById(Integer id);

}
