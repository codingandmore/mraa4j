package com.github.mraa4j.enums;

import java.util.EnumSet;

public enum PlatformT {
	MRAA_INTEL_GALILEO_GEN1(0),
	MRAA_INTEL_GALILEO_GEN2(1),
	MRAA_INTEL_EDISON_FAB_C(2),
	MRAA_INTEL_DE3815 (3),
	MRAA_INTEL_MINNOWBOARD_MAX(4),
	MRAA_RASPBERRY_PI(5),
	MRAA_UNKNOWN_PLATFORM(99);

	private int value;

	private PlatformT(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	static public PlatformT fromValue(int v) {
		EnumSet<PlatformT> allEnums = EnumSet.allOf(PlatformT.class);
		for (PlatformT elem: allEnums) {
			if (elem.getValue() == v) {
				return elem;
			}
		}
		return null;
	}


};
