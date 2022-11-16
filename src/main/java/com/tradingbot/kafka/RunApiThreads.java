package com.tradingbot.kafka;

import com.tradingbot.kafka.utils.ApiClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

import static com.tradingbot.kafka.AppConfigs.KafkaThreadsEndpoint;

public class RunApiThreads {
    public static void main(String[] args) throws InterruptedException {
        String className;
        JSONArray threads = new JSONArray(ApiClient.fetch(KafkaThreadsEndpoint));
        System.out.println(threads);
        for (int i = 0, size = threads.length(); i < size; i++) {
            JSONObject thread = threads.getJSONObject(i);
            JSONObject threadParams = new JSONObject((String) thread.get("thread"));
            className = (String) threadParams.get("class");
            System.out.println(threadParams);
            Thread t = new Thread(new Runnable(threadParams));
            t.start();
            if (Objects.equals(className, "MarketDataStreamWindowedAgg")){
                System.out.println("Sleeping for 1m\n\n\n\n");
                Thread.sleep(180000);
            } else {
                Thread.sleep(5000);
            }
        }
    }
}
