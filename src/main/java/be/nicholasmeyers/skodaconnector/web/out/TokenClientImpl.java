package be.nicholasmeyers.skodaconnector.web.out;

import be.nicholasmeyers.skodaconnector.resource.TokenInfo;
import be.nicholasmeyers.skodaconnector.resource.Tokens;
import be.nicholasmeyers.skodaconnector.service.TokenService;
import be.nicholasmeyers.skodaconnector.web.out.resource.CodeExchangeWebRequestResource;
import be.nicholasmeyers.skodaconnector.web.out.resource.TokenWebResponseResource;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class TokenClientImpl implements TokenService {
    private final TokenClient tokenClient;

    public TokenClientImpl() {
        this.tokenClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(TokenClient.class, "https://mysmob.api.connect.skoda-auto.cz");
    }

    @Override
    public Tokens getTokens(TokenInfo tokenInfo) {
        CodeExchangeWebRequestResource codeExchangeWebRequestResource = new CodeExchangeWebRequestResource();
        codeExchangeWebRequestResource.setCode(tokenInfo.getAuthCode());
        codeExchangeWebRequestResource.setRedirectUri(tokenInfo.getRedirectUri());
        codeExchangeWebRequestResource.setVerifier(tokenInfo.getVerifier());
        TokenWebResponseResource webResponseResource = tokenClient.getTokens(codeExchangeWebRequestResource);
        return new Tokens(webResponseResource.getAccessToken(), webResponseResource.getIdToken(), webResponseResource.getRefreshToken());
    }
}
