package mvc.portlet.pdi.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
        "mvc.command.name=saveItem" 
    },
    service = MVCActionCommand.class
)
public class ActionCommand implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {


        // ParamUtil é uma classe utilitária do Liferay para facilitar a obtenção de parâmetros de requisição.
        // getString: Obtém um parâmetro de string do ActionRequest.
        // getDouble: Obtém um parâmetro de ponto flutuante (double) do ActionRequest.
        // getLong: Obtém um parâmetro de número inteiro (long) do ActionRequest.
        // getString: Obtém um parâmetro de string do ActionRequest.
        // getDouble: Obtém um parâmetro de ponto flutuante (double) do ActionRequest.


        // ParamUtil ignora o namespace e pega o valor direto
        String itemName = ParamUtil.getString(actionRequest, "itemName");
        double productPrice = ParamUtil.getDouble(actionRequest, "productPrice");
        String description = ParamUtil.getString(actionRequest, "description");
        
        System.out.println("O item chegou no Java: " + itemName);
        System.out.println("O preço chegou no Java: " + productPrice);
        System.out.println("A descrição chegou no Java: " + description);



        // itemName: valor do itemName do form.jsp, que sera passado para o list_items.jsp
        // productPrice: valor do productPrice do form.jsp que sera passado para o list_items.jsp
        // description: valor do description do form.jsp que sera passado para o list_items.jsp

        actionRequest.setAttribute("itemName", itemName);
        actionRequest.setAttribute("itemPrice", productPrice);
        actionRequest.setAttribute("itemDescription", description);


        actionResponse.setRenderParameter("mvcPath", "/list_items.jsp");
        
        return true; 
    }



}