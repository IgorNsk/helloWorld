package org.igorr.quickstarts.helloworld.beans.generics;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MessageManagerImpl implements MessageManager {
    private static final Logger LOG = LogManager.getLogger(MessageManagerImpl.class);

    @Override
    public <M> M get(Transaction<M> var) {
        LOG.debug(var.toString());
        return var.begin();
    }

    @Override
    public <M> M get(M var){
        return var;
    }

}
