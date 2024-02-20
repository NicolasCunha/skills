package com.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Class responsible for creating a Freemarker output from a File.
 */
public class FreemarkerOutputFromFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApacheFreemarkerSandbox.class);

    /**
     * Create output.
     *
     * @param templateFile String containing the template file directory.
     * @param dataModel    Map object containing the data model which will be used to apply the data into the templateFile.
     * @return String containing an output.
     */
    public String createOutput(final String templateFile, final Map<String, Object> dataModel) throws IOException, TemplateException {
        LOGGER.debug("Creating output from template: {}", templateFile);
        Configuration configuration = ConfigurationUtils.getConfiguration();
        Template template = configuration.getTemplate(templateFile);
        StringWriter strWriter = new StringWriter();
        template.process(dataModel, strWriter);
        return strWriter.toString();
    }

}
