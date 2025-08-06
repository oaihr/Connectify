package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiService apiService;

	/**
	 * 
	 * 법정동 코드 동기화를 실행하는 API 엔드포인트
	 * 
	 */

	@PostMapping("/ldong-codes/sync") // POST 방식으로 /api/ldong-codes/sync 요청을 처리합니다.
	public ResponseEntity<String> syncLdongCodes() {

		try {
			apiService.syncLdongCodes();
			return ResponseEntity.ok("법정동 코드 동기화가 성공적으로 완료되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("동기화 중 오류가 발생했습니다: " + e.getMessage());
		}
	}
	
	@PostMapping("/lcls-system-codes/sync")
	public ResponseEntity<String> syncLclsSystemCodes(){
		try {
			apiService.syncLclsSystmCodes();
			return ResponseEntity.ok("분류체계 코드 동기화가 성공적으로 완료되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("동기화 중 오류가 발생했습니다: " + e.getMessage());
		}
	}
	
	@PostMapping("/area-list/sync")
	public ResponseEntity<String> syncAreaList(){
		
		try {
			apiService.syncAreaBasedList();
			return ResponseEntity.ok("여행지 정보 동기화가 성공적으로 완료되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("동기화 중 오류가 발생했습니다: " + e.getMessage());
		}
	}
}

