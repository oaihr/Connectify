package com.app.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.api.dto.LclsSystmCode.LclsSystmCodeItem;
import com.app.api.dto.LdongCode.LdongCodeItem;
import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.api.dto.detailIntro.DetailIntroItem;

@Mapper // MyBatis가 이 인터페이스를 DAO로 인식하도록 하는 어노테이션
public interface ApiDAO {

    /**
     * 법정동 코드 목록을 데이터베이스에 저장하거나 업데이트합니다.
     * @param ldongCodeItems 저장할 법정동 코드 항목 목록
     */
    void mergeLdongCodes(List<LdongCodeItem> ldongCodeItems);
    
    void mergeLclsSystmCodes(List<LclsSystmCodeItem> LclsSystmCodeItems);
    
    void mergeAreaBasedList(AreaBasedListItem AreaBasedListItem);

	List<AreaBasedListItem> getDestinationsList();
	
	//관광지
	void mergeDetailIntroForType12(DetailIntroItem detailIntroItem);
	
	//문화시설
	void mergeDetailIntroForType14(DetailIntroItem detailIntroItem);
	
	//행사 공연 축제
	void mergeDetailIntroForType15(DetailIntroItem detailIntroItem);
	
	//레포츠
	void mergeDetailIntroForType28(DetailIntroItem detailIntroItem);
	
	//숙박
	void mergeDetailIntroForType32(DetailIntroItem detailIntroItem);
	
	//쇼핑
	void mergeDetailIntroForType38(DetailIntroItem detailIntroItem);
	
	//음식점
	void mergeDetailIntroForType39(DetailIntroItem detailIntroItem);
}