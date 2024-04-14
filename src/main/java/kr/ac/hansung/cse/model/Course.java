package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    private int id;

    private Integer year;

    private Integer semester;

    @Size(min=1, max=100, message="Course code must be between 1 and 100 chars")
    private String course_code;

    @Size(min=1, max=100, message="Course name must be between 1 and 100 chars")
    private String course_name;

    @Size(min=1, max=100, message="Course category must be between 1 and 100 chars")
    private String course_category;

    @Size(min=1, max=100, message="Professor must be between 1 and 100 chars")
    private String Professor;

    private Integer credits;
}
