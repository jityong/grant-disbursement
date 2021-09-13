//package com.meteor.grant_disbursement;
//
//import com.meteor.grant_disbursement.model.FamilyMember;
//import com.meteor.grant_disbursement.model.Household;
//import com.meteor.grant_disbursement.model.dao.HouseholdRepository;
//import com.meteor.grant_disbursement.model.dto.FamilyMemberDTO;
//import com.meteor.grant_disbursement.model.dto.HouseholdDTO;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class config {
//    @Bean
//    public ModelMapper modelMapper() {
//
//        ModelMapper modelMapper = new ModelMapper();
//        PropertyMap<FamilyMember, FamilyMemberDTO> familyMemberMap1 = new PropertyMap<FamilyMember, FamilyMemberDTO>() {
//            protected void configure() {
//                map().setSpouseId(source.getSpouse().getId());
//            }
//        };
//        PropertyMap<Household, HouseholdDTO> householdMap = new PropertyMap<Household, HouseholdDTO>() {
//            protected void configure() {
//                List<FamilyMemberDTO> familyMemberDTOList = new ArrayList<>();
//                for (FamilyMember familyMember: source.getMembers()) {
//                    familyMemberDTOList.add();
//                }
//                map().setMembers(map(source.getMembers());
//            }
//        };
//        PropertyMap<FamilyMemberDTO, FamilyMember> familyMemberMap2 = new PropertyMap<FamilyMemberDTO, FamilyMember>() {
//            protected void configure() {
//                map().setHousehold(householdRepository.findById(source.getHousehold()).get());
//            }
//        };
//        modelMapper.addMappings(familyMemberMap1);
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapper.addMappings(familyMemberMap2);
//        return modelMapper;
//    }
//
//}
