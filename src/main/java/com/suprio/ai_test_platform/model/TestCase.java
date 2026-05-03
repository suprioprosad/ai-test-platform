package com.suprio.ai_test_platform.model;

import jakarta.persistence.*;

@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;

    private String apiEndpoint;
    private String method;
    private String requestBody;
    private String expectedResponse;
    private String lastExecutedAt;
    private String failureReason;
    private String aiAnalysis;

    // Getters and Setters

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getApiEndpoint() { return apiEndpoint; }
    public void setApiEndpoint(String apiEndpoint) { this.apiEndpoint = apiEndpoint; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getRequestBody() { return requestBody; }
    public void setRequestBody(String requestBody) { this.requestBody = requestBody; }

    public String getExpectedResponse() { return expectedResponse; }
    public void setExpectedResponse(String expectedResponse) { this.expectedResponse = expectedResponse; }

    public String getLastExecutedAt() { return lastExecutedAt; }
    public void setLastExecutedAt(String lastExecutedAt) { this.lastExecutedAt = lastExecutedAt; }

    public String getFailureReason() { return failureReason; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }

    public String getAiAnalysis() { return aiAnalysis; }
    public void setAiAnalysis(String aiAnalysis) { this.aiAnalysis = aiAnalysis; }
}