package com.example.service.util;

import com.example.service.ReportService;
import org.springframework.stereotype.Service;


import java.io.File;
import java.nio.file.Files;

@Service
public class ReportServiceImpl implements ReportService {


    @Override
    public byte[] generateReport() {


        try {

            byte[] bFile = Files.readAllBytes(new File("C:\\report.pdf").toPath());
            return bFile;
        } catch (Exception e) {

        }

        return new byte[0];
    }
}
