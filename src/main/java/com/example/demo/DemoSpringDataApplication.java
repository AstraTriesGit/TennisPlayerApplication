package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoSpringDataApplication {
    @Autowired
    PlayerSpringDataRepository repo;

}
