package com.example.seamless;

import java.util.List;

public interface IResponse {

    void onSuccess(List<Meniuri> restaurante);
    void onError(String mesaj);
}
