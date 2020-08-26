package com.cozarb.service.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CozarbLogger {
	private Logger logger;

	private CozarbLogger(Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
	}

	public static CozarbLogger getLogger(Class<?> clazz) {
		return new CozarbLogger(clazz);
	}

	public void info(String infoMessage) {
		logger.info(infoMessage);
	}

	public void info(String infoMessage, Object... params) {
		logger.info(infoMessage, params);
	}

	public void debug(String debugMessage) {
		logger.debug(debugMessage);
	}

	public void debug(String debugMessage, Object... params) {
		logger.debug(debugMessage, params);
	}

	public void error(String errorMessage, Throwable e) {
		logger.error(errorMessage, e);
	}

	public void error(String errorMessage, Throwable e, Object... params) {
		logger.error(errorMessage, e, params);
	}

	public void fatal(String fatalMessage, Throwable t) {
		logger.fatal(fatalMessage, t);
	}

	public void fatal(String fatalMessage, Throwable t, Object... params) {
		logger.fatal(fatalMessage, t, params);
	}
}
