package com.github.mraa4j;

import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Pointer;
import static com.github.mraa4j.MraaException.checkResult;

public final class AnalogIO {

	private Pointer aioContext;
	private NativeMraa nativeLib;

	public AnalogIO (int pin) throws MraaException {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
		aioContext = nativeLib.mraa_aio_init(pin);
		if (null == aioContext) {
			throw new MraaException("Failed to initialize GPIO pin: " + pin);
		}
	}

	public int read() {
		return nativeLib.mraa_aio_read(aioContext);
	}

	public float readFloat() {
		return nativeLib.mraa_aio_read_float(aioContext);
	}

    public void setBits(int bits) throws MraaException {
	int result = nativeLib.mraa_aio_set_bit(aioContext, bits);
	checkResult(ResultT.fromValue(result));
    }

    public int getBit() {
		return nativeLib.mraa_aio_get_bit(aioContext);
    }
}
