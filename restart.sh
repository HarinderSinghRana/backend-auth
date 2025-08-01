#!/bin/bash

echo "⛔ Stopping existing Kubernetes resources..."
./stop-app.sh

echo "🔄 Restarting Kubernetes resources..."
./start-app.sh

echo "⏳ Waiting for pods to be ready..."
kubectl wait --for=condition=ready pod --all --timeout=120s

echo "🚀 App restarted successfully. Current status:"
kubectl get pods