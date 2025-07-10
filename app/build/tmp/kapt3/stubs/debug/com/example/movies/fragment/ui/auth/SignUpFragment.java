package com.example.movies.fragment.ui.auth;

import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.movies.R;
import com.example.movies.databinding.FragmentSignUpBinding;
import com.example.movies.fragment.viewmodel.auth.AuthViewModel;
import com.google.android.material.textfield.TextInputLayout;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\u0013H\u0016J$\u0010$\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J \u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u0018\u00100\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0013H\u0002J\u0018\u00104\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00065"}, d2 = {"Lcom/example/movies/fragment/ui/auth/SignUpFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View$OnKeyListener;", "()V", "email", "", "fullName", "mBinding", "Lcom/example/movies/databinding/FragmentSignUpBinding;", "password", "viewModel", "Lcom/example/movies/fragment/viewmodel/auth/AuthViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/auth/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isValidDate", "", "date", "formatter", "Ljava/time/format/DateTimeFormatter;", "onClick", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "hasFocus", "onKey", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onViewCreated", "setInputError", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "input", "title", "setView", "validateDate", "validateEmail", "validateFullName", "validatePassWord", "validatePhoneNumber", "app_debug"})
public final class SignUpFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnKeyListener {
    private com.example.movies.databinding.FragmentSignUpBinding mBinding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fullName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SignUpFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.auth.AuthViewModel getViewModel() {
        return null;
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
    
    private final void setView() {
    }
    
    private final boolean setInputError(com.google.android.material.textfield.TextInputLayout inputLayout, java.lang.String input, java.lang.String title) {
        return false;
    }
    
    private final boolean validateFullName() {
        return false;
    }
    
    private final boolean validateEmail() {
        return false;
    }
    
    private final boolean validatePassWord() {
        return false;
    }
    
    private final boolean validatePhoneNumber(com.google.android.material.textfield.TextInputLayout inputLayout, java.lang.String input) {
        return false;
    }
    
    private final boolean validateDate(com.google.android.material.textfield.TextInputLayout inputLayout, java.lang.String input) {
        return false;
    }
    
    private final boolean isValidDate(java.lang.String date, java.time.format.DateTimeFormatter formatter) {
        return false;
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