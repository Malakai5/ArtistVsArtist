import APIConnetions.RefreshAuth;
import Services.Searcher;
import spotify.api.spotify.SpotifyApi;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        SpotifyApi spotifyApi = RefreshAuth.refreshAuth();
        Searcher searcher =  new Searcher(spotifyApi);
        searcher.searchForArtist("Drake").forEach(artistFull -> System.out.println(artistFull.getName()));
//        Map<String, String> optionalParameters = new HashMap<>();
//        optionalParameters.put("limit", "5");
//        ArtistFullCollection taylor = spotifyApi.getRelatedArtists("06HL4z0CvFAxyc27GXpf02");
//        taylor.getArtists().forEach(artist ->{
//            System.out.println(artist.getName() + "\nPopularity:  " + artist.getPopularity() + "\n");
//        });
//        ArtistFullCollection jayZ = spotifyApi.getRelatedArtists("3nFkdlSjzX9mRTtwJOzDYB");
//        jayZ.getArtists().forEach(artist ->{
//            System.out.println(artist.getName() + "\nPopularity:  " + artist.getPopularity() + "\n");
//        });
//        Services.CompareArtist comp = new Services.CompareArtist(spotifyApi);
//        ArtistFull artist = comp.getArtist("06HL4z0CvFAxyc27GXpf02");
//        comp.getMostPopularAlbum(artist);
//        comp.getPopularTracks(artist);
//        comp.compareArtist("699OTQXzgjhIYAHMy9RyPD","4O15NlyKLIASxsJ0PrXPfz");
//        System.out.println("done");
        //Create an artist comparison service


    }

}
