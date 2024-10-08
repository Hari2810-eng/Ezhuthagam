package com.hari.ezhuthagam.ui.recent;

import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.ui.home.HomeView;

public class RecentsView extends BaseView {
    private RecentsViewModel viewModel;

    public RecentsView() {
        viewModel = new RecentsViewModel(this);
    }

    public void onCreate() {
            System.out.println("Viewing recent documents...");

            viewModel.viewRecentDocuments();
        
    }

    private void navigateToHome() {
        HomeView homeView = new HomeView();
        homeView.onCreate();
    }
}
