package Models;

import spotify.models.artists.ArtistSimplified;
import spotify.models.tracks.TrackFull;

import java.util.ArrayList;
import java.util.List;

public class Track {
    String id;
    boolean isPlayable;
    String name;
    String type;
    int durationMs;
    int popularity;
    List<String> artists = new ArrayList<>();
    String album;

    public Track(TrackFull trackFull){
        this.id = trackFull.getId();
        this.album = trackFull.getAlbum().getName();
        setArtists(trackFull.getArtists());
        this.isPlayable = trackFull.isPlayable();
        this.name = trackFull.getName();
        this.durationMs = trackFull.getDurationMs();
        this.popularity = trackFull.getPopularity();
        this.type = trackFull.getType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistSimplified> artists) {
        for (ArtistSimplified artist : artists) {
            this.artists.add(artist.getName());
        }
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
