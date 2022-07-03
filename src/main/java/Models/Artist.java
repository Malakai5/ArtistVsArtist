package Models;

import spotify.models.albums.AlbumFull;
import spotify.models.artists.ArtistFull;
import spotify.models.generic.Image;

import java.awt.*;
import java.util.List;

public class Artist{
    String name;
    int followers;
    int popularity;
    Image imageURL;
    List<String> genres;
    List<Track> topSongs;
    Album topAlbum;

    public Artist(ArtistFull artist, List<Track> topSongs, Album topAlbum){
        this.name = artist.getName();
        this.followers = artist.getFollowers().getTotal();
        this.genres = artist.getGenres();
        this.imageURL = artist.getImages().get(0);
        this.popularity = artist.getPopularity();
        this.topSongs = topSongs;
        this.topAlbum = topAlbum;
    }

    public Artist() {
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

    public Image getImageURL() {
        return imageURL;
    }

    public void setImageURL(Image imageURL) {
        this.imageURL = imageURL;
    }


}
