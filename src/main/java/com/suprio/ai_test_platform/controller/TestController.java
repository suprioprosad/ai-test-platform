package com.suprio.ai_test_platform.controller;

import com.suprio.ai_test_platform.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.suprio.ai_test_platform.model.TestCase;
import com.suprio.ai_test_platform.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private AIService aiService;

    @PostMapping("/create-test")
    public TestCase createTest(@RequestBody TestCase testCase) {
        return testService.createTest(testCase);
    }

    @GetMapping("/tests")
    public List<TestCase> getTests() {
        return testService.getAllTests();
    }

    @PostMapping("/ai-generate")
    public List<TestCase> generate(@RequestBody String input) {

        List<TestCase> tests = aiService.generateTestCases(input);

        return tests.stream()
                .map(testService::createTest)
                .toList();
    }

    @PostMapping("/run-test/{id}")
    public String runTest(@PathVariable Long id) {
        return testService.runTest(id);
    }
}

