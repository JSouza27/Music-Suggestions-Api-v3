package br.com.musicsuggestions.dto;

public class SpotifyDTO {

    private String categoryId;
    private String spotifyToken;

    public SpotifyDTO(String categoryId, String spotifyToken) {
        this.categoryId = categoryId;
        this.spotifyToken = spotifyToken;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getToken() {
        return spotifyToken;
    }

    public void setToken(String spotifyToken) {
        this.spotifyToken = spotifyToken;
    }
}
