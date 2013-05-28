package org.example.ws.util;

import org.example.ws.pojo.CategoryInfoDto;

public class CategoryComparator extends ObjectComparator {

	@Override
	public int compareObject(Object arg0, Object arg1) {
		CategoryInfoDto cate0 = (CategoryInfoDto) arg0;
		CategoryInfoDto cate1 = (CategoryInfoDto) arg1;

		return cate0.getCategoryId().compareTo(cate1.getCategoryId());
	}

}
