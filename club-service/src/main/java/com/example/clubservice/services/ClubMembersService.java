package com.example.clubservice.services;

import com.example.clubservice.entites.CLubMembers;
import com.example.clubservice.repositories.ClubMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubMembersService implements IClubMembersService {

    @Autowired
    private ClubMembersRepository clubMembersRepository;

    @Override
    public CLubMembers addClubMember(CLubMembers clubMember) {
        return clubMembersRepository.save(clubMember);
    }

    @Override
    public CLubMembers updateClubMember(CLubMembers clubMember) {
        return clubMembersRepository.save(clubMember);
    }

    @Override
    public void deleteClubMember(Long id) {
        clubMembersRepository.deleteById(id);
    }
}




