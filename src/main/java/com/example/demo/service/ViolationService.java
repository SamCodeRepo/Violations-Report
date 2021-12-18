package com.example.demo.service;

import com.example.demo.domain.Violation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ViolationService {

    String create(Violation violation);

    Boolean update(String id, Violation violation);

    Violation getOne(String id);

    List<Violation> getList();

    List<Violation> deleteList();

    Violation deleteOne(String id);


}
