package com.alialsubhi.jaspercronmailing.BI;

import lombok.*;

@Builder
@Data
public class SchoolStudentReport {

    String studentName;
    Long studentId;
    Long rollNumber;
    String schoolName;

}
