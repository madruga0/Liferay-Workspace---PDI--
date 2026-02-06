package mvc.portlet.pdi.portlet.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;

@Component(property = {
        "javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
        "mvc.command.name=listAllItens"
}, service = MVCResourceCommand.class)

public class ResourceCommand implements MVCResourceCommand {

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {

        String itemName = ParamUtil.getString(resourceRequest, "itemName");
        double productPrice = ParamUtil.getDouble(resourceRequest, "productPrice");
        String description = ParamUtil.getString(resourceRequest, "description");

        resourceRequest.setAttribute("itemName", itemName);
        resourceRequest.setAttribute("productPrice", productPrice);
        resourceRequest.setAttribute("description", description);

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("success", true);

        try {
            resourceResponse.getWriter().print(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

// Liferay code example
/*
 * @Component(
 * property = {
 * "javax.portlet.name=com_acme_p8v5_web_internal_portlet_P8V5Portlet",
 * "mvc.command.name=/p8v5/download"
 * },
 * service = MVCResourceCommand.class
 * )
 * public class P8V5DownloadMVCResourceCommand implements MVCResourceCommand {
 * 
 * @Override
 * public boolean serveResource(
 * ResourceRequest resourceRequest, ResourceResponse resourceResponse)
 * throws PortletException {
 * 
 * try {
 * PortletResponseUtil.sendFile(
 * resourceRequest, resourceResponse, "p8v5.txt",
 * "Hello P8V5!".getBytes(), "text");
 * 
 * return false;
 * }
 * catch (IOException ioException) {
 * _log.error(ioException, ioException);
 * 
 * return true;
 * }
 * }
 * 
 * private static final Log _log = LogFactoryUtil.getLog(
 * P8V5DownloadMVCResourceCommand.class);
 * 
 * }
 */

// GEMINI CODE
/*
 * @Override
 * public boolean serveResource(
 * ResourceRequest request, ResourceResponse response) {
 * 
 * String name = ParamUtil.getString(request, "itemName");
 * double price = ParamUtil.getDouble(request, "productPrice");
 * String description = ParamUtil.getString(request, "description");
 * 
 * ItemService.save(name, price, description);
 * 
 * JSONObject json = JSONFactoryUtil.createJSONObject();
 * json.put("success", true);
 * 
 * response.getWriter().print(json.toString());
 * return false;
 * }
 */