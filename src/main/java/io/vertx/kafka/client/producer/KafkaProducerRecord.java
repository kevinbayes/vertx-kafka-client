/*
 * Copyright 2016 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vertx.kafka.client.producer;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.kafka.client.producer.impl.KafkaProducerRecordImpl;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;

/**
 * Vert.x Kafka producer record.
 */
@VertxGen
public interface KafkaProducerRecord<K, V> {

  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param timestamp the timestamp of this record
   * @param partition the partition to which the record will be sent (or null if no partition was specified)
   * @param <K> key type
   * @param <V> value type
   * @return  Vert.x producer record
   */
  static <K, V> KafkaProducerRecord<K, V> create(String topic, K key, V value, Long timestamp, Integer partition) {

    return new KafkaProducerRecordImpl<>(topic, key, value, timestamp, partition);
  }

  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param timestamp the timestamp of this record
   * @param partition the partition to which the record will be sent (or null if no partition was specified)
   * @param <K> key type
   * @param <V> value type
   * @param headers the headers that will be included in the record
   * @return  Vert.x producer record
   */
  @GenIgnore
  static <K, V> KafkaProducerRecord<K, V> create(String topic, K key, V value, Long timestamp, Integer partition, Iterable<Header> headers) {

    return new KafkaProducerRecordImpl<>(topic, key, value, timestamp, partition, headers);
  }


  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param partition the partition to which the record will be sent (or null if no partition was specified)
   * @param <K> key type
   * @param <V> value type
   * @return  Vert.x producer record
   */
  @GenIgnore
  static <K, V> KafkaProducerRecord<K, V> create(String topic, K key, V value, Integer partition) {

    return new KafkaProducerRecordImpl<>(topic, key, value, partition);
  }

  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param partition the partition to which the record will be sent (or null if no partition was specified)
   * @param <K> key type
   * @param <V> value type
   * @param headers the headers that will be included in the record
   * @return  Vert.x producer record
   */
  @GenIgnore
  static <K, V> KafkaProducerRecord<K, V> create(String topic, K key, V value, Integer partition, Iterable<Header> headers) {

    return new KafkaProducerRecordImpl<>(topic, key, value, partition, headers);
  }

  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param <K> key type
   * @param <V> value type
   * @return  Vert.x producer record
   */
  static <K, V> KafkaProducerRecord<K, V> create(String topic, K key, V value) {

    return new KafkaProducerRecordImpl<>(topic, key, value);
  }

  /**
   * Create a concrete instance of a Vert.x producer record
   *
   * @param topic the topic this record is being sent to
   * @param value the value
   * @param <K> key type
   * @param <V> value type
   * @return  Vert.x producer record
   */
  static <K, V> KafkaProducerRecord<K, V> create(String topic, V value) {

    return new KafkaProducerRecordImpl<>(topic, value);
  }

  /**
   * @return  the topic this record is being sent to
   */
  String topic();

  /**
   * @return The headers
   */
  @GenIgnore
  Headers headers();

  /**
   * @return  the key (or null if no key is specified)
   */
  K key();

  /**
   * @return  the value
   */
  V value();

  /**
   * @return  the timestamp of this record
   */
  Long timestamp();

  /**
   * @return  the partition to which the record will be sent (or null if no partition was specified)
   */
  Integer partition();

  /**
   * @return  the native Kafka producer record with backed information
   */
  @GenIgnore
  ProducerRecord record();
}
