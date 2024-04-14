package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OfferDao {

    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from offers";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

    }
    //query and return a single object
    public Offer getOffer(String name) {

        String sqlStatement= "select * from offers where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Offer>() {

                    @Override
                    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Offer offer= new Offer();

                        offer.setYear(rs.getInt("year"));
                        offer.setSemester(rs.getInt("semester"));
                        offer.setCourse_code(rs.getString("course_code"));
                        offer.setCourse_name(rs.getString("course_name"));
                        offer.setCourse_category(rs.getString("course_category"));
                        offer.setProfessor(rs.getString("professor"));
                        offer.setCredits(rs.getInt("credits"));

                        return offer;
                    }
                });
    }

    //query and return multiple objects
    // cRud method
    public List<Offer> getOffers() {

        String sqlStatement= "select * from offers";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

            @Override
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

                Offer offer= new Offer();

                offer.setYear(rs.getInt("year"));
                offer.setSemester(rs.getInt("semester"));
                offer.setCourse_code(rs.getString("course_code"));
                offer.setCourse_name(rs.getString("course_name"));
                offer.setCourse_category(rs.getString("course_category"));
                offer.setProfessor(rs.getString("professor"));
                offer.setCredits(rs.getInt("credits"));

                return offer;
            }
        });
    }


    // Crud method
    public boolean insert(Offer offer) {

        Integer year = offer.getYear();
        Integer semester = offer.getSemester();
        String course_code = offer.getCourse_code();
        String course_name = offer.getCourse_name();
        String course_category = offer.getCourse_category();
        String professor = offer.getProfessor();
        Integer credits = offer.getCredits();

        String sqlStatement= "insert into offers (year, semester, course_code, course_name, course_category, professor, credits) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, course_code, course_name, course_category, professor, credits}) == 1);
    }

    // crUd method
    public boolean update(Offer offer) {

        int id = offer.getId();
        Integer year = offer.getYear();
        Integer semester = offer.getSemester();
        String course_code = offer.getCourse_code();
        String course_name = offer.getCourse_name();
        String course_category = offer.getCourse_category();
        String professor = offer.getProfessor();
        Integer credits = offer.getCredits();

        String sqlStatement= "update offers set year=?, semester=?, course_code=?, course_name=?, course_category=?, professor=?, credits=? where id=?";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, course_code, course_name, course_category, professor, credits, id}) == 1);
    }

    //cruD method
    public boolean delete(int id) {
        String sqlStatement= "delete from offers where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }

}
