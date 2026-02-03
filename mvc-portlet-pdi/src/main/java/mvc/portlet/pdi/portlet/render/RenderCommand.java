package mvc.portlet.pdi.portlet.render;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;

@Component(property = {
		"javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
		"mvc.command.name=showItems"
}, service = MVCRenderCommand.class)

public class RenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		System.out.println("Render was called");

		if (_log.isInfoEnabled()) {
			_log.info("Invoking #render(RenderRequest, RenderResponse)");
		}
		return "/list_items.jsp";
	}

	private static final Log _log = LogFactoryUtil.getLog(RenderCommand.class);

}

// Liferay code example
/*
 * @Component(
 * property = {
 * "javax.portlet.name=com_acme_a4p1_web_internal_portlet_A4P1Portlet",
 * "mvc.command.name=/a4p1/able"
 * },
 * service = MVCRenderCommand.class
 * )
 * public class A4P1AbleMVCRenderCommand implements MVCRenderCommand {
 * 
 * @Override
 * public String render(
 * RenderRequest renderRequest, RenderResponse renderResponse) {
 * 
 * if (_log.isInfoEnabled()) {
 * _log.info("Invoking #render(RenderRequest, RenderResponse)");
 * }
 * 
 * return "/a4p1/able.jsp";
 * }
 * 
 * private static final Log _log = LogFactoryUtil.getLog(
 * A4P1AbleMVCRenderCommand.class);
 * 
 * }
 * 
 */