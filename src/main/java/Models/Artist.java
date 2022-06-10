package Models;

import spotify.models.albums.AlbumFull;
import spotify.models.artists.ArtistFull;
import java.util.List;

public class Artist{
    String name;
    int followers;
    int popularity;
    List<String> genres;
    List<Track> topSongs;
    Album topAlbum;

    public Artist(ArtistFull artist, List<Track> topSongs, Album topAlbum){
        this.name = artist.getName();
        this.followers = artist.getFollowers().getTotal();
        this.genres = artist.getGenres();
        this.popularity = artist.getPopularity();
        this.topSongs = topSongs;
        this.topAlbum = topAlbum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Track> getTopSongs() {
        return topSongs;
    }

    public void setTopSongs(List<Track> topSongs) {
        this.topSongs = topSongs;
    }

    public Album getTopAlbum() {
        return topAlbum;
    }

    public void setTopAlbum(Album topAlbum) {
        this.topAlbum = topAlbum;
    }
}
