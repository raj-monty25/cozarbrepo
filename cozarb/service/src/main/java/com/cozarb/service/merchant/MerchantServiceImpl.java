package com.cozarb.service.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cozarb.bo.merchant.MerchantStoreCategoryBo;
import com.cozarb.bo.merchant.MerchantStoreProductBo;
import com.cozarb.bo.merchant.MerchantStoreProductDetailsBo;
import com.cozarb.bo.merchant.MerchantStoreWithBusinessBo;
import com.cozarb.bo.productandcategories.ProductFeedbackBo;
import com.cozarb.dao.merchant.MerchantDao;
import com.cozarb.dto.merchant.MerchantStoreCategoryDto;
import com.cozarb.dto.merchant.MerchantStoreDto;
import com.cozarb.dto.merchant.MerchantStoreProductDetailsDto;
import com.cozarb.dto.merchant.MerchantStoreProductDto;
import com.cozarb.dto.productandcategories.ProductFeedbackDto;
import com.cozarb.service.util.CozarbImageMapper;
import com.cozarb.service.util.DateTimeUtil;

@Service
public class MerchantServiceImpl implements MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	@Override
	@Transactional(readOnly = true)
	public List<MerchantStoreCategoryDto> getTopMerchantCategories(int days) {
		List<MerchantStoreCategoryBo> merchantStoreCategoryBos = null;
		List<MerchantStoreCategoryDto> merchantStoreCategoryDtos = null;
		MerchantStoreCategoryDto merchantStoreCategoryDto = null;
		Date fromDate = null;

		fromDate = DateTimeUtil.getBeforeDateofDays(days);
		merchantStoreCategoryBos = merchantDao.getTopMerchantCategoriesFromDate(fromDate);
		merchantStoreCategoryDtos = new ArrayList<>();

		for (MerchantStoreCategoryBo bo : merchantStoreCategoryBos) {
			merchantStoreCategoryDto = new MerchantStoreCategoryDto();
			merchantStoreCategoryDto.setCategoryId(bo.getCategoryId());
			merchantStoreCategoryDto.setCategoryName(bo.getCategoryName());
			merchantStoreCategoryDto
					.setCategoryImage(CozarbImageMapper.mapImageBoToDto(bo.getMerchantStoreCategoryImage()));
			merchantStoreCategoryDtos.add(merchantStoreCategoryDto);
		}
		return merchantStoreCategoryDtos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MerchantStoreProductDto> getRecentMerchantProducts(int days) {
		List<MerchantStoreProductBo> merchantStoreProductBos = null;
		List<MerchantStoreProductDto> merchantStoreProductDtos = null;
		MerchantStoreProductDto merchantStoreProductDto = null;
		Date fromDate = null;

		fromDate = DateTimeUtil.getBeforeDateofDays(days);
		merchantStoreProductBos = merchantDao.getRecentMerchantProductsFromDate(fromDate);
		merchantStoreProductDtos = new ArrayList<>();

		for (MerchantStoreProductBo bo : merchantStoreProductBos) {
			merchantStoreProductDto = mapMerchantStoreProductBoToDto(bo);
			merchantStoreProductDtos.add(merchantStoreProductDto);
		}
		return merchantStoreProductDtos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MerchantStoreDto> getRecentlyAddedMerchantStores(int days) {
		List<MerchantStoreWithBusinessBo> merchantStoreWithBusinessBos = null;
		List<MerchantStoreDto> merchantStoreDtos = null;
		MerchantStoreDto merchantStoreDto = null;
		Date fromDate = null;

		fromDate = DateTimeUtil.getBeforeDateofDays(days);
		merchantStoreWithBusinessBos = merchantDao.getRecentlyAddedMerchantStoresFromDate(fromDate);
		merchantStoreDtos = new ArrayList<>();
		for (MerchantStoreWithBusinessBo bo : merchantStoreWithBusinessBos) {
			merchantStoreDto = new MerchantStoreDto();
			merchantStoreDto.setMerchantStoreId(bo.getMerchantStoreId());
			merchantStoreDto.setBusinessName(bo.getMerchantBusinessBo().getBusinessName());
			merchantStoreDto.setMerchantStoreImages(CozarbImageMapper.mapImageBosToDtos(bo.getStoreImages()));
			merchantStoreDtos.add(merchantStoreDto);
		}

		return merchantStoreDtos;
	}

	@Override
	public List<MerchantStoreProductDto> getMerchantProductsOfSimilarCategoryByProductId(int productId) {
		List<MerchantStoreProductDto> merchantStoreProductDtos = null;
		List<MerchantStoreProductBo> merchantStoreProductBos = null;
		MerchantStoreProductDto merchantStoreProductDto = null;

		merchantStoreProductBos = merchantDao.getMerchantStoreProductsBySimilarCategoryProduct(productId);
		merchantStoreProductDtos = new ArrayList<>();
		for (MerchantStoreProductBo bo : merchantStoreProductBos) {
			merchantStoreProductDto = mapMerchantStoreProductBoToDto(bo);
			merchantStoreProductDtos.add(merchantStoreProductDto);
		}
		return merchantStoreProductDtos;
	}

	@Override
	public MerchantStoreProductDetailsDto getMerchantStoreProductDetails(int productId) {
		int totalRating = 0;
		ProductFeedbackDto productFeedbackDto = null;
		List<ProductFeedbackDto> productFeedbackDtos = null;
		MerchantStoreProductDetailsBo merchantStoreProductDetailsBo = null;
		MerchantStoreProductDetailsDto merchantStoreProductDetailsDto = null;

		merchantStoreProductDetailsBo = merchantDao.getMerchantStoreProduct(productId);
		if (merchantStoreProductDetailsBo != null) {
			merchantStoreProductDetailsDto = new MerchantStoreProductDetailsDto();
			productFeedbackDtos = new ArrayList<>();

			merchantStoreProductDetailsDto.setProductId(merchantStoreProductDetailsBo.getProductId());
			merchantStoreProductDetailsDto.setTitle(merchantStoreProductDetailsBo.getTitle());
			merchantStoreProductDetailsDto.setDescription(merchantStoreProductDetailsBo.getDescription());
			merchantStoreProductDetailsDto.setMerchantBusinessName(
					merchantStoreProductDetailsBo.getMerchantBusiness().getBusinessAliasName());
			merchantStoreProductDetailsDto.setPrice(merchantStoreProductDetailsBo.getPrice());
			merchantStoreProductDetailsDto.setQuantity(merchantStoreProductDetailsBo.getQuantity());
			merchantStoreProductDetailsDto.setProductImages(
					CozarbImageMapper.mapImageBosToDtos(merchantStoreProductDetailsBo.getProductImages()));

			for (ProductFeedbackBo pfbo : merchantStoreProductDetailsBo.getProductFeedback()) {
				totalRating += pfbo.getRating();
				productFeedbackDto = new ProductFeedbackDto();
				productFeedbackDto.setFeedbackId(pfbo.getFeedbackId());
				productFeedbackDto.setProductId(pfbo.getProductId());
				productFeedbackDto.setComments(pfbo.getComments());
				productFeedbackDto.setRating(pfbo.getRating());
				productFeedbackDto.setFeedbackUserName(pfbo.getSystemUser().getEmailAddress());
				productFeedbackDto.setFeedbackPostedDate(pfbo.getCreatedDate());
				productFeedbackDtos.add(productFeedbackDto);
			}
			merchantStoreProductDetailsDto.setProductFeedback(productFeedbackDtos);
			double averageRating = (((double) totalRating) / merchantStoreProductDetailsBo.getProductFeedback().size());
			merchantStoreProductDetailsDto.setRating((averageRating / 5) * 100);
		}

		return merchantStoreProductDetailsDto;
	}

	private MerchantStoreProductDto mapMerchantStoreProductBoToDto(MerchantStoreProductBo bo) {
		MerchantStoreProductDto merchantStoreProductDto = new MerchantStoreProductDto();
		merchantStoreProductDto.setProductId(bo.getProductId());
		merchantStoreProductDto.setProductName(bo.getTitle());
		merchantStoreProductDto.setPrice(bo.getPrice());
		merchantStoreProductDto.setProductImages(CozarbImageMapper.mapImageBosToDtos(bo.getProductImages()));
		return merchantStoreProductDto;
	}
}
