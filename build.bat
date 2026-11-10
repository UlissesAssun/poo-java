@echo off
chcp 65001 >nul
echo ==================================================
echo   Building POO Java Project (src/ -^> bin/)
echo ==================================================
if not exist bin mkdir bin
javac -encoding UTF-8 -d bin src/*.java
if %ERRORLEVEL% EQU 0 (
    echo [SUCCESS] Build completed successfully!
) else (
    echo [ERROR] Build failed.
)
