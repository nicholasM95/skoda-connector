package be.nicholasmeyers.skodaconnector.web.out;

import be.nicholasmeyers.skodaconnector.resource.AuthorizationInfo;
import be.nicholasmeyers.skodaconnector.resource.ConsentInfo;
import be.nicholasmeyers.skodaconnector.resource.FinalAuthorizationInfo;
import be.nicholasmeyers.skodaconnector.resource.SsoLogin;
import be.nicholasmeyers.skodaconnector.resource.StartAuthorization;
import be.nicholasmeyers.skodaconnector.resource.SuccessInfo;
import be.nicholasmeyers.skodaconnector.resource.TokenInfo;
import be.nicholasmeyers.skodaconnector.resource.Tokens;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VWGClientImplTest {
    private VWGClientImpl vwgClient;
    private TokenClientImpl tokenClient;
    private IdentityClientHelper identityClientHelper;

    @BeforeEach
    public void setup() {
        tokenClient = new TokenClientImpl();
        identityClientHelper = new IdentityClientHelper(new IdentityClientImpl());
        vwgClient = new VWGClientImpl();
    }

    @Test
    public void getAccessToken() {
        Tokens tokens = tokenClient.getTokens(getTokenInfo());
        String accessToken = vwgClient.getAccessToken(tokens.getIdToken());
        Assertions.assertNotNull(accessToken);
    }

    private TokenInfo getTokenInfo() {
        StartAuthorization startAuthorization = identityClientHelper.getStartAuthorization();
        AuthorizationInfo authorizationInfo = identityClientHelper.getAuthorizationInfo(startAuthorization);
        identityClientHelper.postEmail(startAuthorization, authorizationInfo);

        FinalAuthorizationInfo finalAuthorizationInfo = identityClientHelper.getFinalAuthorizationInfo(startAuthorization, authorizationInfo);

        SsoLogin ssoLogin = identityClientHelper.postEmailPassword(startAuthorization, authorizationInfo, finalAuthorizationInfo);
        ConsentInfo consentInfo = identityClientHelper.ssoLogin(startAuthorization, authorizationInfo, ssoLogin);
        SuccessInfo successInfo = identityClientHelper.checkConsent(startAuthorization, authorizationInfo, ssoLogin, consentInfo);

        return identityClientHelper.handleSuccess(startAuthorization, authorizationInfo, ssoLogin, successInfo);
    }
}
