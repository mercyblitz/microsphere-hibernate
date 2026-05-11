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
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.metamodel.RepresentationMode;
import org.hibernate.metamodel.spi.EntityRepresentationStrategy;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Composite {@link Interceptor}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see Interceptor
 * @since 1.0.0
 */
public class CompositeInterceptor implements Interceptor {

    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onLoad(entity, id, state, propertyNames, types);
    }

    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onPersist(entity, id, state, propertyNames, types);
    }

    @Override
    public void onRemove(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        Interceptor.super.onRemove(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return Interceptor.super.onSave(entity, id, state, propertyNames, types);
    }

    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        Interceptor.super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public void onDelete(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        Interceptor.super.onDelete(entity, id, state, propertyNames, types);
    }

    public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
        Interceptor.super.onCollectionRecreate(collection, key);
    }

    @Override
    public void onCollectionRecreate(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionRecreate(collection, key);
    }

    public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
        Interceptor.super.onCollectionRemove(collection, key);
    }

    @Override
    public void onCollectionRemove(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionRemove(collection, key);
    }

    public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
        Interceptor.super.onCollectionUpdate(collection, key);
    }

    @Override
    public void onCollectionUpdate(Object collection, Object key) throws CallbackException {
        Interceptor.super.onCollectionUpdate(collection, key);
    }

    @Override
    public void preFlush(Iterator<Object> entities) throws CallbackException {
        Interceptor.super.preFlush(entities);
    }

    @Override
    public void postFlush(Iterator<Object> entities) throws CallbackException {
        Interceptor.super.postFlush(entities);
    }

    @Override
    public Boolean isTransient(Object entity) {
        return Interceptor.super.isTransient(entity);
    }

    public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return Interceptor.super.findDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public int[] findDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        return Interceptor.super.findDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public Object instantiate(String entityName, EntityRepresentationStrategy representationStrategy, Object id) throws CallbackException {
        return Interceptor.super.instantiate(entityName, representationStrategy, id);
    }

    @Override
    public Object instantiate(String entityName, RepresentationMode representationMode, Object id) throws CallbackException {
        return Interceptor.super.instantiate(entityName, representationMode, id);
    }

    @Override
    public String getEntityName(Object object) throws CallbackException {
        return Interceptor.super.getEntityName(object);
    }

    public Object getEntity(String entityName, Serializable id) throws CallbackException {
        return Interceptor.super.getEntity(entityName, id);
    }

    @Override
    public Object getEntity(String entityName, Object id) throws CallbackException {
        return Interceptor.super.getEntity(entityName, id);
    }

    @Override
    public void afterTransactionBegin(Transaction tx) {
        Interceptor.super.afterTransactionBegin(tx);
    }

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        Interceptor.super.beforeTransactionCompletion(tx);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        Interceptor.super.afterTransactionCompletion(tx);
    }

    @Override
    public void onInsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        Interceptor.super.onInsert(entity, id, state, propertyNames, propertyTypes);
    }

    @Override
    public void onUpdate(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        Interceptor.super.onUpdate(entity, id, state, propertyNames, propertyTypes);
    }

    @Override
    public void onUpsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        Interceptor.super.onUpsert(entity, id, state, propertyNames, propertyTypes);
    }

    @Override
    public void onDelete(Object entity, Object id, String[] propertyNames, Type[] propertyTypes) {
        Interceptor.super.onDelete(entity, id, propertyNames, propertyTypes);
    }
}