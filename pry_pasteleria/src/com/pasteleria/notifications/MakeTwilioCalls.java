package com.pasteleria.notifications;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;

public class MakeTwilioCalls {
	/* Twilio REST API version */
	public static final String APIVERSION = "2010-04-01";

	public static void main(String[] args) {
		/* Twilio AccountSid and AuthToken */
		String AccountSid = "AC35e1a3bc74abfe5b6a6355f48e8dfb6d";
		String AuthToken = "e348c78f82d7724ecc141f17debc29f1";
		/* Outgoing Caller ID previously validated with Twilio */
		String CallerID = "+5117094159";
		//String ToCall = "+51961948257";
		String ToCall = "+51954191116";
		String Url = "http://twimlets.com/message?Message%5B0%5D=Hello%20from%20my%20java%20application.&Message%5B1%5D=http%3A%2F%2Fcom.twilio.music.electronica.s3.amazonaws.com%2Fteru_-_110_Downtempo_Electronic_4.mp3";
		/* Instantiate a new Twilio Rest Client */
		TwilioRestClient client = new TwilioRestClient(AccountSid, AuthToken,
				null);
		// build map of post parameters
		Map params = new HashMap();
		params.put("From", CallerID);
		params.put("To", ToCall);
		params.put("Url", Url);
		TwilioRestResponse response;
		try {
			response = client.request(
					"/" + APIVERSION + "/Accounts/" + client.getAccountSid()
							+ "/Calls", "POST", params);
			if (response.isError())
				System.out.println("Error making outgoing call: "
						+ response.getHttpStatus() + "n"
						+ response.getResponseText());
			else {
				System.out.println(response.getResponseText());
			}
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
		
	}
}