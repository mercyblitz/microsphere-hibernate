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

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.event.spi.DeleteContext;
import org.hibernate.event.spi.DeleteEvent;
import org.hibernate.event.spi.DeleteEventListener;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.EvictEvent;
import org.hibernate.event.spi.EvictEventListener;
import org.hibernate.event.spi.FlushEntityEvent;
import org.hibernate.event.spi.FlushEntityEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;
import org.hibernate.event.spi.LockEvent;
import org.hibernate.event.spi.LockEventListener;
import org.hibernate.event.spi.MergeContext;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistContext;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.hibernate.event.spi.PostCollectionRecreateEventListener;
import org.hibernate.event.spi.PostCollectionRemoveEvent;
import org.hibernate.event.spi.PostCollectionRemoveEventListener;
import org.hibernate.event.spi.PostCollectionUpdateEvent;
import org.hibernate.event.spi.PostCollectionUpdateEventListener;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PostUpsertEvent;
import org.hibernate.event.spi.PostUpsertEventListener;
import org.hibernate.event.spi.PreCollectionRecreateEvent;
import org.hibernate.event.spi.PreCollectionRecreateEventListener;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
import org.hibernate.event.spi.PreCollectionRemoveEventListener;
import org.hibernate.event.spi.PreCollectionUpdateEvent;
import org.hibernate.event.spi.PreCollectionUpdateEventListener;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.event.spi.PreUpsertEvent;
import org.hibernate.event.spi.PreUpsertEventListener;
import org.hibernate.event.spi.RefreshContext;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;
import org.hibernate.event.spi.ReplicateEvent;
import org.hibernate.event.spi.ReplicateEventListener;
import org.hibernate.persister.entity.EntityPersister;

import java.util.List;

import static io.microsphere.collection.ListUtils.newLinkedList;
import static io.microsphere.lang.Prioritized.COMPARATOR;
import static java.util.ServiceLoader.load;

/**
 * The listener class for {@link EntityCallback}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see LoadEventListener
 * @see PersistEventListener
 * @see MergeEventListener
 * @see DeleteEventListener
 * @see ReplicateEventListener
 * @see FlushEntityEventListener
 * @see EvictEventListener
 * @see LockEventListener
 * @see RefreshEventListener
 * @see PreLoadEventListener
 * @see PostLoadEventListener
 * @see PreDeleteEventListener
 * @see PostDeleteEventListener
 * @see PreUpdateEventListener
 * @see PostUpdateEventListener
 * @see PreInsertEventListener
 * @see PostInsertEventListener
 * @see PreUpsertEventListener
 * @see PostUpsertEventListener
 * @see PreCollectionRecreateEventListener
 * @see PostCollectionRecreateEventListener
 * @see PreCollectionRemoveEventListener
 * @see PostCollectionRemoveEventListener
 * @see PreCollectionUpdateEventListener
 * @see PostCollectionUpdateEventListener
 * @see EntityCallback
 * @see EventType
 * @since 1.0.0
 */
