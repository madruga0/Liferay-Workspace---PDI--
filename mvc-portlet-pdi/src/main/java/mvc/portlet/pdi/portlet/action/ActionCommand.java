package mvc.portlet.pdi.portlet.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;
import mvc.portlet.pdi.model.ItemProduct;

@Component(
        property = {
        "javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
        "mvc.command.name=saveItem"
}, 
        service = MVCActionCommand.class
)
public class ActionCommand implements MVCActionCommand {
    @Override
    public boolean processAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse) {

        String itemName = ParamUtil.getString(actionRequest, "itemName");
        String itemDescription = ParamUtil.getString(actionRequest, "description");

        // escopo do meu portlet
        PortletSession session = actionRequest.getPortletSession();

        List<ItemProduct> items = (List<ItemProduct>) session.getAttribute(
                "ITEMS",
                PortletSession.PORTLET_SCOPE);

        if (items == null) {
            items = new ArrayList<>();
        }

        ItemProduct item = new ItemProduct();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);

        items.add(item);

        session.setAttribute(
                "ITEMS",
                items,
                PortletSession.PORTLET_SCOPE);

        System.out.println("Total items: " + items.size());

        actionResponse.setRenderParameter(
                "mvcRenderCommandName",
                "showItems");

        return true;
    }
}