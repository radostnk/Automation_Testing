package infrastructure;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;

import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;

public class MailslurpService {
    private static ApiClient defaultClient;
    private static InboxControllerApi inboxControllerApi;
    private static String API_KEY = System.getenv("MAILSLURP_KEY");
    private static final Long TIMEOUT = 30000L;

    static {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
        defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setConnectTimeout(TIMEOUT.intValue());
        defaultClient.setWriteTimeout(TIMEOUT.intValue());
        defaultClient.setReadTimeout(TIMEOUT.intValue());
        defaultClient.setHttpClient(httpClient);
        defaultClient.setApiKey(API_KEY);
        inboxControllerApi = new InboxControllerApi(defaultClient);
    }

    @SneakyThrows
    public static InboxDto createInbox(String name) {
        InboxDto inbox = inboxControllerApi.createInbox(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        return inbox;
    }

    @SneakyThrows
    public static Email waitForLatestEmail(InboxDto inbox, OffsetDateTime since) throws ApiException {
        var waitForControllerApi = new WaitForControllerApi(defaultClient);
        Email receivedEmail = waitForControllerApi
                .waitForLatestEmail(inbox.getId(), TIMEOUT, false, null, since, null, 10000L);

        return receivedEmail;
    }
}