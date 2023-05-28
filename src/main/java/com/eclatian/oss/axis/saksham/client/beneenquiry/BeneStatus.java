
package com.eclatian.oss.axis.saksham.client.beneenquiry;

/**
 * The {@code BeneStatus} enum represents the status of a beneficiary.
 * It defines three possible values: "Inactive", "Active", and "All".
 *
 * <p>The {@code BeneStatus} enum provides a set of constants that represent the possible beneficiary statuses.</p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>{@code
 * BeneStatus status = BeneStatus.Active;
 *
 * if (status == BeneStatus.Active) {
 *     System.out.println("Beneficiary is active");
 * } else if (status == BeneStatus.Inactive) {
 *     System.out.println("Beneficiary is inactive");
 * } else if (status == BeneStatus.All) {
 *     System.out.println("All beneficiaries");
 * }
 * }</pre>
 *
 * <p><strong>Author:</strong> Abhideep Chakravarty</p>
 */
public enum BeneStatus {
    /**
     * Represents an inactive beneficiary.
     */
    Inactive,

    /**
     * Represents an active beneficiary.
     */
    Active,

    /**
     * Represents all beneficiaries.
     */
    All;
}

