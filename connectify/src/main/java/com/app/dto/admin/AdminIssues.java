package com.app.dto.admin;

import lombok.Data;

@Data
public class AdminIssues {
	String adminId;
	String userId;
	String askTime;
	String title;
	String question;
	String answer;
	String status;
	int isPublic;
	int id;
}
