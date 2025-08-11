package com.app.api.dto;

import com.app.api.dto.TourApiErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class TourApiResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(TourApiResponseErrorHandler.class);
    private final ObjectMapper xmlMapper = new XmlMapper(); // XML 파싱을 위한 ObjectMapper

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String responseBody = new BufferedReader(new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))
               .lines().collect(Collectors.joining("\n"));

        logger.error("TourAPI HTTP Error: Status Code={}, Status Text={}, Response Body={}",
                response.getStatusCode(), response.getStatusText(), responseBody);

        try {
            // TourAPI는 오류 메시지를 XML로만 반환하므로 XML로 파싱 시도 
            TourApiErrorResponse errorResponse = xmlMapper.readValue(responseBody, TourApiErrorResponse.class);
            if (errorResponse!= null && errorResponse.getHeader()!= null) {
                throw new TourApiException(
                        errorResponse.getHeader().getReturnReasonCode(),
                        errorResponse.getHeader().getErrMsg(),
                        errorResponse.getHeader().getReturnAuthMsg()
                );
            }
        } catch (Exception e) {
            logger.warn("Failed to parse TourAPI error response as XML. Falling back to generic error. Error: {}", e.getMessage());
            // XML 파싱 실패 시 일반적인 HTTP 오류로 처리
        }
        throw new TourApiException("TourAPI call failed with HTTP status: " + response.getStatusCode() + " " + response.getStatusText());
    }
}
