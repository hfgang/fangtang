package com.fangtang.tv.sdk.download.core.db;

import android.database.sqlite.SQLiteDatabase;

import com.fangtang.tv.sdk.download.Download;
import com.fangtang.tv.sdk.download.DownloadTask;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig downloadDaoConfig;
    private final DaoConfig downloadTaskDaoConfig;

    private final DownloadDao downloadDao;
    private final DownloadTaskDao downloadTaskDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        downloadDaoConfig = daoConfigMap.get(DownloadDao.class).clone();
        downloadDaoConfig.initIdentityScope(type);

        downloadTaskDaoConfig = daoConfigMap.get(DownloadTaskDao.class).clone();
        downloadTaskDaoConfig.initIdentityScope(type);

        downloadDao = new DownloadDao(downloadDaoConfig, this);
        downloadTaskDao = new DownloadTaskDao(downloadTaskDaoConfig, this);

        registerDao(Download.class, downloadDao);
        registerDao(DownloadTask.class, downloadTaskDao);
    }

    public void clear() {
        downloadDaoConfig.getIdentityScope().clear();
        downloadTaskDaoConfig.getIdentityScope().clear();
    }

    public DownloadDao getDownloadDao() {
        return downloadDao;
    }

    public DownloadTaskDao getDownloadTaskDao() {
        return downloadTaskDao;
    }

}
