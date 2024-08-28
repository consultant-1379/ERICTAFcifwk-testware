package com.ericsson.cifwk.flows;

import javax.inject.Inject;

import com.ericsson.cifwk.taf.scenario.TestStepFlow;
import com.ericsson.cifwk.teststeps.PortalUITestSteps;

import static com.ericsson.cifwk.taf.scenario.TestScenarios.*;

public class PortalUIFlow {

    @Inject
    PortalUITestSteps portalUITestSteps;

    public TestStepFlow runDropPerformance() {
        TestStepFlow ui = flow("Perform Drop UI Performance")
                .addTestStep(annotatedMethod(portalUITestSteps, PortalUITestSteps.RUN_DROP_PERFORMANCE))
                .withDataSources(dataSource("dropLoadingPerformanceUI"))
                .build();
        return ui;
    }

    public TestStepFlow runPackagePagePerformance() {
        TestStepFlow ui = flow("Perform Package/Testware UI Performance")
                .addTestStep(annotatedMethod(portalUITestSteps, PortalUITestSteps.RUN_PACKAGE_PAGE_PERFORMANCE))
                .withDataSources(dataSource("productPackageLoadingPerformanceUI"))
                .build();
        return ui;
    }

    public TestStepFlow runTestwarePagePerformance() {
        TestStepFlow ui = flow("Perform Testware UI Performance")
                .addTestStep(annotatedMethod(portalUITestSteps, PortalUITestSteps.RUN_TESTWARE_PAGE_PERFORMANCE))
                .withDataSources(dataSource("testwareLoadingPerformanceUI"))
                .build();
        return ui;
    }
}
