package org.igorr.quickstarts.helloworld.web.restful;

import com.google.common.collect.Sets;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.CacheControl;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("restful/")
public class RestInfoApplication extends Application {

    public static final CacheControl NO_CACHE;
    private static final String DATE_FORMAT_STRING = "dd.MM.yyyy";

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
                // ...
                //JacksonConfigurator.class
        );
    }

    @Override
    public Set<Object> getSingletons() {

        Set<Object> s = new HashSet<>();

        // Register the Jackson provider for JSON

        // Make (de)serializer use a subset of JAXB and (afterwards) Jackson annotations
        // See http://wiki.fasterxml.com/JacksonJAXBAnnotations for more information
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT_STRING));
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        // Set up the provider
        JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
        jaxbProvider.setMapper(mapper);

        s.add(jaxbProvider);

        return s;
    }
}
