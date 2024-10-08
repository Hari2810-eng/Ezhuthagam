package com.hari.ezhuthagam.ui.home;

import com.hari.ezhuthagam.dto.User;
import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;

class HomeViewModel {
    private HomeView homeView;
    private EzhuthagamRepo repo;

    public HomeViewModel(HomeView homeView) {
        this.homeView = homeView;
        this.repo = EzhuthagamRepo.getInstance();
    }

    public User getCurrentUser() {
        return repo.getLoggedUser();
    }

    public void  logout() {
        System.out.println("Signing off...");
        repo.setLoggedUser(null);
        homeView.navigateToLoginOrSignUpScreen();

    }

}
