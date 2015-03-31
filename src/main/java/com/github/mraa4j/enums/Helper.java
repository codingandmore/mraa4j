package com.github.mraa4j.enums;

import java.util.EnumSet;


public class Helper {

	static <T extends Enum<T>> T fromValue(Class<T> clazz, int v) {
		EnumSet<T> allEnums = EnumSet.allOf(clazz);
		for (T elem: allEnums) {
			if (elem.ordinal() == v) {
				return elem;
			}
		}
		return null;
	}
}
