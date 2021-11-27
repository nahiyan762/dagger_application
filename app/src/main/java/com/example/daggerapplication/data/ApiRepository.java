package com.example.daggerapplication.data;

import javax.inject.Inject;

public class ApiRepository {
    ApiService apiService;

    @Inject
    public ApiRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public String getApiCall() {
        return this.toString();
    }
}
