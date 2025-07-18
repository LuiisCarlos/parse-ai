# Makefile for managing Docker containers
# Usage: make <target>
# Targets:
#   start     - Start the containers
#   stop      - Stop the containers
#   down      - Down the containers
#   restart   - Restart the containers
#   build     - Rebuilds all the containers
#
#!/bin/bash

.PHONY: start stop down restart build

start:
	docker-compose up -d --build

stop:
	docker-compose stop

down:
	docker-compose -f docker-compose.yml down

restart:
	make stop && make start

build:
	docker-compose build
