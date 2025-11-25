#!/bin/bash
echo "==========================================="
echo "   Starting Spring Boot Application"
echo "==========================================="
echo ""
echo "📱 Application will be available at:"
echo "   👉 http://localhost:8080/ 👈"
echo ""
echo "🔗 Useful API Endpoints:"
echo "   • Create customer:              POST /customers?name=Anna&phone=123"
echo "   • Get customer ID by name:      GET  /customer-id?name=Anna"
echo "   • List all customers + vehicles GET  /customers"
echo "   • Create vehicle:               POST /vehicles?registrationNumber=ABC123..."
echo "   • List all vehicles:            GET  /vehicles"
echo "   • Vehicles by brand:            GET  /vehicles-by-brand?brand=Volvo"
echo ""
echo "Press Ctrl+C to stop the application"
echo "==========================================="
echo ""

chmod +x mvnw
./mvnw spring-boot:run
