import Models.Artist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spotify.api.spotify.SpotifyApi;

import java.util.List;


@SpringBootApplication (scanBasePackages = {
        "default"
})

@RestController
public class RESTApp {
    public static void main(String[] args) {
        SpringApplication.run(RESTApp.class, args);
    }

    @RequestMapping(value = "/CompareArtists", method = RequestMethod.GET)
    public List<Artist> getArtistComp(@RequestParam() String artistID1, @RequestParam() String artistID2){
        SpotifyApi spotifyApi = RefreshAuth.refreshAuth();
        CompareArtist compareArtist = new CompareArtist(spotifyApi);
        return compareArtist.compareArtist(artistID1,artistID2);
    }
}
