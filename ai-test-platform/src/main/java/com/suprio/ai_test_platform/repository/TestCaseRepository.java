package com.suprio.ai_test_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suprio.ai_test_platform.model.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}