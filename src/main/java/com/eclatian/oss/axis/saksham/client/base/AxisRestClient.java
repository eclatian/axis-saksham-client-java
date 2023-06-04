
package com.eclatian.oss.axis.saksham.client.base;

import com.eclatian.oss.axis.saksham.client.SakshamManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import okhttp3.OkHttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.LoggerFactory;

/**
 * The {@code AxisRestClient} enum represents a REST client for Axis requests.
 * It provides methods for obtaining the REST client and HTTP client instances.
 * This enum follows the singleton pattern to ensure a single instance of the client is used.
 *
 *
 * <p>The enum provides the following methods:</p>
 * <ul>
 *   <li>{@link #getHttpClient()}: Retrieves the CloseableHttpClient instance for HTTP requests.
 *     <ul>
 *       <li>Description: Initializes and returns the CloseableHttpClient instance if it is null.</li>
 *       <li>Returns: The CloseableHttpClient instance.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <p>The enum uses the {@code SakshamManager} class to retrieve necessary options and certificate details.
 * If any required details are missing, it throws an {@code IllegalArgumentException}.
 * It also handles the initialization of SSLContext for secure connections.</p>
 *
 * <p>Note: The enum follows the singleton pattern, and {@code INSTANCE} should be used to access the client instance.</p>
 *
 * @see OkHttpClient
 * @see CloseableHttpClient
 * @see SakshamManager
 * @see IllegalArgumentException
 *
 * @since 1.0
 * @author Abhideep Chakravarty
 */ 
public enum AxisRestClient {

    /**
     * The singleton instance of the AxisRestClient.
     */
    INSTANCE;

    private CloseableHttpClient httpClient;
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * Retrieves the CloseableHttpClient instance for HTTP requests.
     *
     * @return The CloseableHttpClient instance.
     * @throws com.eclatian.oss.axis.saksham.client.base.SakshamClientException
     */
    public CloseableHttpClient getHttpClient() throws SakshamClientException {
        if (this.httpClient == null) {

            try {
                if (SakshamManager.INSTANCE.getOptions().getCertPassPhrase() == null || SakshamManager.INSTANCE
                        .getOptions().getCertFileStream() == null) {
                    throw new IllegalArgumentException("Certificate file details or certificate "
                            + "key is missing."
                            + " Please provide the same in InitializationOptions.");
                }

                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                keyStore.load(SakshamManager.INSTANCE.getOptions().getCertFileStream(),
                        SakshamManager.INSTANCE.getOptions().getCertPassPhrase().toCharArray());

                SSLContext sslContext = SSLContexts.custom()
                        .loadKeyMaterial(keyStore, SakshamManager.INSTANCE.getOptions()
                                .getCertPassPhrase().toCharArray())
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .build();

                this.httpClient = HttpClients.custom()
                        .setSSLContext(sslContext)
                        .build();
            } catch (NoSuchAlgorithmException | KeyStoreException | UnrecoverableKeyException | IOException
                    | CertificateException | KeyManagementException ex) {
                throw new SakshamClientException("Could not initialize the HTTP client.", ex);
            }
        }
        return this.httpClient;
    }
}
