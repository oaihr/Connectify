package com.app.api.dto;

import com.app.api.dto.detailIntro.DetailIntroItem;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TourApiItemDeserializer extends JsonDeserializer<List<DetailIntroItem>> {

    @Override
    public List<DetailIntroItem> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // 현재 파서에서 객체를 읽어오기 위한 코덱 가져오기
        ObjectCodec codec = p.getCodec();
        TreeNode treeNode = codec.readTree(p);
        
        List<DetailIntroItem> items = new ArrayList<>();
        ObjectMapper mapper = (ObjectMapper) codec;

        // Jackson의 다형성 처리(polymorphic deserialization)를 위한 타입 정의
        JavaType type = ctxt.getTypeFactory().constructCollectionType(List.class, DetailIntroItem.class);
        
        // JSON 노드의 타입이 배열인지 확인합니다.
        if (treeNode.isArray()) {
            // 배열인 경우, 정상적으로 리스트로 변환합니다.
            ArrayNode arrayNode = (ArrayNode) treeNode;
            if (arrayNode.size() > 0) {
                 // 배열의 모든 요소를 DetailIntroItem 리스트로 매핑
                 items = mapper.readValue(arrayNode.toString(), type);
            }
        } else if (treeNode.isObject()) {
            // 단일 객체인 경우
            ObjectNode objectNode = (ObjectNode) treeNode;
            
            // ObjectMapper를 사용하여 단일 객체를 List에 담습니다.
            DetailIntroItem item = mapper.readValue(objectNode.toString(), DetailIntroItem.class);
            items.add(item);

        } else {
            // 그 외의 경우 (null 등)
            return null;
        }

        return items;
    }
}