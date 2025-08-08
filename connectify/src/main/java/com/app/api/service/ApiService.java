package com.app.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.api.client.TourApiClient;
import com.app.api.dao.ApiDAO;
import com.app.api.dto.LclsSystmCode.LclsSystmCodeItem;
import com.app.api.dto.LdongCode.LdongCodeItem;
import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.api.dto.detailIntro.DetailIntroItem;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    
    @Autowired
    private TourApiClient tourApiClient;
    @Autowired
    private ApiDAO apiDAO;

    /*
     * TourAPI에서 법정동 코드 데이터를 동기화하고 데이터베이스에 저장
     */
    @Transactional 
    public void syncLdongCodes() {
        logger.info("Starting ldong code synchronization process...");
        try {
            // TourAPI에서 법정동 코드 전체 목록 조회
            List<LdongCodeItem> ldongCodes = tourApiClient.getAllLdongCodes();

            if (ldongCodes.isEmpty()) {
                logger.warn("No ldong codes fetched from TourAPI. Synchronization skipped.");
                return;
            }

            logger.info("Successfully fetched {} ldong codes from TourAPI.", ldongCodes.size());

            // 조회된 법정동 코드 목록을 데이터베이스에 MERGE (UPSERT)
            apiDAO.mergeLdongCodes(ldongCodes);
            logger.info("Successfully merged ldong codes into the database.");

        } catch (Exception e) {
            logger.error("Failed to synchronize ldong codes: {}", e.getMessage(), e);
            throw new RuntimeException("Ldong code synchronization failed.", e);
        }
        logger.info("Ldong code synchronization process completed successfully.");
    }
    
    
    /*
     * TourAPI에서 분류 체계 코드 데이터를 동기화하고 데이터베이스에 저장
     */
    @Transactional
    public void syncLclsSystmCodes() {
    	 logger.info("Starting LclsSystm code synchronization process...");
         try {
             // TourAPI에서 법정동 코드 전체 목록 조회
             List<LclsSystmCodeItem> lclsSystmCodes = tourApiClient.getAllLclsSystmCodes();

             if (lclsSystmCodes.isEmpty()) {
                 logger.warn("No LclsSystm codes fetched from TourAPI. Synchronization skipped.");
                 return;
             }

             logger.info("Successfully fetched {} LclsSystm codes from TourAPI.", lclsSystmCodes.size());

             // 조회된 법정동 코드 목록을 데이터베이스에 MERGE (UPSERT)
             apiDAO.mergeLclsSystmCodes(lclsSystmCodes);
             logger.info("Successfully merged LclsSystm codes into the database.");

         } catch (Exception e) {
             logger.error("Failed to synchronize LclsSystm codes: {}", e.getMessage(), e);
             throw new RuntimeException("LclsSystm code synchronization failed.", e);
         }
         logger.info("LclsSystm code synchronization process completed successfully.");
     }
    
    
    @Transactional
    public void syncAreaBasedList() {
    	logger.info("Starting AreaBasedList synchronization process...");
        try {
            // TourAPI에서 전체 여행지 정보 목록 조회
            List<AreaBasedListItem> allTourDestinations = tourApiClient.getAllTourDestinationsByLdongCodes();

            if (allTourDestinations.isEmpty()) {
                logger.warn("No AreaBasedList fetched from TourAPI. Synchronization skipped.");
                return;
            }

            logger.info("Successfully fetched {} AreaBasedList from TourAPI.", allTourDestinations.size());

            // 조회된 여행지 정보 목록을 데이터베이스에 MERGE (UPSERT)
            for(AreaBasedListItem item : allTourDestinations) {
            	apiDAO.mergeAreaBasedList(item);
            }
            logger.info("Successfully merged AreaBasedList into the database.");

        } catch (Exception e) {
            logger.error("Failed to synchronize AreaBasedList: {}", e.getMessage(), e);
            throw new RuntimeException("AreaBasedList synchronization failed.", e);
        }
        logger.info("AreaBasedList synchronization process completed successfully.");
    }
    
    
    public List<AreaBasedListItem> getDestinationsList(){
    	List<AreaBasedListItem> getDestinationsList = apiDAO.getDestinationsList();
    	return getDestinationsList;
    } 
    
    
    
    @Transactional
    public void syncDetailIntro() {
		logger.info("Starting DetailIntro synchronization process...");

		try {
			List<AreaBasedListItem> destinationsList = getDestinationsList();
			// 전체 여행지에 대한 소개 정보 목록 조회
			List<DetailIntroItem> allDetailIntro = tourApiClient
					.getAllTourDetailIntroByContentIdAndContentTypeID(destinationsList);

			if (allDetailIntro.isEmpty()) {
				logger.warn("No DetailIntro fetched from TourAPI. Synchronization skipped.");
				return;
			}

			logger.info("Successfully fetched {} DetailIntro from TourAPI.", allDetailIntro.size());

			// 조회된 여행지 정보 목록을 데이터베이스에 MERGE (UPSERT)
			for (DetailIntroItem item : allDetailIntro) {
				String contentTypeId = item.getContenttypeid();

				 if (contentTypeId == null) {
				        logger.warn("Skipping item due to null contentTypeId. Item: {}", item.getContentId());
				        continue; // 다음 루프로
				 }
				 
	            // contentTypeId에 따라 다른 DAO 메서드 호출
	            switch (contentTypeId) {
	                case "12":
	                    apiDAO.mergeDetailIntroForType12(item);
	                    break;
	                case "14":
	                    apiDAO.mergeDetailIntroForType14(item);
	                    break;
	                case "15":
	                    apiDAO.mergeDetailIntroForType15(item);
	                    break;
	                case "28":
	                    apiDAO.mergeDetailIntroForType28(item);
	                    break;
	                case "32":
	                    apiDAO.mergeDetailIntroForType32(item);
	                    break;
	                case "38":
	                    apiDAO.mergeDetailIntroForType38(item);
	                    break;
	                case "39":
	                    apiDAO.mergeDetailIntroForType39(item);
	                    break;    
	                default:
	                    logger.warn("Unsupported contentTypeId: {}. Skipping item.", contentTypeId);
	                    break;
	            }
			}
			logger.info("Successfully merged DetailIntro into the database.");

		} catch (Exception e) {
			logger.error("Failed to synchronize DetailIntro: {}", e.getMessage(), e);
			throw new RuntimeException("DetailIntro synchronization failed.", e);
		}
		logger.info("DetailIntro synchronization process completed successfully.");
    }

}