#!/bin/bash

BROKER="kafka-server:8889"
TOPICS=(
  "document.uploaded"
  "document.storage.completed"
  "document.ocr.ready"
  "document.ocr.completed"
  "document.ai.ready"
  "document.ai.completed"
  "document.errors"
)

sleep 5

echo "[SCRIPTS] - Creating topics on broker $BROKER"

for topic in "${TOPICS[@]}"; do
  echo "[SCRIPTS] - Creating kafka topic: $topic"
  kafka-topics.sh --create \
    --topic "$topic" \
    --bootstrap-server "$BROKER" \
    --partitions 1 \
    --replication-factor 1 \
    --if-not-exists
done

echo "[SCRIPTS] - Topics created seccessfully"
