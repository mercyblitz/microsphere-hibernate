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
import org.hibernate.event.spi.DeleteContext;
import org.hibernate.event.spi.DeleteEvent;
import org.hibernate.event.spi.DeleteEventListener;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.EvictEvent;
import org.hibernate.event.spi.EvictEventListener;
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
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

/**
 * The listener class for {@link EntityCallback}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see PreLoadEventListener
 * @see EntityCallback
 * @see EventType
 * @since 1.0.0
 */
class EntityCallbackListener implements LoadEventListener, PersistEventListener, MergeEventListener,
        DeleteEventListener, ReplicateEventListener, FlushEventListener,
        EvictEventListener, LockEventListener, RefreshEventListener,
        PreLoadEventListener, PostLoadEventListener,
        PreDeleteEventListener, PostDeleteEventListener,
        PreUpdateEventListener, PostUpdateEventListener,
        PreInsertEventListener, PostInsertEventListener,
        PreUpsertEventListener, PostUpsertEventListener,
        PreCollectionRecreateEventListener, PostCollectionRecreateEventListener,
        PreCollectionRemoveEventListener, PostCollectionRemoveEventListener,
        PreCollectionUpdateEventListener, PostCollectionUpdateEventListener {

    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {

    }

    @Override
    public void onDelete(DeleteEvent event) throws HibernateException {

    }

    @Override
    public void onDelete(DeleteEvent event, DeleteContext transientEntities) throws HibernateException {

    }

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {

    }

    @Override
    public void onPersist(PersistEvent event, PersistContext createdAlready) throws HibernateException {

    }

    @Override
    public void onMerge(MergeEvent event) throws HibernateException {

    }

    @Override
    public void onMerge(MergeEvent event, MergeContext copiedAlready) throws HibernateException {

    }

    @Override
    public void onReplicate(ReplicateEvent event) throws HibernateException {

    }

    @Override
    public void onFlush(FlushEvent event) throws HibernateException {

    }

    @Override
    public void onEvict(EvictEvent event) throws HibernateException {

    }

    @Override
    public void onLock(LockEvent event) throws HibernateException {

    }

    @Override
    public void onRefresh(RefreshEvent event) throws HibernateException {

    }

    @Override
    public void onRefresh(RefreshEvent event, RefreshContext refreshedAlready) throws HibernateException {

    }

    @Override
    public void onPreLoad(PreLoadEvent event) {

    }

    @Override
    public void onPostLoad(PostLoadEvent event) {

    }

    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        return false;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {

    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        return false;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {

    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        return false;
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {

    }

    @Override
    public boolean onPreUpsert(PreUpsertEvent event) {
        return false;
    }

    @Override
    public void onPostUpsert(PostUpsertEvent event) {

    }

    @Override
    public void onPreRecreateCollection(PreCollectionRecreateEvent event) {

    }

    @Override
    public void onPostRecreateCollection(PostCollectionRecreateEvent event) {

    }

    @Override
    public void onPreRemoveCollection(PreCollectionRemoveEvent event) {

    }

    @Override
    public void onPostRemoveCollection(PostCollectionRemoveEvent event) {

    }

    @Override
    public void onPreUpdateCollection(PreCollectionUpdateEvent event) {

    }

    @Override
    public void onPostUpdateCollection(PostCollectionUpdateEvent event) {

    }
}