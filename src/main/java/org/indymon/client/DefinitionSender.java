package org.indymon.client;

import org.indymon.common.definitions.PutDefinitionsRequest;
import org.indymon.common.model.CheckDefinition;
import org.indymon.common.model.PresenterAggregatorDefinition;
import org.indymon.common.model.PresenterCheckDefinition;
import org.springframework.web.client.RestTemplate;

public class DefinitionSender {

    private String host;

    public DefinitionSender(String host) {
        this.host = host;
    }

    public void send(
            CheckDefinition[] checks,
            PresenterAggregatorDefinition[] presentersAggregators,
            PresenterCheckDefinition[] presentersChecks
    ) {
        PutDefinitionsRequest definitionsRequest = new PutDefinitionsRequest();
        definitionsRequest.setChecks(checks);
        definitionsRequest.setPresentersAggregators(presentersAggregators);
        definitionsRequest.setPresentersChecks(presentersChecks);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(host + "/definitionsRequest", definitionsRequest, (Object) null);
    }

}
