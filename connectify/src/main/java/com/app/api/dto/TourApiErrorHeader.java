package com.app.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourApiErrorHeader {
    @JacksonXmlProperty(localName = "errMsg")
    private String errMsg;
    @JacksonXmlProperty(localName = "returnAuthMsg")
    private String returnAuthMsg;
    @JacksonXmlProperty(localName = "returnReasonCode")
    private String returnReasonCode;

   
}
