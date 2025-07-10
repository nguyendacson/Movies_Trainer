package com.example.movies.fragment.ui.auth;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.example.movies.R;
import com.example.movies.adapter.authen.AdapterProfile;
import com.example.movies.database.authen.ProfileData;
import com.example.movies.databinding.FragmentProfileBinding;
import com.example.movies.datastore.DataStoreManagerAuth;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/movies/fragment/ui/auth/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/movies/databinding/FragmentProfileBinding;", "dataStoreManagerAuth", "Lcom/example/movies/datastore/DataStoreManagerAuth;", "getDataStoreManagerAuth", "()Lcom/example/movies/datastore/DataStoreManagerAuth;", "setDataStoreManagerAuth", "(Lcom/example/movies/datastore/DataStoreManagerAuth;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    private com.example.movies.databinding.FragmentProfileBinding binding;
    @javax.inject.Inject()
    public com.example.movies.datastore.DataStoreManagerAuth dataStoreManagerAuth;
    
    public ProfileFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.movies.datastore.DataStoreManagerAuth getDataStoreManagerAuth() {
        return null;
    }
    
    public final void setDataStoreManagerAuth(@org.jetbrains.annotations.NotNull()
    com.example.movies.datastore.DataStoreManagerAuth p0) {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"CutPasteId", "MissingInflatedId"})
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}