#!/bin/bash

# Function to check if Cassandra is ready
wait_for_cassandra() {
  until cqlsh cassandra -e "DESCRIBE CLUSTER"; do
    echo "Waiting for Cassandra to be ready..."
    sleep 2
  done
}

# Wait for Cassandra to start up
wait_for_cassandra

# Create the keyspace
echo "Creating keyspace..."
cqlsh cassandra -f /scripts/create-keyspace.cql