package com.tushar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

	private int accNo;
	private String accName;
	private double accBal;
	
}
