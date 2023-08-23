package com.cxl.ddns;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class TestJson {

    public static void getJsonArray(JsonElement element, String property, List<JsonElement> elementList) {
        String proRemain;
        String firstProperty;
        if (property.contains(".")) {
            proRemain = property.substring(property.indexOf(".") + 1);
            firstProperty = property.substring(0, property.indexOf("."));
        } else {
            proRemain = property;
            firstProperty = property;
        }

        if (element.isJsonPrimitive()) {
            elementList.add(element);
            return;
        }
        JsonElement jsonElementTmp = element.getAsJsonObject().get(firstProperty);
        if (jsonElementTmp == null) {
            return;
        }

        if (jsonElementTmp.isJsonArray()) {
            for (JsonElement jsonElement : jsonElementTmp.getAsJsonArray()) {
                getJsonArray(jsonElement, proRemain, elementList);
            }
        } else {
            getJsonArray(jsonElementTmp, proRemain, elementList);
        }
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"name\": \"cxl\",\n" +
                "  \"array\": [\n" +
                "    {\n" +
                "      \"grander\": \"female\",\n" +
                "      \"age\": 12,\n" +
                "      \"array1\": [\n" +
                "        {\n" +
                "          \"region\": \"china\",\n" +
                "          \"type\": [\"c\",\"d\"]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"grander\": \"male\",\n" +
                "      \"age\": 15,\n" +
                "      \"array1\": [\n" +
                "        {\n" +
                "          \"region\": \"russia\",\n" +
                "          \"type\": [\"a\",\"b\"]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        List<JsonElement> jsonElements = new ArrayList<JsonElement>();
        getJsonArray(jsonElement, "name", jsonElements);
        System.out.println(jsonElements);
    }
}
