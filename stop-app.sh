#!/bin/bash

echo "🛑 Tearing down Kubernetes environment..."

# Stop port forwards
echo "🔍 Killing port-forward processes..."
pkill -f "kubectl port-forward"

# Delete all Kubernetes resources
kubectl delete -f k8s/

# Optionally stop minikube
read -p "❓ Stop minikube too? (y/n): " yn
if [[ $yn == "y" ]]; then
  minikube stop
  echo "Minikube stopped!"
else
  echo "Minikube is still ON!"
fi