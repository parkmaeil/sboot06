package com.example.sboot.service;

import com.example.sboot.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    //@Autowired
    private final BookRepository bookRepository;

}
