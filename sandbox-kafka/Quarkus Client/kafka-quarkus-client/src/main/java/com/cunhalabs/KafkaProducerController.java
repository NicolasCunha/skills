package com.cunhalabs;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.Map;

@Path("/api/quarkusProduce")
public class KafkaProducerController {

    @Inject
    @Channel("quarkus-topic-outgoing")
    private Emitter<String> emitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void produce(final Map<String, Object> body) {
        emitter.send(new Gson().toJson(body));
    }

}
