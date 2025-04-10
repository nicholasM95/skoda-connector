package be.nicholasmeyers.skodaconnector.service;

import be.nicholasmeyers.skodaconnector.resource.TokenInfo;
import be.nicholasmeyers.skodaconnector.resource.Tokens;

public interface TokenService {
    Tokens getTokens(TokenInfo tokenInfo);
}
