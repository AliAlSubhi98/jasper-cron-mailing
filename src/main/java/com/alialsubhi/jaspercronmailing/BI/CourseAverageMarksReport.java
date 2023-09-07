package com.alialsubhi.jaspercronmailing.BI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseAverageMarksReport {
    Double averageMark;
    String courseName;

}
