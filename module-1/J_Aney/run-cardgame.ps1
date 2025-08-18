# Navigate to project directory
Set-Location "C:\Users\Jonah\csd\csd-420\module-1\J_Aney"

# Clean any existing compiled classes
if (Test-Path "com") { Remove-Item -Recurse -Force "com" }

# Compile the application
Write-Host "Compiling CardGameApp..." -ForegroundColor Green
$compileResult = & javac --module-path "C:\Users\Jonah\Downloads\openjfx-17.0.2_windows-x64_bin-sdk\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml -d . src\main\java\com\csd420\cardgame\CardGameApp.java 2>&1

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed!" -ForegroundColor Red
    Write-Host $compileResult
    exit 1
}

Write-Host "Compilation successful!" -ForegroundColor Green

# Check if class file was created
if (Test-Path "com\csd420\cardgame\CardGameApp.class") {
    Write-Host "Class file created successfully" -ForegroundColor Green
} else {
    Write-Host "Class file not found!" -ForegroundColor Red
    exit 1
}

# Run the application
Write-Host "Running CardGameApp..." -ForegroundColor Green
& java --module-path "C:\Users\Jonah\Downloads\openjfx-17.0.2_windows-x64_bin-sdk\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml -cp . com.csd420.cardgame.CardGameApp
