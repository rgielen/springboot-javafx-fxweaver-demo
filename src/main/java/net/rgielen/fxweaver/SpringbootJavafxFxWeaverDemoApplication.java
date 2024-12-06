package net.rgielen.fxweaver;

import com.sun.javafx.stage.StageHelper;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.controller.MainWindow;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootJavafxFxWeaverDemoApplication {

    public static void main(String[] args) {
        Platform.startup(() -> {
            SpringApplication.run(SpringbootJavafxFxWeaverDemoApplication.class, args);
        });
    }

    @Bean
    CommandLineRunner commandLineRunner(FxWeaver fxWeaver) {
        return args -> {
            Stage stage = new Stage();
            StageHelper.setPrimary(stage, true);
            Scene scene = new Scene(fxWeaver.loadView(MainWindow.class), 400, 300);
            stage.setScene(scene);
            stage.show();
        };
    }
}
