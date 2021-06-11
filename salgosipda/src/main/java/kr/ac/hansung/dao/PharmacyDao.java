package kr.ac.hansung.dao;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Pharmacy;

@Repository
public class PharmacyDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Pharmacy> getPharmacy() {
		String sqlStatement = "select Id,Name,Address,Lat,Lon from pharmacy ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Pharmacy>() {

			@Override
			public Pharmacy mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pharmacy pharmacy = new Pharmacy();
				pharmacy.setId(rs.getString("Id"));
				pharmacy.setName(rs.getString("Name"));
				pharmacy.setAddress(rs.getString("Address"));
				pharmacy.setLatitude(rs.getDouble("Lat"));
				pharmacy.setLongitude(rs.getDouble("Lon"));
				return pharmacy;
			}
		});
	}
}