package com.ch.conversion.builders;

import com.ch.conversion.config.ITransformConfig;
import com.ch.conversion.helpers.MultiPartHelper;
import com.ch.model.FormsPackage;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elliott.jenkins on 31/03/2016.
 */
public class JsonBuilder {

    private final ITransformConfig config;
    private final FormsPackage rawFormsPackage;

    /**
     * Convert FormDataMultiPart.
     *
     * @param config json and xml
     * @param parts  the form parts
     */
    public JsonBuilder(ITransformConfig config, FormDataMultiPart parts) {
        this.config = config;
        MultiPartHelper helper = MultiPartHelper.getInstance();
        this.rawFormsPackage = helper.getPackageFromMultiPart(config, parts);
    }

    /**
     * Builder to create the json object for multiple forms.
     *
     * @param config      json and xml
     * @param packageJson package data
     * @param formsJson   list of forms json (untransformed)
     */
    public JsonBuilder(ITransformConfig config, String packageJson, List<String> formsJson) {
        this.config = config;
        this.rawFormsPackage = new FormsPackage(packageJson, formsJson);
    }

    /**
     * Get the transformed forms package for multiple forms.
     *
     * @return forms package
     */
    public FormsPackage getTransformedPackage() {
        // 1. create list of transformed forms
        List<String> forms = new ArrayList<>();

        // 2. loop forms and transform
        for (String formJson : rawFormsPackage.getForms()) {
            FormJsonBuilder builder = new FormJsonBuilder(config, rawFormsPackage.getPackageMetaData(), formJson);
            JSONObject object = builder.getJson();
            forms.add(object.toString());
        }

        // 3. create transformed forms package
        String packageMetaData = rawFormsPackage.getPackageMetaData();
        return new FormsPackage(packageMetaData, forms);
    }
}
