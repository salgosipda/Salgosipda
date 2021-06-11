package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subway;

@Repository
public class SubwayDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Subway> getSubway() {
		String sqlStatement = "select Number,Station,Line,Lon,Lat from subway ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Subway>() {

			@Override
			public Subway mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subway subway = new Subway();
				subway.setNumber(rs.getString("Number"));
				subway.setStation(rs.getString("Station"));
				subway.setLine(rs.getString("Line"));
				subway.setLongitude(rs.getDouble("Lon"));
				subway.setLatitude(rs.getDouble("Lat"));
				return subway;
			}
		});
	}
}