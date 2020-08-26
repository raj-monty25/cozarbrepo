package com.cozarb.dao.hawker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cozarb.bo.hawker.HawkerBo;
import com.cozarb.bo.productandcategories.ImageBo;
import com.cozarb.dao.productandcategories.ProductAndCategoryDaoImpl;
import com.cozarb.service.util.CozarbImageMapper;

@Repository
public class HawkerDaoImpl implements HawkerDao {
	private final String SQL_GET_RECENT_HAWKERS_BY_DAY = "select h.hawker_id, h.hawker_nm, h.display_nm, h.description, h.hawker_address_id, h.hawker_contact_info_id, h.hawker_image_id, h.status, h.created_by, h.created_dt, h.last_modified_by, h.last_modified_dt,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from hawker h inner join image i on h.hawker_image_id = i.image_id where h.created_dt >= ? order by h.hawker_nm";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HawkerBo> getHawkersFrom(Date fromDate) {
		return jdbcTemplate.query(SQL_GET_RECENT_HAWKERS_BY_DAY, new HawkerRowMapper(), fromDate);
	}

	private final class HawkerRowMapper implements RowMapper<HawkerBo> {
		@Override
		public HawkerBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			HawkerBo bo = new HawkerBo();
			ImageBo imageBo = null;

			bo.setHawkerId(rs.getInt(1));
			bo.setHawkerName(rs.getString(2));
			bo.setDisplayName(rs.getString(3));
			bo.setDescription(rs.getString(4));
			bo.setHawkerAddressId(rs.getInt(5));
			bo.setHawkerContactInfoId(rs.getInt(6));

			bo.setStatus(rs.getString(8));
			bo.setCreatedBy(rs.getString(9));
			bo.setCreatedDate(rs.getDate(10));
			bo.setLastModifiedBy(rs.getString(11));
			bo.setLastModifiedDate(rs.getDate(12));

			imageBo = CozarbImageMapper.mapResultSetToImageBo(rs);
			bo.setHawkerImage(imageBo);

			return bo;
		}
	}

}
