package com.github.mraa4j;

import com.github.mraa4j.enums.GPIODirT;
import com.github.mraa4j.enums.GPIOModeT;
import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

import static com.github.mraa4j.MraaException.checkResult;

public final class GPIO {

	private Pointer gpioContext;
	private NativeMraa nativeLib;

	public GPIO () {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
	}

	public GPIO (int pin) throws MraaException {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
		gpioContext = nativeLib.mraa_gpio_init(pin);
		if (null == gpioContext) {
			throw new MraaException("Failed to initialize GPIO pin: " + pin);
		}
	}

	public void initRaw(int gpioPin)  throws MraaException {
		gpioContext = nativeLib.mraa_gpio_init_raw(gpioPin);
		if (null == gpioContext) {
			throw new MraaException("Failed to initialize GPIO pin: " + gpioPin);
		}
	}

	public void edgeMode(int mode) throws MraaException {
		int result = nativeLib.mraa_gpio_edge_mode(gpioContext, /* gpio_edge_t */ mode);
		checkResult(ResultT.fromValue(result));
	}

	interface Isr extends Callback {
		void invoke();
	}
	public void setIsr(int edge, Isr func, Pointer args) throws MraaException {
//		Isr fn = new Isr() {
//			public void invoke () {
//				System.out.println("Callback called");
//			}
//		};
		int  result = nativeLib.mraa_gpio_isr(gpioContext, /* gpio_edge_t */edge, /* void(*fptr)(void*) */func, /* void* args*/ args);
		checkResult(ResultT.fromValue(result));
	}

	public void  isrExit() throws MraaException {
		int result = nativeLib.mraa_gpio_isr_exit(gpioContext);
		checkResult(ResultT.fromValue(result));
	}

	public void setMode(GPIOModeT mode) throws MraaException {
		int  result = nativeLib.mraa_gpio_mode(gpioContext, /* gpio_mode_t */mode.ordinal());
		checkResult(ResultT.fromValue(result));
	}

	public void setDirection(GPIODirT dir) throws MraaException {
		int  result = nativeLib.mraa_gpio_dir(gpioContext, /* gpio_dir_t */dir.ordinal());
		checkResult(ResultT.fromValue(result));
	}

	public void close() throws MraaException {
		int  result = nativeLib.mraa_gpio_close(gpioContext);
		checkResult(ResultT.fromValue(result));
	}

	public int read() {
		return  nativeLib.mraa_gpio_read(gpioContext);
	}

	public void write(int value) throws MraaException {
		int  result = nativeLib.mraa_gpio_write(gpioContext, value);
		checkResult(ResultT.fromValue(result));
	}

	public void setOwner(boolean owner) throws MraaException {
		int  result = nativeLib.mraa_gpio_owner(gpioContext, /* mraa_boolean_t */owner);
		checkResult(ResultT.fromValue(result));
	}

	public void setUseMmap(boolean mmap) throws MraaException {
		int  result = nativeLib.mraa_gpio_use_mmaped(gpioContext, /* mraa_boolean_t */mmap);
		checkResult(ResultT.fromValue(result));
	}

	public void getPin() throws MraaException {
		int  result = nativeLib.mraa_gpio_get_pin(gpioContext);
		checkResult(ResultT.fromValue(result));
	}

	public void getPinRaw() throws MraaException {
		int  result = nativeLib.mraa_gpio_get_pin_raw(gpioContext);
		checkResult(ResultT.fromValue(result));
	}

}
