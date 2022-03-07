package com.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.framework.base.BaseClass;

/*
* Log4j is used to register implementation details (also called logs) in the log file at a specific location.
* It has several levels which can be invoked during execution which stores the input provided with date and time at that
* instance.
* */

public class Log extends BaseClass {
// initialization of log4j logs
	public static Logger log = Logger.getLogger(Log.class.getName());
	public static Date date = new Date();
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

// every test case must begin with this method
	public static void startOfTestCase(String testName) {
		log.info(simpleDateFormat.format(date) + " = " + "============= TEST " + testName + " STARTED =============");
	}

// every test case must end with this method
	public static void endOfTestCase(String testName) {
		log.info(simpleDateFormat.format(date) + " = " + "============= TEST " + testName + " ENDED ===============");
	}

// all the log levels implementations
	public static void info(String message) {
		log.info(simpleDateFormat.format(date) + " INFO = " + message);
	}

	public static void warn(String message) {
		log.warn(simpleDateFormat.format(date) + " WARN = " + message);
	}

	public static void fatal(String message) {
		log.fatal(simpleDateFormat.format(date) + " FATAL = " + message);
	}

	public static void debug(String message) {
		log.debug(simpleDateFormat.format(date) + " DEBUG = " + message);
	}
}