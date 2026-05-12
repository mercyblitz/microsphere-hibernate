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

import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.type.Type;

import java.util.Iterator;

/**
 * The lifecycle callback interface for entity.
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see org.hibernate.Interceptor
 * @see org.hibernate.event.spi.LoadEventListener
 * @see org.hibernate.event.spi.LockEventListener
 * @see org.hibernate.event.spi.MergeEventListener
 * @see org.hibernate.event.spi.PersistEventListener
 * @see org.hibernate.event.spi.RefreshEventListener
 * @see org.hibernate.event.spi.ReplicateEventListener
 * @see org.hibernate.event.spi.PreLoadEventListener
 * @see org.hibernate.event.spi.PostLoadEventListener
 * @see org.hibernate.event.spi.PreFlushEventListener
 * @see org.hibernate.event.spi.PreInsertEventListener
 * @see org.hibernate.event.spi.PostInsertEventListener
 * @see org.hibernate.event.spi.PreUpdateEventListener
 * @see org.hibernate.event.spi.PostUpdateEventListener
 * @see org.hibernate.event.spi.PreDeleteEventListener
 * @see org.hibernate.event.spi.PostDeleteEventListener
 * @see org.hibernate.event.spi.PreUpsertEventListener
 * @see org.hibernate.event.spi.PostUpsertEventListener
 * @see org.hibernate.event.spi.PreCollectionRecreateEventListener
 * @see org.hibernate.event.spi.PostCollectionRecreateEventListener
 * @see org.hibernate.event.spi.PreCollectionRemoveEventListener
 * @see org.hibernate.event.spi.PostCollectionRemoveEventListener
 * @see org.hibernate.event.spi.PreCollectionUpdateEventListener
 * @see org.hibernate.event.spi.PostCollectionUpdateEventListener
 * @see org.hibernate.event.spi.EventType
 * @since 1.0.0
 */
public interface EntityCallback {

    /**
     * Called just before an object is initialized. The interceptor may change the {@code state}, which will
     * be propagated to the persistent object. Note that when this method is called, {@code entity} will be
     * an empty uninitialized instance of the class.
     *
     * @param entity        The entity instance being loaded
     * @param id            The identifier value being loaded
     * @param state         The entity state (which will be pushed into the entity instance)
     * @param propertyNames The names of the entity properties, corresponding to the {@code state}.
     * @param types         The types of the entity properties, corresponding to the {@code state}.
     */
    default void onPreLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    /**
     * Called just after an object is initialized. The interceptor may change the {@code state}, which will
     * be propagated to the persistent object.
     *
     * @param entity        The entity instance being loaded
     * @param id            The identifier value being loaded
     * @param state         The entity state (which will be propagated into the entity instance)
     * @param propertyNames The names of the entity properties, corresponding to the {@code state}.
     * @param types         The types of the entity properties, corresponding to the {@code state}.
     */
    default void onPostLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    /**
     * Called before an object is made persistent by a stateful session.
     * <p>
     * The interceptor may modify the {@code state}, which will be used for
     * the SQL {@code INSERT} and propagated to the persistent object.
     *
     * @param entity        The entity instance whose state is being inserted
     * @param id            The identifier of the entity
     * @param state         The state of the entity which will be inserted
     * @param propertyNames The names of the entity properties.
     * @param types         The types of the entity properties
     * @see Session#persist(Object)
     * @see Session#merge(Object)
     */
    default void onPrePersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    /**
     * Called after an object is made persistent by a stateful session.
     * <p>
     * It is not recommended that the interceptor modify the {@code state}.
     *
     * @param entity        The entity instance being saved
     * @param id            The identifier of the entity
     * @param state         The state of the entity
     * @param propertyNames The names of the entity properties.
     * @param types         The types of the entity properties
     * @see Session#persist(Object)
     * @see Session#merge(Object)
     */
    default void onPostPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    /**
     * Called before an object is removed by a stateful session.
     * <p>
     * It is not recommended that the interceptor modify the {@code state}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The state of the entity
     * @param propertyNames The names of the entity properties.
     * @param types         The types of the entity properties
     * @see Session#remove(Object)
     */
    default void onPreRemove(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    default void onPostRemove(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
    }

    /**
     * Called when an object is detected to be dirty, during a flush. The interceptor may modify the detected
     * {@code currentState}, which will be propagated to both the database and the persistent object.
     * Note that not all flushes end in actual synchronization with the database, in which case the
     * new {@code currentState} will be propagated to the object, but not necessarily (immediately) to
     * the database. It is strongly recommended that the interceptor <b>not</b> modify the {@code previousState}.
     *
     * @param entity        The entity instance detected as being dirty and being flushed
     * @param id            The identifier of the entity
     * @param currentState  The entity's current state
     * @param previousState The entity's previous (load time) state.
     * @param propertyNames The names of the entity properties
     * @param types         The types of the entity properties
     * @apiNote The indexes across the {@code currentState}, {@code previousState}, {@code propertyNames}, and
     * {@code types} arrays match.
     * @see Session#flush()
     */
    default void onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState,
                              String[] propertyNames, Type[] types) {
    }

    /**
     * Called before a collection is (re)created.
     *
     * @param collection The collection instance.
     * @param key        The collection key value.
     */
    default void onPreCollectionUpdate(Object collection, Object key) {
    }

    /**
     * Called after a collection is (re)created.
     *
     * @param collection The collection instance.
     * @param key        The collection key value.
     */
    default void onPostCollectionUpdate(Object collection, Object key) {
    }

    /**
     * Called before a collection is deleted.
     *
     * @param collection The collection instance.
     * @param key        The collection key value.
     */
    default void onPreCollectionRemove(Object collection, Object key) {
    }

    /**
     * Called after a collection is deleted.
     *
     * @param collection The collection instance.
     * @param key        The collection key value.
     */
    default void onPostCollectionRemove(Object collection, Object key) {
    }

    /**
     * Called before a flush.
     *
     * @param entities The entities to be flushed.
     */
    default void onPreFlush(Iterator<Object> entities) {
    }

    /**
     * Called after a flush that actually ends in execution of the SQL statements
     * required to synchronize in-memory state with the database.
     *
     * @param entities The entities that were flushed.
     */
    default void onPostFlush(Iterator<Object> entities) {
    }

    /**
     * Called before a record is inserted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties.
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#insert(Object)
     */
    default void onPreInsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called after a record is inserted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties.
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#insert(Object)
     */
    default void onPostInsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called before a record is updated by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#update(Object)
     */
    default void onPreUpdate(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called after a record is updated by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#update(Object)
     */
    default void onPostUpdate(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called before a record is upserted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#upsert(String, Object)
     */
    default void onPreUpsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called after a record is upserted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param state         The entity state
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#upsert(String, Object)
     */
    default void onPostUpsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called before a record is deleted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#delete(Object)
     */
    default void onPreDelete(Object entity, Object id, String[] propertyNames, Type[] propertyTypes) {
    }

    /**
     * Called after a record is deleted by a {@link StatelessSession}.
     *
     * @param entity        The entity instance being deleted
     * @param id            The identifier of the entity
     * @param propertyNames The names of the entity properties
     * @param propertyTypes The types of the entity properties
     * @see StatelessSession#delete(Object)
     */
    default void onPostDelete(Object entity, Object id, String[] propertyNames, Type[] propertyTypes) {
    }
}