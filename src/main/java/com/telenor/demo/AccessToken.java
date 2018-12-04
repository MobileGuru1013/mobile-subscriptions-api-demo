package com.telenor.demo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.logging.Logger;

@XmlRootElement
public class AccessToken {

    private static final Logger logger = Logger.getLogger(AccessToken.class.getName());

    private int expires_in;
    private String access_token;

    private long created;

    public AccessToken() {
        //empty bean constructor
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {

        this.access_token = access_token;
        this.created = System.currentTimeMillis();
    }

    public boolean hasExpired(){
        if(expires_in<=(System.currentTimeMillis()-created) ) {

            logger.info("Access token has expired");
            return true;
        }else {
            logger.info("Access token is still valid");
            return false;
        }
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "expires_in=" + expires_in +
                ", access_token='" + access_token + '\'' +
                '}';
    }

}