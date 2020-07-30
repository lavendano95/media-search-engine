package com.example.mediasearchengine.model.itunes;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "wrapperType",
        "kind",
        "artistId",
        "collectionId",
        "trackId",
        "artistName",
        "collectionName",
        "trackName",
        "collectionCensoredName",
        "trackCensoredName",
        "artistViewUrl",
        "collectionViewUrl",
        "trackViewUrl",
        "previewUrl",
        "artworkUrl30",
        "artworkUrl60",
        "artworkUrl100",
        "collectionPrice",
        "trackPrice",
        "releaseDate",
        "collectionExplicitness",
        "trackExplicitness",
        "discCount",
        "discNumber",
        "trackCount",
        "trackNumber",
        "trackTimeMillis",
        "country",
        "currency",
        "primaryGenreName",
        "isStreamable"
})
public class Result {

    @JsonProperty("wrapperType")
    private String wrapperType;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("artistId")
    private Long artistId;
    @JsonProperty("collectionId")
    private Long collectionId;
    @JsonProperty("trackId")
    private Long trackId;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("collectionName")
    private String collectionName;
    @JsonProperty("trackName")
    private String trackName;
    @JsonProperty("collectionCensoredName")
    private String collectionCensoredName;
    @JsonProperty("trackCensoredName")
    private String trackCensoredName;
    @JsonProperty("artistViewUrl")
    private String artistViewUrl;
    @JsonProperty("collectionViewUrl")
    private String collectionViewUrl;
    @JsonProperty("trackViewUrl")
    private String trackViewUrl;
    @JsonProperty("previewUrl")
    private String previewUrl;
    @JsonProperty("artworkUrl30")
    private String artworkUrl30;
    @JsonProperty("artworkUrl60")
    private String artworkUrl60;
    @JsonProperty("artworkUrl100")
    private String artworkUrl100;
    @JsonProperty("collectionPrice")
    private Float collectionPrice;
    @JsonProperty("trackPrice")
    private Float trackPrice;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("collectionExplicitness")
    private String collectionExplicitness;
    @JsonProperty("trackExplicitness")
    private String trackExplicitness;
    @JsonProperty("discCount")
    private Long discCount;
    @JsonProperty("discNumber")
    private Long discNumber;
    @JsonProperty("trackCount")
    private Long trackCount;
    @JsonProperty("trackNumber")
    private Long trackNumber;
    @JsonProperty("trackTimeMillis")
    private Long trackTimeMillis;
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("primaryGenreName")
    private String primaryGenreName;
    @JsonProperty("isStreamable")
    private Boolean isStreamable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("wrapperType")
    public String getWrapperType() {
        return wrapperType;
    }

    @JsonProperty("wrapperType")
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("artistId")
    public Long getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("collectionId")
    public Long getCollectionId() {
        return collectionId;
    }

    @JsonProperty("collectionId")
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    @JsonProperty("trackId")
    public Long getTrackId() {
        return trackId;
    }

    @JsonProperty("trackId")
    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    @JsonProperty("artistName")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("artistName")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("collectionName")
    public String getCollectionName() {
        return collectionName;
    }

    @JsonProperty("collectionName")
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @JsonProperty("trackName")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("trackName")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @JsonProperty("collectionCensoredName")
    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    @JsonProperty("collectionCensoredName")
    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    @JsonProperty("trackCensoredName")
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    @JsonProperty("trackCensoredName")
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    @JsonProperty("artistViewUrl")
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    @JsonProperty("artistViewUrl")
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    @JsonProperty("collectionViewUrl")
    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    @JsonProperty("collectionViewUrl")
    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    @JsonProperty("trackViewUrl")
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    @JsonProperty("trackViewUrl")
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    @JsonProperty("previewUrl")
    public String getPreviewUrl() {
        return previewUrl;
    }

    @JsonProperty("previewUrl")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    @JsonProperty("artworkUrl30")
    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    @JsonProperty("artworkUrl30")
    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    @JsonProperty("artworkUrl60")
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    @JsonProperty("artworkUrl60")
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    @JsonProperty("artworkUrl100")
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    @JsonProperty("artworkUrl100")
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    @JsonProperty("collectionPrice")
    public Float getCollectionPrice() {
        return collectionPrice;
    }

    @JsonProperty("collectionPrice")
    public void setCollectionPrice(Float collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    @JsonProperty("trackPrice")
    public Float getTrackPrice() {
        return trackPrice;
    }

    @JsonProperty("trackPrice")
    public void setTrackPrice(Float trackPrice) {
        this.trackPrice = trackPrice;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("collectionExplicitness")
    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    @JsonProperty("collectionExplicitness")
    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    @JsonProperty("trackExplicitness")
    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    @JsonProperty("trackExplicitness")
    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    @JsonProperty("discCount")
    public Long getDiscCount() {
        return discCount;
    }

    @JsonProperty("discCount")
    public void setDiscCount(Long discCount) {
        this.discCount = discCount;
    }

    @JsonProperty("discNumber")
    public Long getDiscNumber() {
        return discNumber;
    }

    @JsonProperty("discNumber")
    public void setDiscNumber(Long discNumber) {
        this.discNumber = discNumber;
    }

    @JsonProperty("trackCount")
    public Long getTrackCount() {
        return trackCount;
    }

    @JsonProperty("trackCount")
    public void setTrackCount(Long trackCount) {
        this.trackCount = trackCount;
    }

    @JsonProperty("trackNumber")
    public Long getTrackNumber() {
        return trackNumber;
    }

    @JsonProperty("trackNumber")
    public void setTrackNumber(Long trackNumber) {
        this.trackNumber = trackNumber;
    }

    @JsonProperty("trackTimeMillis")
    public Long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    @JsonProperty("trackTimeMillis")
    public void setTrackTimeMillis(Long trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("primaryGenreName")
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    @JsonProperty("primaryGenreName")
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    @JsonProperty("isStreamable")
    public Boolean getIsStreamable() {
        return isStreamable;
    }

    @JsonProperty("isStreamable")
    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
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