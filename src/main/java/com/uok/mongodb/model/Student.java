package com.uok.mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "student_collection")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
}
