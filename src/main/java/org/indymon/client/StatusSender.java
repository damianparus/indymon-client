package org.indymon.client;

import org.indymon.common.model.CheckStatus;
import org.indymon.common.statuses.PutStatusRequest;
import org.springframework.web.client.RestTemplate;

public class StatusSender {

    private String host;

    public StatusSender(String host) {
        this.host = host;
    }

    public void send(CheckStatus[] checksStatuses) {
        PutStatusRequest statusesRequest = new PutStatusRequest();
        statusesRequest.setChecksStatuses(checksStatuses);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(host + "/status", statusesRequest, (Object) null);
    }

}
