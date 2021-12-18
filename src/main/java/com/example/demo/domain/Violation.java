package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Violation")
public class Violation {

    public enum report {
        id, title, description, createDate, modifyDate
    }

    @Id
    private String id;
    private String title;
    private String description;
    private Date createDate;
    private Date modifyDate;
}
