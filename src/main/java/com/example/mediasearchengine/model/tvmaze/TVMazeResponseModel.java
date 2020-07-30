package com.example.mediasearchengine.model.tvmaze;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "score",
        "show"
})
public class TVMazeResponseModel {

    @JsonProperty("score")
    private Float score;
    @JsonProperty("show")
    private Show show;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("score")
    public Float getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Float score) {
        this.score = score;
    }

    @JsonProperty("show")
    public Show getShow() {
        return show;
    }

    @JsonProperty("show")
    public void setShow(Show show) {
        this.show = show;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}