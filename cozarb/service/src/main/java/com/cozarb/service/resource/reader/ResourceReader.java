package com.cozarb.service.resource.reader;

public interface ResourceReader {
	default byte[] getResource(String resourceName) {
		return null;
	}

	default byte[] getResource(String resourceName, Object... objects) {
		return null;
	}
}
