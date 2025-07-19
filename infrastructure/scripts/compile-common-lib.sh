#!/bin/bash

set -e  # Exit on error

# Get the directory of this script
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Resolve project root absolute path by canonicalizing
PROJECT_ROOT="$(realpath "$SCRIPT_DIR/../..")"
SHARED_UTILS_DIR="$PROJECT_ROOT/shared/common-lib"
LIBS_DIR="$PROJECT_ROOT/libs"

echo "Building common-lib..."
cd "$SHARED_UTILS_DIR"
mvn clean package

echo "Copying JAR to libs folder..."
mkdir -p "$LIBS_DIR"
cp target/*.jar "$LIBS_DIR/"

echo "Done! common-lib JAR copied to $LIBS_DIR"
