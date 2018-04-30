package org.igorr.quickstarts.helloworld.web.restful;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class SingletonsProps {

    private static final String DATE_FORMAT_STRING = "dd.MM.yyyy";

    private SingletonsProps() {
        throw new IllegalStateException("Utility class");
    }


    public static final Set<Object> getProps() {
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
