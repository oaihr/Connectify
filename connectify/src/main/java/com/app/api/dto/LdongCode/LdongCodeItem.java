package com.app.api.dto.LdongCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LdongCodeItem {
	
	@JsonProperty("rnum")
    private String rnum;

    @JsonProperty("lDongRegnCd")
    private String ldongRegnCd; // 필드명은 DTO 규칙에 맞게 그대로 사용 가능

    @JsonProperty("lDongRegnNm")
    private String ldongRegnNm;

    @JsonProperty("lDongSignguCd")
    private String ldongSignguCd;

    @JsonProperty("lDongSignguNm")
    private String ldongSignguNm;
}
