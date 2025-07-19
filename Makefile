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

.PHONY: start stop down restart build rebuild

start:
	docker-compose -f docker-compose.yml up -d --build

stop:
	docker-compose stop

down:
	docker-compose -f docker-compose.yml down

restart:
	make stop && make start

build:
	docker-compose build --no-cache

rebuild:
	docker-compose build ${SERVICE}
	docker-compose up -d --no-deps ${SERVICE}
