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


}