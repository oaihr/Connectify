package com.app.api.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
	Header header;
	T body;
}
