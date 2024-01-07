package pageUIs.user;

public class UserProductReviewPageUI {
    public static final String REVIEW_TITLE_TEXTBOX = "css=input#AddProductReview_Title";
    public static final String REVIEW_CONTENT_TEXTAREA = "css=textarea#AddProductReview_ReviewText";
    public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[text()='Submit review']";
    public static final String SUCCESSFUL_REVIEW_PRODUCT_MESSAGE = "xpath=//div[@class='result' and contains(text(),'%s')]";
    public static final String REVIEW_PRODUCT_TITLE = "css=div.review-title>strong";
    public static final String REVIEW_PRODUCT_CONTENT = "css=div.review-text>div";
}
