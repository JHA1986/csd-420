@echo off
set PATH=C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot\bin;%PATH%
java --module-path "C:\Users\Jonah\.m2\repository\org\openjfx\javafx-base\17.0.2\javafx-base-17.0.2-win.jar;C:\Users\Jonah\.m2\repository\org\openjfx\javafx-graphics\17.0.2\javafx-graphics-17.0.2-win.jar;C:\Users\Jonah\.m2\repository\org\openjfx\javafx-controls\17.0.2\javafx-controls-17.0.2-win.jar" --add-modules javafx.controls,javafx.fxml --add-opens javafx.graphics/com.sun.javafx.application=ALL-UNNAMED -cp "C:\Users\Jonah\AppData\Local\Temp\vscodesws_177e8\jdt_ws\jdt.ls-java-project\bin" com.csd420.cardgame.CardGameApp
pause
