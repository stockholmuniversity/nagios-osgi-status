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
                LOG.debug("It's a stream!")
                break
            case { it instanceof String}:
                LOG.debug("It's a string!")
                bodyString = body
                break
            case null:
                LOG.debug("It's null!")
                break
            default:
                LOG.error("Input object type ${body} not supported")
                break
        }

        return "YEAH YEAH YEAH\n"
    }

}
