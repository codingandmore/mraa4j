package com.github.mraa4j;

import static com.github.mraa4j.MraaException.checkResult;

import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Pointer;

public final class SPI {
	private Pointer spiContext;
	private NativeMraa nativeLib;

	public SPI() {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
	}

	public SPI(int bus, int cs) throws MraaException {
		this();
		spiContext = nativeLib.mraa_spi_init(bus);
		if (null == spiContext) {
			throw new MraaException("Failed to initialize SPI pin: " + bus);
		}
	}

	public void initRaw(int bus, int cs) throws MraaException{
		spiContext = nativeLib.mraa_spi_init_raw(bus, cs);
		if (null == spiContext) {
			throw new MraaException("Failed to initialize SPI pin: " + bus + ", cs: " + cs);
		}
	}

	public void setMode(int mode) throws MraaException {
		int result = nativeLib.mraa_spi_mode(spiContext, mode);
		checkResult(ResultT.fromValue(result));
	}

	public void setFrequency(int hertz) throws MraaException {
		int result = nativeLib.mraa_spi_frequency(spiContext, hertz);
		checkResult(ResultT.fromValue(result));
	}

	public int write(byte data) {
		return nativeLib.mraa_spi_write(spiContext, data);
	}

	public short write(short data) {
		return nativeLib.mraa_spi_write_word(spiContext, data);
	}

	public byte[] write(byte[] data) {
		return nativeLib.mraa_spi_write_buf(spiContext, data, data.length);
	}

	public short[] write(short[] data) {
		return nativeLib.mraa_spi_write_buf_word(spiContext, data, data.length);
	}

	public void transferBuffer(byte[] data, byte[] rxBuf) throws MraaException {
		int result = nativeLib.mraa_spi_transfer_buf(spiContext, data, rxBuf, data.length);
		checkResult(ResultT.fromValue(result));
	}

	public void transferBuffer(short[] data, short[] rxBuf) throws MraaException {
		int result = nativeLib.mraa_spi_transfer_buf_word(spiContext, data, rxBuf, data.length);
		checkResult(ResultT.fromValue(result));
	}

	public void setLsbMode(boolean lsb) throws MraaException {
		int result = nativeLib.mraa_spi_lsbmode(spiContext, lsb);
		checkResult(ResultT.fromValue(result));
	}

	public void setBitsPerWord(int bits) throws MraaException {
		int result = nativeLib.mraa_spi_bit_per_word(spiContext, bits);
		checkResult(ResultT.fromValue(result));
	}
}
