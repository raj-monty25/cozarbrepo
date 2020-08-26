package com.cozarb.service.hawker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozarb.bo.hawker.HawkerBo;
import com.cozarb.dao.hawker.HawkerDao;
import com.cozarb.dto.hawker.HawkerDto;
import com.cozarb.dto.productandcategories.ImageDto;
import com.cozarb.service.util.CozarbImageMapper;
import com.cozarb.service.util.DateTimeUtil;

@Service
public class HawkerServiceImpl implements HawkerService {
	@Autowired
	private HawkerDao hawkerDao;

	@Override
	public List<HawkerDto> getRecentHawkers(int days) {
		ImageDto imageDto = null;
		HawkerDto hawkerDto = null;
		List<HawkerBo> hawkerBos = null;
		List<HawkerDto> hawkerDtos = null;

		Date fromDate = null;

		fromDate = DateTimeUtil.getBeforeDateofDays(days);
		hawkerBos = hawkerDao.getHawkersFrom(fromDate);
		hawkerDtos = new ArrayList<>();
		for (HawkerBo bo : hawkerBos) {
			hawkerDto = new HawkerDto();
			hawkerDto.setHawkerId(bo.getHawkerId());
			hawkerDto.setHawkerName(bo.getHawkerName());
			hawkerDto.setDescription(bo.getDescription());

			imageDto = CozarbImageMapper.mapImageBoToDto(bo.getHawkerImage());
			hawkerDto.setHawkerImage(imageDto);

			hawkerDtos.add(hawkerDto);
		}
		return hawkerDtos;
	}

}
