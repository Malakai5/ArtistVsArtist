import spotify.api.spotify.SpotifyApi;
import spotify.models.artists.ArtistFull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws IOException {

        SpotifyApi spotifyApi = RefreshAuth.refreshAuth();
        Map<String, String> optionalParameters = new HashMap<>();
        optionalParameters.put("limit", "5");
//        ArtistFullCollection taylor = spotifyApi.getRelatedArtists("06HL4z0CvFAxyc27GXpf02");
//        taylor.getArtists().forEach(artist ->{
//            System.out.println(artist.getName() + "\nPopularity:  " + artist.getPopularity() + "\n");
//        });
//        ArtistFullCollection jayZ = spotifyApi.getRelatedArtists("3nFkdlSjzX9mRTtwJOzDYB");
//        jayZ.getArtists().forEach(artist ->{
//            System.out.println(artist.getName() + "\nPopularity:  " + artist.getPopularity() + "\n");
//        });
        CompareArtist comp = new CompareArtist(spotifyApi);
//        ArtistFull artist = comp.getArtist("06HL4z0CvFAxyc27GXpf02");
//        comp.getMostPopularAlbum(artist);
//        comp.getPopularTracks(artist);
        comp.compareArtist("699OTQXzgjhIYAHMy9RyPD","4O15NlyKLIASxsJ0PrXPfz");
        System.out.println("done");
        //Create an artist comparison service
    }

}
