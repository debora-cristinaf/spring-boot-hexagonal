package com.debora.hexagonal.wiremock;

import com.debora.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {WireMockInitializer.class})
class FindAddressByZipCodeTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @AfterEach
    public void afterEach() {
        this.wireMockServer.resetAll();
    }

    @Test
    void testGetAllTodosShouldReturnDataFromClient() {
        this.wireMockServer.stubFor(
                WireMock.get("/33100000")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody("{\n" +
                                        "            \"street\": \"Rua Hexagonal\",\n" +
                                        "            \"city\": \"Uberlândia\",\n" +
                                        "            \"state\": \"Minas Gerais\"\n" +
                                        "        }"))
        );

        var address = this.findAddressByZipCodeClient.find("33100000");

        Assertions.assertEquals(address.getState(), "Minas Gerais");
        Assertions.assertEquals(address.getCity(), "Uberlândia");
        Assertions.assertEquals(address.getStreet(), "Rua Hexagonal");

    }
}
