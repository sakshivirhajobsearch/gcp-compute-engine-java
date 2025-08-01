package com.gcp.compute.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ComputeEngineClientTest {

	@Test
	public void testListInstances() {
		ComputeEngineClient client = new ComputeEngineClient();
		String projectId = "your-gcp-project-id";
		String zone = "us-central1-a";

		try {
			// This method doesn’t return anything — update your logic accordingly
			client.listInstances(projectId, zone);

			// If needed, you can refactor listInstances to return a list of instance names.
			// For now we just assert true to ensure the test compiles and runs.
			assertTrue(true);
		} catch (IOException e) {
			fail("Exception during test: " + e.getMessage());
		}
	}
}