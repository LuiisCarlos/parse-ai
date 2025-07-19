# Parse AI

Parse AI is a collection of microservices built with Spring Cloud to make document parsing and analysis easy. It handles everything from configuration and service discovery to routing, document processing, and cloud storage. With built-in AI features, you can extract and analyze documents intelligently, while the modular setup keeps things scalable and reliable. Whether you’re storing files or running health checks, Parse AI helps you manage documents smoothly.

## Table of Contents

- [Parse AI](#parse-ai)
  - [Table of Contents](#table-of-contents)
  - [Architecture](#architecture)
  - [Prerequisites](#prerequisites)
  - [Environment Variables](#environment-variables)
  - [Building and Running](#building-and-running)
    - [Using Docker Compose](#using-docker-compose)
    - [Manual Build](#manual-build)
  - [Service Endpoints](#service-endpoints)
  - [Health Checks](#health-checks)
  - [Dependencies](#dependencies)
  - [Project Structure](#project-structure)
  - [Contributing](#contributing)
  - [License](#license)

## Architecture

The application consists of the following microservices:

- **Config Server** (Port: 8888): Centralized configuration management
- **Eureka Server** (Port: 8761): Service discovery and registration
- **Gateway Service** (Port: 8090): API Gateway for routing requests
- **Document Service** (Port: 8091): Handles document processing and management
- **Storage Service** (Port: 8092): Manages file storage using Cloudinary
- **AI Service** (Port: 9093): Provides AI-powered document analysis and processing

## Prerequisites

- Java 21
- Maven 3.9+
- Docker and Docker Compose
- PostgreSQL (runs in container)
- Cloudinary account

## Environment Variables

Create a `.env` file in the root directory with the following variables:

```env
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
CLOUDINARY_NAME=your_cloudinary_name
CLOUDINARY_API_KEY=your_cloudinary_key
CLOUDINARY_API_SECRET=your_cloudinary_secret
```

## Building and Running

### Using Docker Compose

Start all services:
```bash
make start
```

Stop all services:
```bash
make stop
```

Rebuild all services:
```bash
make build
```

Rebuild a specific service:
```bash
make rebuild SERVICE=service-name
```

### Manual Build

Each service can be built individually using Maven:

```bash
cd services/<service-name>
./mvnw clean package
```

## Service Endpoints

- Config Server: http://localhost:8888
- Eureka Server: http://localhost:8761
- API Gateway: http://localhost:8090
- Document Service: http://localhost:8091
- Storage Service: http://localhost:8092
- AI Service: http://localhost:9093

## Health Checks

Health endpoints are available at:
```
/actuator/health
```

## Dependencies

- Spring Boot 3.x
- Spring Cloud
- Spring Cloud Config
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- PostgreSQL
- Cloudinary

## Project Structure

```
.
├── infrastructure/             # Contains infrastructure-as-code, scripts, and config files
├── resources/                  # Documentation, diagrams, and other supporting resources
├── services/                   # Source code for each microservice
│   ├── config-server/          # Centralized configuration management service
│   ├── document-service/       # Handles document parsing and management
│   ├── eureka-server/          # Service registry for microservices discovery
│   ├── gateway-service/        # API gateway for routing and security
│   ├── storage-service/        # Manages file storage using Cloudinary
│   └── ai-service/             # Provides AI-powered document analysis and processing
├── .env                        # Environment variable definitions
├── Makefile                    # Automation commands for building and running services
└── docker-compose.yml          # Docker Compose configuration for orchestrating containers
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the [MIT License](./LICENSE.md) - see the LICENSE file for details

Developed by [LuiisCarlos](https://github.com/LuiisCarlos)
