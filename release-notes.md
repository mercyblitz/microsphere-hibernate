# Release Notes

## v0.1.0

# Release Notes for Version 0.1.0

## New Features
- Added `EntityCallback` integrator for Hibernate (`6b73e36`, `33807be`).
- Introduced composite `EntityCallback` and listener integration (`33807be`).
- Added `CompositeInterceptor` for Hibernate and updated related code (`a5352fe`).

## Bug Fixes
- Fixed duplicate `onPostUpdateCollection` override (`e591b83`).

## Documentation
- Added compatibility matrix to `README` (`701b7e8`).
- Updated Codecov badge to reflect `dev-1.x` branch (`1dba066`).
- Enhanced release notes and naming conventions (`e81006a`).
- Removed 'ORM' from project name in `README` (`ea2cf57`).

## Dependency Updates
- Adapted code for older Hibernate versions to maintain compatibility (`6e4254c`).

## Test Improvements
- Added tests for `EntityCallback`, `CompositeInterceptor`, and sample entities (`bbcaf7e`, `1687cd3`, `6b73e36`).

## Build and Workflow Enhancements
- Configured Maven publishing credentials (`ce6735a`, `5abd59c`).
- Added Maven profiles for CI (`144f0ef`).
- Removed stray bracket in Maven workflow (`971305e`).
- Updated Maven wrapper setup (`5abd59c`).
- Improved CI workflows, including a Hibernate matrix (`6e4254c`, `144f0ef`).

## Other Changes
- Removed unused `CompositeInterceptor.java` (`e34a34b`).

---

Thank you for using version 0.1.0! Stay tuned for future updates.

**Full Changelog**: https://github.com/microsphere-projects/microsphere-hibernate/compare/...0.1.0## v0.1.1

# Release Notes - Version 0.1.1

## New Features
- Added Hibernate JUnit extension for testing.  
- Simplified static test setup using `javax.Entity`.  

## Documentation
- Updated README with branch names and version changes.  
- Added documentation for Hibernate JUnit extension.  

## Dependency Updates
- Upgraded `microsphere-spring-cloud` to version 0.1.12.  

## Build and Workflow Enhancements
- Merged `release-1.x` changes into `dev-1.x`.  
- Bumped version to next patch post 0.1.0 release.  

---

**Full Changelog**: https://github.com/microsphere-projects/microsphere-hibernate/compare/0.1.0...0.1.1