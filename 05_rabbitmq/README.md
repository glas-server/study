# RabbitMQ

## 1. Message Queue
### What is a Message Queues: 

- Message queues provide an asynchronous communications protocol, 
meaning that the sender and receiver of the message do not need to interact with 
the message queue at the same time. Messages placed onto the queue are stored until 
the recipient retrieves them. Message queues have implicit or explicit limits on the
size of data that may be transmitted in a single message and the number of messages that may remain outstanding on the queue.

#### Standards and protocols:
- Advanced Message Queuing Protocol (AMQP) - feature-rich message queue protocol, approved as ISO/IEC 19464 since April 2014
- Streaming Text Oriented Messaging Protocol (STOMP) - simple, text-oriented message protocol
- MQTT (formerly MQ Telemetry Transport) - lightweight message queue protocol especially for embedded devices

#### The Advanced Message Queuing model: 3 abstract components: 
- Exchange - The component of the message broker that routes messages to queues
- Queue - A data structure on disk or in memory that stores messages
- Binding - A rule that tells the exchange which queue the messages should be stored in

<img src="https://upload.wikimedia.org/wikipedia/commons/9/9d/The-amqp-model-for-wikipedia.svg" width="500px">


### Advantages of using Message Queue
- Better Performance
- Increased Reliability
- Granular Scalability
- Simplifed Decoupling

[Reference](https://aws.amazon.com/message-queue/benefits/)

### Common tools:
- RabbitMQ
- ActiveMQ
- Amazon SQS
- Kafka 
- ...


## 2. RabbitMQ
The most widely deployed open source message-oriented middleware that implements the Advanced Message Queuing Protocol (AMQP), written in Erlang.

### Features highlights:
- Reliability: RabbitMQ offers a variety of features to let you trade off performance with reliability, including persistence, delivery acknowledgements, publisher confirms, and high availability.
- Flexible Routing: Messages are routed through exchanges before arriving at queues. RabbitMQ features several built-in exchange types for typical routing logic. For more complex routing you can bind exchanges together or even write your own exchange type as a plugin.
- Clustering: 
- Federation: transmit messages between brokers without requiring clustering
- Highly Available Queues: Queues can be mirrored across several machines in a cluster, ensuring that even in the event of hardware failure your messages are safe.
- Multi-protocol: RabbitMQ supports messaging over a variety of messaging protocols.
- Many Clients: Java, Ruby, Python, PHP, JavaScript, and C#
- Management UI: RabbitMQ ships with an easy-to use management UI that allows you to monitor and control every aspect of your message broker.
- Tracing: If your messaging system is misbehaving, RabbitMQ offers tracing support to let you find out what's going on.
- Plugin System: RabbitMQ ships with a variety of plugins extending it in different ways, and you can also write your own.
- Commercial Support
- Large Community

### Exchange, Routing, Binding



