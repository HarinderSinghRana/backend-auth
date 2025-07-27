#!/bin/bash

echo "🚀 Starting Kubernetes environment..."

# Start minikube (if not running)
minikube status | grep -q "Running" || {
    echo "⏳ Starting Minikube..."
    minikube start
}

# Set docker env so you can build/pull locally
eval $(minikube docker-env)

# Apply all Kubernetes manifests
kubectl apply -f k8s/

# Wait for pods to be ready
echo "⏳ Waiting for all pods to be ready..."
kubectl wait --for=condition=ready pod --all --timeout=180s

# Port-forward ecommerce app
echo "🌐 Forwarding ecommerce-service to http://localhost:8080"
kubectl port-forward service/ecommerce-service 8080:80 &
echo "📦 App should be accessible at: http://localhost:8080"