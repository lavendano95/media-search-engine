package com.example.mediasearchengine.model;

public class ResponseModel {

    private String name;
    private String kind;
    private String genre;
    private String artistName;
    private String artwork;
    private String timeLengthInMinutes;
    private String viewUrl;
    private String artistSite;
    private String releaseDate;
    private String source;
    private String sourceServiceImgUrl;

    public ResponseModel(String name, String kind, String genre, String artistName, String artwork, String timeLengthInMinutes, String viewUrl, String artistSite, String releaseDate, String source, String sourceServiceImgUrl) {
        this.name = name != null ? name : "";
        this.kind = kind != null ? kind : "";
        this.genre = genre != null ? genre : "";
        this.artistName = artistName != null ? artistName : "";
        this.artwork = artwork != null ? artwork : "";
        this.timeLengthInMinutes = timeLengthInMinutes != null ? timeLengthInMinutes : "";
        this.viewUrl = viewUrl != null ? viewUrl : "";
        this.artistSite = artistSite != null ? artistSite : "";
        this.releaseDate = releaseDate != null ? releaseDate : "";
        this.source = source != null ? source : "";
        this.sourceServiceImgUrl = sourceServiceImgUrl != null ? sourceServiceImgUrl : "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public String getTimeLengthInMinutes() {
        return timeLengthInMinutes;
    }

    public void setTimeLengthInMinutes(String timeLengthInMinutes) {
        this.timeLengthInMinutes = timeLengthInMinutes;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getArtistSite() {
        return artistSite;
    }

    public void setArtistSite(String artistSite) {
        this.artistSite = artistSite;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceServiceImgUrl() {
        return sourceServiceImgUrl;
    }

    public void setSourceServiceImgUrl(String sourceServiceImgUrl) {
        this.sourceServiceImgUrl = sourceServiceImgUrl;
    }

}
