package com.example.mediasearchengine.searchsource;

import com.example.mediasearchengine.model.ResponseModel;

import java.util.List;

public interface SearchSource {

    List<ResponseModel> search(String encodedSearchCriteria);

}
