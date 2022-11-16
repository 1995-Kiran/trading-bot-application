FROM openjdk:20-ea-11-jdk

ADD kafkaStreams.jar kafkaStreams.jar

#COPY start.sh .

# ENTRYPOINT java -cp kafkaStreams.jar
