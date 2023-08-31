package com.alialsubhi.jaspercronmailing.Controllers;

import com.alialsubhi.jaspercronmailing.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/report")
    public ResponseEntity<byte[]> generateReport() {
        byte[] reportBytes = studentService.generateStudentReport();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add("Content-Disposition", "inline; filename=student_report.pdf");
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }

}
