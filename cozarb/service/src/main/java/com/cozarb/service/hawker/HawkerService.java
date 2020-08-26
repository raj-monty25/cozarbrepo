package com.cozarb.service.hawker;

import java.util.List;

import com.cozarb.dto.hawker.HawkerDto;

public interface HawkerService {
	List<HawkerDto> getRecentHawkers(int days);
}
