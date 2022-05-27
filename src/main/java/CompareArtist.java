import spotify.api.enums.AlbumType;
import spotify.api.spotify.SpotifyApi;
import spotify.models.albums.AlbumFull;
import spotify.models.albums.AlbumSimplified;
import spotify.models.artists.ArtistFull;
import spotify.models.paging.Paging;
import spotify.models.tracks.TrackFull;
import spotify.models.tracks.TrackFullCollection;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareArtist {

    SpotifyApi spotifyApi;

    public CompareArtist(SpotifyApi spotifyApi){
        this.spotifyApi = spotifyApi;
    }
    public ArtistFull getArtist(String artistID){
        return spotifyApi.getArtist(artistID);
    }

    public List<TrackFull> getPopularTracks(ArtistFull artist){
        Map<String, String> optionalParameters = new HashMap<>();
        optionalParameters.put("market", "ES");
        List<TrackFull> tracks = spotifyApi.getArtistTopTracks(artist.getId(),optionalParameters).getTracks();
        List<TrackFull> topThreeTracks = new ArrayList<>();
        topThreeTracks.add(tracks.get(0));
        topThreeTracks.add(tracks.get(1));
        topThreeTracks.add(tracks.get(2));
        return topThreeTracks;
    }


    public AlbumFull getMostPopularAlbum(ArtistFull artist){
        Map<String, String> optionalParameters = new HashMap<>();
        optionalParameters.put("market", "ES");
        optionalParameters.put("limit", "5");
        List<AlbumFull> correct = new ArrayList<>();
        List<AlbumType> albumType = new ArrayList<>();

        albumType.add(0,AlbumType.ALBUM);
        Paging<AlbumSimplified> temp = spotifyApi.getArtistAlbums(artist.getId(), albumType, optionalParameters);
        List<AlbumSimplified> albums = temp.getItems();
        albums.forEach(album -> {
            correct.add(spotifyApi.getAlbum(album.getId(), optionalParameters));
        });

        return getTopAlbum(correct);
    }


    public void compareArtist(String artistID1, String artistID2){
        ArtistFull firstArtist = getArtist(artistID1);
        ArtistFull secondArtist = getArtist(artistID2);
        List<TrackFull> firstArtistSongs = getPopularTracks(firstArtist);
        List<TrackFull> secondArtistSongs = getPopularTracks(secondArtist);
        String result = "";
        String genre = "GENRE:";

        result += String.format("%20s%20s","\n" + firstArtist.getName(),secondArtist.getName() + "\n");
        result += "----------------------------------------\n";
        result += String.format("%6s%14s%20s","GENRE:",firstArtist.getGenres(),secondArtist.getGenres() + "\n");
        result += String.format("%10s%10s%20s","FOLLOWERS:",firstArtist.getFollowers().getTotal(),secondArtist.getFollowers().getTotal() + "\n");
        result += String.format("%11s%9s%20s","POPULARITY:",firstArtist.getPopularity(),secondArtist.getPopularity() + "\n\n");


        result += String.format("%30s", "Most Popular Albums\n");
        result += "----------------------------------------\n\n";
        result += getMostPopularAlbum(firstArtist).getName() + " " + getMostPopularAlbum(firstArtist).getPopularity() + "\n\n";
        result += getMostPopularAlbum(secondArtist).getName() + " " + getMostPopularAlbum(secondArtist).getPopularity()+ "\n\n";


        result += "----------------------------------------\n\n";
        result += String.format("%30s", firstArtist.getName() + "\n");
        result += addTopSongs(firstArtistSongs);
        result += "========================================\n";
        result += String.format("%30s", secondArtist.getName() + "\n");
        result += addTopSongs(secondArtistSongs);

        System.out.println(result);

    }

    private String addTopSongs(List<TrackFull> tracks){

        int count = 0;
        StringBuilder resultBuilder = new StringBuilder();
        while(count < 3){
            resultBuilder.append(tracks.get(count).getName()).append(": ").append(tracks.get(count).getPopularity()).append("\n");
            count++;
        }
        return resultBuilder.toString();
    }

    private AlbumFull getTopAlbum(List<AlbumFull> albums){
        int pop = 0;
        AlbumFull topAlbum = new AlbumFull();
        for (AlbumFull album : albums) {
            if (album.getPopularity() > pop) {
                pop = album.getPopularity();
                topAlbum = album;
            }
        }
        return topAlbum;
    }


}
