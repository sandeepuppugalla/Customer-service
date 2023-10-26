package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	@Column(nullable=false)
	private int customerId;
	
	@Column(nullable = false)
	@Size(min=2, message ="customer name should have atleast 2 characters")
	@NotEmpty
	private String customerName;
	
	@NotEmpty
	@Column(nullable = false)
	private String customerAddress;
	
	@NotEmpty
	@Size(max=10,message ="customer phone number should have  10 characters")
	@Column(nullable = false)
	private String phoneNo;
	
	@NotNull
	@Column(nullable = false)
	private Long landlineNo;
	
	@NotNull
	@Column(nullable=false)
	private Long pinCode;
	
}
