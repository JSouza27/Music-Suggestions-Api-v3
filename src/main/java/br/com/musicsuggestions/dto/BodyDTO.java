package br.com.musicsuggestions.dto;

public class BodyDTO {

    private Long userId;
    private String city;
    private String spotifyToken;

    public BodyDTO() {
    }

    public BodyDTO(Long userId, String city, String spotifyToken) {
        this.userId = userId;
        this.city = city;
        this.spotifyToken = spotifyToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpotifyToken() {
        return spotifyToken;
    }

    public void setSpotifyToken(String spotifyToken) {
        this.spotifyToken = spotifyToken;
    }
}
