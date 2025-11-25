@echo off
echo ===========================================
echo   Starting Spring Boot Application
echo ===========================================
echo.
echo Application will be available at:
echo   http://localhost:8080/
echo.
echo Useful endpoints:
echo   POST /customers?name=Anna&phone=123
echo   GET  /customer-id?name=Anna
echo   GET  /customers
echo   POST /vehicles?registrationNumber=ABC123...
echo   GET  /vehicles
echo   GET  /vehicles-by-brand?brand=Volvo
echo.
echo Press Ctrl+C to stop the application
echo ===========================================
echo.

cd /d "%~dp0"

call mvnw spring-boot:run

pause
