package com.example.jasperreportdemo;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/generate-report")
    public ResponseEntity<byte[]> generateReport(@RequestParam Map<String, Object> params) throws JRException {
        byte[] pdfReport = reportService.generateReport(params);

        // Set headers for the PDF response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=test-report.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfReport);
    }
}
