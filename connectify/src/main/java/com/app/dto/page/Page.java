package com.app.dto.page;

import lombok.Data;

@Data
public class Page {
    private int currentPage;  // 현재 페이지 번호
    private int pageSize;     // 한 페이지에 보여줄 데이터 개수
    private int totalCount;   // 전체 데이터 개수
    private int totalPages;   // 전체 페이지 수

    // 현재 페이지 기준 데이터 시작 인덱스(offset)
    public int getOffset() {
        return (currentPage - 1) * pageSize;
    }
}
