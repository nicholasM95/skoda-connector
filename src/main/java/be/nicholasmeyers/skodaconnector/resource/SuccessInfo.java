package be.nicholasmeyers.skodaconnector.resource;

public class SuccessInfo {
    private final String hmac;

    public SuccessInfo(String hmac) {
        this.hmac = hmac;
    }

    public String getHmac() {
        return hmac;
    }
}
