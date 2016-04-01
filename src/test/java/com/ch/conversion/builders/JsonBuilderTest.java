package com.ch.conversion.builders;

import com.ch.conversion.config.ITransformConfig;
import com.ch.conversion.config.TestTransformationConfig;
import com.ch.helpers.TestHelper;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elliott.jenkins on 31/03/2016.
 */
public class JsonBuilderTest {

  ITransformConfig config;

  @Before
  public void setUp() {
    config = new TestTransformationConfig();
  }

  @Test(expected = JSONException.class)
  public void throwsJSONExceptionWithInvalidJson() throws Exception {
    String path = "src/test/test_json/invalid.json";
    String invalid = TestHelper.getStringFromFile(path);
    List<String> invalid_forms = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      invalid_forms.add(invalid);
    }
    JsonBuilder builder = new JsonBuilder(config, invalid, invalid_forms);
    builder.getJson();
  }

  // TODO: is this the desired behaviour?
  @Test(expected = JSONException.class)
  public void throwsJSONExceptionWithValidJsonMissingRequiredData() throws Exception {
    String path = "src/test/test_json/valid.json";
    String valid = TestHelper.getStringFromFile(path);
    List<String> valid_json_forms = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      valid_json_forms.add(valid);
    }
    JsonBuilder builder = new JsonBuilder(config, valid, valid_json_forms);
    builder.getJson();
  }

  // TODO: what to assert?
  @Test
  public void createStringForValidJson() throws Exception {
    JsonBuilder builder = getValidJsonBuilder();
    String json = builder.getJson();
    Assert.assertNotNull(json);
  }

  private JsonBuilder getValidJsonBuilder() throws Exception {
    // valid package data
    String package_path = "src/test/resources/package.json";
    String package_string = TestHelper.getStringFromFile(package_path);
    // valid forms
    String form_path = "src/test/resources/form_all.json";
    String valid = TestHelper.getStringFromFile(form_path);
    List<String> valid_forms = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      valid_forms.add(valid);
    }
    // builder
    return new JsonBuilder(config, package_string, valid_forms);
  }
}
