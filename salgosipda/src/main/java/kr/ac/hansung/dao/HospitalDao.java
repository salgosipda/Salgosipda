package kr.ac.hansung.dao;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Hospital;

@Repository
public class HospitalDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Hospital> getHospital() {
		String sqlStatement = "select Id,Name,Type,Address,Lat,Lon from hospital ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Hospital>() {

			@Override
			public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
				Hospital hospital = new Hospital();
				hospital.setId(rs.getString("Id"));
				hospital.setName(rs.getString("Name"));
				hospital.setType(rs.getString("Type"));
				hospital.setAddress(rs.getString("Address"));
				hospital.setLongitude(rs.getDouble("Lon"));
				hospital.setLatitude(rs.getDouble("Lat"));
				return hospital;
			}
		});
	}
}