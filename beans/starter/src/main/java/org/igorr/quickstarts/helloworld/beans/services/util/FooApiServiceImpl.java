package org.igorr.quickstarts.helloworld.beans.services.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("fooApiService")
@Qualifier("foo")
public class FooApiServiceImpl implements ApiService {
    private static final Logger LOG = LogManager.getLogger(FooApiServiceImpl.class);

    @Override
    public void call() {
        LOG.info("foo-foo-foo");
    }
}
