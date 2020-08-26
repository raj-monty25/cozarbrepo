package com.cozarb.dao.hawker;

import java.util.Date;
import java.util.List;

import com.cozarb.bo.hawker.HawkerBo;

public interface HawkerDao {
	List<HawkerBo> getHawkersFrom(Date fromDate);
}
