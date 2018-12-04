package com.telenor.demo;


import org.junit.Test;

import java.util.logging.Logger;

/**
 * Unit test for simple SubscriptionHandler.
 */
public class SubscriptionHandlerTest {

    private static final Logger logger = Logger.getLogger(SubscriptionHandlerTest.class.getName());

    @Test
    public void listIncidents(){
        logger.info("Starting test");
        //demo class
        SubscriptionHandler subscriptionHandler = new SubscriptionHandler();

        //get the access token
        logger.info("Get the access token");
        AccessToken accessToken = subscriptionHandler.getAccessToken();
        assert (accessToken!=null);
        assert (accessToken.getAccess_token()!=null);

        //for demonstrational purposes only check if token is still valid (it probably will be).
        //If not, just get a new one. (refresh token is not yet supported)
        if(accessToken.hasExpired() ){
            //it has expired, so just replace it.
            accessToken = subscriptionHandler.getAccessToken();
        }
        //get some subscription info
        logger.info("Give us the info");
        String list = subscriptionHandler.getAccountList(accessToken);
        assert (list!=null);
        assert(!list.isEmpty());

        logger.info("Change a user reference");
        String result = subscriptionHandler.changeUserReference(accessToken);
        assert (result!=null);
    }


}

