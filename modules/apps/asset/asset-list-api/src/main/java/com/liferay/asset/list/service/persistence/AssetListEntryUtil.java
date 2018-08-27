/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.list.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.list.model.AssetListEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the asset list entry service. This utility wraps {@link com.liferay.asset.list.service.persistence.impl.AssetListEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetListEntryPersistence
 * @see com.liferay.asset.list.service.persistence.impl.AssetListEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class AssetListEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AssetListEntry assetListEntry) {
		getPersistence().clearCache(assetListEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AssetListEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AssetListEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AssetListEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AssetListEntry update(AssetListEntry assetListEntry) {
		return getPersistence().update(assetListEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AssetListEntry update(AssetListEntry assetListEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(assetListEntry, serviceContext);
	}

	/**
	* Returns all the asset list entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the asset list entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @return the range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the asset list entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid(String uuid, int start,
		int end, OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the asset list entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid(String uuid, int start,
		int end, OrderByComparator<AssetListEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first asset list entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByUuid_First(String uuid,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first asset list entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUuid_First(String uuid,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByUuid_Last(String uuid,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUuid_Last(String uuid,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the asset list entries before and after the current asset list entry in the ordered set where uuid = &#63;.
	*
	* @param assetListEntryId the primary key of the current asset list entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next asset list entry
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry[] findByUuid_PrevAndNext(
		long assetListEntryId, String uuid,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(assetListEntryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the asset list entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of asset list entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching asset list entries
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the asset list entry where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByUUID_G(String uuid, long groupId)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the asset list entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the asset list entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the asset list entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the asset list entry that was removed
	*/
	public static AssetListEntry removeByUUID_G(String uuid, long groupId)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of asset list entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching asset list entries
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the asset list entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the asset list entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @return the range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the asset list entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the asset list entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first asset list entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByUuid_C_First(String uuid,
		long companyId, OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first asset list entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the asset list entries before and after the current asset list entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param assetListEntryId the primary key of the current asset list entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next asset list entry
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry[] findByUuid_C_PrevAndNext(
		long assetListEntryId, String uuid, long companyId,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(assetListEntryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the asset list entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of asset list entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching asset list entries
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the asset list entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching asset list entries
	*/
	public static List<AssetListEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the asset list entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @return the range of matching asset list entries
	*/
	public static List<AssetListEntry> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the asset list entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByGroupId(long groupId, int start,
		int end, OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the asset list entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByGroupId(long groupId, int start,
		int end, OrderByComparator<AssetListEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first asset list entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByGroupId_First(long groupId,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first asset list entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByGroupId_First(long groupId,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByGroupId_Last(long groupId,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByGroupId_Last(long groupId,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the asset list entries before and after the current asset list entry in the ordered set where groupId = &#63;.
	*
	* @param assetListEntryId the primary key of the current asset list entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next asset list entry
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry[] findByGroupId_PrevAndNext(
		long assetListEntryId, long groupId,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(assetListEntryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the asset list entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of asset list entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching asset list entries
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the asset list entry where groupId = &#63; and title = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByG_T(long groupId, String title)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByG_T(groupId, title);
	}

	/**
	* Returns the asset list entry where groupId = &#63; and title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByG_T(long groupId, String title) {
		return getPersistence().fetchByG_T(groupId, title);
	}

	/**
	* Returns the asset list entry where groupId = &#63; and title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param title the title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByG_T(long groupId, String title,
		boolean retrieveFromCache) {
		return getPersistence().fetchByG_T(groupId, title, retrieveFromCache);
	}

	/**
	* Removes the asset list entry where groupId = &#63; and title = &#63; from the database.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the asset list entry that was removed
	*/
	public static AssetListEntry removeByG_T(long groupId, String title)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().removeByG_T(groupId, title);
	}

	/**
	* Returns the number of asset list entries where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the number of matching asset list entries
	*/
	public static int countByG_T(long groupId, String title) {
		return getPersistence().countByG_T(groupId, title);
	}

	/**
	* Returns all the asset list entries where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the matching asset list entries
	*/
	public static List<AssetListEntry> findByG_TY(long groupId, int type) {
		return getPersistence().findByG_TY(groupId, type);
	}

	/**
	* Returns a range of all the asset list entries where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @return the range of matching asset list entries
	*/
	public static List<AssetListEntry> findByG_TY(long groupId, int type,
		int start, int end) {
		return getPersistence().findByG_TY(groupId, type, start, end);
	}

	/**
	* Returns an ordered range of all the asset list entries where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByG_TY(long groupId, int type,
		int start, int end, OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .findByG_TY(groupId, type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the asset list entries where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching asset list entries
	*/
	public static List<AssetListEntry> findByG_TY(long groupId, int type,
		int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_TY(groupId, type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first asset list entry in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByG_TY_First(long groupId, int type,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByG_TY_First(groupId, type, orderByComparator);
	}

	/**
	* Returns the first asset list entry in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByG_TY_First(long groupId, int type,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .fetchByG_TY_First(groupId, type, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry
	* @throws NoSuchEntryException if a matching asset list entry could not be found
	*/
	public static AssetListEntry findByG_TY_Last(long groupId, int type,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByG_TY_Last(groupId, type, orderByComparator);
	}

	/**
	* Returns the last asset list entry in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching asset list entry, or <code>null</code> if a matching asset list entry could not be found
	*/
	public static AssetListEntry fetchByG_TY_Last(long groupId, int type,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence()
				   .fetchByG_TY_Last(groupId, type, orderByComparator);
	}

	/**
	* Returns the asset list entries before and after the current asset list entry in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param assetListEntryId the primary key of the current asset list entry
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next asset list entry
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry[] findByG_TY_PrevAndNext(
		long assetListEntryId, long groupId, int type,
		OrderByComparator<AssetListEntry> orderByComparator)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence()
				   .findByG_TY_PrevAndNext(assetListEntryId, groupId, type,
			orderByComparator);
	}

	/**
	* Removes all the asset list entries where groupId = &#63; and type = &#63; from the database.
	*
	* @param groupId the group ID
	* @param type the type
	*/
	public static void removeByG_TY(long groupId, int type) {
		getPersistence().removeByG_TY(groupId, type);
	}

	/**
	* Returns the number of asset list entries where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the number of matching asset list entries
	*/
	public static int countByG_TY(long groupId, int type) {
		return getPersistence().countByG_TY(groupId, type);
	}

	/**
	* Caches the asset list entry in the entity cache if it is enabled.
	*
	* @param assetListEntry the asset list entry
	*/
	public static void cacheResult(AssetListEntry assetListEntry) {
		getPersistence().cacheResult(assetListEntry);
	}

	/**
	* Caches the asset list entries in the entity cache if it is enabled.
	*
	* @param assetListEntries the asset list entries
	*/
	public static void cacheResult(List<AssetListEntry> assetListEntries) {
		getPersistence().cacheResult(assetListEntries);
	}

	/**
	* Creates a new asset list entry with the primary key. Does not add the asset list entry to the database.
	*
	* @param assetListEntryId the primary key for the new asset list entry
	* @return the new asset list entry
	*/
	public static AssetListEntry create(long assetListEntryId) {
		return getPersistence().create(assetListEntryId);
	}

	/**
	* Removes the asset list entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assetListEntryId the primary key of the asset list entry
	* @return the asset list entry that was removed
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry remove(long assetListEntryId)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().remove(assetListEntryId);
	}

	public static AssetListEntry updateImpl(AssetListEntry assetListEntry) {
		return getPersistence().updateImpl(assetListEntry);
	}

	/**
	* Returns the asset list entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param assetListEntryId the primary key of the asset list entry
	* @return the asset list entry
	* @throws NoSuchEntryException if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry findByPrimaryKey(long assetListEntryId)
		throws com.liferay.asset.list.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(assetListEntryId);
	}

	/**
	* Returns the asset list entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assetListEntryId the primary key of the asset list entry
	* @return the asset list entry, or <code>null</code> if a asset list entry with the primary key could not be found
	*/
	public static AssetListEntry fetchByPrimaryKey(long assetListEntryId) {
		return getPersistence().fetchByPrimaryKey(assetListEntryId);
	}

	public static java.util.Map<java.io.Serializable, AssetListEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the asset list entries.
	*
	* @return the asset list entries
	*/
	public static List<AssetListEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the asset list entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @return the range of asset list entries
	*/
	public static List<AssetListEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the asset list entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of asset list entries
	*/
	public static List<AssetListEntry> findAll(int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the asset list entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssetListEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of asset list entries
	* @param end the upper bound of the range of asset list entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of asset list entries
	*/
	public static List<AssetListEntry> findAll(int start, int end,
		OrderByComparator<AssetListEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the asset list entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of asset list entries.
	*
	* @return the number of asset list entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AssetListEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssetListEntryPersistence, AssetListEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AssetListEntryPersistence.class);

		ServiceTracker<AssetListEntryPersistence, AssetListEntryPersistence> serviceTracker =
			new ServiceTracker<AssetListEntryPersistence, AssetListEntryPersistence>(bundle.getBundleContext(),
				AssetListEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}