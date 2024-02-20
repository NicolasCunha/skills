package com.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * Class responsible for creating a Freemarker output from a String.
 */
public class FreemarkerOutputFromString {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApacheFreemarkerSandbox.class);

    /**
     * Create output.
     *
     * @param stringTemplate String containing the stringTemplate.
     * @param dataModel      Map object containing the data model which will be used to apply the data into the stringTemplate.
     * @return String containing an output.
     */
    public String createOutput(final String stringTemplate, final Map<String, Object> dataModel) throws IOException, TemplateException {
        LOGGER.debug("Creating output from template: {}", stringTemplate);
        Configuration configuration = ConfigurationUtils.getConfiguration();
        Template template = new Template("StringTemplateName", new StringReader(stringTemplate), configuration);
        StringWriter strWriter = new StringWriter();
        template.process(dataModel, strWriter);
        return strWriter.toString();
    }

}
