package org.example.ws.util;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public abstract class ObjectComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		return compareObject(arg0, arg1);
	}

	public abstract int compareObject(Object arg0, Object arg1);
}
