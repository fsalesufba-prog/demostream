package com.demo.streamflix.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.demo.streamflix.databinding.FragmentCategoryBinding;
import com.demo.streamflix.ui.adapters.ChannelAdapter;
import com.demo.streamflix.util.Extensions.showSnackbar;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H$J\b\u0010\u0013\u001a\u00020\u0014H$J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0004J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u001a\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0004J\b\u0010(\u001a\u00020\u0016H\u0004R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/demo/streamflix/ui/categories/CategoryBaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "error/NonExistentClass", "Lerror/NonExistentClass;", "binding", "getBinding", "()Lerror/NonExistentClass;", "channelAdapter", "Lcom/demo/streamflix/ui/adapters/ChannelAdapter;", "viewModel", "Lcom/demo/streamflix/ui/categories/CategoryViewModel;", "getViewModel", "()Lcom/demo/streamflix/ui/categories/CategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCategoryId", "", "getCategoryName", "", "loadChannels", "", "refresh", "", "navigateToChannelDetail", "channel", "Lcom/demo/streamflix/data/model/Channel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupObservers", "setupUI", "mobile_debug"})
public abstract class CategoryBaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private FragmentCategoryBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.demo.streamflix.ui.adapters.ChannelAdapter channelAdapter;
    
    public CategoryBaseFragment() {
        super();
    }
    
    protected abstract int getCategoryId();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.lang.String getCategoryName();
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.Object getBinding() {
        return null;
    }
    
    private final com.demo.streamflix.ui.categories.CategoryViewModel getViewModel() {
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
    
    protected final void setupUI() {
    }
    
    protected final void setupObservers() {
    }
    
    protected final void loadChannels(boolean refresh) {
    }
    
    protected final void navigateToChannelDetail(@org.jetbrains.annotations.NotNull()
    com.demo.streamflix.data.model.Channel channel) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}