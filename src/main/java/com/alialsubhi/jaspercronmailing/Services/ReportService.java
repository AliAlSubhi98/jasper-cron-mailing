package com.alialsubhi.jaspercronmailing.Services;

import com.alialsubhi.jaspercronmailing.Models.Student;
import com.alialsubhi.jaspercronmailing.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ReportService {
    String pathToReports = "C:\\Users\\user002\\Desktop\\AliAlSubhi\\jasper-cron-mailing\\Reports";
    @Autowired
    StudentRepository studentRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.findAll();
        File file = new File("C:\\Users\\user002\\Desktop\\AliAlSubhi\\jasper-cron-mailing\\src\\main\\resources\\Student_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "AliAlSubhi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Report.pdf");
        return "Report generated : " + pathToReports + "\\Report.pdf";
    }
}
