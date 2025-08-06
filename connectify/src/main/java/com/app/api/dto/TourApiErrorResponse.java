package com.app.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "OpenAPI_ServiceResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourApiErrorResponse {
    @JacksonXmlProperty(localName = "cmmMsgHeader")
    private TourApiErrorHeader header;
}
