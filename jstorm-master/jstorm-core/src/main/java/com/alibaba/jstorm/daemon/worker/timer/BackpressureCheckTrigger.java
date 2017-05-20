/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.jstorm.daemon.worker.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.jstorm.task.backpressure.BackpressureTrigger;


public class BackpressureCheckTrigger extends TimerTrigger{
    private static final Logger LOG = LoggerFactory.getLogger(BackpressureCheckTrigger.class);

    private BackpressureTrigger trigger;

    public BackpressureCheckTrigger(int initDelay, int frequence, String name, BackpressureTrigger trigger) {
        if (frequence <= 0) {
            LOG.warn(" The frequence of " + name + " is invalid");
            frequence = 1;
        }
        this.firstTime = initDelay;
        this.frequence = frequence;
        this.trigger = trigger;
    }

    @Override
    public void run() {
        try {
            trigger.checkAndTrigger();
        } catch (Exception e) {
            LOG.warn("Failed to publish timer event to " + name, e);
            return;
        }
    }

}
