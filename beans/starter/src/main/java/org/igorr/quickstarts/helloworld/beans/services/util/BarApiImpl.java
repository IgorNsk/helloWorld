package org.igorr.quickstarts.helloworld.beans.services.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bar")
public class BarApiImpl implements Api {
    private static final Logger LOG = LogManager.getLogger(FooApiImpl.class);
    @Override
    public void call() {
        LOG.info("***************************");
    }
}
