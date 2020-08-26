package com.cozarb.service.productandcategories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cozarb.bo.merchant.MerchantStoreCategoryBo;
import com.cozarb.dao.productandcategories.ProductAndCategoryDao;
import com.cozarb.dto.merchant.MerchantStoreCategoryDto;
import com.cozarb.dto.productandcategories.ImageDto;
import com.cozarb.service.util.CozarbImageMapper;

@Service
public class ProductAndCategoryServiceImpl implements ProductAndCategoryService {
	@Autowired
	private ProductAndCategoryDao productAndCategoryDao;

	@Override
	@Transactional(readOnly = true)
	public byte[] getImage(int imageId) {
		return productAndCategoryDao.getImage(imageId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MerchantStoreCategoryDto> getMerchantStoreCategories() {
		List<MerchantStoreCategoryBo> merchantStoreCategoryBos = null;
		List<MerchantStoreCategoryDto> merchantStoreCategoryDtos = null;
		MerchantStoreCategoryDto merchantStoreCategoryDto = null;
		ImageDto imageDto = null;

		merchantStoreCategoryBos = productAndCategoryDao.getMerchantStoreCategories();
		merchantStoreCategoryDtos = new ArrayList<>();
		for (MerchantStoreCategoryBo bo : merchantStoreCategoryBos) {
			merchantStoreCategoryDto = new MerchantStoreCategoryDto();

			merchantStoreCategoryDto.setCategoryId(bo.getCategoryId());
			merchantStoreCategoryDto.setCategoryName(bo.getCategoryName());
			
			imageDto = CozarbImageMapper.mapImageBoToDto(bo.getMerchantStoreCategoryImage());
			
			merchantStoreCategoryDto.setCategoryImage(imageDto);
			merchantStoreCategoryDtos.add(merchantStoreCategoryDto);

		}

		return merchantStoreCategoryDtos;
	}

}
