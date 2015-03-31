package com.github.mraa4j.enums;

public enum GPIOModeT {
	MRAA_GPIO_STRONG,
	MRAA_GPIO_PULLUP,
	MRAA_GPIO_PULLDOWN,
	MRAA_GPIO_HIZ;

	static public GPIOModeT fromValue(int v) {
		return Helper.fromValue(GPIOModeT.class, v);
	}

}
