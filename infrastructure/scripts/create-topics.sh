#!/bin/bash

BROKER="kafka-server:8889"
TOPICS=(
  "document.storage.request"
  "document.storage.completed"
  "document.storage.failed"
  "document.ocr.request"
  "document.ocr.completed"
  "document.ocr.failed"
  "document.ai.request"
  "document.ai.completed"
  "document.ai.failed"
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
