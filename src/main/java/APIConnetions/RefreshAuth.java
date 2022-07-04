package APIConnetions;

import spotify.api.authorization.AuthorizationCodeFlow;
import spotify.api.authorization.AuthorizationRequestToken;
import spotify.api.authorization.ClientCredentialsFlow;
import spotify.api.enums.AuthorizationScope;
import spotify.api.spotify.SpotifyApi;
import spotify.models.authorization.AuthorizationCodeFlowTokenResponse;
import java.util.Arrays;

public class RefreshAuth {

    public static SpotifyApi refreshAuth(){
        ClientCredentialsFlow clientCredentialsFlow = new ClientCredentialsFlow();
        String accessToken = clientCredentialsFlow.getClientCredentialToken(
                "d4ceff4850ae48979fb290d9925e3376",
                "0a5689cdcad94340a85138e8e298a992")
                .getAccessToken();

        AuthorizationCodeFlow authorizationCodeFlow = new AuthorizationCodeFlow.Builder()
                .setClientId("d4ceff4850ae48979fb290d9925e3376")
                .setRedirectUri("http://localhost:8888/")
                .setResponseType("code")
                .setScopes(Arrays.asList(
                        AuthorizationScope.APP_REMOTE_CONTROL,
                        AuthorizationScope.PLAYLIST_MODIFY_PRIVATE))
                .build();

        System.out.println("\n\n");
        System.out.println("CLICK ON THIS LINK: " + authorizationCodeFlow.constructUrl() + " AND COPY THE CODE VALUE INTO LINE 33\n\n");

        AuthorizationRequestToken authorizationRequestToken = new AuthorizationRequestToken();
        AuthorizationCodeFlowTokenResponse token = authorizationRequestToken
                .getAuthorizationCodeToken(
                        "d4ceff4850ae48979fb290d9925e3376",
                        "0a5689cdcad94340a85138e8e298a992",
                        "AQA6tsAh6xY4kzOr7at4w2i0NV9iMmfCbYo_VCnr8g2iXqV3y2FTlA39xvwwUtK5vW9TCUvDAj4wvkbJA_cw-MhxWhiN6sKCGT7ScFOUZo0bbyFZzW88tz3msJ2v9rLnmzrNZR7tN80bBoaCCSz4DLxhxmJVtt6b0xcu9u2aoy1XTjbnltf0wQxxX4jE-A",
                        "http://localhost:8888/");

        return new SpotifyApi(accessToken);
    }
}
