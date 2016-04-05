package com.ch.conversion.transformations;

import static com.ch.helpers.TestHelper.CONVERTED_FORM_XML_PATH;
import static com.ch.helpers.TestHelper.FORM_XML_PATH;

import com.ch.conversion.config.ITransformConfig;
import com.ch.conversion.config.TestTransformationConfig;
import com.ch.helpers.TestHelper;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by elliott.jenkins on 04/04/2016.
 */
public class ManualElementsTransformTest {

  ITransformConfig config;

  @Before
  public void setUp() {
    config = new TestTransformationConfig();
  }

  @Test
  public void addManualElementsToXml() throws Exception {
    // xml
    String xml = TestHelper.getStringFromFile(CONVERTED_FORM_XML_PATH);

    // transform
    ManualElementsTransform transform = new ManualElementsTransform(config, xml);
    String output = transform.getXml();

    Assert.assertThat(output, CoreMatchers.containsString("<method>enablement</method>"));
  }

}