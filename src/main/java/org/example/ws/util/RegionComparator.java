package org.example.ws.util;

import org.example.ws.pojo.RegionInfoDto;

public class RegionComparator extends ObjectComparator {

	@Override
	public int compareObject(Object arg0, Object arg1) {
		RegionInfoDto region0 = (RegionInfoDto) arg0;
		RegionInfoDto region1 = (RegionInfoDto) arg1;

		return region0.getRegionId().compareTo(region1.getRegionId());
	}

}
