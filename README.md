# 🛒 Ecommerce Backend (Spring Boot + PostgreSQL + Redis + Prometheus + Grafana)

A complete backend application containerized and deployed with Kubernetes, featuring:
- Spring Boot REST API
- PostgreSQL for persistence
- Redis for caching
- Prometheus for metrics scraping
- Grafana for monitoring dashboards

---

## 📦 Project Structure
<details>

<summary>📁 Full Project Structure</summary>

```agsl
ecommerce-backend22/
├── 📁 k8s/                          # All Kubernetes manifests
│   ├── grafana.yaml
│   ├── prometheus-configmap.yaml
│   ├── prometheus-deployment.yaml
│   ├── redis.yaml
│   ├── postgres.yaml
│   ├── deployment.yaml             # App Deployment
│   └── service.yaml                # App Service
│
├── 📁 prometheus/                  # Prometheus configuration
│   └── prometheus.yml
│
├── 📁 src/                         # Spring Boot source files
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── auth_service1/
│       │           └── ecommerce_backend/
│       │               ├── config/
│       │               ├── controller/
│       │               ├── dto/
│       │                   ├── auth/
│       │                   ├── order/
│       │                   ├── order_item/
│       │                   ├── product/
│       │                   ├── user/
│       │               ├── entity/
│       │               ├── repository/
│       │               ├── security/
│       │               ├── service/
│       │                   ├── impl/
│       │               └── Application.java
│       └── resources/
│           ├── application.yml
│
├── .dockerignore
├── .gitignore
├── Dockerfile                      # Spring Boot app container
├── docker-compose.yml             # For local multi-container setup
├── start-app.sh                        # Script to start k8s resources
├── stop-app.sh                         # Script to stop k8s resources
├── README.md
├── mvnw / mvnw.cmd (if using Maven wrapper)
└── pom.xml                         # Maven dependencies and config
```

</details>

---

## ⚙️ Prerequisites

- [Docker](https://www.docker.com/)
- [Minikube](https://minikube.sigs.k8s.io/docs/)
- [kubectl](https://kubernetes.io/docs/tasks/tools/)
- Docker Hub account (if using remote image)

---

## 🚀 Getting Started

### 1. Start Minikube

```bash
minikube start
```

### 2. (Optional) Use Minikube Docker Daemon

If you’re building the Docker image locally:

```eval $(minikube docker-env)```

```docker build -t ecommerce-backend22 .```

✅ Skip docker push if using Minikube’s Docker daemon.

---

### 3. 🐳 Local Docker Compose (Dev/Debug)

```docker-compose up --build```

    Access:

    •	API: http://localhost:8080

    •	Grafana: http://localhost:3000

    •	Prometheus: http://localhost:9090

---

### 4. ☸️ Kubernetes Deployment

#### Start the app using helper script
    
```./start-app.sh```
    
    This will:

    •	Apply all YAMLs in k8s/

    •	Wait for pods to become ready

    •	Show current cluster state

--

#### Port Forwarding (for local access)

In separate terminals:

```•	kubectl port-forward service/ecommerce-service 8080:80```

```•	kubectl port-forward deployment/grafana 3000:3000```

```•	kubectl port-forward deployment/prometheus 9090:9090```

--

#### ✅ Verifying Everything Works

```kubectl get pods```

```kubectl get svc```

```kubectl get deployments```

--

#### Check logs if needed:

```kubectl logs deployment/ecommerce-app```

--

    Access services:

    •	App → http://localhost:8080

    •	Grafana → http://localhost:3000

    •	Prometheus → http://localhost:9090

---

### 5. 📊 Grafana Setup

1.	Go to http://localhost:3000

2.	Login:

    •	Username: admin
    •	Password: admin

3.	Add Prometheus as a data source:

    •	Settings → Data Sources → Add data source
    •	Select Prometheus
    •	URL: http://prometheus:9090
    •	Click Save & Test

4.	Import Dashboards:

    •	Click + → Import
    •	Use Prometheus template IDs (e.g., 1860 or 8919 for JVM/Spring Boot)

--

#### 🧼 To Stop Everything

```./stop-app.sh```

This script will delete all Kubernetes resources.

---

### 6. 🐘 Postgres Details

    POSTGRES_DB: ecommerce
    POSTGRES_USER: user
    POSTGRES_PASSWORD: password

---

### 7. 🧠 Redis Details

    Host: redis
    Port: 6379

---

### 8. 🔧 Environment Variables

Used via application.yml:

    SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/ecommerce
    SPRING_DATASOURCE_USERNAME: user
    SPRING_DATASOURCE_PASSWORD: password
    SPRING_REDIS_HOST: redis
    SPRING_REDIS_PORT: 6379

### 9. 📜 Scripts

start-app.sh

```
#!/bin/bash
echo "🚀 Starting Kubernetes resources..."
kubectl apply -f k8s/
echo "⏳ Waiting for pods to be ready..."
kubectl wait --for=condition=ready pod --all --timeout=120s
kubectl get all
echo "✅ Deployment complete. Run 'kubectl port-forward service/ecommerce-service 8080:80' to access the app."
```

stop-app.sh

```
#!/bin/bash

echo "🛑 Deleting all Kubernetes resources..."
kubectl delete -f k8s/
echo "✅ All resources deleted."
```

--

#### Make both scripts executable:

    chmod +x start.sh stop.sh

---

### 10. 📦 Docker Image

If using Docker Hub:

    docker build -t harindersinghrana/ecommerce-backend22:latest .
    docker push harindersinghrana/ecommerce-backend22:latest

Ensure Kubernetes uses this image (or use local image with Minikube daemon).


---

📌 Notes

    •	If you get a connect: connection refused error, ensure port-forwarding is running.
    •	Use minikube dashboard to inspect deployments visually.