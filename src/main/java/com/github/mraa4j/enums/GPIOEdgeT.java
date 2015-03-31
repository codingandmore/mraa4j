package com.github.mraa4j.enums;

public enum GPIOEdgeT {
	MRAA_GPIO_EDGE_NONE,
	MRAA_GPIO_EDGE_BOTH,
	MRAA_GPIO_EDGE_RISING,
	MRAA_GPIO_EDGE_FALLING;

	static public GPIOEdgeT fromValue(int v) {
		return Helper.fromValue(GPIOEdgeT.class, v);
	}

}
