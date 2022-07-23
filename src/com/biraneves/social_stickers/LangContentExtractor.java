package com.biraneves.social_stickers;

import com.biraneves.service.json.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LangContentExtractor implements ContentExtractor {

    @Override
    public List<Content> extractContents(String json) {

        List<Map<String, String>> attributesList = JsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attribute : attributesList) {

            String title = attribute.get("title");
            String imageUrl = attribute.get("image");

            Content content = new Content(title, imageUrl);

            contents.add(content);

        }

        return contents;

    }
}
