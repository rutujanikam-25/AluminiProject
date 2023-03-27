package com.alumini.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity 
@Builder
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="sId")
    private Integer id;
	@Column(name="sName")
    private String name;
	@Column(name="sGraduationYear")
    private String graduationYear;
	@Column(name="sEmail")
    private String email;
	@Column(name="sPhone")
    private String phone;
	@Column(name="sAddress")
    private String address;
    
}
