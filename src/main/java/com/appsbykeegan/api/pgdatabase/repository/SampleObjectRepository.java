package com.appsbykeegan.api.pgdatabase.repository;

import com.appsbykeegan.api.pgdatabase.model.SampleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SampleObjectRepository extends JpaRepository<SampleObject,Integer> {

    //Optional<SampleObject> findById(int objectId);

    Optional<SampleObject> findByEmail(String email);

    Optional<SampleObject> findByPhoneNumber(long phoneNumber);

    List<SampleObject> findByCountry(String country);

}
