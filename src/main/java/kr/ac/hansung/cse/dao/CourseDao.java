package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

    }
    //query and return a single object
    public Course getCourse(String name) {

        String sqlStatement= "select * from courses where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Course>() {

                    @Override
                    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Course course = new Course();

                        course.setYear(rs.getInt("year"));
                        course.setSemester(rs.getInt("semester"));
                        course.setCourse_code(rs.getString("course_code"));
                        course.setCourse_name(rs.getString("course_name"));
                        course.setCourse_category(rs.getString("course_category"));
                        course.setProfessor(rs.getString("professor"));
                        course.setCredits(rs.getInt("credits"));

                        return course;
                    }
                });
    }

    //query and return multiple objects
    // cRud method
    public List<Course> getCourses() {

        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course = new Course();

                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourse_code(rs.getString("course_code"));
                course.setCourse_name(rs.getString("course_name"));
                course.setCourse_category(rs.getString("course_category"));
                course.setProfessor(rs.getString("professor"));
                course.setCredits(rs.getInt("credits"));

                return course;
            }
        });
    }

    // Crud method
    public boolean insert(Course course) {

        Integer year = course.getYear();
        Integer semester = course.getSemester();
        String course_code = course.getCourse_code();
        String course_name = course.getCourse_name();
        String course_category = course.getCourse_category();
        String professor = course.getProfessor();
        Integer credits = course.getCredits();

        String sqlStatement= "insert into courses (year, semester, course_code, course_name, course_category, professor, credits) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, course_code, course_name, course_category, professor, credits}) == 1);
    }

    // crUd method
    public boolean update(Course course) {

        int id = course.getId();
        Integer year = course.getYear();
        Integer semester = course.getSemester();
        String course_code = course.getCourse_code();
        String course_name = course.getCourse_name();
        String course_category = course.getCourse_category();
        String professor = course.getProfessor();
        Integer credits = course.getCredits();

        String sqlStatement= "update courses set year=?, semester=?, course_code=?, course_name=?, course_category=?, professor=?, credits=? where id=?";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, course_code, course_name, course_category, professor, credits, id}) == 1);
    }

    //cruD method
    public boolean delete(int id) {
        String sqlStatement= "delete from courses where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }

    public Map<String, Integer> getTotalCreditsByYearAndSemester() {
        String sqlStatement = "SELECT year, semester, SUM(credits) AS total_credits " +
                "FROM courses GROUP BY year, semester ORDER BY year ASC, semester ASC";
        return jdbcTemplate.query(sqlStatement, new ResultSetExtractor<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<String, Integer> result = new LinkedHashMap<>();
                while (rs.next()) {
                    String key = rs.getInt("year") + "-" + rs.getInt("semester");
                    int totalCredits = rs.getInt("total_credits");
                    result.put(key, totalCredits);
                }
                return result;
            }
        });
    }

    public List<Map<String, Object>> getCourseCreditsByYearAndSemester(int year, int semester) {
        String sqlStatement = "SELECT year, semester, course_name, course_category, professor," +
                " credits FROM courses WHERE year = ? AND semester = ?";
        return jdbcTemplate.queryForList(sqlStatement, year, semester);
    }
}























