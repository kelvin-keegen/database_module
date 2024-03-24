package com.appsbykeegan.api.pgdatabase.controller;

import com.appsbykeegan.api.pgdatabase.model.ResponseTemplate;
import com.appsbykeegan.api.pgdatabase.service.SampleObjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "api/v1",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class SampleObjectController {

    private final SampleObjectService sampleObjectService;

    @GetMapping(path = "/get_all")
    public ResponseTemplate getAllSampleObjects_API() {

        return sampleObjectService.getAllObjects();
    }

}
