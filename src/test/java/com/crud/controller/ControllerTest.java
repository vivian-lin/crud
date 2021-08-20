package com.crud.controller;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.crud.dto.ValidationError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    private static final String ENDPOINT = "/";

    @Autowired
    private ObjectMapper objectMapper;
    @LocalServerPort
    private int port;

    private ObjectNode body;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @BeforeEach
    public void before() {
        body = objectMapper.createObjectNode();
    }

    @Test
    public void shouldRespondUnprocessableEntityInvalidResourceProvided() {
        body = objectMapper.valueToTree(null);

        Response response = given().port(port).when().body(body).contentType(ContentType.JSON).post(ENDPOINT).then()
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_UNPROCESSABLE_ENTITY);

        ValidationError actual = response.as(ValidationError.class);
        ValidationError expected = ValidationError.builder().build();
        assertThat(actual).isEqualTo(expected);
    }

}
