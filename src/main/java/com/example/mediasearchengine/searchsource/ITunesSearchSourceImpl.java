package com.example.mediasearchengine.searchsource;

import com.example.mediasearchengine.model.ResponseModel;
import com.example.mediasearchengine.model.itunes.ITunesResponseModel;
import com.example.mediasearchengine.model.itunes.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ITunesSearchSourceImpl implements SearchSource {

    private Logger logger = LoggerFactory.getLogger(ITunesSearchSourceImpl.class);

    private static final String I_TUNES_URL = "https://itunes.apple.com";

    private static final String I_TUNES_API_URL = I_TUNES_URL.concat("/search?term=");

    private static final String SERVICE_IMG_URL = "https://km.support.apple.com/resources/sites/APPLE/content/live/IMAGES/0/IM749/en_US/itunes-macos-icon-240.png";

    @Override
    public List<ResponseModel> search(String encodedSearchCriteria) {
        String url = I_TUNES_API_URL.concat(encodedSearchCriteria);
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
        ITunesResponseModel iTunesResponseModel = jsonToObject(json, url);
        for (Result result : iTunesResponseModel.getResults()) {
            responseList.add(resultToResponseModel(result));
        }
        return responseList;
    }

    private ITunesResponseModel jsonToObject(String json, String url) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, ITunesResponseModel.class);
        } catch (JsonProcessingException e) {
            logger.error("An error occurred in processing the response to the following request: ".concat(url), e);
            return new ITunesResponseModel();
        }
    }

    private ResponseModel resultToResponseModel(Result result) {
        return new ResponseModel(result.getTrackName(), result.getKind(), result.getPrimaryGenreName(), result.getArtistName(),
                result.getArtworkUrl100(),
                result.getTrackTimeMillis() != null ? millisToMinutes(result.getTrackTimeMillis()) : "",
                result.getTrackViewUrl(), result.getArtistViewUrl(),
                result.getReleaseDate() != null && !result.getReleaseDate().isEmpty() ? extractOnlyTheDate(result.getReleaseDate(), result.getTrackName()) : "",
                I_TUNES_URL, SERVICE_IMG_URL);
    }

    private void errorResponseMessages(String url, HttpStatus httpStatus) {
        logger.error("A problem occurred while performing the following query: ".concat(url));
        logger.error("Http status: ".concat(String.valueOf(httpStatus.value())).concat(", ").concat(httpStatus.getReasonPhrase()));
    }

    private String millisToMinutes(long timeInMillis) {
        return String.format("%02d min, %02d sec", TimeUnit.MILLISECONDS.toMinutes(timeInMillis),
                TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMillis))
        );
    }

    private String extractOnlyTheDate(String dateTime, String elementName) {
        String formattedDate = "";
        SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat dateToStringFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = stringToDateFormat.parse(dateTime.replaceAll("Z$", "+0000"));
            formattedDate = dateToStringFormat.format(date);
        } catch (ParseException e) {
            logger.error("An error occurred in processing the release date of the \"".concat(elementName).concat("\" element of the source: ".concat(I_TUNES_URL)), e);
        }
        return formattedDate;
    }

}
