package com.github.mraa4j;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;

public interface NativeMraa extends Library {
	// commons:

	/* Pointer  */int mraa_init();

	void mraa_deinit();

	/* mraa_boolean_t */boolean mraa_pin_mode_test(int pin, /* mraa_pinmodes_t */int mode);

	/* unsigned */int mraa_adc_raw_bits();

	/* unsigned */int mraa_adc_supported_bits();

	/* mraa_result_t */int mraa_set_log_level(int level);

	String mraa_get_platform_name();

	int mraa_set_priority(/* const unsigned */int priority);

	String mraa_get_version();

	void mraa_result_print(/* mraa_result_t */int result);

	/* mraa_platform_t */int mraa_get_platform_type();

	int mraa_get_pin_count();

	String mraa_get_pin_name(int pin);

	// AIO:

	/* mraa_aio_context */Pointer mraa_aio_init(/* unsigned */int pin);

	/* unsigned */int mraa_aio_read(Pointer dev);

	float mraa_aio_read_float(Pointer dev);

	/* mraa_result_t */int mraa_aio_close(Pointer dev);

	/* mraa_result_t */int mraa_aio_set_bit(Pointer dev, int bits);

	int mraa_aio_get_bit(Pointer dev);

	// GPIO:
	Pointer mraa_gpio_init(int pin);

	Pointer mraa_gpio_init_raw(int gpiopin);

	int mraa_gpio_edge_mode(Pointer dev, /* gpio_edge_t */int mode);

	int mraa_gpio_isr(Pointer dev, /* gpio_edge_t */int edge, /* void(*fptr)(void*) */Callback fptr, /* void* args*/Pointer args);

	int mraa_gpio_isr_exit(Pointer dev);

	int mraa_gpio_mode(Pointer dev, /* gpio_mode_t */int mode);

	int mraa_gpio_dir(Pointer dev, /* gpio_dir_t */int dir);

	int mraa_gpio_close(Pointer dev);

	int mraa_gpio_read(Pointer dev);

	int mraa_gpio_write(Pointer dev, int value);

	int mraa_gpio_owner(Pointer dev, /* mraa_boolean_t */boolean owner);

	int mraa_gpio_use_mmaped(Pointer dev, /* mraa_boolean_t */boolean mmap);

	int mraa_gpio_get_pin(Pointer dev);

	int mraa_gpio_get_pin_raw(Pointer dev);


	// I2C
	Pointer mraa_i2c_init(int bus);

	Pointer mraa_i2c_init_raw(int bus);

	int mraa_i2c_frequency(Pointer dev, int mode);

	int mraa_i2c_read(Pointer dev, byte[] data, int length);

	byte mraa_i2c_read_byte(Pointer dev);

	byte mraa_i2c_read_byte_data(Pointer dev, byte command);

	short mraa_i2c_read_word_data(Pointer dev, byte command);

	int mraa_i2c_read_bytes_data(Pointer dev, byte command, byte[] data, int length);

	int mraa_i2c_write(Pointer dev, byte[] data, int length);

	int mraa_i2c_write_byte(Pointer dev, byte data);

	int mraa_i2c_write_byte_data(Pointer dev, byte data, byte command);

	int mraa_i2c_write_word_data(Pointer dev, short data, byte command);

	int mraa_i2c_address(Pointer dev, byte address);

	int mraa_i2c_stop(Pointer dev);

	// PWM
	Pointer mraa_pwm_init(int pin);

	Pointer mraa_pwm_init_raw(int chipid, int pin);

	int mraa_pwm_write(Pointer dev, float percentage);

	float mraa_pwm_read(Pointer dev);

	int mraa_pwm_period(Pointer dev, float seconds);

	int mraa_pwm_period_ms(Pointer dev, int ms);

	int mraa_pwm_period_us(Pointer dev, int us);

	int mraa_pwm_pulsewidth(Pointer dev, float seconds);

	int mraa_pwm_pulsewidth_ms(Pointer dev, int ms);

	int mraa_pwm_pulsewidth_us(Pointer dev, int us);

	int mraa_pwm_enable(Pointer dev, int enable);

	int mraa_pwm_owner(Pointer dev, boolean owner);

	int mraa_pwm_close(Pointer dev);

	int mraa_pwm_config_ms(Pointer dev, int period, float duty);

	int mraa_pwm_config_percent(Pointer dev, int period, float duty);

	int mraa_pwm_get_max_period();

	int mraa_pwm_get_min_period();

	// SPI
	Pointer mraa_spi_init(int bus);

	Pointer mraa_spi_init_raw(int bus, int cs);

	int mraa_spi_mode(Pointer dev, int mode);

	int mraa_spi_frequency(Pointer dev, int hz);

	int mraa_spi_write(Pointer dev, byte data);

	short mraa_spi_write_word(Pointer dev, short data);

	byte[] mraa_spi_write_buf(Pointer dev, byte[] data, int length);

	short[] mraa_spi_write_buf_word(Pointer dev, short[] data, int length);

	int mraa_spi_transfer_buf(Pointer dev, byte[] data, byte[] rxbuf, int length);

	int mraa_spi_transfer_buf_word(Pointer dev, short[] data, short[] rxbuf, int length);

	int mraa_spi_lsbmode(Pointer dev, boolean lsb);

	int mraa_spi_bit_per_word(Pointer dev, int bits);

	int mraa_spi_stop(Pointer dev);

	// UART
	Pointer	mraa_uart_init (int uart);

	String mraa_uart_get_dev_path (Pointer dev);
}
