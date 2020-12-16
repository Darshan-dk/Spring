package com.xworkz.config.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="corona_vaccine")
@Getter
@Setter
@ToString
public class CoronaVaccineDTO implements Serializable {
	
	
	@Id
	@GenericGenerator(name= "ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "v_id")
	private long vaccineId;
	@Column(name = "v_name")
	private String name;
	@Column(name = "v_developedBy")
	private String developedBy;
	@Column(name = "v_country")
	private String country;
	@Column(name = "v_readyToUse")
	private boolean readyToUse;

}