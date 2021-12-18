package com.example.demo.dao;

import com.example.demo.domain.Violation;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class ViolationDaoImpl implements ViolationDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String create(Violation violation) {
        try {
            return mongoTemplate.save(violation).getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean update(String id, Violation violation) {
        try {
            Query query = new Query();
            Criteria criteria = Criteria.where(Violation.report.id.name()).is(id);
            query.addCriteria(criteria);

            Update update = new Update()
                    .set(Violation.report.title.name(), violation.getTitle())
                    .set(Violation.report.description.name(), violation.getDescription())
                    .set(Violation.report.modifyDate.name(), new Date());
            UpdateResult result = mongoTemplate.updateFirst(query, update, Violation.class);
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Violation getOne(String id) {
        try {
            Query query = new Query();
            Criteria criteria = Criteria.where(Violation.report.id.name()).is(id);
            query.addCriteria(criteria);
            return mongoTemplate.findOne(query, Violation.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Violation> getList() {
        try {
            Query query = new Query();
            Criteria criteria = new Criteria();
            query.addCriteria(criteria);
            return mongoTemplate.find(query, Violation.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Violation deleteOne(String id) {
        try {
            Query query = new Query();
            Criteria criteria = Criteria.where(Violation.report.id.name()).is(id);
            query.addCriteria(criteria);
            return mongoTemplate.findAndRemove(query, Violation.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Violation> deleteList() {
        try {
            Query query = new Query();
            Criteria criteria = new Criteria();
            query.addCriteria(criteria);
            return mongoTemplate.findAllAndRemove(query, Violation.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
