package com.example.controller;


import com.example.service.ReportService;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;

@RestController()
@RequestMapping("/api")
@CrossOrigin("*")
public class ReportController {



    private ReportService reportService;

    @Autowired
    ReportController( ReportService reportService) {
        this.reportService = reportService;
    }

//    @GetMapping( path = "/report")
//    ResponseEntity<String>  index() {
//
//        byte[] result = reportService.generateReport();
//        Gson gson = new Gson();
//        return  new ResponseEntity<>( gson.toJson("hola mundo"), HttpStatus.OK);
//    }

    @RequestMapping(value="/report", method= RequestMethod.GET)
    public ResponseEntity<byte[]> report() {

        byte[] result = reportService.generateReport();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
