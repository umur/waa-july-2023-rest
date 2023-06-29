package com.miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
public class Course  {
    private Long id;
    private String name;
    private String code;
}
