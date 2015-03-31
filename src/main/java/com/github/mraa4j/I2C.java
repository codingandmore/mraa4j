package com.github.mraa4j;

import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Pointer;
import static com.github.mraa4j.MraaException.checkResult;

public final class I2C {
	private Pointer i2cContext;
	private NativeMraa nativeLib;

	public I2C() {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
	}

	public I2C(int bus) throws MraaException {
		this();
		i2cContext = nativeLib.mraa_i2c_init(bus);
		if (null == i2cContext) {
			throw new MraaException("Failed to initialize I2C bus: " + bus);
		}
	}

	public void initRaw(int bus) throws MraaException{
		i2cContext = nativeLib.mraa_i2c_init_raw(bus);
		if (null == i2cContext) {
			throw new MraaException("Failed to initialize I2C bus: " + bus);
		}
	}

	public void setFrequency(int mode) throws MraaException {
		int result =  nativeLib.mraa_i2c_frequency(i2cContext, mode);
		checkResult(ResultT.fromValue(result));
	}

	public int read(byte[] data) {
		return nativeLib.mraa_i2c_read(i2cContext, data, data.length);
	}

	public byte read() {
		return nativeLib.mraa_i2c_read_byte(i2cContext);
	}

	public byte readByteData(byte command) {
		return nativeLib.mraa_i2c_read_byte_data(i2cContext, command);
	}

	public short readWordData(byte command) {
		return nativeLib.mraa_i2c_read_word_data(i2cContext, command);
	}

	public int readBytesData(byte command, byte[] data) {
		return nativeLib.mraa_i2c_read_bytes_data(i2cContext, command, data, data.length);
	}

	public int write (byte[] data) {
		return nativeLib.mraa_i2c_write(i2cContext, data, data.length);
	}

	public int write (byte data) {
		return nativeLib.mraa_i2c_write_byte(i2cContext, data);
	}

	public int writeByteData(byte command, byte data) {
		return nativeLib.mraa_i2c_write_byte_data(i2cContext, data, command);
	}

	public int writeWordData(byte command, short data) {
		return nativeLib.mraa_i2c_write_word_data(i2cContext, data, command);
	}

	public void setAddress(byte address) throws MraaException {
		int result = nativeLib.mraa_i2c_address(i2cContext, address);
		checkResult(ResultT.fromValue(result));
	}

	public void stop() throws MraaException {
		int result =  nativeLib.mraa_i2c_stop(i2cContext);
		checkResult(ResultT.fromValue(result));
	}
}
