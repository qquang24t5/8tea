package com.github.qquang24t5._8tea.presentation;

public enum View {

    STARTUP("Startup"),
    LOGIN("Login"),
    CREATING_NEW_ACCOUNT("CreatingNewAccount");

    public String fxml;
    View(String fxml) {
        this.fxml = "presentation/views/" + fxml;
    }


}
