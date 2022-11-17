##Kubernetes Quick Start

### Install minikube

Install minikube to work locally with kubernetes
```
https://kubernetes.io/docs/tasks/tools/install-minikube/
```
Install kubectl
```
https://kubernetes.io/docs/tasks/tools/install-kubectl/
```

Make sure that minikube and kubectl version are compatible

Cluster info
```
kubectl cluster-info
```

Get nods
```
kubectl get nodes
```

### Create first Deployment

Common form of kubectl commands: ``kubectl <action> <resource>``  

kubectl get nodes --help

Example image
```
kubectl create deployment kubernetes-bootcamp \
--image=gcr.io/google-samples/kubernetes-bootcamp:v1
```

Actions done through this command:
- search for node where the application could be run
- schedule the application to run on that node
- configure the cluster to reschedule the instance on a new Node when needed

Get deployments:
```
kubectl get deployments
```

Pods running on private isolated networks. Accessible by default by
other pods and services in the same cluster.

Create a proxy with the minikube env: ``kubectl proxy``  

Echo name of pods
```
export POD_NAME=$(kubectl get pods -o go-template \
--template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
```

### Pods

Group of containers that share:
- storage
- networking
- information regarding each container

kubectl get - list resources
kubectl describe - show detailed information about a resource
kubectl logs - print the logs from a container in a pod
kubectl exec - execute a command on a container in a pod

Get env from pod
```
kubectl exec $POD_NAME env
```
Enter container
```
kubectl exec -ti $POD_NAME -- bash
curl localhost:8080
```

### Service

Abstraction over a group of pods as a logical set (same ip for different instances)

Types:
- ClusterIP ---> is internal only
- NodePort ---> exposes externally
- LoadBalancer ----> Superset of NodePort

Expose port
```
kubectl expose services/dummy-service-service --type="NodePort" --port 8080
```

Get port
```
export NODE_PORT=$(kubectl get services/dummy-service-service \
-o go-template='{{(index .spec.ports 0).nodePort}}')

curl $(minikube ip):$NODE_PORT
```

Get all pods by label
```
kubectl get pods -l app=kubernetes-bootcamp
```

Add label
```
kubectl label pod $POD_NAME app=v1
```

Delete service
```
kubectl delete service -l app=kubernetes-bootcamp
```

### Scaling our application

Check number of instances
```
kubectl get deployments
```

See ReplicaSet:

```
kubectl get rs
```

Scale application
```
kubectl scale deployments/kubernetes-bootcamp --replicas=4
```

See pods in with more info
```
kubectl get pods -o wide
```

Get service for label
```
kubectl describe services/kubernetes-bootcamp
```

Call service
```
curl $(minikube ip):<NODE_PORT>
```


### Update your app

Set new image
```
kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=jocatalin/kubernetes-bootcamp:v2
```

Check rollout status
```
kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=jocatalin/kubernetes-bootcamp:v2
```

Perform new update
```
kubectl set image deployments/kubernetes-bootcamp kubernetes-bootcamp=gcr.io/google-samples/kubernetes-bootcamp:v10
```

```
kubectl get deployments
kubectl get pods
```

Rollback
```
kubectl rollout undo deployments/kubernetes-bootcamp
```
