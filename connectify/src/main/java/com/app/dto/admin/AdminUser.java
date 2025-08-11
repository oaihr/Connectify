package com.app.dto.admin;

import lombok.Data;

@Data
public class AdminUser {
	
	String id;
	String pw;
	String name;
	String tel;
	String mail;
	String adress;
	String joinDate;
	String status;
	int point;
	
}
