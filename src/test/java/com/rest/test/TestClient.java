package com.rest.test;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestClient {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		signUpTest(service);
		signInTest(service);
		getAllAlbumsTest(service);
		getAllTracksTest(service);
		getAllUserFeedbackTest(service);
		getTrackByID(service);

	}

	private static void signUpTest(WebResource service) {
		JSONObject jsonuser = new JSONObject();
		try {
			jsonuser.put("userid", "777777");
			jsonuser.put("password", "test");
			

		} catch (Exception e) {
		}

		test(jsonuser, "user/signup", service);
	}

	private static void signInTest(WebResource service) {
		JSONObject jsonuser = new JSONObject();
		try {

			jsonuser.put("userid", "5");
			jsonuser.put("password", "5");

		} catch (Exception e) {
		}

		test(jsonuser, "user/signin", service);
	}


	private static void getAllTracksTest(WebResource service) {

		test("track/all", service);
	}
	
	private static void getAllAlbumsTest(WebResource service) {

		test("album/all", service);
	}
	
	
	private static void getAllUserFeedbackTest(WebResource service) {

		test("feedback/all/5", service);
	}
	
	private static void getTrackByID(WebResource service) {

		test("track/gettrack/1", service);
	}
	
	private static void test(String restPath, WebResource service) {
		System.out.println(service.path("rest").path(restPath)
				.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
				.get(String.class));
	}

	
	private static void test(JSONObject jsonObject, String restPath,
			WebResource service) {
		try {
			String result = service.path("rest").path(restPath)
					.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
					.post(ClientResponse.class, jsonObject)
					.getEntity(String.class);
			System.out.println(result);
		} catch (com.sun.jersey.api.client.UniformInterfaceException e) {

		}
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/euphony").build();
	}

}