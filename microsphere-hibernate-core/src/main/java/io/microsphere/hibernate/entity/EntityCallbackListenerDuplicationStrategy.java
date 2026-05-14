/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.microsphere.hibernate.entity;

import org.hibernate.event.service.spi.DuplicationStrategy;

import java.util.Objects;

import static org.hibernate.event.service.spi.DuplicationStrategy.Action.KEEP_ORIGINAL;

/**
 * {@link DuplicationStrategy} class for {@link EntityCallbackListener}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see EntityCallbackListener
 * @since 1.0.0
 */
class EntityCallbackListenerDuplicationStrategy implements DuplicationStrategy {

    @Override
    public boolean areMatch(Object listener, Object original) {
        Class<?> listenerClass = listener.getClass();
        return Objects.equals(listenerClass, original.getClass())
                && EntityCallbackListener.class.equals(listenerClass);
    }

    @Override
    public Action getAction() {
        return KEEP_ORIGINAL;
    }
}
