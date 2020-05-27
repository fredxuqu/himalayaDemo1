package com.himalaya.kafka;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author xuqu
 * @date 2020/5/21 17:33
 */
public class KafkaProducerDemo {

    private static String abc = "message";

    public static void main(String[] args) {
        final String kafkaServers = "hadoop201:9092,hadoop202:9092,hadoop203:9092";
        final String topic = "billTopic";

        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.ACKS_CONFIG, "0");
        // 最大处理时间500ms
        p.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 500);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p);
        BillBO billBO = new BillBO(1, "abc", 1.1d, abc);
        boolean successful = false;
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, JSON.toJSONString(billBO));
            Future<RecordMetadata> future = kafkaProducer.send(record);
            future.get();
            successful = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }
}

@Data
@AllArgsConstructor
class BillBO {
    private int id;
    private String name;
    private double bill;
    private String desc;
}
