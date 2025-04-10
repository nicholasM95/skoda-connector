package be.nicholasmeyers.skodaconnector.resource;

public class ConsentInfo {
    private final String hmac;

    public ConsentInfo(String hmac) {
        this.hmac = hmac;
    }

    public String getHmac() {
        return hmac;
    }
}
