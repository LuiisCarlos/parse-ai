#!/bin/bash

set -e  # Exit on error

# Get the directory of this script
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(realpath "$SCRIPT_DIR/../..")"
SHARED_UTILS_DIR="$PROJECT_ROOT/shared/common-lib"
LIBS_DIR="$PROJECT_ROOT/libs"

echo "[SCRIPTS] - Building common-lib"
cd "$SHARED_UTILS_DIR"
mvn clean package

echo "[SCRIPTS] - Copying JAR to libs folder"
mkdir -p "$LIBS_DIR"
cp target/*.jar "$LIBS_DIR/"

echo "[SCRIPTS] - common-lib JAR copied to $LIBS_DIR successfully"
