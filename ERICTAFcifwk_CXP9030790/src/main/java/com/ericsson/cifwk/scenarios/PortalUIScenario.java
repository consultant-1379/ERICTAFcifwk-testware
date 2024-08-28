package com.ericsson.cifwk.scenarios;

import javax.inject.Inject;

import org.testng.annotations.Test;

import com.ericsson.cifwk.flows.PortalRESTFlow;
import com.ericsson.cifwk.flows.PortalUIFlow;
import com.ericsson.cifwk.taf.TorTestCaseHelper;
import com.ericsson.cifwk.taf.scenario.TestScenario;
import com.ericsson.cifwk.taf.scenario.TestScenarioRunner;
import com.ericsson.cifwk.taf.scenario.api.ExceptionHandler;
import com.ericsson.cifwk.taf.scenario.impl.LoggingScenarioListener;

import static com.ericsson.cifwk.taf.scenario.TestScenarios.runner;
import static com.ericsson.cifwk.taf.scenario.TestScenarios.scenario;

public class PortalUIScenario extends TorTestCaseHelper {

    @Inject
    PortalUIFlow portalUIFlow;

    @Inject
    PortalRESTFlow portalRESTFlow;

    @Test
    public void performanceUIParallelScenario() {
        TestScenario scenario = scenario("Portal UI Performance Parallel Scenario")
                .split(
                        portalUIFlow.runDropPerformance(),
                        portalUIFlow.runPackagePagePerformance(),
                        portalUIFlow.runTestwarePagePerformance()
                      )
                .build();
        TestScenarioRunner runner = runner()
                .withListener(new LoggingScenarioListener())
                .withExceptionHandler(ExceptionHandler.PROPAGATE).build();
        runner.start(scenario);
    }
}
