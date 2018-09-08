package com.example.sos.infinitepops.dto;

/**
 * FeedItem
 *
 * @author SOS
 * @since 07/09/2018.
 */
public class FeedItemResponse extends BaseResponse {

    private String id;
    private String imageSrc;
    private String postingUserId;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getPostingUserId() {
        return postingUserId;
    }

    public void setPostingUserId(String postingUserId) {
        this.postingUserId = postingUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
