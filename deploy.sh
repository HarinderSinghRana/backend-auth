#!/bin/bash

# === CONFIG ===
APP_NAME="ecommerce-app"
IMAGE_NAME="ecommerce-backend22"
DOCKER_USER="harindersinghrana"   # your DockerHub username
NAMESPACE="default"               # change if using custom namespace

echo "🚀 Starting deployment for $APP_NAME..."

# 1. Compile + package backend
echo "📦 Building JAR with Maven..."
mvn clean package -DskipTests

# 2. Point Docker to Minikube
echo "🐳 Setting Docker env to Minikube..."
eval $(minikube docker-env)

# 3. Build Docker image
echo "🔨 Building Docker image..."
docker build -t $DOCKER_USER/$IMAGE_NAME:latest .

# 4. Check if deployment exists
if kubectl get deployment $APP_NAME -n $NAMESPACE >/dev/null 2>&1; then
    echo "🔄 Restarting existing deployment..."
    kubectl rollout restart deployment $APP_NAME -n $NAMESPACE
else
    echo "⚠️ Deployment $APP_NAME not found, applying manifests..."
    kubectl apply -f k8s/
fi

# 5. Wait until rollout is ready
echo "⏳ Waiting for rollout to finish..."
kubectl rollout status deployment/$APP_NAME -n $NAMESPACE

# 6. Show logs
echo "📜 Showing logs for $APP_NAME..."
kubectl logs -l app=$APP_NAME -n $NAMESPACE -f