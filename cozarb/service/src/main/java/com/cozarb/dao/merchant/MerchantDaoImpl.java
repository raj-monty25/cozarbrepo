package com.cozarb.dao.merchant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cozarb.bo.accountmanagement.SystemUserBo;
import com.cozarb.bo.merchant.MerchantBusinessBo;
import com.cozarb.bo.merchant.MerchantStoreCategoryBo;
import com.cozarb.bo.merchant.MerchantStoreProductBo;
import com.cozarb.bo.merchant.MerchantStoreProductDetailsBo;
import com.cozarb.bo.merchant.MerchantStoreWithBusinessBo;
import com.cozarb.bo.productandcategories.ImageBo;
import com.cozarb.bo.productandcategories.ProductFeedbackBo;
import com.cozarb.service.util.CozarbImageMapper;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	private final String SQL_GET_TOP_MERCHANT_STORE_CATEGORIES_FROM_DATE = "select msc.category_id, msc.merchant_store_id, msc.category_nm, msc.description, msc.status, msc.created_by, msc.created_dt, msc.last_modified_by, msc.last_modified_dt, msc.category_image_id, i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_store_categories msc inner join image i on msc.category_image_id = i.image_id where msc.created_dt >= ? order by msc.category_nm";
	private final String SQL_GET_RECENT_MERCHANT_PRODUCTS_FROM_DATE = "select msp.product_id, msp.merchant_store_id, msp.title, msp.description, msp.category_id, msp.price, msp.quantity, msp.status, msp.created_by, msp.created_dt, msp.last_modified_by, msp.last_modified_dt,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_store_product msp inner join product_images pi on msp.product_id = pi.product_id inner join image i on i.image_id = pi.image_id where msp.created_dt >= ? order by msp.title";
	private final String SQL_GET_RECENT_MERCHANT_STORES_WITH_BUSINESS_FROM_DATE = "select msb.merchant_business_id, msb.business_nm, msb.business_alias_nm, msb.business_license_no, msb.license_issued_authority, msb.license_issued_dt, msb.business_address_id, msb.primary_contact_info_id, msb.secondary_contact_info_id, msb.status, msb.created_by, msb.created_dt, msb.last_modified_by, msb.last_modified_dt, ms.merchant_store_id, ms.merchant_business_id, ms.merchant_store_address_id, ms.store_contact_info_id, ms.primary_contact_info_id, ms.secondary_contact_info_id, ms.store_opening_time_hours, ms.store_opening_time_minutes, ms.store_closing_time_hours, ms.store_closing_time_minutes, ms.status, ms.created_dt, ms.last_modified_by, ms.last_modified_dt, ms.created_by,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_store ms inner join merchant_business msb on ms.merchant_business_id = msb.merchant_business_id inner join merchant_store_images msi on msi.merchant_store_id = ms.merchant_store_id inner join image i on msi.image_id = i.image_id where ms.created_dt >= ? order by msb.business_nm";
	private final String SQL_GET_MERCHANT_STORE_PRODUCT_DETAILS = "select msp.product_id, msp.merchant_store_id, msp.title, msp.description, msp.category_id, msp.price, msp.quantity, msp.status, msp.created_by, msp.created_dt, msp.last_modified_by, msp.last_modified_dt,mb.merchant_business_id, mb.business_nm, mb.business_alias_nm, mb.business_license_no, mb.license_issued_authority, mb.license_issued_dt, mb.business_address_id, mb.primary_contact_info_id, mb.secondary_contact_info_id, mb.status, mb.created_by, mb.created_dt, mb.last_modified_by, mb.last_modified_dt,su.system_user_id, su.user_role_id, su.email_address, su.password, su.mobile_nbr, su.email_verification_code, su.mobile_nbr_verification_code, su.is_email_address_verified, su.is_mobile_nbr_verified, su.email_address_verification_dt, su.mobile_nbr_verification_dt, su.last_logged_in_dt, su.account_status, su.created_by, su.created_dt, su.last_modified_by, su.last_modified_dt,fb.feedback_id, fb.system_user_id, fb.product_id, fb.comments, fb.ratings, fb.status, fb.created_by, fb.created_dt, fb.last_modified_by, fb.last_modified_dt,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_store_product msp inner join merchant_store ms on msp.merchant_store_id = ms.merchant_store_id inner join merchant_business mb on mb.merchant_business_id = ms.merchant_business_id inner join feedback fb on fb.product_id = msp.product_id inner join system_user su on fb.system_user_id = su.system_user_id inner join product_images pi on pi.product_id = msp.product_id inner join image i on i.image_id = pi.image_id where msp.product_id = ?";
	private final String SQL_GET_MERCHANT_STORE_SIMILAR_PRODUCTS_BY_PRODUCT_ID = "select msp.product_id, msp.merchant_store_id, msp.title, msp.description, msp.category_id, msp.price, msp.quantity, msp.status, msp.created_by, msp.created_dt, msp.last_modified_by, msp.last_modified_dt,i.image_id, i.image_nm, i.image_type, i.description, i.image_content, i.status, i.created_by, i.created_dt, i.last_modified_by, i.last_modified_dt from merchant_store_product msp inner join product_images pi on msp.product_id = pi.product_id inner join image i on i.image_id = pi.image_id inner join merchant_store_categories msc on msc.category_id = msp.category_id where msp.category_id = (select smsp.category_id from merchant_store_product smsp where smsp.product_id = ?) and msp.product_id <> ? order by msp.title";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MerchantStoreCategoryBo> getTopMerchantCategoriesFromDate(Date fromDate) {
		return jdbcTemplate.query(SQL_GET_TOP_MERCHANT_STORE_CATEGORIES_FROM_DATE, new MerchantStoreCategoryRowMapper(),
				fromDate);
	}

	@Override
	public List<MerchantStoreProductBo> getRecentMerchantProductsFromDate(Date fromDate) {
		return jdbcTemplate.query(SQL_GET_RECENT_MERCHANT_PRODUCTS_FROM_DATE,
				new MerchantStoreProductBoResultSetExtractor(), fromDate);
	}

	@Override
	public List<MerchantStoreWithBusinessBo> getRecentlyAddedMerchantStoresFromDate(Date fromDate) {
		return jdbcTemplate.query(SQL_GET_RECENT_MERCHANT_STORES_WITH_BUSINESS_FROM_DATE,
				new MerchantStoreWithBusinessBoResultSetExtractor(), fromDate);
	}

	@Override
	public List<MerchantStoreProductBo> getMerchantStoreProductsBySimilarCategoryProduct(int productId) {
		return jdbcTemplate.query(SQL_GET_MERCHANT_STORE_SIMILAR_PRODUCTS_BY_PRODUCT_ID,
				new MerchantStoreProductBoResultSetExtractor(), productId, productId);
	}

	@Override
	public MerchantStoreProductDetailsBo getMerchantStoreProduct(int productId) {
		List<MerchantStoreProductDetailsBo> merchantStoreProductDetailsBos = null;

		merchantStoreProductDetailsBos = jdbcTemplate.query(SQL_GET_MERCHANT_STORE_PRODUCT_DETAILS,
				new MerchantStoreProductWithMerchantBusinessAndFeedbackResultSetExtractor(), productId);
		if (merchantStoreProductDetailsBos != null && merchantStoreProductDetailsBos.size() == 1) {
			return merchantStoreProductDetailsBos.get(0);
		}
		return null;
	}

	private final class MerchantStoreCategoryRowMapper implements RowMapper<MerchantStoreCategoryBo> {
		@Override
		public MerchantStoreCategoryBo mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
			MerchantStoreCategoryBo merchantStoreCategoryBo = null;
			ImageBo imageBo = null;

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

			imageBo = CozarbImageMapper.mapResultSetToImageBo(rs);
			merchantStoreCategoryBo.setMerchantStoreCategoryImage(imageBo);

			return merchantStoreCategoryBo;
		}

	}

	private final class MerchantStoreProductBoResultSetExtractor
			implements ResultSetExtractor<List<MerchantStoreProductBo>> {
		@Override
		public List<MerchantStoreProductBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, MerchantStoreProductBo> merchantStoreProductBoMap = null;
			List<MerchantStoreProductBo> merchantStoreProductBos = null;
			MerchantStoreProductBo merchantStoreProductBo = null;
			List<ImageBo> storeProductImages = null;
			ImageBo imageBo = null;
			int productId = 0;

			merchantStoreProductBoMap = new HashMap<Integer, MerchantStoreProductBo>();
			while (rs.next()) {
				productId = rs.getInt(1);
				if (merchantStoreProductBoMap.containsKey(productId) == false) {
					merchantStoreProductBo = new MerchantStoreProductBo();
					merchantStoreProductBo.setProductId(productId);
					merchantStoreProductBo.setStoreId(rs.getInt(2));
					merchantStoreProductBo.setTitle(rs.getString(3));
					merchantStoreProductBo.setDescription(rs.getString(4));
					merchantStoreProductBo.setCategoryId(rs.getInt(5));
					merchantStoreProductBo.setPrice(rs.getDouble(6));
					merchantStoreProductBo.setQuantity(rs.getInt(7));
					merchantStoreProductBo.setStatus(rs.getString(8));
					merchantStoreProductBo.setCreatedBy(rs.getString(9));
					merchantStoreProductBo.setCreatedDate(rs.getDate(10));
					merchantStoreProductBo.setLastModifiedBy(rs.getString(11));
					merchantStoreProductBo.setLastModifiedDate(rs.getDate(12));
					storeProductImages = new ArrayList<>();
					merchantStoreProductBo.setProductImages(storeProductImages);
					merchantStoreProductBoMap.put(productId, merchantStoreProductBo);
				} else {
					merchantStoreProductBo = merchantStoreProductBoMap.get(productId);
				}
				imageBo = CozarbImageMapper.mapResultSetToImageBo(rs);
				merchantStoreProductBo.getProductImages().add(imageBo);
			}
			merchantStoreProductBos = new ArrayList<>();
			for (MerchantStoreProductBo bo : merchantStoreProductBoMap.values()) {
				merchantStoreProductBos.add(bo);
			}

			return merchantStoreProductBos;
		}
	}

	private final class MerchantStoreWithBusinessBoResultSetExtractor
			implements ResultSetExtractor<List<MerchantStoreWithBusinessBo>> {
		@Override
		public List<MerchantStoreWithBusinessBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, MerchantStoreWithBusinessBo> merchantStoreWithBusinessBoMap = null;
			List<MerchantStoreWithBusinessBo> merchantStoreWithBusinessBos = null;
			MerchantStoreWithBusinessBo merchantStoreWithBusinessBo = null;
			MerchantBusinessBo merchantBusinessBo = null;
			List<ImageBo> merchantStoreImages = null;
			ImageBo imageBo = null;
			int storeId = 0;

			merchantStoreWithBusinessBoMap = new HashMap<>();
			while (rs.next()) {
				storeId = rs.getInt(15);

				if (merchantStoreWithBusinessBoMap.containsKey(storeId) == false) {
					merchantBusinessBo = new MerchantBusinessBo();
					merchantBusinessBo.setMerchantBusinessId(rs.getInt(1));
					merchantBusinessBo.setBusinessName(rs.getString(2));
					merchantBusinessBo.setBusinessAliasName(rs.getString(3));
					merchantBusinessBo.setBusinessLicenseNo(rs.getString(4));
					merchantBusinessBo.setLicenseIssuedAuthority(rs.getString(5));
					merchantBusinessBo.setLicenseIssuedDate(rs.getDate(6));
					merchantBusinessBo.setBusinessAddressId(rs.getInt(7));
					merchantBusinessBo.setPrimaryContactInfoId(rs.getInt(8));
					merchantBusinessBo.setSecondaryContactInfoId(rs.getInt(9));
					merchantBusinessBo.setStatus(rs.getString(10));
					merchantBusinessBo.setCreatedBy(rs.getString(11));
					merchantBusinessBo.setCreatedDate(rs.getDate(12));
					merchantBusinessBo.setLastModifiedBy(rs.getString(13));
					merchantBusinessBo.setLastModifiedDate(rs.getDate(14));

					merchantStoreWithBusinessBo = new MerchantStoreWithBusinessBo();
					merchantStoreWithBusinessBo.setMerchantBusinessBo(merchantBusinessBo);

					merchantStoreWithBusinessBo.setMerchantBusinessId(rs.getInt(1));
					merchantStoreWithBusinessBo.setMerchantStoreId(rs.getInt(15));
					merchantStoreWithBusinessBo.setMerchantStoreAddressId(rs.getInt(17));
					merchantStoreWithBusinessBo.setStoreContactInfoId(rs.getInt(18));
					merchantStoreWithBusinessBo.setPrimaryContactInfoId(rs.getInt(19));
					merchantStoreWithBusinessBo.setSecondaryContactInfoId(rs.getInt(20));
					merchantStoreWithBusinessBo.setStoreOpeningTimeInHours(rs.getInt(21));
					merchantStoreWithBusinessBo.setStoreOpeningTimeInMinutes(rs.getInt(22));
					merchantStoreWithBusinessBo.setStoreClosingTimeInHours(rs.getInt(23));
					merchantStoreWithBusinessBo.setStoreClosingTimeInMinutes(rs.getInt(24));
					merchantStoreWithBusinessBo.setStatus(rs.getString(25));
					merchantStoreWithBusinessBo.setCreatedBy(rs.getString(29));
					merchantStoreWithBusinessBo.setCreatedDate(rs.getDate(26));
					merchantStoreWithBusinessBo.setLastModifiedBy(rs.getString(27));
					merchantStoreWithBusinessBo.setLastModifiedDate(rs.getDate(28));
					merchantStoreImages = new ArrayList<>();
					merchantStoreWithBusinessBo.setStoreImages(merchantStoreImages);
					merchantStoreWithBusinessBoMap.put(storeId, merchantStoreWithBusinessBo);
				} else {
					merchantStoreWithBusinessBo = merchantStoreWithBusinessBoMap.get(storeId);
				}
				imageBo = CozarbImageMapper.mapResultSetToImageBo(rs);
				merchantStoreWithBusinessBo.getStoreImages().add(imageBo);
			}

			merchantStoreWithBusinessBos = new ArrayList<>();
			for (MerchantStoreWithBusinessBo bo : merchantStoreWithBusinessBoMap.values()) {
				merchantStoreWithBusinessBos.add(bo);
			}

			return merchantStoreWithBusinessBos;
		}
	}

	private final class MerchantStoreProductWithMerchantBusinessAndFeedbackResultSetExtractor
			implements ResultSetExtractor<List<MerchantStoreProductDetailsBo>> {
		@Override
		public List<MerchantStoreProductDetailsBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, MerchantStoreProductDetailsBo> merchantStoreProductDetailsMap = null;
			List<MerchantStoreProductDetailsBo> merchantStoreProductDetailsBos = null;
			MerchantStoreProductDetailsBo merchantStoreProductDetailsBo = null;
			Map<Integer, ProductFeedbackBo> productFeedbackMap = null;
			List<ProductFeedbackBo> productFeedbackBos = null;
			MerchantBusinessBo merchantBusinessBo = null;
			ProductFeedbackBo productFeedbackBo = null;
			Map<Integer, ImageBo> imageMap = null;
			List<ImageBo> productImages = null;
			SystemUserBo systemUser = null;
			ImageBo imageBo = null;
			int productFeedbackId = 0;
			int productId = 0;
			int imageId = 0;

			merchantStoreProductDetailsMap = new HashMap<>();
			productFeedbackMap = new HashMap<>();
			imageMap = new HashMap<>();

			while (rs.next()) {
				productId = rs.getInt(1);
				if (merchantStoreProductDetailsMap.containsKey(productId) == false) {
					merchantBusinessBo = new MerchantBusinessBo();
					merchantBusinessBo.setMerchantBusinessId(rs.getInt(13));
					merchantBusinessBo.setBusinessName(rs.getString(14));
					merchantBusinessBo.setBusinessAliasName(rs.getString(15));
					merchantBusinessBo.setBusinessLicenseNo(rs.getString(16));
					merchantBusinessBo.setLicenseIssuedAuthority(rs.getString(17));
					merchantBusinessBo.setLicenseIssuedDate(rs.getDate(18));
					merchantBusinessBo.setBusinessAddressId(rs.getInt(19));
					merchantBusinessBo.setPrimaryContactInfoId(rs.getInt(20));
					merchantBusinessBo.setSecondaryContactInfoId(rs.getInt(21));
					merchantBusinessBo.setStatus(rs.getString(22));
					merchantBusinessBo.setCreatedBy(rs.getString(23));
					merchantBusinessBo.setCreatedDate(rs.getDate(24));
					merchantBusinessBo.setLastModifiedBy(rs.getString(25));
					merchantBusinessBo.setLastModifiedDate(rs.getDate(26));

					merchantStoreProductDetailsBo = new MerchantStoreProductDetailsBo();
					merchantStoreProductDetailsBo.setMerchantBusiness(merchantBusinessBo);
					merchantStoreProductDetailsBo.setProductId(productId);
					merchantStoreProductDetailsBo.setStoreId(rs.getInt(2));
					merchantStoreProductDetailsBo.setTitle(rs.getString(3));
					merchantStoreProductDetailsBo.setDescription(rs.getString(4));
					merchantStoreProductDetailsBo.setCategoryId(rs.getInt(5));
					merchantStoreProductDetailsBo.setPrice(rs.getDouble(6));
					merchantStoreProductDetailsBo.setQuantity(rs.getInt(7));
					merchantStoreProductDetailsBo.setStatus(rs.getString(8));
					merchantStoreProductDetailsBo.setCreatedBy(rs.getString(9));
					merchantStoreProductDetailsBo.setCreatedDate(rs.getDate(10));
					merchantStoreProductDetailsBo.setLastModifiedBy(rs.getString(11));
					merchantStoreProductDetailsBo.setLastModifiedDate(rs.getDate(12));

					productImages = new ArrayList<>();
					productFeedbackBos = new ArrayList<>();
					merchantStoreProductDetailsBo.setProductImages(productImages);
					merchantStoreProductDetailsBo.setProductFeedback(productFeedbackBos);
					merchantStoreProductDetailsMap.put(productId, merchantStoreProductDetailsBo);
				} else {
					merchantStoreProductDetailsBo = merchantStoreProductDetailsMap.get(productId);
				}
				productFeedbackId = rs.getInt(44);
				if (productFeedbackMap.containsKey(productFeedbackId) == false) {
					productFeedbackBo = new ProductFeedbackBo();
					productFeedbackBo.setFeedbackId(productFeedbackId);
					productFeedbackBo.setProductId(rs.getInt(46));
					productFeedbackBo.setComments(rs.getString(47));
					productFeedbackBo.setRating(rs.getInt(48));
					productFeedbackBo.setStatus(rs.getString(49));
					productFeedbackBo.setCreatedBy(rs.getString(50));
					productFeedbackBo.setCreatedDate(rs.getDate(51));
					productFeedbackBo.setLastModifiedBy(rs.getString(52));
					productFeedbackBo.setLastModifiedDate(rs.getDate(53));

					systemUser = new SystemUserBo();
					systemUser.setSystemUserId(rs.getInt(27));
					systemUser.setUserRoleId(rs.getInt(28));
					systemUser.setEmailAddress(rs.getString(29));
					systemUser.setPassword(rs.getString(30));
					systemUser.setMobileNumber(rs.getString(31));
					systemUser.setEmailVerificationCode(rs.getString(32));
					systemUser.setMobileNumberVerificationCode(rs.getString(33));
					systemUser.setEmailAddressVerified(rs.getInt(34));
					systemUser.setMobileNumberVerified(rs.getInt(35));
					systemUser.setEmailAddressVerificationDate(rs.getDate(36));
					systemUser.setMobileNumberVerificationDate(rs.getDate(37));
					systemUser.setLastLoggedInDate(rs.getDate(38));
					systemUser.setAccountStatus(rs.getString(39));
					systemUser.setCreatedBy(rs.getString(40));
					systemUser.setCreatedDate(rs.getDate(41));
					systemUser.setLastModifiedBy(rs.getString(42));
					systemUser.setLastModifiedDate(rs.getDate(43));
					productFeedbackBo.setSystemUser(systemUser);
					productFeedbackMap.put(productFeedbackId, productFeedbackBo);
					merchantStoreProductDetailsBo.getProductFeedback().add(productFeedbackBo);
				}
				imageId = rs.getInt(54);
				if (imageMap.containsKey(imageId) == false) {
					imageBo = CozarbImageMapper.mapResultSetToImageBo(rs);
					imageMap.put(imageId, imageBo);
					merchantStoreProductDetailsBo.getProductImages().add(imageBo);
				}
			}
			merchantStoreProductDetailsBos = new ArrayList<>();
			for (MerchantStoreProductDetailsBo bo : merchantStoreProductDetailsMap.values()) {
				merchantStoreProductDetailsBos.add(bo);
			}
			return merchantStoreProductDetailsBos;
		}

	}
}
