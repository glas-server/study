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

### Exchange, Bindings

## Exchange: 
The core idea int the messaging model in RabbitMQ is that the producer never sends any messages directly to a queue.Actually, quite often the producer doen't even know if a message will be delivered to any queue at all. Instead, the producer can only send messages to an exchange.
An exchange is a very simple thing. On one side, it receives messages from producer and the other side it pushes them to queues. Messages may send to particular queue, or many queues, or discarded. The rules for that are defined by the exchange type.

## Bindings: 
Is a relationship between an exchange and a queue. Exchange and queue are bound  each other by routing key.
<img src="https://www.rabbitmq.com/img/tutorials/bindings.png" width="500px">

#Note: There can be as many words in the routing key as you like, up to the limit of 255 bytes.


### Exchange type (DIRECT, TOPIC, FANOUT and HEADERS)
## Direct:
A message goes to the queues whose routing key (between an exchange and a queue) exactly matches the rounting key of message.
<img src="https://www.rabbitmq.com/img/tutorials/direct-exchange.png" width="500px">

## Fanout: 
Broadcasts all the messages it receives to all queues it knows
<img src="https://www.rabbitmq.com/img/tutorials/exchanges.png" width="500px">

## Topic:
A message sent with a particular routing key will be delivered to all the queues that are bound with a matching routing key (between an exchange and a queue).

Messages sent to a topic exchange can't have an arbitrary routing_key - it must be a list of words, delimited by dots. A few valid routing key examples: "stock.usd.nyse", "nyse.vmw", "quick.orange.rabbit". 

<img src="https://www.rabbitmq.com/img/tutorials/python-five.png" width="500px">

## Headers:
A headers exchange is an exchange which route messages to queues based on message header value instead of rouring key. Producer adds some values in a form of key value pair in message header and sends it to headers exchange.

After receiving a message, exchange try to match all or any (based on the value of “x-match”) header value with the binding value of all the queues bound to it. If match is found, it route the message to the queue whose binding value is matched and if match is not found, it ignored the message

Producer can add one special value in the header of the message called as “x-match“, The “x-match” can have two different values, “any” or “all“, where “all” is the default value. “all” means all the header key-value pairs must match while “any” means at least one of the headers key-value pairs must match with the binding value of the queue. The value in header key-value pairs can be of any data type like integer, string or even hash.

<img src="https://codedestine.com/wp-content/uploads/2016/09/HeadersExchange.png" width="500px">
