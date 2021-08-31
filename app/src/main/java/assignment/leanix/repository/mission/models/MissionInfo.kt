package assignment.leanix.repository.mission.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*


/**
 * Created by Ashutosh Srivastava on 31-Aug-2021 1:14 AM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
@Parcelize
data class MissionInfo(
    @SerializedName("id")
    val id: String?,
    @SerializedName("mission_name")
    val missionName: String?,
    @SerializedName("launch_date_utc")
    val launchDate: Date?,
    @SerializedName("links")
    val links: Link?,
    @SerializedName("details")
    val details: String?,
    @SerializedName("launch_success")
    val launchSuccess: Boolean?,
    @SerializedName("launch_site")
    val launchSite: LaunchSite?,
    @SerializedName("rocket")
    val rocket: Rocket?,
) : Comparable<MissionInfo>, Parcelable {

    override fun compareTo(other: MissionInfo): Int {
        return if (other.missionName == this.missionName) 0 else 1
    }
}

@Parcelize
data class Link(
    @SerializedName("mission_patch_small")
    val missionPatchSmall: String?,
    @SerializedName("flickr_images")
    val flickrImages: MutableList<String>?,
) : Parcelable

@Parcelize
data class LaunchSite(
    @SerializedName("site_id")
    val siteId: String?,
    @SerializedName("site_name_long")
    val siteNameLong: String?,
    @SerializedName("site_name")
    val siteName: String?,
) : Parcelable

@Parcelize
data class Rocket(
    @SerializedName("rocket_name")
    val rocketName: String?,
) : Parcelable