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
public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
  private final Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider;

  public ProfileFragment_MembersInjector(
      Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider) {
    this.dataStoreManagerAuthProvider = dataStoreManagerAuthProvider;
  }

  public static MembersInjector<ProfileFragment> create(
      Provider<DataStoreManagerAuth> dataStoreManagerAuthProvider) {
    return new ProfileFragment_MembersInjector(dataStoreManagerAuthProvider);
  }

  @Override
  public void injectMembers(ProfileFragment instance) {
    injectDataStoreManagerAuth(instance, dataStoreManagerAuthProvider.get());
  }

  @InjectedFieldSignature("com.example.movies.fragment.ui.auth.ProfileFragment.dataStoreManagerAuth")
  public static void injectDataStoreManagerAuth(ProfileFragment instance,
      DataStoreManagerAuth dataStoreManagerAuth) {
    instance.dataStoreManagerAuth = dataStoreManagerAuth;
  }
}
