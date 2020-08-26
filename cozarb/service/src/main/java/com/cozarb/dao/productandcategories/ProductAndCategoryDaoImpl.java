package com.cozarb.dao.productandcategories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cozarb.bo.merchant.MerchantStoreCategoryBo;
import com.cozarb.bo.productandcategories.ImageBo;
import com.cozarb.service.util.CozarbImageMapper;

@Repository
public class ProductAndCategoryDaoImpl implements ProductAndCategoryDao {
	private final String SQL_GET_IMAGE_CONTENT_BY_ID = "select image_content from image where image_id = ?";
	private final String SQL_GET_MERCHANT_STORE_CATEGORIES = "select mc.category_id, mc.merchant_store_id, mc.category_nm, mc.description, mc.status, mc.created_by, mc.created_dt, mc.last_modified_by, mc.last_modified_dt, mc.category_image_id,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_Store_categories mc inner join image i on mc.category_image_id = i.image_id order by mc.category_nm";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public byte[] getImage(int imageId) {
		return jdbcTemplate.queryForObject(SQL_GET_IMAGE_CONTENT_BY_ID, (rs, rowNum) -> {
			return rs.getBytes(1);
		}, imageId);
	}

	@Override
	public List<MerchantStoreCategoryBo> getMerchantStoreCategories() {
		return jdbcTemplate.query(SQL_GET_MERCHANT_STORE_CATEGORIES, (rs, rowNum) -> {
			MerchantStoreCategoryBo merchantStoreCategoryBo = null;
			ImageBo storeCategoryImageBo = null;

			merchantStoreCategoryBo = new MerchantStoreCategoryBo();
			merchantStoreCategoryBo.setCategoryId(rs.getInt(1));
			merchantStoreCategoryBo.setMerchantStoreId(rs.getInt(2));
			merchantStoreCategoryBo.setCategoryName(rs.getString(3));
			merchantStoreCategoryBo.setDescription(rs.getString(4));
			merchantStoreCategoryBo.setStatus(rs.getString(5));
			merchantStoreCategoryBo.setCreatedBy(rs.getString(6));
			merchantStoreCategoryBo.setCreatedDate(rs.getDate(7));
			merchantStoreCategoryBo.setLastModifiedBy(rs.getString(8));
			merchantStoreCategoryBo.setLastModifiedDate(rs.getDate(9));

			storeCategoryImageBo = CozarbImageMapper.mapResultSetToImageBo(rs);

			merchantStoreCategoryBo.setMerchantStoreCategoryImage(storeCategoryImageBo);

			return merchantStoreCategoryBo;
		});
	}

}
