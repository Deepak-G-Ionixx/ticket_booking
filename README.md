# Event Ticket Booking — corrected starter project

## Fixes applied
- Set the JVM default timezone to `Asia/Kolkata` before Spring Boot starts. This addresses the reported PostgreSQL connection error where the driver sent `Asia/Calcutta`.
- Kept the PostgreSQL JDBC URL on host port `5433`, matching the Compose mapping `5433:5432`.
- Added an explicit Liquibase changelog because Liquibase was enabled but the project had no changelog file.
- Added a PostgreSQL health check to Docker Compose.
- Set Hibernate's JDBC timezone explicitly to `Asia/Kolkata`.

## Requirements
- JDK 21
- Docker Desktop with Docker Compose

## Run on Windows
Open a terminal in this folder (`eventTicketBooking`).

1. Start PostgreSQL:
   ```powershell
   docker compose up -d
   docker compose ps
   ```
2. Start the application:
   ```powershell
   .\gradlew.bat bootRun
   ```
3. Check health in a browser:
   `http://localhost:8080/actuator/health`

## Notes
- This is a starter project with no JPA entities yet, so the initial Liquibase change set is intentionally a no-op. Add real table changesets as the application schema is developed.
- The configured local database credentials are `postgres` / `welcome`. Change them if your local environment uses different credentials.
- The Compose file keeps the original named volume mount path to reduce the risk of disrupting existing local database data.
