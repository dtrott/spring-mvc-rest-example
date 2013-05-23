package org.example.sample.client;

import org.example.sample.web.rest.RestHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.support.PrefixedRestOperations;

@Component
public class MyClient extends PrefixedRestOperations {

    private final ServerConfig serverConfig;

    @Autowired
    public MyClient(RestOperations restTemplate, ServerConfig serverConfig) {
        super(restTemplate);
        this.serverConfig = serverConfig;
    }

    @Override
    protected String prefixUrl(String path) {
        return serverConfig.getUrl(path);
    }

    public void execute(String name) {
        final RestHello hello = getForObject("/api/hello/{name}", RestHello.class, name);
        System.out.println(hello.getId());
    }
}
