package com.example.clubservice.services;
import com.example.clubservice.entites.CLubMembers;
public interface IClubMembersService {
    public CLubMembers addClubMember(CLubMembers clubMember);
    public CLubMembers updateClubMember(CLubMembers clubMember);
    public void deleteClubMember(Long id);


}
