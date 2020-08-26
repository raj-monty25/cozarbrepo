package com.cozarb.service.resource.reader;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.cozarb.service.exception.ResourceNotFoundException;

@Component
public class ClassPathFileResourceReader implements ResourceReader {

	@Override
	public byte[] getResource(String resourceName) {
		byte[] content = null;
		InputStream is = null;

		is = this.getClass().getClassLoader().getResourceAsStream(resourceName);
		try {
			content = is.readNBytes(is.available());
		} catch (IOException e) {
			throw new ResourceNotFoundException("resource not available", e);
		}
		return content;
	}

}
