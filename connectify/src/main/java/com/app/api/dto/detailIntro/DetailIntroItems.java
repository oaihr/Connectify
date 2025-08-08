package com.app.api.dto.detailIntro;

import java.util.List;

import com.app.api.dto.TourApiItemDeserializer;
import com.app.api.dto.detailIntro.impl.DetailIntroItemAttraction;
import com.app.api.dto.detailIntro.impl.DetailIntroItemCulturalFacility;
import com.app.api.dto.detailIntro.impl.DetailIntroItemFestival;
import com.app.api.dto.detailIntro.impl.DetailIntroItemFood;
import com.app.api.dto.detailIntro.impl.DetailIntroItemLeports;
import com.app.api.dto.detailIntro.impl.DetailIntroItemLodging;
import com.app.api.dto.detailIntro.impl.DetailIntroItemShopping;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
public class DetailIntroItems {
	
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "contenttypeid")
	@JsonSubTypes({
        @JsonSubTypes.Type(value = DetailIntroItemAttraction.class, name = "12"),
        @JsonSubTypes.Type(value = DetailIntroItemCulturalFacility.class, name = "14"),
        @JsonSubTypes.Type(value = DetailIntroItemFestival.class, name = "15"),
        @JsonSubTypes.Type(value = DetailIntroItemLeports.class, name = "28"),
        @JsonSubTypes.Type(value = DetailIntroItemLodging.class, name = "32"),
        @JsonSubTypes.Type(value = DetailIntroItemShopping.class, name = "38"),
        @JsonSubTypes.Type(value = DetailIntroItemFood.class, name = "39")
    })
    @JsonDeserialize(using = TourApiItemDeserializer.class)
	List<DetailIntroItem> item;
}
