package com.example.mediasearchengine.controller;

import com.example.mediasearchengine.model.ResponseModel;
import com.example.mediasearchengine.service.SearchService;
import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class SearchController {

    private static final String MAIN_APPLICATION_PATH = "/media-search-engine";

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Operation(summary = "Make searches in other services from the same search criteria.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Items matching the search criteria are returned in a list.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseModel.class)) }),
            @ApiResponse(responseCode = "400", description = "The search criteria is not valid and cannot be processed.",
                    content = @Content)})
    @CrossOrigin
    @GetMapping(MAIN_APPLICATION_PATH)
    public List<ResponseModel> search(@Parameter(description = "search criteria") @RequestParam(value = "search") String search) {
        try {
            return searchService.performSearch(URLEncoder.encode(search, StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The search criteria entered is not valid.", e);
        }
    }

}
