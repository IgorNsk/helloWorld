package org.igorr.quickstarts.helloworld.web.restful.test;

import com.google.common.collect.Sets;
import org.igorr.quickstarts.helloworld.web.restful.SingletonsProps;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.CacheControl;
import java.util.Set;


@ApplicationPath("restful/test")
public class TestInfoApplication extends Application {

    public static final CacheControl NO_CACHE;

    static {
        NO_CACHE = new CacheControl();
        NO_CACHE.setMaxAge(-1);
        NO_CACHE.setNoCache(true);
        NO_CACHE.setNoStore(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        //noinspection RedundantTypeArguments
        return Sets.<Class<?>>newHashSet(
                TestService.class



                // ...
                //JacksonConfigurator.class
        );
    }

    @Override
    public Set<Object> getSingletons() {
        return SingletonsProps.getProps();
    }
}
