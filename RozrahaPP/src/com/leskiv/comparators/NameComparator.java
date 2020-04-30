package com.leskiv.comparators;

import com.leskiv.Vegetable;

public class NameComparator implements java.util.Comparator<Vegetable>{
		public int compare(Vegetable v1, Vegetable v2) {
	        return  v1.getName().compareTo(v2.getName()) ;
	    }
}
