package org.indymon.client;

import org.indymon.common.definitions.PutDefinitionsRequest;
import org.indymon.common.model.CheckDefinition;
import org.indymon.common.model.PresenterAggregatorDefinition;
import org.indymon.common.model.PresenterCheckDefinition;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class DefinitionSender {

    private String host;

    public DefinitionSender(String host) {
        this.host = host;
    }

    public void deleteAll()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(host + "/definitions");
    }

    public void send(
            ArrayList<CheckDefinition> checks,
            ArrayList<PresenterAggregatorDefinition> presentersAggregators,
            ArrayList<PresenterCheckDefinition> presentersChecks
    ) {
        PutDefinitionsRequest definitionsRequest = new PutDefinitionsRequest();
        definitionsRequest.setChecks(checks);
        definitionsRequest.setPresentersAggregators(presentersAggregators);
        definitionsRequest.setPresentersChecks(presentersChecks);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(host + "/definitions", definitionsRequest, (Object) null);
    }

}
