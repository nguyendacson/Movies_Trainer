package com.example.movies.di;

import com.example.movies.api.ApiAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModuleAuth_ProvideApiAuthFactory implements Factory<ApiAuth> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModuleAuth_ProvideApiAuthFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiAuth get() {
    return provideApiAuth(retrofitProvider.get());
  }

  public static NetworkModuleAuth_ProvideApiAuthFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModuleAuth_ProvideApiAuthFactory(retrofitProvider);
  }

  public static ApiAuth provideApiAuth(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModuleAuth.INSTANCE.provideApiAuth(retrofit));
  }
}
