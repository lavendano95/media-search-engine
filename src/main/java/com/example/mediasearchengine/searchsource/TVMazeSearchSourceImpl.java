package com.example.mediasearchengine.searchsource;

import com.example.mediasearchengine.model.ResponseModel;
import com.example.mediasearchengine.model.tvmaze.TVMazeResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TVMazeSearchSourceImpl implements SearchSource {

    private Logger logger = LoggerFactory.getLogger(TVMazeSearchSourceImpl.class);

    private static final String TV_MAZE_URL = "http://api.tvmaze.com";

    private static final String TV_MAZE_API_URL = TV_MAZE_URL.concat("/search/shows?q=");

    private static final String SERVICE_IMG_URL = "https://static.tvmaze.com/images/tvm-header-logo.png";

    @Override
    public List<ResponseModel> search(String encodedSearchCriteria) {
        String url = TV_MAZE_API_URL.concat(encodedSearchCriteria);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            errorResponseMessages(url, response.getStatusCode());
            return new ArrayList<>();
        }
        return buildResponseList(response.getBody(), url);
    }

    private List<ResponseModel> buildResponseList(String json, String url) {
        List<ResponseModel> responseList = new ArrayList<>();
        List<TVMazeResponseModel> items = jsonToObject(json, url);
        for (TVMazeResponseModel item : items) {
            responseList.add(tvMazeResponseModelToResponseModel(item));
        }
        return responseList;
    }

    private List<TVMazeResponseModel> jsonToObject(String json, String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<List<TVMazeResponseModel>>(){});
        } catch (JsonProcessingException e) {
            logger.error("An error occurred in processing the response to the following request: ".concat(url), e);
            return new ArrayList<>();
        }
    }

    private ResponseModel tvMazeResponseModelToResponseModel(TVMazeResponseModel tvMazeResponseModel) {
        return new ResponseModel(
                tvMazeResponseModel.getShow().getName(), tvMazeResponseModel.getShow().getType(),
                tvMazeResponseModel.getShow().getGenres() != null ? tvMazeResponseModel.getShow().getGenres().toString() : "",
                tvMazeResponseModel.getShow().getName(),
                tvMazeResponseModel.getShow().getImage() != null ? tvMazeResponseModel.getShow().getImage().getOriginal() : "",
                tvMazeResponseModel.getShow().getRuntime() != null ? timeExpressedInMinutes(tvMazeResponseModel.getShow().getRuntime()) : "",
                tvMazeResponseModel.getShow().getUrl(), tvMazeResponseModel.getShow().getOfficialSite(),
                tvMazeResponseModel.getShow().getPremiered(), TV_MAZE_URL, SERVICE_IMG_URL);
    }

    private void errorResponseMessages(String url, HttpStatus httpStatus) {
        logger.error("A problem occurred while performing the following query: ".concat(url));
        logger.error("Http status: ".concat(String.valueOf(httpStatus.value())).concat(", ").concat(httpStatus.getReasonPhrase()));
    }

    private String timeExpressedInMinutes(Long timeLength) {
        return String.valueOf(timeLength).concat(" min");
    }

}
