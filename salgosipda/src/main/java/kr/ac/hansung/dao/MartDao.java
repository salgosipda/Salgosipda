package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Mart;

@Repository
public class MartDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Mart> getMart() {
		String sqlStatement = "select Id,Name,Type,Address,Lon,Lat from mart ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Mart>() {

			@Override
			public Mart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mart mart = new Mart();
				mart.setId(rs.getString("Id"));
				mart.setName(rs.getString("Name"));
				mart.setType(rs.getString("Type"));
				mart.setAddress(rs.getString("Address"));
				mart.setLongitude(rs.getDouble("Lon"));
				mart.setLatitude(rs.getDouble("Lat"));
				return mart;
			}
		});
	}
}
