package com.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

public class AWSDAO {

	static AmazonDynamoDBClient client;

	static String productCatalogTableName = "ProductCatalog";

	public static void main(String[] args) throws Exception {
		//getClient();
		try {

			getItemsByQuery("Book");

			List<String> attrList = new ArrayList<String>();
			attrList.add("ID");
			attrList.add("ISBN");
			attrList.add("Title");
			attrList.add("Authors");
			// Get an item.
			getItem(101,"Book", attrList);
		} catch (AmazonServiceException ase) {
			ase.printStackTrace();
		}
	}

	public static AmazonDynamoDBClient getClient() throws Exception {
		
		if(client== null){
			AWSCredentials credentials = new PropertiesCredentials(
					AWSDAO.class.getResourceAsStream("AwsCredentials.properties"));
	
			client = new AmazonDynamoDBClient(credentials);
		}else{
			return client;
		}
		return client;
	}

	public static QueryResult getItemsByQuery(String category) {
		// category eg: Book, Bike, truck etc
		QueryResult result = null;
		try {
			getClient();
		
		Condition hashKeyCondition = new Condition().withComparisonOperator(
				ComparisonOperator.EQ).withAttributeValueList(
				new AttributeValue().withS(category));

		Map<String, Condition> keyConditions = new HashMap<String, Condition>();
		keyConditions.put("productCategory", hashKeyCondition);

		QueryRequest queryRequest = new QueryRequest().withTableName(
				"ProductCatalog").withKeyConditions(keyConditions);

		 result = client.query(queryRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {
			printItem(item);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static GetItemResult getItem(Integer id,String category,
			List<String> attrList) {
		GetItemResult result = null;
		try {
			getClient();
		
		Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
		key.put("productCategory", new AttributeValue().withS(category));
		key.put("ID", new AttributeValue().withN(id.toString()));
		GetItemRequest getItemRequest = new GetItemRequest()
				.withTableName("ProductCatalog").withKey(key)
				.withAttributesToGet(attrList);

		result = client.getItem(getItemRequest);

		// Check the response.
		/*System.out.println("Printing item after retrieving it....");
		printItem(result.getItem());*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static void printItem(Map<String, AttributeValue> attributeList) {
		for (Map.Entry<String, AttributeValue> item : attributeList.entrySet()) {
			String attributeName = item.getKey();
			AttributeValue value = item.getValue();
			System.out.println(attributeName
					+ " "
					+ (value.getS() == null ? "" : ":" + value.getS())
					+ (value.getN() == null ? "" : ":" + value.getN())
					+ (value.getB() == null ? "" : ":" + value.getB())
					+ (value.getSS() == null ? "" : ":" + value.getSS()
							
					+ (value.getNS() == null ? "" : ":" + value.getNS())
					+ (value.getBS() == null ? "" : ":" + value.getBS()
							+ "\n")));
		}
	}
}
