package br.com.musicsuggestions.service;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;

import java.io.IOException;


@Service
public class SpotifyService {

    public void getToken(SpotifyApi spotifyApi) throws IOException, ParseException, SpotifyWebApiException {
        ClientCredentialsRequest request = spotifyApi.clientCredentials().build();
        ClientCredentials credentials = request.execute();

        spotifyApi.setAccessToken(credentials.getAccessToken());
    }

    public void getPlaylist(SpotifyApi spotifyApi, String playlistId) {
        try {
            GetPlaylistRequest getPlaylistRequest = spotifyApi
                .getPlaylist(playlistId)
                .build();

            Playlist playlist = getPlaylistRequest.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
