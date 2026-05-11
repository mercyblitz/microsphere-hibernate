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

package io.microsphere.hibernate.test.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * {@link User} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see User
 * @since 1.0.0
 */
class UserTest {

    static final Long TEST_ID = 18L;

    static final String TEST_NAME = "Mercy";

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setId(TEST_ID);
        this.user.setName(TEST_NAME);
    }

    @Test
    void test() {
        assertEquals(TEST_ID, user.getId());
        assertEquals(TEST_NAME, user.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        User user = new User(TEST_ID, TEST_NAME);
        assertEquals(this.user, user);
        assertEquals(this.user.hashCode(), user.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("User{id=" + TEST_ID + ", name='" + TEST_NAME + "'}", user.toString());
    }
}