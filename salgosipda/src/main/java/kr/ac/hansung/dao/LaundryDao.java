package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Laundry;

@Repository
public class LaundryDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Laundry> getLaundry() {
		String sqlStatement = "select Id,Name,Address,Lon,Lat from laundry ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Laundry>() {

			@Override
			public Laundry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Laundry laundry = new Laundry();
				laundry.setId(rs.getString("Id"));
				laundry.setName(rs.getString("Name"));
				laundry.setAddress(rs.getString("Address"));
				laundry.setLongitude(rs.getDouble("Lon"));
				laundry.setLatitude(rs.getDouble("Lat"));
				return laundry;
			}
		});
	}
}
