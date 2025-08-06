package com.app.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.api.dto.LclsSystmCode.LclsSystmCodeItem;
import com.app.api.dto.LdongCode.LdongCodeItem;
import com.app.api.dto.areaBasedList.AreaBasedListItem;

@Mapper // MyBatis가 이 인터페이스를 DAO로 인식하도록 하는 어노테이션
public interface ApiDAO {

    /**
     * 법정동 코드 목록을 데이터베이스에 저장하거나 업데이트합니다.
     * @param ldongCodeItems 저장할 법정동 코드 항목 목록
     */
    void mergeLdongCodes(List<LdongCodeItem> ldongCodeItems);
    
    void mergeLclsSystmCodes(List<LclsSystmCodeItem> LclsSystmCodeItems);
    
    void mergeAreaBasedList(AreaBasedListItem AreaBasedListItem);
}