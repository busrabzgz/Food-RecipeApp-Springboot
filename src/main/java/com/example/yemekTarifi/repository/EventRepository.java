package com.example.yemekTarifi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.events.Event;

import java.util.List;

public class EventRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
