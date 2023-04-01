# message-sending-with-rabbit-mq
## A spring boot application that shows how to configure rabbit MQ with spring boot and send message with producer and consumer concept.

How to start:
1. Download ERLang with version 25.3. Link: https://www.erlang.org/patches/otp-25.3
2. Download a suitable version of rabbit MQ(3.11.13). Link: https://github.com/rabbitmq/rabbitmq-server/releases

***You can find your compatible version : https://www.rabbitmq.com/which-erlang.html***

3. Install relang and rebbit MQ.
4. Go to. directory where it installed: EX: ***C:\Program Files\RabbitMQ Server\rabbitmq_server-3.11.11\sbin***
5. Open a command prompt and run the server: ***rabbitmq-server start***
6. Open browser and go to ***http://localhost:15672*** with username: *guest* and password: *guest*
7. Now create and configure your QUEUE and Exchange by following these steps:

    i. Create two exchanges:
        
        a. javabeans.exchange
        
        b. javabeans.deadLetterExchange
    
    ii. Create a dead letter queue qith name: ***javabeans.deadLetterQueue***
    
    iii. Now Bind the dead letter exchange with the dead letter queue with value:
        
        a. To queue: javabeans.deadLetterQueue
        
        b. Routing Key: javabeans.deadLetterRoutingkey
    
    iv. Create a queue with name : ***javabeans.queue*** with these arguments:
        
        a. x-dead-letter-exchange : javabeans.deadLetterExchange
        
        b. x-dead-letter-routing-key : javabeans.deadLetterRoutingkey
        
    You can find a screenshot here: https://prnt.sc/-Ar0iiAXEbvw

    v. Last Step: Bind the queue with the exchange : ***javabeans.exchange***:
        
        a. To queue: javabeans.queue
        
        b. Routing Key: javabeans.routingkey
        
    You can find a screenshot here: https://prnt.sc/S0XVurH9UaNJ

8. Now clone the project and run it.
    
## Notes :

  1. Dependencies used:

      a. Spring Web

      b. Rabbit AMQP

  2. Configuration properties used: 
      ```
      spring.rabbitmq.host=localhost
      spring.rabbitmq.port=5672
      spring.rabbitmq.username=guest
      spring.rabbitmq.password=guest

      spring.rabbitmq.exchange=javabeans.exchange
      spring.rabbitmq.queuename=javabeans.queue
      spring.rabbitmq.routingkey=javabeans.routingkey

      com.javabeans.deadLetterQueue=javabeans.deadLetterQueue
      com.javabeans.deadLetterExchange=javabeans.deadLetterExchange
      com.javabeans.deadLetterRoutingkey=javabeans.deadLetterRoutingkey

      server.port=8085

      ```


