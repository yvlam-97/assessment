# Project Structure

1. The domain is pure Java, with no dependencies on any frameworks or libraries.
2. The application is a Spring Boot application, wiring the domain to the infrastructure.
3. The infrastructure uses Spring JPA to connect to a H2 database. (in a production-like scenario, a formal solution like Postgres would be used)

# Gaps
## Personal approach
- Given the time constraints, I focused on implementing the project structure and domain logic.
- Phase 1 of the application is not fully functional.
- Unfortunately, phase 2 was not implemented at all.

## Overall project structure and code
- CI/CD: Github actions could have been used to run tests and build the application.
- CI/CD: Missing maven publication to a repository (e.g. Maven Central if this were open source).
- Logging: No centralized logging.
- Security: no authentication or authorization implemented.
- Code style: No code style enforcement.
- Dependency management: Could have used Gradle version catalog to more easily manage dependencies.
- Stability: No integration tests for the application.
- Containerization: Lack of a Dockerfile to run the application in a container.
- Documentation: No Swagger/OpenAPI or similar documentation for REST endpoints.
- SoC: The application could be better structured to separate concerns, the controller has too much logic.
