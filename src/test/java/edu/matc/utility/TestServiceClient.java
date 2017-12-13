package edu.matc.utility;

import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.*;


public class TestServiceClient {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.edamam.com/search?q=lasagna&app_id=376db8c2&app_key=5ea3504c65672bb93decbf9669548e5b"
                            );
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}