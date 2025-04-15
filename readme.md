# Homematic IP Connect API (Java Implementation)

This repository contains the **Java implementation** of the **Homematic IP Connect API**, a library designed to enable seamless integration of plugins with the Homematic IP system. It provides Java-based models, utilities, and message structures for communication with the Homematic IP Home Control Unit (HCU).

## Documentation

The documentation for the Homematic IP Connect API is available at [https://github.com/homematicip/connect-api](https://github.com/homematicip/connect-api).

## Key Features

- **Java-Based API**: Implements the Homematic IP Connect API in Java for plugin integration.
- **Message Models**: Predefined Java classes for system requests, responses, and events.
- **Serialization**: JSON serialization/deserialization using Jackson.
- **Annotations**: Custom Java annotations for documenting headers, fields, and message types.

## Project Structure

- **Main Code**: Located in `src/main/java/de/eq3/plugin/`, organized into domains such as `device`, `control`, `user`, and `system`.

## Requirements

- **Java Version**: 11 or higher
- **Dependencies**:
  - Jackson Databind
  - Lombok
  - JUnit 5 (for testing)
  - [Homematic IP Connect API Documentation Model](https://github.com/homematicip/connect-api-documentation-model)


### Build Steps:
1. Ensure you have Java 11+ and Maven installed.
2. Run the following command to build the project:
   ```bash
   mvn clean install
   ```

## License

This project is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).

## Maintainer

Developed and maintained by **eQ-3 AG**.\
Homematic IP is a trademark of **eQ-3 AG**.