package com.example.movies.fragment.ui.auth;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.movies.R;
import com.example.movies.databinding.FragmentLoginBinding;
import com.example.movies.datastore.DataStoreManagerAuth;
import com.example.movies.fragment.viewmodel.auth.AuthViewModel;
import com.google.android.material.textfield.TextInputLayout;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020!H\u0016J$\u0010\"\u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/example/movies/fragment/ui/auth/LoginFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View$OnKeyListener;", "()V", "dataStoreManagerAuth", "Lcom/example/movies/datastore/DataStoreManagerAuth;", "getDataStoreManagerAuth", "()Lcom/example/movies/datastore/DataStoreManagerAuth;", "setDataStoreManagerAuth", "(Lcom/example/movies/datastore/DataStoreManagerAuth;)V", "mBinding", "Lcom/example/movies/databinding/FragmentLoginBinding;", "viewModel", "Lcom/example/movies/fragment/viewmodel/auth/AuthViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/auth/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onClick", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "hasFocus", "", "onKey", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onViewCreated", "setInputError", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "input", "", "title", "app_debug"})
public final class LoginFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnKeyListener {
    private com.example.movies.databinding.FragmentLoginBinding mBinding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.example.movies.datastore.DataStoreManagerAuth dataStoreManagerAuth;
    
    public LoginFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.auth.AuthViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.movies.datastore.DataStoreManagerAuth getDataStoreManagerAuth() {
        return null;
    }
    
    public final void setDataStoreManagerAuth(@org.jetbrains.annotations.NotNull()
    com.example.movies.datastore.DataStoreManagerAuth p0) {
    }
    
    @java.lang.Override()
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
    
    private final void setInputError(com.google.android.material.textfield.TextInputLayout inputLayout, java.lang.String input, java.lang.String title) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onFocusChange(@org.jetbrains.annotations.Nullable()
    android.view.View view, boolean hasFocus) {
    }
    
    @java.lang.Override()
    public boolean onKey(@org.jetbrains.annotations.Nullable()
    android.view.View view, int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
}