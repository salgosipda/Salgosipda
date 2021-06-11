package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Estate;

@Repository
public class EstateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 크롤링으로 얻은 매물 데이터 DB에 삽입하는 메소드
	public boolean insert(Estate estate) {
		String esId = estate.getId();
		String esName = estate.getName();
		String esType = estate.getType();
		String esPrice = estate.getPrice();
		String esAddress = estate.getAddress();
		String esx = estate.getLongitude();
		String esy = estate.getLatitude();
		String esarea = estate.getArea();
		String esfloor = estate.getFloor();
		String essch_moving = estate.getSch_moving();
		String esconstruction_year = estate.getConstruction_year();
		String esfeature = estate.getFeature();
		String esdirection = estate.getDirection();
		String esparking = estate.getParking();
		String esmanage_cost = estate.getManage_cost();
		String esmanage_included = estate.getManage_included();
		String essecurity = estate.getSecurity();
		String esestatename = estate.getEstatename();
		String escallnum = estate.getCallnum();

		String sqlStatement = "insert into estate(Id,Name,Type,Price,Address,longitude,latitude,area,floor,sch_moving,"
				+ "construction_year,feature,direction,parking,manage_cost,manage_included,security,estatename,callnum)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement,
				new Object[] { esId, esName, esType, esPrice, esAddress, esx, esy, esarea, esfloor, essch_moving,
						esconstruction_year, esfeature, esdirection, esparking, esmanage_cost, esmanage_included,
						essecurity, esestatename, escallnum }) == 1);

	}

	// 모든 매물을 리턴하는 메소드
	public List<Estate> getEstate() {
		String sqlStatement = "select Id,Name,Type,Price,Address,longitude,latitude,area,floor,sch_moving,"
				+ "construction_year,feature,direction,parking,manage_cost,manage_included,security,estatename,callnum from estate ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Estate>() {

			@Override
			public Estate mapRow(ResultSet rs, int rowNum) throws SQLException {
				Estate estate = new Estate();
				estate.setId(rs.getString("Id"));
				estate.setName(rs.getString("Name"));
				estate.setType(rs.getString("Type"));
				estate.setPrice(rs.getString("Price"));
				estate.setAddress(rs.getString("Address"));
				estate.setLongitude(rs.getString("longitude"));
				estate.setLatitude(rs.getString("latitude"));
				estate.setArea(rs.getString("area"));
				estate.setFloor(rs.getString("floor"));
				estate.setSch_moving(rs.getString("sch_moving"));
				estate.setConstruction_year(rs.getString("construction_year"));
				estate.setFeature(rs.getString("feature"));
				estate.setDirection(rs.getString("direction"));
				estate.setParking(rs.getString("parking"));
				estate.setManage_cost(rs.getString("manage_cost"));
				estate.setManage_included(rs.getString("manage_included"));
				estate.setSecurity(rs.getString("security"));
				estate.setEstatename(rs.getString("estatename"));
				estate.setCallnum(rs.getString("callnum"));

				return estate;
			}

		});

	}

	// 매물의 상세정보를 리턴하는 메소드
	public List<Estate> getEstateDetail(Estate estate) {
		String sqlStatement = "select Id,Name,Type,Price,Address,longitude,latitude,area,floor,sch_moving,\"\r\n"
				+ "				+ \"construction_year,feature,direction,parking,manage_cost,manage_included,security,estatename,callnum from estate ";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Estate>() {

			@Override
			public Estate mapRow(ResultSet rs, int rowNum) throws SQLException {
				Estate estate = new Estate();
				estate.setId(rs.getString("Id"));
				estate.setName(rs.getString("Name"));
				estate.setType(rs.getString("Type"));
				estate.setPrice(rs.getString("Price"));
				estate.setAddress(rs.getString("Address"));
				estate.setLongitude(rs.getString("longitude"));
				estate.setLatitude(rs.getString("latitude"));
				estate.setArea(rs.getString("area"));
				estate.setFloor(rs.getString("floor"));
				estate.setSch_moving(rs.getString("sch_moving"));
				estate.setConstruction_year(rs.getString("construction_year"));
				estate.setFeature(rs.getString("feature"));
				estate.setDirection(rs.getString("direction"));
				estate.setParking(rs.getString("parking"));
				estate.setManage_cost(rs.getString("manage_cost"));
				estate.setManage_included(rs.getString("manage_included"));
				estate.setSecurity(rs.getString("security"));
				estate.setEstatename(rs.getString("estatename"));
				estate.setCallnum(rs.getString("callnum"));

				return estate;
			}

		});
	}

}