# cover-right-task
This repository contains the implementation of the coding task fiven during the hiring process for CoverRight.

## Building and Running the solution

The project was built using Java Version 17.

Solution can be built and ran using either:
  - a) Driver module, or
  - b) Spring boot command

The following commands can be ran in the root folder of the project:
  ``bash driver.sh prod	// running production environment``
  ``bash driver.sh stag	// running staging environment``
  ``./mvnw spring-boot:run -Dspring-boot.run.profiles=prod	// running production environment``
  ``./mvnw spring-boot:run -Dspring-boot.run.profiles=staging	// running staging environment``
