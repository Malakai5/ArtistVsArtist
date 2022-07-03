package Services;

import Models.Artist;
import spotify.api.enums.QueryType;
import spotify.api.spotify.SpotifyApi;
import spotify.models.artists.ArtistFull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Searcher {

    private SpotifyApi spotifyApi;

    public Searcher(SpotifyApi spotifyApi) {
        this.spotifyApi = spotifyApi;
    }

    public List<ArtistFull> searchForArtist(String artist){
        Map<String,String> optionalParameters = new HashMap<>();
        optionalParameters.put("market", "ES");
        optionalParameters.put("limit", "5");
        optionalParameters.put("offset", "0");
        List<QueryType> types = new ArrayList<>();
        types.add(QueryType.ARTIST);

        return spotifyApi.searchItem(artist,types,optionalParameters).getArtists().getItems();
    }

}
