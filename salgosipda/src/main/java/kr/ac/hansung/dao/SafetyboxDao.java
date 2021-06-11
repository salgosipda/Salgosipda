package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Safetybox;

@Repository
public class SafetyboxDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Safetybox> getSafetybox() {
		String sqlStatement = "select Id,Name,Address,Lon,Lat from safetybox ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Safetybox>() {

			@Override
			public Safetybox mapRow(ResultSet rs, int rowNum) throws SQLException {
				Safetybox safetybox = new Safetybox();
				safetybox.setId(rs.getString("Id"));
				safetybox.setName(rs.getString("Name"));
				safetybox.setAddress(rs.getString("Address"));
				safetybox.setLongitude(rs.getDouble("Lon"));
				safetybox.setLatitude(rs.getDouble("Lat"));
				return safetybox;
			}
		});
	}
}
