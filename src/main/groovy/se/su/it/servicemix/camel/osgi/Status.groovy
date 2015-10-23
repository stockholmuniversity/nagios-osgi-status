package se.su.it.servicemix.camel.osgi

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.apache.camel.converter.stream.InputStreamCache

public class Status {
    private static final transient Logger LOG = LoggerFactory.getLogger(this)

    public Object status(Object body) {
        String bodyString = null

        switch (body) {
            case { it instanceof InputStreamCache }:
                InputStreamCache inputStreamCache = (InputStreamCache)body
                bodyString = inputStreamCache.text
                break
            case { it instanceof String}:
                bodyString = body
            default:
                LOG.error("Input object type ${body} not supported")
                break
        }

        return "OK"
    }

}
