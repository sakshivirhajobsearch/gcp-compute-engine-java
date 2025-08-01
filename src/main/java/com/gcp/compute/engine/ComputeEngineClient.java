package com.gcp.compute.engine;

import java.io.IOException;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;

public class ComputeEngineClient {

    public void listInstances(String projectId, String zone) throws IOException {
    	
        try (InstancesClient instancesClient = InstancesClient.create()) {
            for (Instance instance : instancesClient.list(projectId, zone).iterateAll()) {
                System.out.printf("Instance: %s%n", instance.getName());
            }
        } catch (NotFoundException e) {
            System.err.println("Error: GCP project or zone not found. Details: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
    	
        // ✅ REPLACE with your actual GCP project ID
        String projectId = "your-real-gcp-project-id";  // Example: "my-dev-project-123456"
        String zone = "us-central1-a"; // ✅ You can change this as needed

        ComputeEngineClient client = new ComputeEngineClient();
        client.listInstances(projectId, zone);
    }
}
