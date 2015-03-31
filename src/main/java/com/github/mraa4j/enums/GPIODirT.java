package com.github.mraa4j.enums;

public enum GPIODirT {
	 MRAA_GPIO_OUT,
	 MRAA_GPIO_IN,
	 MRAA_GPIO_OUT_HIGH,
	 MRAA_GPIO_OUT_LOW;

	 static public GPIODirT fromValue(int v) {
		 return Helper.fromValue(GPIODirT.class, v);
	 }
}
