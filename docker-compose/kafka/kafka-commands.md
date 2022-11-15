# Kafka commands for beginners

## Kafka locally
In this folder run ``docker-compose up -d``

## Get Kafka scripts

Download the kafka zip in order to use the scripts in the 'bin' folder
https://kafka.apache.org/downloads

## CREATE TOPIC
```
./kafka-topics --bootstrap-server 127.0.0.1:9092 --create --topic TEST_TOPIC --partitions 1 --replication-factor 1
```
Important aspects:
- partitions - number of partitions
- replication factor - on how many nodes is the topic replicated

List topics
```
./kafka-topics --list --bootstrap-server localhost:9092
```

Describe a topic
./kafka-topics --bootstrap-server 127.0.0.1:9092 --describe --topic TEST_TOPIC

## ADD MESSAGE
./kafka-console-producer --broker-list 127.0.0.1:9092 --topic TEST_TOPIC
./kafka-console-producer --broker-list localhost:9092 --topic TEST_TOPIC < topic.json

./kafka-console-producer \
--broker-list localhost:9092 \
  --topic my-topic \
  --property "parse.key=true" \
  --property "key.separator=:"

## CONSUME MESSAGE
./kafka-console-consumer --bootstrap-server localhost:9092 --topic TEST_TOPIC --from-beginning \
--property print.key=true   \
 --property print.value=true

./kafka-console-consumer --bootstrap-server localhost:9092 --topic TEST_TOPIC --group testGroup --from-beginning

## GROUPS
./kafka-consumer-groups --bootstrap-server localhost:9092 --list
./kafka-consumer-groups --bootstrap-server localhost:9092 --group=testGroup --describe
