package com.example.demo.dao;

import com.example.demo.domain.Violation;

import java.util.List;


public interface ViolationDao {

    String create(Violation violation);

    List<Violation> getList();

    Violation getOne(String id);

    Boolean update(String id, Violation violation);

    Violation deleteOne(String id);

    List<Violation> deleteList();
}
