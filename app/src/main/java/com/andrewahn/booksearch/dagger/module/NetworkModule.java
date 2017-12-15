package com.andrewahn.booksearch.dagger.module;

import android.app.Application;

import com.andrewahn.booksearch.api.BooksService;
import com.andrewahn.booksearch.models.books.BooksDataRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by andrewahn on 12/1/17.
 */

@Module
public class NetworkModule {
    String mBaseUrl = "https://www.googleapis.com/";

    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    BooksService provideBooksService(Retrofit retrofit) {
        return retrofit.create(BooksService.class);
    }

    @Provides
    BooksDataRepository provideBooksDataRepository(BooksService booksService) {
        return new BooksDataRepository(booksService);
    }
}
