package br.com.musicsuggestions.authorization;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

import java.net.URI;

@Service
public class SpotifyAuthorization {

    private URI redirectUri = SpotifyHttpManager
        .makeUri("http://localhost:8080/auth/spotify/callback ");

    public SpotifyApi getSpotifyBuilder(String clientId, String clientSecret) {
        SpotifyApi spotifyApi = SpotifyApi.builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();

        return spotifyApi;
    }
}
