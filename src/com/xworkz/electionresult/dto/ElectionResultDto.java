package com.xworkz.electionresult.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="electionResult")
public class ElectionResultDto implements Serializable {
	
	@Id
	@GenericGenerator(name= "ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "electionId")
	private int electionId;
	@Column(name = "wardNo")
	private int wardNo;
	@Column(name = "name")
	private String name;
	@Column(name = "noOfCandidate")
	private int noOfCandidate;
	

}
