package com.wipro.bindhu.services;



import java.util.List;

import com.wipro.bindhu.entities.*;

public interface SchoolService {
    School save(School school);
    List<School> findAll();
    School findById(Long id);
    School update(Long id, School school);
    School patchUpdate(Long id, String schoolName);
    void delete(Long id);
	List<School> findBySchoolName(String name);
	List<School> findBySchoolAddress(String address);
}


