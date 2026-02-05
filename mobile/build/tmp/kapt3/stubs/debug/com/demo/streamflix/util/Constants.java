package com.demo.streamflix.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/demo/streamflix/util/Constants;", "", "()V", "BASE_URL", "", "CACHE_DURATION_LONG", "", "CACHE_DURATION_SHORT", "DATABASE_NAME", "DEBUG", "", "EXOPLAYER_USER_AGENT", "PREF_AUTH_TOKEN", "PREF_IS_LOGGED_IN", "PREF_MEMBERSHIP_EXPIRY", "PREF_REMEMBER_ME", "PREF_USER_EMAIL", "mobile_debug"})
public final class Constants {
    public static final boolean DEBUG = true;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://10.0.2.2:8080/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_IS_LOGGED_IN = "is_logged_in";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_AUTH_TOKEN = "auth_token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_MEMBERSHIP_EXPIRY = "membership_expiry";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_REMEMBER_ME = "remember_me";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "streamflix_db";
    public static final long CACHE_DURATION_SHORT = 300000L;
    public static final long CACHE_DURATION_LONG = 1800000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXOPLAYER_USER_AGENT = "StreamFlix-Android";
    @org.jetbrains.annotations.NotNull()
    public static final com.demo.streamflix.util.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}