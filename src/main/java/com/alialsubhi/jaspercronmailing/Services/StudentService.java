package com.alialsubhi.jaspercronmailing.Services;

import com.alialsubhi.jaspercronmailing.Models.Student;
import com.alialsubhi.jaspercronmailing.Repository.StudentRepository;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //  methods for CRUD Later may be.

    public byte[] generateStudentReport() {
        try {
            // Load the Jasper report template (compiled .jasper file)
            InputStream reportStream = getClass().getResourceAsStream("/path/to/your/report.jasper");

            // Set up your data source or collection (list of Student objects)
            List<Student> students = studentRepository.findAll();

            // Compile and fill the Jasper report
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, null, new JRBeanCollectionDataSource(students));

            // Export the report to PDF or other formats
            byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            return reportBytes;
        } catch (Exception e) {
            // Handle exceptions appropriately
            return null;
        }
    }
}