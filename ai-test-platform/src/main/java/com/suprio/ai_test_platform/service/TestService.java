package com.suprio.ai_test_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suprio.ai_test_platform.model.TestCase;
import com.suprio.ai_test_platform.repository.TestCaseRepository;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestCaseRepository repository;

    @Autowired
    private AIService aiService; // ✅ inject here (top)

    public TestCase createTest(TestCase testCase) {
        return repository.save(testCase);
    }

    public List<TestCase> getAllTests() {
        return repository.findAll();
    }

    public String runTest(Long id) {

        TestCase testCase = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found"));

        int maxRetries = 2;
        int attempt = 0;
        boolean success = false;

        while (attempt <= maxRetries && !success) {
            attempt++;

            // Simulate execution
            if (testCase.getName().toLowerCase().contains("valid")) {
                success = true;
                testCase.setStatus("PASS");
                testCase.setFailureReason(null);
            } else {
                testCase.setStatus("FAIL");
                testCase.setFailureReason("Invalid credentials or API failure");
            }
        }

        // ✅ Step 20 → execution timestamp
        testCase.setLastExecutedAt(java.time.LocalDateTime.now().toString());

        // ✅ Step 22 → AI analysis (MUST be before save & return)
        String analysis = aiService.analyzeFailure(testCase);
        testCase.setAiAnalysis(analysis);

        // Save updated test case
        repository.save(testCase);

        return "Test executed after " + attempt +
                " attempt(s). Final status: " + testCase.getStatus();
    }
}