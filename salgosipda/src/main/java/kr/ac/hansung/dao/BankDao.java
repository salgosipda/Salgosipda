package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Bank;

@Repository
public class BankDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Bank> getBank() {
		String sqlStatement = "select Id,Branch,Bank,Address,Lon,Lat from bank ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Bank>() {

			@Override
			public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bank bank = new Bank();
				bank.setId(rs.getString("Id"));
				bank.setBranch(rs.getString("Branch"));
				bank.setBank(rs.getString("Bank"));
				bank.setAddress(rs.getString("Address"));
				bank.setLongitude(rs.getDouble("Lon"));
				bank.setLatitude(rs.getDouble("Lat"));
				return bank;
			}
		});
	}
}
