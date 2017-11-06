// CHECKSTYLE:OFF

package if12.onekey_triage;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;


/**
 * Generated localization support class.
 * 
 */
@SuppressWarnings({
    "",
    "PMD",
    "all"
})
public class Messages {

    /**
     * The resource bundle reference
     * 
     */
    private final static ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    /**
     * Key {@code displayName}: {@code Triage}.
     * 
     * @return
     *     {@code Triage}
     */
    public static String displayName() {
        return holder.format("displayName");
    }

    /**
     * Key {@code displayName}: {@code Triage}.
     * 
     * @return
     *     {@code Triage}
     */
    public static Localizable _displayName() {
        return new Localizable(holder, "displayName");
    }

    /**
     * Key {@code artsServer}: {@code
     * https://qti.sv.splunk.com/en-US/app/ARTs/}.
     * 
     * @return
     *     {@code https://qti.sv.splunk.com/en-US/app/ARTs/}
     */
    public static String artsServer() {
        return holder.format("artsServer");
    }

    /**
     * Key {@code artsServer}: {@code
     * https://qti.sv.splunk.com/en-US/app/ARTs/}.
     * 
     * @return
     *     {@code https://qti.sv.splunk.com/en-US/app/ARTs/}
     */
    public static Localizable _artsServer() {
        return new Localizable(holder, "artsServer");
    }

    /**
     * Key {@code product}: {@code splunk}.
     * 
     * @return
     *     {@code splunk}
     */
    public static String product() {
        return holder.format("product");
    }

    /**
     * Key {@code product}: {@code splunk}.
     * 
     * @return
     *     {@code splunk}
     */
    public static Localizable _product() {
        return new Localizable(holder, "product");
    }

    /**
     * Key {@code triageIconName}: {@code
     * /plugin/onekey-triage/images/triage.png}.
     * 
     * @return
     *     {@code /plugin/onekey-triage/images/triage.png}
     */
    public static String triageIconName() {
        return holder.format("triageIconName");
    }

    /**
     * Key {@code triageIconName}: {@code
     * /plugin/onekey-triage/images/triage.png}.
     * 
     * @return
     *     {@code /plugin/onekey-triage/images/triage.png}
     */
    public static Localizable _triageIconName() {
        return new Localizable(holder, "triageIconName");
    }

}
