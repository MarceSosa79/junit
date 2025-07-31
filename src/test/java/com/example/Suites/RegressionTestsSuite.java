package com.example.Suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;

@Suite
@SelectPackages("com.example")
@IncludeTags("regression")
public class RegressionTestsSuite {
}
