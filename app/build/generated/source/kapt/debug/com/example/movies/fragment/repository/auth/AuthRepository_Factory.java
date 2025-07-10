package com.example.movies.fragment.repository.auth;

import com.example.movies.api.ApiAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AuthRepository_Factory implements Factory<AuthRepository> {
  private final Provider<ApiAuth> apiAuthProvider;

  public AuthRepository_Factory(Provider<ApiAuth> apiAuthProvider) {
    this.apiAuthProvider = apiAuthProvider;
  }

  @Override
  public AuthRepository get() {
    return newInstance(apiAuthProvider.get());
  }

  public static AuthRepository_Factory create(Provider<ApiAuth> apiAuthProvider) {
    return new AuthRepository_Factory(apiAuthProvider);
  }

  public static AuthRepository newInstance(ApiAuth apiAuth) {
    return new AuthRepository(apiAuth);
  }
}
