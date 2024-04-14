package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.CourseService;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("id_courses", courses);

        Map<String, Integer> totalCreditsByYearAndSemester = courseService.getTotalCreditsByYearAndSemester();
        model.addAttribute("totalCreditsByYearAndSemester", totalCreditsByYearAndSemester);

        return "courses";
    }

    @GetMapping("/coursescredits")
    public String showCourseCredits(Model model, @RequestParam("year") int year,
                                    @RequestParam("semester") int semester) {
        List<Map<String, Object>>
                courseCredits = courseService.getCourseCreditsByYearAndSemester(year, semester);
        model.addAttribute("detailedInfoWithTotalCredits", courseCredits);
        return "coursescredits";
    }
}




















