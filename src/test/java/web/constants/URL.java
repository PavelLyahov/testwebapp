package web.constants;

public enum URL {
    START_PAGE("https://www.google.co.in");

    URL(String url) {
        this.url = url;
    }

    private final String url;

    public String getUrl() {
        return url;
    }
}
