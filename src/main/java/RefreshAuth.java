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
        System.out.println("CLICK ON THIS LINK: " + authorizationCodeFlow.constructUrl() + " AND COPY THE CODE VALUE INTO RefreshAuth LINE 33\n\n");
        AuthorizationRequestToken authorizationRequestToken = new AuthorizationRequestToken();
        AuthorizationCodeFlowTokenResponse token = authorizationRequestToken
                .getAuthorizationCodeToken(
                        "d4ceff4850ae48979fb290d9925e3376",
                        "0a5689cdcad94340a85138e8e298a992",
                        "AQDGprJp-Zq7cHykiDcS51zZ0XBO45vbreU1oHptyrzmbOBMZagpMW4E3nYiNVWbTbFXk-D8rkQfjK0rS0aU-8x_ZsU44EsDTaMILu3yBRXRJ2pSn4rpF0ZxKhF0xhh1755qCOHKv1TjsqxS-u3mVDtGev_KYtKQjPIINM-yvFSRgRhdHghGdmJ76wyX0w",
                        "http://localhost:8888/");
        return new SpotifyApi(accessToken);
    }
}
