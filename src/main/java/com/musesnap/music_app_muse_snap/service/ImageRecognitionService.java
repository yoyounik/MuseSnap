package com.musesnap.music_app_muse_snap.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ImageRecognitionService {
    private static final String API_URL = "https://api.imagga.com/v2/tags";
    private static final String API_KEY = "API_KEY"; // Replace with your API Key
    private static final String API_SECRET = "API_SECRET_KEY"; // Replace with your API Secret

    public String recognizeImage(String imageUrl) {
        try {
            // Construct the URL with the image URL as a query parameter
            String requestUrl = UriComponentsBuilder.fromHttpUrl(API_URL)
                                                    .queryParam("image_url", imageUrl)
                                                    .toUriString();

            // Encode API Key and Secret
            String credentials = API_KEY + ":" + API_SECRET;
            String basicAuth = Base64.getEncoder().encodeToString(credentials.getBytes());

            // Create HTTP Connection
            URL urlObject = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);

            // Get Response Code
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + responseCode);
            }

            // Read Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Return JSON Response as a String
            return response.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error recognizing image: " + e.getMessage());
        }
    }

}
