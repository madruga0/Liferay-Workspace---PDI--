package mvc.portlet.pdi.portlet;

import mvc.portlet.pdi.constants.MvcPortletPdiPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pedro Madruga
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-js=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MvcPortletPdi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MvcPortletPdiPortletKeys.MVCPORTLETPDI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MvcPortletPdiPortlet extends MVCPortlet {
}