package com.mocu.mocu_gbv.one_time_registration;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mocu.mocu_gbv.Apis_Connections;
import com.mocu.mocu_gbv.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LetsGetStartedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LetsGetStartedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText Registration_Phone_number;
    private Button Registration_submition;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LetsGetStartedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LetsGetStartedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LetsGetStartedFragment newInstance(String param1, String param2) {
        LetsGetStartedFragment fragment = new LetsGetStartedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lets_get_started, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Registration_Phone_number = view.findViewById(R.id.user_phone_number);
        Registration_submition = view.findViewById(R.id.let_get_started_btn);

        Registration_submition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = Registration_Phone_number.getText().toString().trim();

                if (!phoneNumber.isEmpty()) {
                    if (Patterns.PHONE.matcher(phoneNumber).matches()) {
                        //Toast.makeText(getContext(), "Okay", Toast.LENGTH_SHORT).show();

                        //connection to remote server
                        Retrofit Apis_connection = new Retrofit.Builder()
                                .baseUrl("https://mocu-gbv.000webhostapp.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        Apis_Connections apis_connections = Apis_connection.create(Apis_Connections.class);

                        Call<ResponseBody> call = apis_connections.set_phone_number_validation("07562411932");

                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if(response.isSuccessful()){
                                    try {
                                        String responseBodyString = response.body().string();
                                        JSONObject jsonObject = new JSONObject(responseBodyString);

                                        int status = jsonObject.getInt("status"); // Assuming the status is an integer
                                        String message = jsonObject.getString("message");

                                        Toast.makeText(getContext(), "Status: " + status + ", Message: " + message, Toast.LENGTH_SHORT).show();

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Toast.makeText(getContext(), "Connection failed", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {

                            }
                        });

                    } else {
                        Registration_Phone_number.setError("Provide a valid phone number");
                    }
                } else {
                    Registration_Phone_number.setError("This field should not be empty");
                }
            }
        });

    }
}