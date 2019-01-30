package com.example.beatrice.globonews.models;

import com.google.gson.annotations.SerializedName;


public class ItemsModel {

    @SerializedName("id")
    String id;
    @SerializedName("feedId")
    String feedId;
    @SerializedName("type")
    String type;
    @SerializedName("lastPublication")
    String lastPublication;
    @SerializedName("publication")
    String publication;
    @SerializedName("content")
    ContentModel content;
    @SerializedName("isPinned")
    String isPinned;
    @SerializedName("draft")
    String draft;
    @SerializedName("postHash")
    String postHash;
    @SerializedName("created")
    String created;
    @SerializedName("modified")
    String modified;
    @SerializedName("tenantId")
    String tenantId;
    @SerializedName("versionId")
    String versionId;
    @SerializedName("age")
    String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastPublication() {
        return lastPublication;
    }

    public void setLastPublication(String lastPublication) {
        this.lastPublication = lastPublication;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public ContentModel getContent() {
        return content;
    }

    public void setContent(ContentModel content) {
        this.content = content;
    }

    public String getIsPinned() {
        return isPinned;
    }

    public void setIsPinned(String isPinned) {
        this.isPinned = isPinned;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getPostHash() {
        return postHash;
    }

    public void setPostHash(String postHash) {
        this.postHash = postHash;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
