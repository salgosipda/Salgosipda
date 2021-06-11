package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Cvs;

@Repository
public class CvsDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Cvs> getCvs() {
		String sqlStatement = "select Id,Name,Type,Address,Lon,Lat from cvs ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Cvs>() {

			@Override
			public Cvs mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cvs cvs = new Cvs();
				cvs.setId(rs.getString("Id"));
				cvs.setName(rs.getString("Name"));
				cvs.setType(rs.getString("Type"));
				cvs.setAddress(rs.getString("Address"));
				cvs.setLongitude(rs.getDouble("Lon"));
				cvs.setLatitude(rs.getDouble("Lat"));
				return cvs;
			}
		});
	}
}
