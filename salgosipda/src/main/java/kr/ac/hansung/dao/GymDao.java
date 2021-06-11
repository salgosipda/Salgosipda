package kr.ac.hansung.dao;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Gym;

@Repository
public class GymDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Gym> getGym() {
		String sqlStatement = "select Id,Name,Address,Lat,Lon from gym ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Gym>() {

			@Override
			public Gym mapRow(ResultSet rs, int rowNum) throws SQLException {
				Gym gym = new Gym();
				gym.setId(rs.getString("Id"));
				gym.setName(rs.getString("Name"));
				gym.setAddress(rs.getString("Address"));
				gym.setLatitude(rs.getDouble("Lat"));
				gym.setLongitude(rs.getDouble("Lon"));
				return gym;
			}
		});
	}
}