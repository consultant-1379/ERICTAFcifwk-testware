package com.ericsson.cifwk.flows;

import javax.inject.Inject;

import com.ericsson.cifwk.taf.scenario.TestStepFlow;
import com.ericsson.cifwk.teststeps.PortalRESTTestSteps;

import static com.ericsson.cifwk.taf.scenario.TestScenarios.*;

public class PortalRESTFlow {

    @Inject
    PortalRESTTestSteps portalRESTTestSteps;

    public TestStepFlow runRestCalls() {
        TestStepFlow restCalls = flow("Perform various portal REST Calls")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS))
                .withDataSources(dataSource("portalRESTCommands"))
                .build();
        return restCalls;
    }

    public TestStepFlow runOnlyGETRestCalls() {
        TestStepFlow restCalls = flow("Perform various portal Only GET REST Calls")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS))
                .withDataSources(dataSource("portalRESTOnlyGETCommands"))
                .withVusers(5)
                .build();
        return restCalls;
    }

    public TestStepFlow runRestJSONInputCalls() {
        TestStepFlow restCalls = flow("Perform various JSON Input portal REST Calls")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS_JSON))
                .withDataSources(dataSource("portalRESTJSONInputCommands"))
                .build();
        return restCalls;
    }

    public TestStepFlow runRestCallsInfra() {
        TestStepFlow restCalls = flow("Delivery to a Drop")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS))
                .withDataSources(dataSource("deliveryRESTCommandsInfra"))
                .build();
        return restCalls;
    }

    public TestStepFlow runRestCallsInfraJsonReturn() {
        TestStepFlow restCalls = flow("Json Return From REST")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS_JSON_RETURN))
                .withDataSources(dataSource("testRestReturnForPackages"))
                .build();
        return restCalls;
    }

    public TestStepFlow runGenericRests() {
        TestStepFlow restCalls = flow("Perform various portal REST Calls for Product Sets, Media, Media Delivery and Obsolete Media")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS))
                .withDataSources(dataSource("genericRESTCommands"))
                .build();
        return restCalls;
    }

    public TestStepFlow runDropActivityRests() {
        TestStepFlow restCalls = flow("Perform various portal REST Calls to Open and Close a Drop and verify that deliveries are as expected")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_REST_CALLS_OPEN_CLOSE_DROP))
                .withDataSources(dataSource("openCloseDropRESTCommands"))
                .build();
        return restCalls;
    }

    public TestStepFlow dropPerformanceRestCalls() {
        TestStepFlow restCalls = flow("Perform Drop Performance REST Calls")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_DROP_PERFORMANCE_REST))
                .withDataSources(dataSource("dropLoadingPerformanceREST"))
                .build();
        return restCalls;
    }

    public TestStepFlow productPackagePerformanceRestCalls() {
        TestStepFlow restCalls = flow("Perform Page Performance REST Calls for product package/testware page")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_PAGE_PERFORMANCE_REST))
                .withDataSources(dataSource("productPackageLoadingPerformanceREST"))
                .build();
        return restCalls;
    }

    public TestStepFlow productTestwarePerformanceRestCalls() {
        TestStepFlow restCalls = flow("Perform Page Performance REST Calls for product testware page")
                .addTestStep(annotatedMethod(portalRESTTestSteps, PortalRESTTestSteps.RUN_PAGE_PERFORMANCE_REST))
                .withDataSources(dataSource("testwareLoadingPerformanceREST"))
                .build();
        return restCalls;
    }
}
