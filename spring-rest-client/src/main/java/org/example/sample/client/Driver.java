package org.example.sample.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

    public static void main(String[] args) {

        final ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/clientContext.xml", Driver.class);
        final MyClient client = applicationContext.getBean("myClient", MyClient.class);
        client.execute("john");
    }
}
