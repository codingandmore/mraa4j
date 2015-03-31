package com.github.mraa4j.enums;

import java.util.EnumSet;

public enum PinModesT {
	MRAA_PIN_VALID(0),
	MRAA_PIN_GPIO(1),
	MRAA_PIN_PWM(2),
	MRAA_PIN_FAST_GPIO(3),
	MRAA_PIN_SPI(4),
	MRAA_PIN_I2C(5),
	MRAA_PIN_AIO(6),
	MRAA_PIN_UART(7);

	private int value;

	private PinModesT(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	static public PinModesT fromValue(int v) {
		EnumSet<PinModesT> allEnums = EnumSet.allOf(PinModesT.class);
		for (PinModesT elem : allEnums) {
			if (elem.getValue() == v) {
				return elem;
			}
		}
		return null;
	}
}
