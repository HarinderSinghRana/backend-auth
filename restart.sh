#!/bin/bash
echo "✅ Rebuilding JAR..."
./mvnw clean package -DskipTests || exit 1

echo "🐳 Setting Docker env for Minikube..."
eval $(minikube docker-env)

echo "📦 Building Docker image..."
docker build -t ecommerce-backend22:latest .

echo "♻️ Restarting Kubernetes deployment..."
kubectl rollout restart deployment ecommerce-app

echo "⏳ Waiting for pod to be ready..."
kubectl wait --for=condition=ready pod -l app=ecommerce-app --timeout=60s

echo "📄 Showing logs:"
kubectl logs -l app=ecommerce-app -f