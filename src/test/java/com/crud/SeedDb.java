package com.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.service.H2CSVExample;

public class SeedDb {

    private H2CSVExample csvSeeder;

    @BeforeEach
    public void before() {
        csvSeeder = new H2CSVExample();
    }

    @Test
    public void seedDb() throws Exception {
        csvSeeder.seedDb();
    }
}
