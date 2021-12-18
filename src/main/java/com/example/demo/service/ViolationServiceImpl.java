package com.example.demo.service;

import com.example.demo.dao.ViolationDao;
import com.example.demo.domain.Violation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ViolationServiceImpl implements ViolationService {

    @Autowired
    private ViolationDao violationDao;

    @Override
    public String create(Violation violation) {
        violation.setCreateDate(new Date());
        return violationDao.create(violation);
    }

    @Override
    public Boolean update(String id, Violation violation) {
        return violationDao.update(id, violation);
    }

    @Override
    public Violation getOne(String id) {
        return violationDao.getOne(id);
    }

    @Override
    public Violation deleteOne(String id) {
        return violationDao.deleteOne(id);
    }

    @Override
    public List<Violation> getList() {
        return violationDao.getList();
    }

    @Override
    public List<Violation> deleteList() {
        return violationDao.deleteList();
    }
}
