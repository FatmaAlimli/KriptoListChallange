package com.example.sample.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.bilgi_URL);
        return restApiClient.getRestApi();
    }
}