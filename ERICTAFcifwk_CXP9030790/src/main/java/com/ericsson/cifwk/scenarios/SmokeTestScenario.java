package com.ericsson.cifwk.scenarios;

import javax.inject.Inject;

import org.testng.annotations.Test;

import com.ericsson.cifwk.flows.PortalRESTFlow;
import com.ericsson.cifwk.taf.TorTestCaseHelper;
import com.ericsson.cifwk.taf.scenario.TestScenario;
import com.ericsson.cifwk.taf.scenario.TestScenarioRunner;
import com.ericsson.cifwk.taf.scenario.api.ExceptionHandler;
import com.ericsson.cifwk.taf.scenario.impl.LoggingScenarioListener;

import static com.ericsson.cifwk.taf.scenario.TestScenarios.runner;
import static com.ericsson.cifwk.taf.scenario.TestScenarios.scenario;

public class SmokeTestScenario extends TorTestCaseHelper {

    @Inject
    PortalRESTFlow portalRESTFlow;

    @Test
    public void smokeTestParallelScenario() {
        TestScenario scenario = scenario("Smoke Test Parallel Scenario")
                .split(
                        portalRESTFlow.runRestCalls(),
                        portalRESTFlow.runRestCallsInfra(),
                        portalRESTFlow.runRestCallsInfraJsonReturn(),
                        portalRESTFlow.runGenericRests(),
                        portalRESTFlow.dropPerformanceRestCalls(),
                        portalRESTFlow.productPackagePerformanceRestCalls(),
                        portalRESTFlow.productTestwarePerformanceRestCalls()
                      )
                .build();
        TestScenarioRunner runner = runner()
                .withListener(new LoggingScenarioListener())
                .withExceptionHandler(ExceptionHandler.PROPAGATE).build();
        runner.start(scenario);
    }
}
