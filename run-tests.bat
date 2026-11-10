@echo off
chcp 65001 >nul
if not exist bin\Main.class (
    call build.bat
)
java -cp bin Main
pause
