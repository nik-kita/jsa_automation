package main_package.api.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClient {
    private String baseUrl = "https://testing-jamessmith-academy.herokuapp.com";
    private String client_id;
    public Logger logger = LoggerFactory.getLogger(this.getClientId());

    public RequestSpecification baseRequestSpecification() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON);
        return builder.build();
    }

    private String client_secret;
    public String getClientId() {
        if(!(client_id == null)) {
            return client_id;
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/credentials.properties"));
        } catch (IOException e) {
            System.err.println("It looks like you forgot to create 'src/resources/credentials.properties' file");
        }
        client_id = properties.getProperty("jsaTestingServerClientId");
        return client_id;
    }

    public String getClientSecret() {
        if(!(client_secret == null)) {
            return client_secret;
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/credentials.properties"));
        } catch (IOException e) {
            System.err.println("It looks like you forgot to create 'src/resources/credentials.properties' file");
        }
        client_secret = properties.getProperty("jsaTestingServerClientSecret");
        return client_secret;
    }
}
