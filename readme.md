## mraa4j ##
A Java library for accessing GPIO ports on Intel Edison, Galileo and other devices based on [librmaa](http://iotdk.intel.com/docs/master/mraa/index.html)

##Important Note##
The current version of this library is only a design study. Most of the functions are completely untested and I do not expect them to work. It may be a starting point for others  using the Intel Edison or similar devices from Java. Currently is seems that no other libraries are availble.

### Architecture ###
mraa4j is a thin layer on top of Intel's librmraa C/C++ library using Java Native interface. Please follow the [documentation](http://iotdk.intel.com/docs/master/mraa/index.html) from Intel to get an introduction to the API. The Java API mainly follows the Intel documentation with a few adaptions to make it more Java like. With this library it is possible to access the GPIO ports from within the Java virtual machine.

## Usage ##
Use maven to build the library. Add the resulting jar to your project. An additional dependency is the Java Native Access (JNA) library. `jna-4.1.0.jar`. You can build a jar including all dependencies with `mvn assembly:assembly`.
Here is an example to use Analog IO (AIO):

<pre lang="java"><code>

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
		System.out.println("Failed to initialize AnalogIO");
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

</code></pre>

## License ##
The MIT License (MIT)

Copyright (c) 2015 https://github.com/jensix/mraa4j

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
