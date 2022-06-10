package Models;

import spotify.models.albums.AlbumFull;
import spotify.models.albums.AlbumSimplified;

import java.util.List;

public class Album {
    private String name;
    private int popularity;
    private String type;
    private String artistName;
    private List<String> genres;
    private String releaseDate;


    public Album(AlbumFull albumFull){
        this.name = albumFull.getName();
        this.popularity = albumFull.getPopularity();
        this.type = albumFull.getType();
        this.artistName = albumFull.getArtists().get(0).getName();
        this.genres = albumFull.getGenres();
        this.releaseDate = albumFull.getReleaseDate();
    }

    public Album() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
