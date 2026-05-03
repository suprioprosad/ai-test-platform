package com.suprio.ai_test_platform.service;

import org.springframework.stereotype.Service;
import com.suprio.ai_test_platform.model.TestCase;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {

    public List<TestCase> generateTestCases(String input) {

        List<TestCase> testCases = new ArrayList<>();

        TestCase t1 = new TestCase();
        t1.setName("Valid Login");
        t1.setDescription("Login with valid username and password");
        t1.setStatus("NEW");
        t1.setApiEndpoint("/login");
        t1.setMethod("POST");

        TestCase t2 = new TestCase();
        t2.setName("Invalid Login");
        t2.setDescription("Login with wrong password");
        t2.setStatus("NEW");
        t2.setApiEndpoint("/login");
        t2.setMethod("POST");

        testCases.add(t1);
        testCases.add(t2);

        return testCases;
    }

    public String analyzeFailure(TestCase testCase) {

        if (testCase.getStatus().equals("FAIL")) {

            return "AI Analysis: Test failed likely due to invalid input or API response mismatch. " +
                    "Check request payload, endpoint, and authentication.";
        }

        return "AI Analysis: Test passed successfully. No issues detected.";
    }
}