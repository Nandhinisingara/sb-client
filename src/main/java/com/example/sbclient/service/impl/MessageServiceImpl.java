package com.example.sbclient.service.impl;

import com.example.sbclient.gateway.TcpClientGateway;
import com.example.sbclient.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    private TcpClientGateway tcpClientGateway;

    @Autowired
    public MessageServiceImpl(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway = tcpClientGateway;
    }

    @Override
    public void sendMessage(String messageContent) {
        String message = messageContent;
        LOGGER.info("Send message: {}", messageContent);
        byte[] responseBytes = tcpClientGateway.send(message.getBytes());
        String response = new String(responseBytes);
        LOGGER.info("Receive response: {}", response);
    }

}
