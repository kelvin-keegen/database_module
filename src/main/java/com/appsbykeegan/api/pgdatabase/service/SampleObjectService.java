package com.appsbykeegan.api.pgdatabase.service;

import com.appsbykeegan.api.pgdatabase.model.ResponseTemplate;
import com.appsbykeegan.api.pgdatabase.model.SampleObject;
import com.appsbykeegan.api.pgdatabase.repository.SampleObjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SampleObjectService {

    private final SampleObjectRepository sampleObjectRepository;

    public ResponseTemplate getAllObjects() {

        ResponseTemplate responseTemplate;

        // Retrieving data
        List<SampleObject> sampleObjectList = sampleObjectRepository.findAll();

        // Formulating API response
        if (sampleObjectList.size() != 0) {

            responseTemplate = new ResponseTemplate(
                    HttpStatus.OK.value(),
                    "data retrieved successfully",
                    sampleObjectList
            );
        } else if (sampleObjectList.size() == 0) {

            responseTemplate = new ResponseTemplate(
                    HttpStatus.OK.value(),
                    "data retrieved is empty",
                    sampleObjectList
            );
        } else {
            responseTemplate = new ResponseTemplate(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Something went wrong!",
                    null

            );
            log.error("data retrieval failed!");
        }
        return responseTemplate;
    }

    public ResponseTemplate getObjectByEmail(String email) {

        Optional<SampleObject> optionalSampleObject = sampleObjectRepository.findByEmail(email);

        if (optionalSampleObject.isEmpty()) {
            return new ResponseTemplate(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Object could not be found",
                    null
            );
        }

        SampleObject retrievedObject = optionalSampleObject.get();

        return new ResponseTemplate(
                HttpStatus.OK.value(),
                "Object found",
                retrievedObject
        );

    }
}
