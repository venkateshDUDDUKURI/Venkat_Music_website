import java.io.IOException;
import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
 
public class eBaySearch {
    public static void main(String[] args) {
        try {
            ApiContext context = new ApiContext();
            ApiCredential credential = new ApiCredential();
            credential.seteBayToken("YOUR_EBAY_TOKEN_HERE");
            context.setApiCredential(credential);
            context.setApiServerUrl("https://api.ebay.com/wsapi");
            FindingServicePortType serviceClient = FindingServiceClientFactory.getServiceClient(context);
 
            FindItemsByKeywordsRequest request = new FindItemsByKeywordsRequest();
            request.setKeywords("iPhone");
            PaginationInput paginationInput = new PaginationInput();
            paginationInput.setEntriesPerPage(10);
            request.setPaginationInput(paginationInput);
 
            FindItemsByKeywordsResponse response = serviceClient.findItemsByKeywords(request);
            if (response != null && response.getSearchResult() != null) {
                for (SearchItem item : response.getSearchResult().getItem()) {
                    System.out.println(item.getTitle());
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
