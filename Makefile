# Makefile for managing Docker containers
# Usage: make <target>
# Targets:
#   start     - Start the containers
#   stop      - Stop the containers
#   down      - Down the containers
#   restart   - Restart the containers
#   build     - Rebuilds all the containers
#   rebuild   - Rebuilds a specific service container
#
#!/bin/bash

.PHONY: start stop down restart build build-common-lib rebuild

start:
	@$(MAKE) build-common-lib
	docker-compose -f docker-compose.yml up -d --build

stop:
	docker-compose stop

down:
	docker-compose -f docker-compose.yml down

restart:
	$(MAKE) stop
	$(MAKE) start

build:
	@$(MAKE) build-common-lib
	docker-compose build --no-cache

build-common-lib:
	wsl ./infrastructure/scripts/compile-common-lib.sh

rebuild:
	docker-compose build ${SERVICE}
	docker-compose up -d --no-deps ${SERVICE}
