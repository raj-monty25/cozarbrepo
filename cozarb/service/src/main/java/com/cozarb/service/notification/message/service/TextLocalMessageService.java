package com.cozarb.service.notification.message.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cozarb.service.exception.MessageServiceException;
import com.cozarb.service.logging.CozarbLogger;
import com.cozarb.service.notification.message.bean.Message;
import com.cozarb.service.textmessage.provider.bean.TextLocalErrorResponse;
import com.cozarb.service.textmessage.provider.bean.TextLocalResponse;

@Component
public class TextLocalMessageService implements MessageService<Message> {
	private final static CozarbLogger cozarbLogger = CozarbLogger.getLogger(TextLocalMessageService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${messaging.text.provider.url}")
	private String providerUrl;
	@Value("${messaging.text.provider.api-key}")
	private String apiKey;
	@Value("${messaging.text.provider.test}")
	private boolean testMode;

	@Override
	public void message(Message message) {
		String requestUrl = null;
		ResponseEntity<?> response = null;
		TextLocalResponse textLocalresponse = null;
		TextLocalErrorResponse textLocalErrorResponse = null;

		requestUrl = providerUrl + "?apikey=" + apiKey + "&message=" + message.getContent() + "&sender="
				+ message.getFrom() + "&numbers=" + Stream.of(message.getTo()).collect(Collectors.joining(","))
				+ "&test=" + testMode;
		response = restTemplate.getForEntity(requestUrl, String.class);
		cozarbLogger.debug("text local response : " + response.getBody());
		
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new MessageServiceException("failed in sending the text message");
		}
	}

}
