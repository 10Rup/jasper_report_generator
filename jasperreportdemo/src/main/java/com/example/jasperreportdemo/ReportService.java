package com.example.jasperreportdemo;

import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ReportService {

    public byte[] generateReport(Map<String, Object> parameters) throws JRException {
        // Path to the JRXML file
        String reportPath = "src/main/resources/reports/demo_report.jrxml";

        // Compile the report
        JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

        // Fill the report with data (using parameters passed from controller)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);

        // Export the report to a PDF (you can also export to other formats like HTML, Excel, etc.)
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
