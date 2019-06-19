package com.example.jpademo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity Member
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String address;



}
