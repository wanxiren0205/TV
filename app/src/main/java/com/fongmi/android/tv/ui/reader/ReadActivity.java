package com.fongmi.tv.ui.reader;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.fongmi.tv.R;
import com.fongmi.tv.bean.NovelContent;
import com.fongmi.tv.impl.Api;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadActivity extends AppCompatActivity {
    private TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        loadContent();
    }

    private void loadContent() {
        JsonObject param = new JsonObject();
        param.addProperty("id", getIntent().getStringExtra("id"));
        param.addProperty("chapterId", getIntent().getStringExtra("chapterId"));
        param.addProperty("type", "novel");

        Api.service().play(param).enqueue(new Callback<JsonObject>() {
            @Override public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    NovelContent data = new Gson().fromJson(response.body(), NovelContent.class);
                    title.setText(data.getTitle());
                    content.setText(data.getContent());
                } catch (Exception ignored) {}
            }
            @Override public void onFailure(Call<JsonObject> call, Throwable t) {}
        });
    }
}
