package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    public void insert(Course course) {
        courseDao.insert(course);
    }

    public Map<String, Integer> getTotalCreditsByYearAndSemester() {
        return courseDao.getTotalCreditsByYearAndSemester();
    }

    public List<Map<String, Object>> getCourseCreditsByYearAndSemester(int year, int semester) {
        return courseDao.getCourseCreditsByYearAndSemester(year, semester);
    }
}










