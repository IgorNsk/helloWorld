package org.igorr.quickstarts.helloworld.beans.services.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("barApiService")
@Qualifier("bar")
public class BarApiServiceImpl implements ApiService {
    private static final Logger LOG = LogManager.getLogger(BarApiServiceImpl.class);
    @Override
    public void call() {
        LOG.info("bar-bar-bar-bar");
    }
}
