package com.example.mediasearchengine.service;

import com.example.mediasearchengine.model.ResponseModel;
import com.example.mediasearchengine.searchsource.SearchSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SearchService {

    private final List<SearchSource> searchSources;

    @Autowired
    public SearchService(List<SearchSource> searchSources) {
        this.searchSources = searchSources;
    }

    public List<ResponseModel> performSearch(String encodedSearchCriteria) {
        List<ResponseModel> responseList = new ArrayList<>();
        for (SearchSource searchSource : searchSources) {
            responseList.addAll(searchSource.search(encodedSearchCriteria));
        }
        return sortList(responseList);
    }

    private List<ResponseModel> sortList(List<ResponseModel> items) {
        Comparator<ResponseModel> compareByName = Comparator.comparing(ResponseModel::getName);
        items.sort(compareByName);
        return items;
    }

}
