package br.com.musicsuggestions.utils;

import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;

public interface SelectCategory {

    Paging<PlaylistSimplified> getPlaylist(String categoryId);
}
