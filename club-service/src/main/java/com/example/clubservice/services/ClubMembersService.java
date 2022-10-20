package com.example.clubservice.services;

import com.example.clubservice.repositories.ClubMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubMembersService implements IClubMembersService {
    @Autowired
    private ClubMembersRepository clubMembersRepository;

}

