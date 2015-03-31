package com.github.mraa4j;

import java.util.EnumSet;

import com.github.mraa4j.enums.GPIODirT;
import com.github.mraa4j.enums.PlatformT;
import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Native;

public class Mraa4j {

	private static Mraa4j INSTANCE;

	public static Mraa4j getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new Mraa4j();
		}
		return INSTANCE;
	}

	private NativeMraa nativeMraa;
	private ResultT libraryState;

	private Mraa4j() {
		nativeMraa = (NativeMraa) Native.loadLibrary("mraa", NativeMraa.class);
		int initResult = nativeMraa.mraa_init();
		this.libraryState = ResultT.fromValue(initResult);
	}

	public NativeMraa getNativeInterface() {
		return nativeMraa;
	}

	public ResultT getInitState() {
		return libraryState;
	}

	public String getPlatformVersion() {
		String result = nativeMraa.mraa_get_version();
		return result;
	}

	public PlatformT getPlatformType() {
		int type = nativeMraa.mraa_get_platform_type();
		PlatformT result = PlatformT.fromValue(type);
		return result;
	}

	public static void main(String[] args) {
		PWM pwm = null;
		try {
			System.out.println("Init PWM ");
			pwm = new PWM(5);
			pwm.enable(true);
			float value = 0.0F;
			while (true) {
				pwm.write(value);
				value += 0.01F;
				Thread.sleep(100);
				if (value >= 1.0F) {
					value = 0.0F;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MraaException e) {
			System.out.println("Failed to initialize GPIO");
			e.printStackTrace();
		} finally {
			if (null != pwm) {
				try {
					pwm.close();
				} catch (MraaException e) {
					// ignore
				}
			}
		}
	}

	public static void mainGPIO(String[] args) {
		try {
			System.out.println("Init GPIO ");
			GPIO gpio = new GPIO(4);
			gpio.setDirection(GPIODirT.MRAA_GPIO_OUT);
			System.out.print("set direction, result: ");
			for (int i=0; i<10; i++) {
				System.out.print("on, result: ");
				gpio.write(1);
				System.out.println("1 written");
				Thread.sleep(1000);
				System.out.print("off, result: ");
				gpio.write(0);
				System.out.println("0 written");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MraaException e) {
			System.out.println("Failed to initialize GPIO");
			e.printStackTrace();
		}
	}

	public static void mainAnalogIO(String[] args) {
		System.out.println("Mraa4j");
		Mraa4j mraa = Mraa4j.getInstance();
		System.out.println("Mraa4j initialzed, state is: " + mraa.getInitState());
		PlatformT platformType = mraa.getPlatformType();
		System.out.println("Platform type is: " + platformType);
		String version = mraa.getPlatformVersion();
		System.out.println("Platform version is: " + version);
		try {
			AnalogIO aio = new AnalogIO(0); // AIO pin 0, GPIO pin 14
			for (int i=0; i<10; i++) {
				int value = aio.read();
				System.out.println("Sensor light value is: " + value);
				Thread.sleep(3000);
			}
		} catch (MraaException e) {
			System.out.println("Failed to initialize AnalogPIO");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main2(String[] args) {
		EnumSet<PlatformT> allEnums = EnumSet.allOf(PlatformT.class);
		for (PlatformT elem: allEnums) {
			System.out.println("ordinal("+ elem + "): " + elem.ordinal() );
		}
	}
	public static void main3(String[] args) {
		for (int i=0; i<5; i++) {
			System.out.println("value of " + i + " is: " + PlatformT.fromValue(i));
		}
		System.out.println("value of 99 is: " + PlatformT.fromValue(99));
	}

	public static void main4(String[] args) {
		for (int i=0; i<15; i++) {
			System.out.println("value of " + i + " is: " + ResultT.fromValue(i));
		}
	}

}
