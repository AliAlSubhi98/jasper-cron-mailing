package com.alialsubhi.jaspercronmailing.Controllers;

import com.alialsubhi.jaspercronmailing.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileNotFoundException;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/reportStudent")
    public String generateReport() {
        try {
            return reportService.generateReport();
        } catch (JRException | FileNotFoundException e) {
            e.printStackTrace();
            return "Report generation failed.";
        }
    }
}