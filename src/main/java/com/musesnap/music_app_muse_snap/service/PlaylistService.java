//package com.musesnap.music_app_muse_snap.service;
//
//import okhttp3.OkHttpClient;
//import org.apache.catalina.connector.Request;
//import org.apache.catalina.connector.Response;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PlaylistService {
//    private static final String RAPIDAPI_KEY = "your-x-rapidapi-key"; // Replace with your key
//    private static final String RAPIDAPI_HOST = "deezerdevs-deezer.p.rapidapi.com";
//
//    public String getPlaylistById(String playlistId) throws Exception {
//        OkHttpClient client = new OkHttpClient();
//
//        String url = "https://deezerdevs-deezer.p.rapidapi.com/playlist/" + playlistId;
//
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .addHeader("x-rapidapi-key", RAPIDAPI_KEY)
//                .addHeader("x-rapidapi-host", RAPIDAPI_HOST)
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        if (response.isSuccessful()) {
//            return response.body().string(); // JSON response from the API
//        } else {
//            throw new Exception("Failed to fetch playlist: " + response.code() + " " + response.message());
//        }
//    }
//}
