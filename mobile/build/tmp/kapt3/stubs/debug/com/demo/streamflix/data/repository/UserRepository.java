package com.demo.streamflix.data.repository;

import com.demo.streamflix.model.entity.UserEntity;
import io.github.jan_tennert.supabase.SupabaseClient;
import io.github.jan_tennert.supabase.postgrest.from;
import io.github.jan_tennert.supabase.postgrest.query.Columns;
import io.github.jan_tennert.supabase.postgrest.query.Count;
import io.github.jan_tennert.supabase.postgrest.query.Order;
import io.github.jan_tennert.supabase.postgrest.request.FilterOperation;
import io.github.jan_tennert.supabase.postgrest.request.FilterOperator;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/streamflix/data/repository/UserRepository;", "", "supabaseClient", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "getUserById", "Lcom/demo/streamflix/model/entity/UserEntity;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobile_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull()
    private final SupabaseClient supabaseClient = null;
    
    public UserRepository(@org.jetbrains.annotations.NotNull()
    SupabaseClient supabaseClient) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.demo.streamflix.model.entity.UserEntity> $completion) {
        return null;
    }
}