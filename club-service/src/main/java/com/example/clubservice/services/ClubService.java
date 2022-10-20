package com.example.clubservice.services;

import com.example.clubservice.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService implements IClubService {
    @Autowired
    private ClubRepository clubRepository;
}

