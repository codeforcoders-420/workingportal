package com.test.spring.boot.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.test.spring.boot.readfile.ExcelReaderService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProgressWebSocketHandler extends TextWebSocketHandler {

    private final ExcelReaderService excelReaderService;

    public ProgressWebSocketHandler(ExcelReaderService excelReaderService) {
        this.excelReaderService = excelReaderService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        
        // Simulate the progress task and send progress and message updates
        for (int progress = 0; progress <= 100; progress += 10) {
            // Send the progress percentage
            session.sendMessage(new TextMessage("progress:" + progress));

            // Get the task update message from the service
            String taskMessage = excelReaderService.simulateProgressTask(progress);
            session.sendMessage(new TextMessage("message:" + taskMessage));

            Thread.sleep(500);  // Simulate a time-consuming task
        }

        session.close();  // Close the WebSocket connection after completion
    }
}
