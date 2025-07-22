# Makefile for managing Docker containers
# Usage: make <target>
# Targets:
#   start               - Start the containers (runs fix-scripts and build-common-lib before starting and create-topics after)
#   stop                - Stop the containers
#   down                - Remove containers, networks, volumes defined in docker-compose.yml
#   restart             - Restart the containers
#   build               - Rebuilds all the containers (runs build-common-lib first)
#   build-common-lib    - Compiles the shared library used by services
#   rebuild             - Rebuilds a specific service container (use SERVICE=<service_name>)
#   fix-scripts         - Converts scripts to Unix format and makes them executable
#  	create-topics       - Creates Kafka topics using a script inside the container


SCRIPTS_DIR=./infrastructure/scripts
KAFKA_CONTAINTER=kafka-server

.PHONY: start stop down restart build build-common-lib rebuild fix-scripts create-topics

start: fix-scripts build-common-lib
	docker-compose -f docker-compose.yml up -d --build
	$(MAKE) create-topics

stop:
	docker-compose stop

down:
	docker-compose -f docker-compose.yml down

restart:
	$(MAKE) stop
	$(MAKE) start

build: build-common-lib
	docker-compose build --no-cache

build-common-lib:
	wsl ${SCRIPTS_DIR}/compile-common-lib.sh

rebuild:
	docker-compose build ${SERVICE}
	docker-compose up -d --no-deps ${SERVICE}

fix-scripts:
	wsl dos2unix $(SCRIPTS_DIR)/*.sh
	wsl chmod +x $(SCRIPTS_DIR)/*.sh

create-topics:
	docker exec -it ${KAFKA_CONTAINTER} bash /scripts/create-topics.sh
