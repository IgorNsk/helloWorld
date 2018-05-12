package org.igorr.quickstarts.helloworld.beans.services.messages;

import org.igorr.quickstarts.helloworld.beans.services.util.Api;

public interface MessageService {
    void show();
    String getMessage();
    void call(Api api);

}
