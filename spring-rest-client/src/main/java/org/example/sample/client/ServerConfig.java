package org.example.sample.client;

public class ServerConfig {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBaseUrl() {
        return "http://" + host + ":" + port;
    }

    public String getUrl(String path) {
        final String baseUrl = getBaseUrl();

        if (path == null || "".equals(path)) {
            return baseUrl;
        }

        return path.startsWith("/") ? baseUrl + path : baseUrl + "/" + path;
    }
}
