package com.github.mraa4j;

import com.sun.jna.Pointer;

public final class UART {
	private Pointer uartContext;
	private NativeMraa nativeLib;

	public UART(int uart) throws MraaException {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
		uartContext = nativeLib.mraa_uart_init(uart);
		if (null == uartContext) {
			throw new MraaException("Failed to initialize UART uart: " + uart);
		}
	}

	public String getDevPath() {
		return nativeLib.mraa_uart_get_dev_path(uartContext);
	}
}
