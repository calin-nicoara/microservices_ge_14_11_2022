# Logging with elk

## Install elk using docker
```
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.9.0

```

Check Elastic search
```
curl -XGET http://localhost:9200
```

## Install kibana using docker

```
docker run --link YOUR_ELASTICSEARCH_CONTAINER_NAME_OR_ID:elasticsearch -p 5601:5601 docker.elastic.co/kibana/kibana:7.9.0
```
Check kibana. 
```
http://localhost:5601/
```

Setting up KIBANA



## Install logstash

Download logstash locally from https://www.elastic.co/downloads/logstash
Go to logstash folder, in the config sub folder and add a custom config file
names  ``logstash-custom-config.conf`` with the following content.
```
input {
    tcp {
        port => 4560
        codec => json_lines
    }
}
filter {
    date {
        match => [ "timestamp" , "dd/MMM/yyyy:HH:mm:ss Z" ]
    }
}
output {
  stdout {
    codec => rubydebug
  }
  elasticsearch {
    hosts => ["http://localhost:9200"]
  }
}
```
Turn logstash on from the ``bin`` folder:

 ```./logstash -f ../config/logstash-custom-config.conf```

Dependency

```
<dependency>
			<groupId>net.logstash.logback</groupId>
			<artifactId>logstash-logback-encoder</artifactId>
			<version>5.3</version>
			<exclusions>
				<exclusion>
					<groupId>ch.qos.logback</groupId>
					<artifactId>logback-core</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```

LOGBACK CONFIG

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <include resource="org/springframework/boot/logging/logback/base.xml"/>

    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <remoteHost>localhost</remoteHost>

        <encoder class="net.logstash.logback.encoder.LogstashEncoder">
            <customFields>{"app_name":"store-service", "environment":"localhost"}</customFields>
        </encoder>
    </appender>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="net.logstash.logback.encoder.LogstashEncoder">
            <customFields>{"app_name":"store-service", "environment":"localhost"}
            </customFields>
        </encoder>
    </appender>

    <logger name="org.apache.kafka" level="ERROR"/>

    <root level="INFO">
        <appender-ref ref="LOGSTASH"/>
        <appender-ref ref="CONSOLE"/>
    </root>

</configuration>

```
