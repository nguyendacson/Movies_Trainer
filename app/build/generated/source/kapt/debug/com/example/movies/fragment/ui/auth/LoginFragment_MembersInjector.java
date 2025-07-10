package com.example.movies.fragment.ui.auth;

import com.example.movies.datastore.DataStoreManagerAuth;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider;

  public LoginFragment_MembersInjector(
      Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider) {
    this.dataStoreManagerAuthProvider = dataStoreManagerAuthProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider) {
    return new LoginFragment_MembersInjector(dataStoreManagerAuthProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    injectDataStoreManagerAuth(instance, dataStoreManagerAuthProvider.get());
  }

  @InjectedFieldSignature("com.example.movies.fragment.ui.auth.LoginFragment.dataStoreManagerAuth")
  public static void injectDataStoreManagerAuth(LoginFragment instance,
      DataStoreManagerAuth dataStoreManagerAuth) {
    instance.dataStoreManagerAuth = dataStoreManagerAuth;
  }
}
