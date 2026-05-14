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

package io.microsphere.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;

import static org.hibernate.EmptyInterceptor.INSTANCE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DelegatingInterceptorTest {

    @Mock
    private Interceptor mockDelegate;

    private DelegatingInterceptor delegatingInterceptor;

    @BeforeEach
    void setUp() {
        delegatingInterceptor = new DelegatingInterceptor(mockDelegate);
    }

    @Test
    void testConstructorWithNullDelegate() {
        DelegatingInterceptor interceptor = new DelegatingInterceptor(null);
        assertNotNull(interceptor);
        assertSame(INSTANCE, interceptor.getDelegate());
    }

    @Test
    void testOnLoad() throws CallbackException {
        Object entity = new Object();
        Serializable id = 1L;
        Object[] state = new Object[0];
        String[] names = new String[0];
        Type[] types = new Type[0];

        when(mockDelegate.onLoad(eq(entity), eq(id), eq(state), eq(names), eq(types)))
                .thenReturn(true);

        assertTrue(delegatingInterceptor.onLoad(entity, id, state, names, types));
        verify(mockDelegate).onLoad(entity, id, state, names, types);
    }

    @Test
    void testOnFlushDirty() throws CallbackException {
        when(mockDelegate.onFlushDirty(any(), any(), any(), any(), any(), any()))
                .thenReturn(true);

        assertTrue(delegatingInterceptor.onFlushDirty(
                new Object(), 1L, new Object[0], new Object[0], new String[0], new Type[0]));
    }

    @Test
    void testOnSave() throws CallbackException {
        when(mockDelegate.onSave(any(), any(), any(), any(), any()))
                .thenReturn(false);

        assertFalse(delegatingInterceptor.onSave(
                new Object(), 1L, new Object[0], new String[0], new Type[0]));
    }

    @Test
    void testOnDelete() throws CallbackException {
        delegatingInterceptor.onDelete(
                new Object(), 1L, new Object[0], new String[0], new Type[0]);
        verify(mockDelegate).onDelete(any(), any(), any(), any(), any());
    }

    @Test
    void testCollectionOperations() throws CallbackException {
        Serializable key = 1L;
        Object collection = new Object();

        delegatingInterceptor.onCollectionRecreate(collection, key);
        delegatingInterceptor.onCollectionRemove(collection, key);
        delegatingInterceptor.onCollectionUpdate(collection, key);

        verify(mockDelegate).onCollectionRecreate(collection, key);
        verify(mockDelegate).onCollectionRemove(collection, key);
        verify(mockDelegate).onCollectionUpdate(collection, key);
    }

    @Test
    void testPreAndPostFlush() {
        Iterator<?> iterator = Collections.emptyIterator();

        delegatingInterceptor.preFlush(iterator);
        delegatingInterceptor.postFlush(iterator);

        verify(mockDelegate).preFlush(iterator);
        verify(mockDelegate).postFlush(iterator);
    }

    @Test
    void testIsTransient() {
        Object entity = new Object();
        when(mockDelegate.isTransient(entity)).thenReturn(Boolean.TRUE);

        assertEquals(Boolean.TRUE, delegatingInterceptor.isTransient(entity));
    }

    @Test
    void testFindDirty() {
        int[] expected = new int[]{0, 1};
        when(mockDelegate.findDirty(any(), any(), any(), any(), any(), any()))
                .thenReturn(expected);

        assertSame(expected, delegatingInterceptor.findDirty(
                new Object(), 1L, new Object[0], new Object[0], new String[0], new Type[0]));
    }

    @Test
    void testInstantiate() throws CallbackException {
        Object instance = new Object();
        when(mockDelegate.instantiate(anyString(), any(), any()))
                .thenReturn(instance);

        assertSame(instance, delegatingInterceptor.instantiate(
                "Entity", EntityMode.POJO, 1L));
    }

    @Test
    void testGetEntityName() throws CallbackException {
        when(mockDelegate.getEntityName(any())).thenReturn("Entity");

        assertEquals("Entity", delegatingInterceptor.getEntityName(new Object()));
    }

    @Test
    void testGetEntity() throws CallbackException {
        Object entity = new Object();
        when(mockDelegate.getEntity(anyString(), any())).thenReturn(entity);

        assertSame(entity, delegatingInterceptor.getEntity("Entity", 1L));
    }

    @Test
    void testTransactionCallbacks() {
        Transaction tx = mock(Transaction.class);

        delegatingInterceptor.afterTransactionBegin(tx);
        delegatingInterceptor.beforeTransactionCompletion(tx);
        delegatingInterceptor.afterTransactionCompletion(tx);

        verify(mockDelegate).afterTransactionBegin(tx);
        verify(mockDelegate).beforeTransactionCompletion(tx);
        verify(mockDelegate).afterTransactionCompletion(tx);
    }

    @Test
    @SuppressWarnings("deprecation")
    void testOnPrepareStatement() {
        String sql = "SELECT * FROM table";
        when(mockDelegate.onPrepareStatement(sql)).thenReturn(sql);

        assertEquals(sql, delegatingInterceptor.onPrepareStatement(sql));
    }

    @Test
    void testGetDelegate() {
        assertSame(mockDelegate, delegatingInterceptor.getDelegate());
    }
}
