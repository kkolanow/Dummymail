package org.dummymailer.rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by kkolanowski on 2015-07-18.
 */
@Path("server")
public class ServerResource  {

    @GET
    public Integer getById(@PathParam("id") Integer id) {
        return 1;
    }
}
