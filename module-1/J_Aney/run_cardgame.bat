@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.8.9-hotspot
set JAVAFX_PATH=C:\Users\Jonah\.m2\repository\org\openjfx
set PROJECT_BIN=C:\Users\Jonah\AppData\Local\Temp\vscodesws_177e8\jdt_ws\jdt.ls-java-project\bin

"%JAVA_HOME%\bin\java.exe" ^
  --module-path "%JAVAFX_PATH%\javafx-base\17.0.2;%JAVAFX_PATH%\javafx-controls\17.0.2;%JAVAFX_PATH%\javafx-graphics\17.0.2;%JAVAFX_PATH%\javafx-fxml\17.0.2" ^
  --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base ^
  --add-opens javafx.graphics/com.sun.javafx.tk=ALL-UNNAMED ^
  --add-opens javafx.graphics/com.sun.javafx.util=ALL-UNNAMED ^
  --add-opens javafx.base/com.sun.javafx.reflect=ALL-UNNAMED ^
  --add-opens javafx.base/com.sun.javafx.beans=ALL-UNNAMED ^
  --add-opens javafx.graphics/com.sun.javafx.stage=ALL-UNNAMED ^
  --add-opens javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED ^
  --add-opens javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED ^
  -cp "%PROJECT_BIN%" ^
  com.csd420.cardgame.CardGameApp
