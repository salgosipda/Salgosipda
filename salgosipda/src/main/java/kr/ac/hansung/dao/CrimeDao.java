package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Crime;

@Repository
public class CrimeDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Crime> getCrime() {
		String sqlStatement = "select Police,Crimes from crime ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Crime>() {

			@Override
			public Crime mapRow(ResultSet rs, int rowNum) throws SQLException {
				Crime crime = new Crime();
				crime.setName(rs.getString("Police"));
				crime.setCrimeRate(Double.parseDouble(rs.getString("Crimes")));
				return crime;
			}
		});
	}
}