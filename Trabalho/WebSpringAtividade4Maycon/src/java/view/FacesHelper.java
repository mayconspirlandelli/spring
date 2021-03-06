package view;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Maycon Spirlandelli
 */
public final class FacesHelper {

    /**
     * Mapeamento de ResourceBundle por Locale da aplica��o.
     */
    private static final Map<Locale, ResourceBundle> BUNDLE_MAP
            = new Hashtable<Locale, ResourceBundle>(2);

    /**
     * Construtor privado.
     */
    private FacesHelper() {
    }

    /**
     * Cria, caso n�o exista, o mapeamento ResourceBundle por Locale da
     * aplica��o.
     *
     * @return ResourceBundle de acordo com o Locale da aplica��o.
     */
    private static ResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale currentLocale = context.getViewRoot().getLocale();
        ResourceBundle bundle = BUNDLE_MAP.get(currentLocale);
        if (bundle == null) {
            // Resolvendo o ResourceBundle.
            bundle = (ResourceBundle) context.getApplication()
                    .evaluateExpressionGet(context, "#{msgs}",
                            ResourceBundle.class);
            BUNDLE_MAP.put(currentLocale, bundle);
        }
        return bundle;
    }

    /**
     * Retorna uma mensagem a paertir de uma chave.
     *
     * @param key Chave do MessageResource
     * @return Mensagem
     */
    public static String getMessage(String key) {
        return getBundle().getString(key);
    }
}
