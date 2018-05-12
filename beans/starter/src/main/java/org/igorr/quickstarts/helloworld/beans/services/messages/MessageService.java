package org.igorr.quickstarts.helloworld.beans.services.messages;

import org.igorr.quickstarts.helloworld.beans.services.util.ApiService;

public interface MessageService {
    void show();
    String getMessage();
    void call(ApiService api);

}
