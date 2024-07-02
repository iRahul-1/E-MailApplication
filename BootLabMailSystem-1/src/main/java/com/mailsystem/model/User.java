package com.mailsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserRegistration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Column(name = "phonenumber",length = 20)
	private Long phonenumber;
	@Column(name = "username",length = 20)
	private String username;
	@Column(name = "FirstName",length = 20)
	private String firstName;
	@Column(name = "LastName",length = 20)
	private String lastName;
	@Column(name = "E-Mail",length = 30)
	private String eMail;
	@Column(name = "password",length = 20)
	private String password;
	
}
