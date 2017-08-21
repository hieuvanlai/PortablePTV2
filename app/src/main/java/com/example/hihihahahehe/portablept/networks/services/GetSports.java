package com.example.hihihahahehe.portablept.networks.services;

import com.example.hihihahahehe.portablept.models.JSONModel.SportsJSONModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by valky on 8/21/2017.
 */

public interface GetSports {
    @GET("get-sports")
    Call<List<SportsJSONModel>> getSports ();
}
