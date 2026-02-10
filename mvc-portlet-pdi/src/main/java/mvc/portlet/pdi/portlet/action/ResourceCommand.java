package mvc.portlet.pdi.portlet.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;
import mvc.portlet.pdi.model.ItemProduct;

@Component(property = {
        "javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
        "mvc.command.name=listAllItens"
}, service = MVCResourceCommand.class)

public class ResourceCommand implements MVCResourceCommand {

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {

        String itemName = ParamUtil.getString(resourceRequest, "itemName");
        String itemDescription = ParamUtil.getString(resourceRequest, "description");

        PortletSession portletSession = resourceRequest.getPortletSession();

        List<ItemProduct> items = (List<ItemProduct>) portletSession.getAttribute("ITEMS");

        if (items == null) {
            items = new ArrayList<>();
        }

        ItemProduct item = new ItemProduct();

        item.setItemName(itemName);
        item.setItemDescription(itemDescription);

        items.add(item);

        portletSession.setAttribute("ITEMS", items);

        // AJAX response
        resourceResponse.setContentType("application/json");

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("success", true);
        json.put("total", items.size());

        try {
            resourceResponse.getWriter().write(json.toString());
        } catch (IOException e) {
            throw new PortletException(e);
        }
        return false;
    }

}