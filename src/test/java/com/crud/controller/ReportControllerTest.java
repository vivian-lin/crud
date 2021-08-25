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

import com.crud.dto.ReportWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportControllerTest {

    private static final String REPORTS_ENDPOINT = "/reports";
    private static final String SINGLE_REPORT_ENDPOINT = "/reports/{id}";

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
    public void before() throws Exception {
        body = objectMapper.createObjectNode();
    }

    @Test
    public void shouldRespondOkOnGetAll() {
        // TODO clear and re-seed db?

        Response response = given().port(port).when().contentType(ContentType.JSON).get(REPORTS_ENDPOINT).then()
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

        ReportWrapper actual = response.as(ReportWrapper.class);

        // TODO assert
    }

}
