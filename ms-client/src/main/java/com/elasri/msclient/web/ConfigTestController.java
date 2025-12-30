package com.elasri.msclient.web;

import com.elasri.msclient.config.GlobalConfig;
import com.elasri.msclient.config.TestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {
    GlobalConfig globalConfig;
    TestParam testParam;

    public ConfigTestController(GlobalConfig globalConfig, TestParam testParam) {
        this.globalConfig = globalConfig;
        this.testParam = testParam;
    }

    @GetMapping("/globalConfig")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    @GetMapping("/testParam")
    public TestParam getTestParam() {
        return testParam;
    }
}
