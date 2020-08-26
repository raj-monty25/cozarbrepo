package com.cozarb.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cozarb.bo.productandcategories.ImageBo;
import com.cozarb.dto.productandcategories.ImageDto;

public class CozarbImageMapper {
	public static ImageDto mapImageBoToDto(ImageBo bo) {
		ImageDto imageDto = new ImageDto();
		imageDto.setImageId(bo.getImageId());
		imageDto.setImageName(bo.getImageName());
		imageDto.setDescription(bo.getDescription());
		imageDto.setImageType(bo.getImageType());
		return imageDto;
	}

	public static ImageBo mapResultSetToImageBo(ResultSet rs) throws SQLException {
		ImageBo imageBo = new ImageBo();
		imageBo.setImageId(rs.getInt("image_id"));
		imageBo.setImageName(rs.getString("image_nm"));
		imageBo.setImageType(rs.getString("image_type"));
		imageBo.setDescription(rs.getString("description"));
		imageBo.setStatus(rs.getString("status"));
		imageBo.setCreatedBy(rs.getString("created_by"));
		imageBo.setCreatedDate(rs.getDate("created_dt"));
		imageBo.setLastModifiedBy(rs.getString("last_modified_by"));
		imageBo.setLastModifiedDate(rs.getDate("last_modified_dt"));

		return imageBo;
	}

	public static List<ImageDto> mapImageBosToDtos(List<ImageBo> imageBos) {
		List<ImageDto> imageDtos = null;
		ImageDto imageDto = null;

		imageDtos = new ArrayList<>();
		for (ImageBo bo : imageBos) {
			imageDto = mapImageBoToDto(bo);
			imageDtos.add(imageDto);
		}
		return imageDtos;
	}
}