class EntityCallbackListener implements LoadEventListener, PersistEventListener, MergeEventListener,
        DeleteEventListener, ReplicateEventListener, FlushEntityEventListener,
        EvictEventListener, LockEventListener, RefreshEventListener,
        PreLoadEventListener, PostLoadEventListener,
        PreDeleteEventListener, PostDeleteEventListener,
        PreUpdateEventListener, PostUpdateEventListener,
        PreInsertEventListener, PostInsertEventListener,
        PreUpsertEventListener, PostUpsertEventListener,
        PreCollectionRecreateEventListener, PostCollectionRecreateEventListener,
        PreCollectionRemoveEventListener, PostCollectionRemoveEventListener,
        PreCollectionUpdateEventListener, PostCollectionUpdateEventListener {

    private final EntityCallback callback;

    EntityCallbackListener() {
        this(load(EntityCallback.class));
    }

    EntityCallbackListener(Iterable<EntityCallback> callbacks) {
        List<EntityCallback> entityCallbacks = newLinkedList(callbacks);
        entityCallbacks.sort(COMPARATOR);
        this.callback = new CompositeEntityCallback(entityCallbacks);
    }

    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
        this.callback.onLoad(event.getEntityId(), event.getEntityClassName(), event.getInstanceToLoad(),
                getLockMode(event.getLockOptions()), event.isAssociationFetch(), event.getResult(), event.getReadOnly(), loadType);
    }

    @Override
    public void onDelete(DeleteEvent event) throws HibernateException {
        onDelete(event, null);
    }

    @Override
    public void onDelete(DeleteEvent event, DeleteContext transientEntities) throws HibernateException {
        this.callback.onDelete(event.getObject(), event.isCascadeDeleteEnabled(), event.isOrphanRemovalBeforeUpdates());
    }

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        onPersist(event, null);
    }

    @Override
    public void onPersist(PersistEvent event, PersistContext createdAlready) throws HibernateException {
        this.callback.onPersist(event.getObject(), event.getEntityName());
    }

    @Override
    public void onMerge(MergeEvent event) throws HibernateException {
        onMerge(event, null);
    }

    @Override
    public void onMerge(MergeEvent event, MergeContext copiedAlready) throws HibernateException {
        this.callback.onMerge(event.getOriginal(), event.getRequestedId(), event.getEntity(), event.getEntityName(),
                event.getResult());
    }

    @Override
    public void onReplicate(ReplicateEvent event) throws HibernateException {
        this.callback.onReplicate(event.getObject(), event.getReplicationMode(), event.getEntityName());
    }

    @Override
    public void onFlushEntity(FlushEntityEvent event) throws HibernateException {
        EntityEntry entry = event.getEntityEntry();
        Object entity = event.getEntity();
        Object id = entry.getId();
        Object[] values = event.getPropertyValues();
        EntityPersister persister = entry.getPersister();

        this.callback.onFlushDirty(entity,
                id,
                values,
                entry.getLoadedState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
    }

    @Override
    public void onEvict(EvictEvent event) throws HibernateException {
        this.callback.onEvict(event.getObject());
    }

    @Override
    public void onLock(LockEvent event) throws HibernateException {
        this.callback.onLock(event.getObject(), getLockMode(event.getLockOptions()), event.getEntityName());
    }

    @Override
    public void onRefresh(RefreshEvent event) throws HibernateException {
        onRefresh(event, null);
    }

    @Override
    public void onRefresh(RefreshEvent event, RefreshContext refreshedAlready) throws HibernateException {
        this.callback.onRefresh(event.getObject(), event.getEntityName(), getLockMode(event.getLockOptions()));
    }

    @Override
    public void onPreLoad(PreLoadEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPreLoad(
                event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes()
        );
    }

    @Override
    public void onPostLoad(PostLoadEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPostLoad(event.getEntity(),
                event.getId(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());

    }

    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPreDelete(event.getEntity(),
                event.getId(),
                event.getDeletedState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
        return false;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPostDelete(event.getEntity(),
                event.getId(),
                event.getDeletedState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPreInsert(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
        return false;
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPostInsert(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPreUpdate(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
        return false;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPostUpdate(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
    }

    @Override
    public boolean onPreUpsert(PreUpsertEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPreUpsert(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
        return false;
    }

    @Override
    public void onPostUpsert(PostUpsertEvent event) {
        EntityPersister persister = event.getPersister();
        this.callback.onPostUpsert(event.getEntity(),
                event.getId(),
                event.getState(),
                persister.getPropertyNames(),
                persister.getPropertyTypes());
    }

    @Override
    public void onPreRecreateCollection(PreCollectionRecreateEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPreRecreateCollection(collection, collection.getKey());
    }

    @Override
    public void onPostRecreateCollection(PostCollectionRecreateEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPostRecreateCollection(collection, collection.getKey());
    }

    @Override
    public void onPreRemoveCollection(PreCollectionRemoveEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPreCollectionRemove(collection, collection.getKey());
    }

    @Override
    public void onPostRemoveCollection(PostCollectionRemoveEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPostRemoveCollection(collection, collection.getKey());
    }

    @Override
    public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPreUpdateCollection(collection, collection.getKey());
    }

    @Override
    public void onPostUpdateCollection(PostCollectionUpdateEvent event) {
        PersistentCollection<?> collection = event.getCollection();
        this.callback.onPostUpdateCollection(collection, collection.getKey());
    }

    protected LockMode getLockMode(LockOptions lockOptions) {
        return lockOptions.getLockMode();
    }
}