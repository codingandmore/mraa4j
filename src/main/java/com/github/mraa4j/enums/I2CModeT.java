package com.github.mraa4j.enums;

public enum I2CModeT {
	MRAA_I2C_STD,
	MRAA_I2C_FAST,
	MRAA_I2C_HIGH;

	static public I2CModeT fromValue(int v) {
		return Helper.fromValue(I2CModeT.class, v);
	}

}
