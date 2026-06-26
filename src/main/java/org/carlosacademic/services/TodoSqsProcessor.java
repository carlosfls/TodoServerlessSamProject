package org.carlosacademic.services;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.Map;

public class TodoSqsProcessor {

    private final String QUEUE_URL;
    private final SqsClient sqsClient;

    public TodoSqsProcessor(String QUEUE_URL, SqsClient sqsClient) {
        this.QUEUE_URL = QUEUE_URL;
        this.sqsClient = sqsClient;
    }

    public void processTodo(String todo, LambdaLogger logger, String correlationId) {
        logger.log("Sending TODO to sqs. Request id: " + correlationId);

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(todo)
                .messageAttributes(Map.of(
                        "correlationId", MessageAttributeValue.builder()
                                            .stringValue(correlationId)
                                            .dataType("String")
                                            .build()
                ))
                .build();

        sqsClient.sendMessage(request);
    }
}
