package com.app.api.dto;

import com.app.api.dto.detailIntro.DetailIntroResponse;

public class TourApiException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    private String errorAuthMessage;
    
    public TourApiException(String message) {
        super(message);
    }

    public TourApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourApiException(String errorCode, String errorMessage, String errorAuthMessage) {
        super(String.format("TourAPI Error: Code=%s, Msg=%s, AuthMsg=%s", errorCode, errorMessage, errorAuthMessage));
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorAuthMessage = errorAuthMessage;
    }

    public TourApiException(String resultCode, String resultMsg, DetailIntroResponse response) {
	}

	public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorAuthMessage() {
        return errorAuthMessage;
    }
}
