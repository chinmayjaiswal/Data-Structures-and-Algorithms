package com.cj.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cj.buffer.cache.BufferPoolTest;
import com.cj.io.FileSubSystemTest;

@RunWith(Suite.class)
@SuiteClasses({BufferPoolTest.class, FileSubSystemTest.class})
public class AllTestCases {}
