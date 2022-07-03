package Services;

import Models.Album;
import Models.Artist;
import Models.Track;
import spotify.api.enums.AlbumType;
import spotify.api.spotify.SpotifyApi;
import spotify.models.albums.AlbumFull;
import spotify.models.albums.AlbumSimplified;
import spotify.models.artists.ArtistFull;
import spotify.models.tracks.TrackFull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareArtist{

    SpotifyApi spotifyApi;

    public CompareArtist(SpotifyApi spotifyApi){
        this.spotifyApi = spotifyApi;
    }
    public ArtistFull getArtist(String artistID){
        return spotifyApi.getArtist(artistID);
    }

    public List<Track> getPopularTracks(String artistID){
        Map<String, String> optionalParameters = new HashMap<>();
        optionalParameters.put("market", "ES");
        List<TrackFull> tracks = spotifyApi.getArtistTopTracks(artistID,optionalParameters).getTracks();
        List<Track> topThreeTracks = new ArrayList<>();
        topThreeTracks.add(new Track(tracks.get(0)));
        topThreeTracks.add(new Track(tracks.get(1)));
        topThreeTracks.add(new Track(tracks.get(2)));
        return topThreeTracks;
    }

    public Album getMostPopularAlbum(String artistID){
        Map<String, String> optionalParameters = new HashMap<>();
        optionalParameters.put("market", "ES");
        optionalParameters.put("limit", "5");
        List<Album> correct = new ArrayList<>();
        List<AlbumType> albumType = new ArrayList<>();
        albumType.add(0,AlbumType.ALBUM);

        List<AlbumSimplified> albums = spotifyApi.getArtistAlbums(artistID, albumType, optionalParameters).getItems();
        albums.forEach(album -> {
            correct.add(new Album(spotifyApi.getAlbum(album.getId(), optionalParameters)));
        });

        return getTopAlbum(correct);
    }

    public List<Artist> compareArtist(String artistID1, String artistID2){
        List<Track> firstArtistSongs = getPopularTracks(artistID1);
        List<Track> secondArtistSongs = getPopularTracks(artistID2);
        Artist firstArtist = getArtistInfo(artistID1);
        Artist secondArtist = getArtistInfo(artistID2);
        List<Artist> artists = new ArrayList<>();
        artists.add(firstArtist);
        artists.add(secondArtist);
        String result = "";

        result += String.format("%20s%20s","\n" + firstArtist.getName(),secondArtist.getName() + "\n");
        result += "----------------------------------------\n";
        result += String.format("%6s%14s%20s","GENRE:",firstArtist.getGenres(),secondArtist.getGenres() + "\n");
        result += String.format("%10s%10s%20s","FOLLOWERS:",firstArtist.getFollowers(),secondArtist.getFollowers() + "\n");
        result += String.format("%11s%9s%20s","POPULARITY:",firstArtist.getPopularity(),secondArtist.getPopularity() + "\n\n");


        result += String.format("%30s", "Most Popular Albums\n");
        result += "----------------------------------------\n\n";
        result += firstArtist.getTopAlbum().getName() + " " + firstArtist.getTopAlbum().getPopularity() + "\n\n";
        result += secondArtist.getTopAlbum().getName() + " " + secondArtist.getTopAlbum().getPopularity()+ "\n\n";


        result += "----------------------------------------\n\n";
        result += String.format("%30s", firstArtist.getName() + "\n");
        result += addTopSongs(firstArtistSongs);
        result += "========================================\n";
        result += String.format("%30s", secondArtist.getName() + "\n");
        result += addTopSongs(secondArtistSongs);

        System.out.println(result);
        return artists;
    }

    private String addTopSongs(List<Track> tracks){

        int count = 0;
        StringBuilder resultBuilder = new StringBuilder();
        while(count < 3){
            resultBuilder.append(tracks.get(count).getName()).append(": ").append(tracks.get(count).getPopularity()).append("\n");
            count++;
        }
        return resultBuilder.toString();
    }

    private Album getTopAlbum(List<Album> albums){
        int pop = 0;
        Album topAlbum = new Album();
        for (Album album : albums) {
            if (album.getPopularity() > pop) {
                pop = album.getPopularity();
                topAlbum = album;
            }
        }
        return topAlbum;
    }

    public Artist getArtistInfo(String artistID){
        return new Artist(getArtist(artistID),getPopularTracks(artistID),getMostPopularAlbum(artistID));
    }


}
