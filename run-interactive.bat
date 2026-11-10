@echo off
chcp 65001 >nul
if not exist bin\TerminalInterface.class (
    call build.bat
)
java -cp bin TerminalInterface
pause
