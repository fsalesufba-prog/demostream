package com.demo.streamflix.ui.main;

import androidx.lifecycle.ViewModel;
import com.demo.streamflix.data.repository.AuthRepository;
import com.demo.streamflix.util.SharedPrefs;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/demo/streamflix/data/repository/AuthRepository;", "sharedPrefs", "Lcom/demo/streamflix/util/SharedPrefs;", "(Lcom/demo/streamflix/data/repository/AuthRepository;Lcom/demo/streamflix/util/SharedPrefs;)V", "_validationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "validationState", "Lkotlinx/coroutines/flow/StateFlow;", "getValidationState", "()Lkotlinx/coroutines/flow/StateFlow;", "validateMembership", "", "ValidationState", "mobile_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SplashViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.demo.streamflix.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.demo.streamflix.util.SharedPrefs sharedPrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.demo.streamflix.ui.main.SplashViewModel.ValidationState> _validationState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.demo.streamflix.ui.main.SplashViewModel.ValidationState> validationState = null;
    
    @javax.inject.Inject()
    public SplashViewModel(@org.jetbrains.annotations.NotNull()
    com.demo.streamflix.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.demo.streamflix.util.SharedPrefs sharedPrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.demo.streamflix.ui.main.SplashViewModel.ValidationState> getValidationState() {
        return null;
    }
    
    public final void validateMembership() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "", "()V", "Expired", "Invalid", "Loading", "Valid", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Expired;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Invalid;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Loading;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Valid;", "mobile_debug"})
    public static abstract class ValidationState {
        
        private ValidationState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Expired;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "()V", "mobile_debug"})
        public static final class Expired extends com.demo.streamflix.ui.main.SplashViewModel.ValidationState {
            @org.jetbrains.annotations.NotNull()
            public static final com.demo.streamflix.ui.main.SplashViewModel.ValidationState.Expired INSTANCE = null;
            
            private Expired() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Invalid;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "()V", "mobile_debug"})
        public static final class Invalid extends com.demo.streamflix.ui.main.SplashViewModel.ValidationState {
            @org.jetbrains.annotations.NotNull()
            public static final com.demo.streamflix.ui.main.SplashViewModel.ValidationState.Invalid INSTANCE = null;
            
            private Invalid() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Loading;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "()V", "mobile_debug"})
        public static final class Loading extends com.demo.streamflix.ui.main.SplashViewModel.ValidationState {
            @org.jetbrains.annotations.NotNull()
            public static final com.demo.streamflix.ui.main.SplashViewModel.ValidationState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState$Valid;", "Lcom/demo/streamflix/ui/main/SplashViewModel$ValidationState;", "()V", "mobile_debug"})
        public static final class Valid extends com.demo.streamflix.ui.main.SplashViewModel.ValidationState {
            @org.jetbrains.annotations.NotNull()
            public static final com.demo.streamflix.ui.main.SplashViewModel.ValidationState.Valid INSTANCE = null;
            
            private Valid() {
            }
        }
    }
}