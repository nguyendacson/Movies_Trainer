package com.example.movies.datastore;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataStoreModule_ProvideDataStoreManagerAuthFactory implements Factory<DataStoreManagerAuth> {
  private final Provider<Context> contextProvider;

  public DataStoreModule_ProvideDataStoreManagerAuthFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DataStoreManagerAuth get() {
    return provideDataStoreManagerAuth(contextProvider.get());
  }

  public static DataStoreModule_ProvideDataStoreManagerAuthFactory create(
      Provider<Context> contextProvider) {
    return new DataStoreModule_ProvideDataStoreManagerAuthFactory(contextProvider);
  }

  public static DataStoreManagerAuth provideDataStoreManagerAuth(Context context) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideDataStoreManagerAuth(context));
  }
}
