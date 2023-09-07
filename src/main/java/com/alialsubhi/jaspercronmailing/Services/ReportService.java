package com.alialsubhi.jaspercronmailing.Services;

import com.alialsubhi.jaspercronmailing.BI.CourseAverageMarksReport;
import com.alialsubhi.jaspercronmailing.BI.CoursesReport;
import com.alialsubhi.jaspercronmailing.BI.SchoolStudentReport;
import com.alialsubhi.jaspercronmailing.Models.Course;
import com.alialsubhi.jaspercronmailing.Models.Mark;
import com.alialsubhi.jaspercronmailing.Models.School;
import com.alialsubhi.jaspercronmailing.Models.Student;
import com.alialsubhi.jaspercronmailing.Repository.CourseRepository;
import com.alialsubhi.jaspercronmailing.Repository.MarkRepository;
import com.alialsubhi.jaspercronmailing.Repository.SchoolRepository;
import com.alialsubhi.jaspercronmailing.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ReportService {
    String pathToReports = "C:\\Users\\user002\\Desktop\\AliAlSubhi\\jasper-cron-mailing\\Reports";
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    MarkRepository markRepository;
    @Autowired
    CourseRepository courseRepository;

    /*
    public String generateReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.findAll();
        File file = new File("C:\\Users\\user002\\Desktop\\AliAlSubhi\\jasper-cron-mailing\\src\\main\\resources\\SchoolStudentReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "AliAlSubhi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Report.pdf");
        return "Report generated : " + pathToReports + "\\Report.pdf";
    }
     */


    public String generateSchoolWithStudentReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.findAll();
        List<Student> studentList = studentRepository.findAll();

        List<SchoolStudentReport> schoolsReportList = new ArrayList<>(); //  to hold the Reports

        for (School s : schoolList) {
            for (Student student : studentList) {
                if (student.getSchool().getId().equals(s.getId())) {
                    SchoolStudentReport schoolsReport = SchoolStudentReport.builder()
                            .schoolName(s.getName())
                            .studentName(student.getFirstName() +" "+ student.getLastName())
                            .rollNumber(student.getRollNumber())
                            .build();
                    schoolsReportList.add(schoolsReport); // Add report to the list
                }
            }
        }

        File file = ResourceUtils.getFile("classpath:SchoolStudentReport.jrxml");


        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // Create a data source from the reports list
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolsReportList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "AliAlSubhi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports +"\\SchoolWithStudentReport.pdf");
        return "Report generated: " + pathToReports + "\\SchoolWithStudentReport.pdf";
    }


    public String generateCoursesReport() throws FileNotFoundException, JRException {
        List<Course> courseList = courseRepository.findAll();
        List<Mark> markList = markRepository.findAll();

        List<CoursesReport> coursesReportList = new ArrayList<>(); //  to hold the Reports

        for (Course course : courseList) {
            for (Mark mark : markList) {
                if (mark.getCourse().getId().equals(course.getId())) {
                    CoursesReport coursesReport = CoursesReport.builder()
                            .courseName(course.getName())
                            .obtainedMark(mark.getObtainedMark())
                            .grade(mark.getGrade())
                            .build();
                    coursesReportList.add(coursesReport); // Add report to the list
                }
            }
        }

        File file = ResourceUtils.getFile("classpath:CourseAverageMarkReport.jrxml");


        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // Create a data source from the reports list
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(coursesReportList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "AliAlSubhi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports +"\\SchoolReport.pdf");
        return "Report generated: " + pathToReports + "\\SchoolReport.pdf";
    }


//    public String Report() throws FileNotFoundException, JRException {
//        List<Course> courseList = courseRepository.findAll();
//        List<Mark> markList = markRepository.findAll();
//
//        List<CourseAverageMarksReport> courseAverageMarksReportArrayList = new ArrayList<>(); //  to hold the Reports
//
//        for(Course course : courseList){
//            for(Mark mark : markList){
//
//
//
//            }
//
//        }
//
//
//
//
//        File file = ResourceUtils.getFile("classpath:CoursesReport.jrxml");
//
//
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//
//        // Create a data source from the reports list
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseAverageMarksReportArrayList);
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("CreatedBy", "AliAlSubhi");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports +"\\courseAverageMarksReport.pdf");
//        return "Report generated: " + pathToReports + "\\courseAverageMarksReport.pdf";
//    }




}



