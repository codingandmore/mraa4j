package com.github.mraa4j;

import com.github.mraa4j.enums.ResultT;
import com.sun.jna.Pointer;
import static com.github.mraa4j.MraaException.checkResult;

public final class PWM {

	private Pointer pwmContext;
	private NativeMraa nativeLib;

	public PWM() {
		nativeLib = Mraa4j.getInstance().getNativeInterface();
	}

	public PWM(int pin) throws MraaException {
		this();
		pwmContext = nativeLib.mraa_pwm_init(pin);
		if (null == pwmContext) {
			throw new MraaException("Failed to initialize PWM pin: " + pin);
		}
	}

	public void initRaw(int chipId, int pwmPin) throws MraaException {
		pwmContext = nativeLib.mraa_pwm_init_raw(chipId, pwmPin);
		if (null == pwmContext) {
			throw new MraaException("Failed to initialize PWM pin: " + pwmPin + ", chipId: " + chipId);
		}
	}

	public void write(float percentage) throws MraaException {
		int result = nativeLib.mraa_pwm_write(pwmContext, percentage);
		checkResult(ResultT.fromValue(result));
	}

	public float read() {
		return nativeLib.mraa_pwm_read(pwmContext);
	}

	public void setPeriod(float seconds) throws MraaException {
		int result = nativeLib.mraa_pwm_period(pwmContext, seconds);
		checkResult(ResultT.fromValue(result));
	}

	public void setPeriodMillis(int ms) throws MraaException {
		int result = nativeLib.mraa_pwm_period_ms(pwmContext, ms);
		checkResult(ResultT.fromValue(result));
	}

	public void setPeriodMicros(int us) throws MraaException {
		int result = nativeLib.mraa_pwm_period_us(pwmContext, us);
		checkResult(ResultT.fromValue(result));
	}

	public void setPulseWidth(float seconds) throws MraaException {
		int result = nativeLib.mraa_pwm_pulsewidth(pwmContext, seconds);
		checkResult(ResultT.fromValue(result));
	}

	public void setPulseWidthMillis(int ms) throws MraaException {
		int result = nativeLib.mraa_pwm_pulsewidth_ms(pwmContext, ms);
		checkResult(ResultT.fromValue(result));
	}

	public void setPulseWidhtMicros(int us) throws MraaException {
		int result = nativeLib.mraa_pwm_pulsewidth_us(pwmContext, us);
		checkResult(ResultT.fromValue(result));
	}

	public void enable(boolean enable) throws MraaException {
		int result = nativeLib.mraa_pwm_enable(pwmContext, enable ? 1 : 0);
		checkResult(ResultT.fromValue(result));
	}

	public void setOwner(boolean owner) throws MraaException {
		int result = nativeLib.mraa_pwm_owner(pwmContext, owner);
		checkResult(ResultT.fromValue(result));
	}

	public void close() throws MraaException {
		int result = nativeLib.mraa_pwm_close(pwmContext);
		checkResult(ResultT.fromValue(result));
	}

	public void setConfigMillis(int period, float duty) throws MraaException {
		int result = nativeLib.mraa_pwm_config_ms(pwmContext, period, duty);
		checkResult(ResultT.fromValue(result));
	}

	public void setConfigPercent(int period, float duty) throws MraaException {
		int result = nativeLib.mraa_pwm_config_percent(pwmContext, period, duty);
		checkResult(ResultT.fromValue(result));
	}

	public void getMaxPeriod() throws MraaException {
		int result = nativeLib.mraa_pwm_get_max_period();
		checkResult(ResultT.fromValue(result));
	}

	public void getMinPeriod() throws MraaException {
		int result = nativeLib.mraa_pwm_get_min_period();
		checkResult(ResultT.fromValue(result));
	}

}
