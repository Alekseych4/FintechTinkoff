package ru.hackathon.fintechtinkoff;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.hackathon.fintechtinkoff.retrofit.ArticleModel;
import ru.hackathon.fintechtinkoff.retrofit.NetworkService;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.test);

        newsRecyclerView = findViewById(R.id.news_list);
        NetworkService.getInstance()
                .getJSONApi()
                .getListNews()
                .enqueue(new Callback<ArticleModel>() {
                    @Override
                    public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                        ArticleModel articleModel = response.body();

                        textView.append(articleModel.getArticleName());
                        textView.append(articleModel.getCodeName());


                    }

                    @Override
                    public void onFailure(Call<ArticleModel> call, Throwable t) {
                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}
