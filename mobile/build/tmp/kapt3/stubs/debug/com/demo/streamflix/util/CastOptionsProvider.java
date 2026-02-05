package com.demo.streamflix.util;

import android.content.Context;
import com.demo.streamflix.MainActivity;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/demo/streamflix/util/CastOptionsProvider;", "", "()V", "getAdditionalSessionProviders", "", "error/NonExistentClass", "context", "Landroid/content/Context;", "getCastOptions", "(Landroid/content/Context;)Lerror/NonExistentClass;", "mobile_debug"})
@kotlin.Suppress(names = {"unused"})
public final class CastOptionsProvider implements com.google.android.gms.cast.framework.OptionsProvider {
    
    public CastOptionsProvider() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public CastOptions getCastOptions(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.util.List<SessionProvider> getAdditionalSessionProviders(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}