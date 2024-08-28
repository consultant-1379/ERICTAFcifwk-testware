package com.ericsson.cifwk.teststeps;

import com.ericsson.cifwk.taf.TorTestCaseHelper;
import com.ericsson.cifwk.taf.annotations.*;
import com.ericsson.sut.test.operators.CIPortalUIOperator;

import javax.inject.Inject;
import javax.inject.Provider;

public class PortalUITestSteps extends TorTestCaseHelper {

    public static final String RUN_DROP_PERFORMANCE = "CIP-6341_Func_2";
    public static final String RUN_PACKAGE_PAGE_PERFORMANCE = "CIP-6341_Func_3";
    public static final String RUN_TESTWARE_PAGE_PERFORMANCE = "CIP-6341_Func_4";

    @Inject
    Provider<CIPortalUIOperator> provider;

    @TestStep(id = RUN_DROP_PERFORMANCE)
    @Context(context = { Context.UI })
    public void testDropPageLoad(@Input("id") String Id,
            @Input("description") String testCaseDescription,
            @Input("host") String host,
            @Input("directory") String directory,
            @Input("product") String product,
            @Input("dropName") String dropName,
            @Output("expected") String expected,
            @Input("timeoutInMillisOne") long firstTimeOut,
            @Input("timeoutInMillisTwo") long secondTimeOut) {
        setTestCase(Id, testCaseDescription);
        CIPortalUIOperator operator = provider.get();
        operator.startBrowser(host, directory, null);
        String result = operator.checkDropPageLoad(product, dropName,
                firstTimeOut, secondTimeOut);
        assert (result.contains(expected));
    }

    @TestStep(id = RUN_PACKAGE_PAGE_PERFORMANCE)
    @Context(context = { Context.UI })
    public void testProductPackagePageLoad(@Input("id") String Id,
            @Input("description") String testCaseDescription,
            @Input("host") String host,
            @Input("directory") String directory,
            @Input("product") String product,
            @Output("expected") String expected,
            @Input("timeoutInMillis") long timeOut) {
        setTestCase(Id, testCaseDescription);
        CIPortalUIOperator operator = provider.get();
        operator.startBrowser(host, directory, null);
        String result = operator.checkProductPackagePageLoad(product, timeOut);
        assertEquals(expected, result);
    }

    @TestStep(id = RUN_TESTWARE_PAGE_PERFORMANCE)
    @Context(context = { Context.UI })
    public void testTestwarePageLoad(@Input("id") String Id,
            @Input("description") String testCaseDescription,
            @Input("host") String host,
            @Input("directory") String directory,
            @Input("product") String product,
            @Output("expected") String expected,
            @Input("timeoutInMillis") long timeOut) {
        setTestCase(Id, testCaseDescription);
        CIPortalUIOperator operator = provider.get();
        operator.startBrowser(host, directory, null);
        String result = operator.checkTestwarePageLoad(product, timeOut);
        assertEquals(expected, result);
    }
}
