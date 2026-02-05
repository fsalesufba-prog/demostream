package com.demo.streamflix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.demo.streamflix.databinding.ActivitySplashBinding;
import com.demo.streamflix.util.SharedPrefs;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/demo/streamflix/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "error/NonExistentClass", "Lerror/NonExistentClass;", "navController", "Landroidx/navigation/NavController;", "sharedPrefs", "Lcom/demo/streamflix/util/SharedPrefs;", "getSharedPrefs", "()Lcom/demo/streamflix/util/SharedPrefs;", "setSharedPrefs", "(Lcom/demo/streamflix/util/SharedPrefs;)V", "checkMembershipStatus", "", "token", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupNavigation", "validateMembership", "mobile_debug"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject()
    public com.demo.streamflix.util.SharedPrefs sharedPrefs;
    private ActivitySplashBinding binding;
    private androidx.navigation.NavController navController;
    
    public SplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.demo.streamflix.util.SharedPrefs getSharedPrefs() {
        return null;
    }
    
    public final void setSharedPrefs(@org.jetbrains.annotations.NotNull()
    com.demo.streamflix.util.SharedPrefs p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupNavigation() {
    }
    
    private final void validateMembership() {
    }
    
    private final void checkMembershipStatus(java.lang.String token) {
    }
}