package be.nicholasmeyers.skodaconnector.service;

import be.nicholasmeyers.skodaconnector.resource.Client;
import be.nicholasmeyers.skodaconnector.resource.Tokens;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static be.nicholasmeyers.skodaconnector.util.UserUtils.getEmail;
import static be.nicholasmeyers.skodaconnector.util.UserUtils.getPassword;

public class ConnectorServiceTest {

    private ConnectorService connectorService;

    @BeforeEach
    public void setup() {
        connectorService = new ConnectorService();
    }

    @Test
    public void testConnect() {
        Tokens tokens = connectorService.getTokens(Client.CONNECT, getEmail(), getPassword());
        Assertions.assertNotNull(tokens.getAccessToken());
        Assertions.assertNotNull(tokens.getIdToken());
        Assertions.assertNotNull(tokens.getRefreshToken());
    }

    @Test
    public void testVWG() {
        Tokens tokens = connectorService.getTokens(Client.VWG, getEmail(), getPassword());
        Assertions.assertNotNull(tokens.getAccessToken());
        Assertions.assertNotNull(tokens.getIdToken());
        Assertions.assertNotNull(tokens.getRefreshToken());
    }
}
