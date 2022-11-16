#!/bin/bash

java -Dpair=BTCUSDT -Dthread='{ "class": "TradeStreamProducer", "params": { "pair": "BTCUSDT" } }' -cp "/home/trading-bot/kafkaStreams/out/artifacts/kafkaStreams_jar/kafkaStreams.jar" com.tradingbot.kafka.RunTest;
