package com.example;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class ConsumerClientContractTest {

	   @Rule
	    public PactProviderRule rule = new PactProviderRule("Foo_Provider", this);

	    @Pact(provider="Foo_Provider", consumer="Foo_Consumer")
	    public PactFragment createFragment(PactDslWithProvider builder) {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json;charset=UTF-8");

	        return builder.uponReceiving("a request for Foos")
	                .path("/foos")
	                .method("GET")

	                .willRespondWith()
	                .headers(headers)
	                .status(200)
	                .body("[{\"value\":42}, {\"value\":100}]").toFragment();
	    }

	    @Test
	    @PactVerification("Foo_Provider")
	    public void runTest() {
	        assertEquals(new ConsumerClient(rule.getConfig().url()).foos(), Arrays.asList(new Foo(42), new Foo(100)));
	    }
}
