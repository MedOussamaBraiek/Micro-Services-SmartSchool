package com.example.clubservice.controllers;

import com.example.clubservice.services.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubController {
    @Autowired
    private IClubService clubService;
}
