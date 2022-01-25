package br.com.musicsuggestions.service;


import br.com.musicsuggestions.authorization.SpotifyAuthorization;

import br.com.musicsuggestions.dto.BodyDTO;
import org.apache.hc.core5.http.ParseException;
import org.apache.tomcat.jni.Buffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchPlaylistsRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;


@Service
public class SpotifyService {

    @Value("${spotify-clinetId}")
    private String clientId;

    @Value("${spotify-clinetSecret}")
    private String clientSecret;

    @Autowired
    private SpotifyAuthorization spotifyAuthorization;

    public String getToken() throws IOException, ParseException, SpotifyWebApiException {
        SpotifyApi spotifyApi = spotifyAuthorization.getSpotifyBuilder(clientId, clientSecret);

        ClientCredentialsRequest request = spotifyApi.clientCredentials().build();
        ClientCredentials credentials = request.execute();
        spotifyApi.setAccessToken(credentials.getAccessToken());

        return spotifyApi.getAccessToken();
    }

    public Paging<PlaylistSimplified> getSpotifyPlaylist(String categoryId, String token) throws IOException, ParseException, SpotifyWebApiException {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(token)
            .build();

        SearchPlaylistsRequest serchPlaylist = spotifyApi.searchPlaylists(categoryId)
            .build();

        Paging<PlaylistSimplified> playlistSimplifiedPaging = serchPlaylist.execute();

        return playlistSimplifiedPaging;
    }
}
