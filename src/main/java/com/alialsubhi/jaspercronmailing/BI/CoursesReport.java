package com.alialsubhi.jaspercronmailing.BI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoursesReport {
    String courseName;
    Double obtainedMark;
    String grade;

}
